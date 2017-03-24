package xh.lifenews.newspage;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import xh.lifenews.GlideLoader;
import xh.lifenews.NewsDetailActivity;
import xh.lifenews.R;
import xh.lifenews.utils.Util;
import xh.lifenews.model.object.news.NewsEntry;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link NewsPageFragmentListener} interface
 * to handle interaction events.
 * Use the {@link NewsPageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewsPageFragment extends Fragment
        implements NewsPageContract.View {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private int mParam2;
    private List<NewsEntry> mImageEntries = new ArrayList<>();
    private NewsBigImageAdapter mNewsBigImageAdapter;
    private List<NewsEntry> mNewsEntries = new ArrayList<>();
    private LinearLayout mListHeader;
    private ViewPager mViewPager;
    private ArrayAdapter<String> mAdapter;
    private LinkedList<String> mListItems;
    private NewsPageContract.Presenter mPresenter;
    private ProgressBar mProgressBar;
    private RecyclerView mRecyclerView;
    private NewsPageRecyclerAdapter mRecyclerAdapter;
    private SwipeRefreshLayout mRefreshLayout;

    private NewsPageFragmentListener mListener;


    @Override
    public void setPresenter(NewsPageContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void updatePreviewImage(List<NewsEntry> imageEntries) {
        if (imageEntries.size() == 0) {
            mRecyclerAdapter.removeHeaderView();
        }
        mImageEntries.clear();
        mImageEntries.addAll(imageEntries);
        mNewsBigImageAdapter.notifyDataSetChanged();

    }

    @Override
    public void updateListItem(List<NewsEntry> entries) {
        mNewsEntries.clear();
        mNewsEntries.addAll(entries);
//        mNewsListAdapter.notifyDataSetChanged();
        mRecyclerAdapter.notifyDataSetChanged();
    }

    @Override
    public void showErrorInfo(String error) {
        Util.showToast(getActivity(), error);
    }

    @Override
    public void showProgressBar() {
        if (!mProgressBar.isShown()) {
            mProgressBar.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void completeRefresh() {
        if (mProgressBar.isShown()) {
            mProgressBar.setVisibility(View.GONE);
        }
//        mPullRefreshListView.onRefreshComplete();
        mRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showDetailPage(NewsEntry newsEntry) {
        String url = newsEntry.getUrl();
        Intent intent = new Intent(getActivity(), NewsDetailActivity.class);
        intent.putExtra(NewsDetailActivity.NEWS_DETAIL_URL, url);
        startActivity(intent);
    }

    public NewsPageFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NewsPageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NewsPageFragment newInstance(String param1, int param2) {
        NewsPageFragment fragment = new NewsPageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putInt(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getInt(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_news_page, container, false);
        mProgressBar = (ProgressBar) v.findViewById(R.id.news_progress_bar);
        mNewsBigImageAdapter = new NewsBigImageAdapter(mImageEntries);
        mListHeader = (LinearLayout) inflater.inflate(R.layout.list_view_header, null);
        mViewPager = (ViewPager) mListHeader.findViewById(R.id.news_image_preview);
        mViewPager.setAdapter(mNewsBigImageAdapter);
        mRecyclerView = (RecyclerView) v.findViewById(R.id.news_page_recycler_view);
        mRefreshLayout = (SwipeRefreshLayout) v.findViewById(R.id.news_swipe_refresh_layout);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerAdapter = new NewsPageRecyclerAdapter(getActivity(), mNewsEntries, mPresenter);
        mRecyclerAdapter.addHeaderView(mListHeader);
        mRecyclerView.setAdapter(mRecyclerAdapter);

        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mRefreshLayout.setRefreshing(true);
                mPresenter.loadNews(false);
            }
        });

        mRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if(dy > 3) {
                    mListener.hideTabHostLayout();
                } else if (dy < -3) {
                    mListener.showTabHostLayout();
                }
            }
        });

        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.loadNews(true);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof NewsPageFragmentListener) {
            mListener = (NewsPageFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void onScrollStateChanged(AbsListView view, int scrollState) {
//        if (scrollState == SCROLL_STATE_IDLE) {
//            //scroll stop, 滚动停止时加载数据，通过notifiy调用getView方法
//            mNewsListAdapter.setListScrollIDLE(true);
//            mNewsListAdapter.notifyDataSetChanged();
//        } else {
//            mNewsListAdapter.setListScrollIDLE(false);
//        }
    }

    public interface NewsPageFragmentListener {
        void showTabHostLayout();
        void hideTabHostLayout();
    }

    private class NewsBigImageAdapter extends PagerAdapter {

        private List<NewsEntry> newsEntries;

        public NewsBigImageAdapter(List<NewsEntry> newsEntries) {
            this.newsEntries = newsEntries;
        }

        @Override
        public Object instantiateItem(ViewGroup container, final int position) {
            RelativeLayout layout = (RelativeLayout) LayoutInflater.from(getActivity())
                    .inflate(R.layout.item_big_image, null);
            TextView itemText = (TextView) layout.findViewById(R.id.preview_image_title);
            ImageView imageView = (ImageView) layout.findViewById(R.id.preview_image);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (newsEntries != null && newsEntries.size() > position) {
                        mPresenter.loadDetailNews(newsEntries.get(position));
                    }
                }
            });
            updateImageLayout(itemText, imageView, position);
            container.addView(layout);

            return layout;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            if (object instanceof View) {
                container.removeView((View) object);
            }

        }

        @Override
        public int getCount() {
            return newsEntries.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        public void updateImageLayout(TextView textView, ImageView imageView, int position) {
            textView.setText(newsEntries.get(position).getTitle());
            GlideLoader.loadImageWithDiskCache(getActivity(),
                    newsEntries.get(position).getThumbnailPicS03(), imageView);
        }
    }

}
