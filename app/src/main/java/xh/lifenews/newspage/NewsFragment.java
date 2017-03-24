package xh.lifenews.newspage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import xh.lifenews.R;
import xh.lifenews.model.Constants;
import xh.lifenews.utils.Util;
import xh.lifenews.widget.ExpandableView;
import xh.lifenews.widget.NewsViewPager;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link NewsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link NewsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private NewsViewPager mViewPager;
    private List<NewsPageContract.Presenter> mPresenters = new ArrayList<>();
    private GridView mGridView;
    private TextView expandTitle;
    private TabLayout tabLayout;
    private ExpandableView expandableLayout;


    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case ExpandableView.EXPAND_VIEW_MSG:
                    closeExpandView();
                    break;
            }
        }
    };

//    private OnFragmentInteractionListener mListener;

    public NewsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NewsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NewsFragment newInstance(String param1, String param2) {
        NewsFragment fragment = new NewsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final View v = inflater.inflate(R.layout.fragment_news, container, false);

        expandableLayout = (ExpandableView) v.findViewById(R.id.expandable_layout);
        expandTitle = (TextView) v.findViewById(R.id.expand_title);
        tabLayout = (TabLayout) v.findViewById(R.id.news_tab_layout);
        mViewPager = (NewsViewPager) v.findViewById(R.id.news_view_pager);
        Toolbar toolbar = (Toolbar) v.findViewById(R.id.toolbar);
        TextView title = (TextView) toolbar.findViewById(R.id.toolbar_title);
        mGridView = (GridView) v.findViewById(R.id.expand_grid_view);

        expandableLayout.setHandler(mHandler);

        expandTitle.setText(Util.getString(getActivity(), R.string.expand_title));
        ImageButton button = (ImageButton) v.findViewById(R.id.expand_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if (expandableLayout.isExpanded()) {
                   closeExpandView();
               } else {
                   openExpandView();
               }
            }
        });

        title.setText(Util.getString(getActivity(), R.string.toolbar_title_news));
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        NewsPageAdapter adapter = new NewsPageAdapter(getChildFragmentManager(), getActivity());
        mViewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(mViewPager);

        mGridView.setAdapter(new GridAdapter(getActivity(), Constants.NEWS_TYPE_CN));

        return v;

    }

    public void closeExpandView() {
        expandableLayout.collapse();
        expandTitle.setVisibility(View.GONE);
        tabLayout.setVisibility(View.VISIBLE);
        mViewPager.setDispatchTouchEvent(true);
    }

    public void openExpandView() {
        expandableLayout.expand();
        expandTitle.setVisibility(View.VISIBLE);
        tabLayout.setVisibility(View.GONE);
        mViewPager.setDispatchTouchEvent(false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.expandTabHost(uri);
//        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
//        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public class GridAdapter extends ArrayAdapter<String> {
        String[] items;
        Context mContext;

        public GridAdapter(Context context, String[] objects) {
            super(context, 0, objects);
            items = objects;
            mContext = context;
        }

        @NonNull
        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(mContext).inflate(R.layout.item_expand_grid_view, parent, false);
            }
            final Button button = (Button) convertView.findViewById(R.id.columns_name);
            button.setText(items[position]);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mViewPager.setCurrentItem(position);
                    closeExpandView();
                    Drawable backgroundColor = button.getBackground();
//                    Util.setBackgroundColorAndRetainShape(R.color.expand_item_high_light, backgroundColor);
                }
            });
            return convertView;
        }
    }

}
