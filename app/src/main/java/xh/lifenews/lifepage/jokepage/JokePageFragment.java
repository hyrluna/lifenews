package xh.lifenews.lifepage.jokepage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import xh.lifenews.R;
import xh.lifenews.model.object.joke.NewestJokeEntry;
import xh.lifenews.model.object.joke.NewestPicEntry;
import xh.lifenews.model.object.joke.RandomJokeEntry;
import xh.lifenews.utils.Util;

public class JokePageFragment extends Fragment implements JokePageContract.View {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static final int PAGE_TYPE_JOKE_NEWEST = 0;
    public static final int PAGE_TYPE_PIC_NEWEST = 1;
    public static final int PAGE_TYPE_JOKE_OR_PIC_RANDOM = 2;
    public static final String TYPE_PIC = "pic";
    public static final String TYPE_JOKE = "";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private int position;

    private JokePageContract.Presenter mPresenter;
    private RecyclerView jokeList;
    private RecyclerView.Adapter<? extends RecyclerView.ViewHolder> mAdapter;

    public JokePageFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment JokePageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static JokePageFragment newInstance(String param1, int param2) {
        JokePageFragment fragment = new JokePageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putInt(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void setPresenter(JokePageContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showErrorInfo(String s) {
        Util.showToast(getActivity(), s);
    }

    @Override
    public void updateRandomJokeOrPicView(List<RandomJokeEntry> entries) {
        JokePageRandomAdapter adapter = null;
        if (mAdapter instanceof JokePageRandomAdapter) {
            adapter = (JokePageRandomAdapter) mAdapter;
        } else {
            Log.d("debug", "error adapter");
            return;
        }
        adapter.clearItems();
        adapter.addItems(entries);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void updateNewestJokeView(List<NewestJokeEntry> entries) {
        Log.d("joke", "newest size "+entries.size());
        JokePageTxtAdapter adapter = null;
        if (mAdapter instanceof JokePageTxtAdapter) {
            adapter = (JokePageTxtAdapter) mAdapter;
        } else {
            Log.d("debug", "error adapter");
            return;
        }
        adapter.clearItems();
        adapter.addItems(entries);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void updateNewestPicView(List<NewestPicEntry> entries) {
        JokePagePicAdapter adapter = null;
        if (mAdapter instanceof JokePagePicAdapter) {
            adapter = (JokePagePicAdapter) mAdapter;
        } else {
            Log.d("debug", "error adapter");
            return;
        }

        adapter.clearItems();
        adapter.addItems(entries);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            position = getArguments().getInt(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_joke_page, container, false);
        jokeList = (RecyclerView) v.findViewById(R.id.joke_page_recycler_view);
        jokeList.setLayoutManager(new LinearLayoutManager(getActivity()));

        switch (position) {
            case PAGE_TYPE_JOKE_NEWEST:
                mAdapter = new JokePageTxtAdapter();
                break;
            case PAGE_TYPE_PIC_NEWEST:
                mAdapter = new JokePagePicAdapter(getActivity());
                break;
            case PAGE_TYPE_JOKE_OR_PIC_RANDOM:
                mAdapter = new JokePageRandomAdapter(getActivity(), mPresenter);
                break;
        }
        jokeList.setAdapter(mAdapter);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        switch (position) {
            case PAGE_TYPE_JOKE_NEWEST:
                mPresenter.loadNewestJoke(1, 20);
                break;
            case PAGE_TYPE_PIC_NEWEST:
                //趣图加载影响动画
//                mPresenter.loadNewestPic(1, 5);
                break;
            case PAGE_TYPE_JOKE_OR_PIC_RANDOM:
                mPresenter.loadRandomJoke(TYPE_JOKE);
                break;
        }
    }

}
