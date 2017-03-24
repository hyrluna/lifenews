package xh.lifenews.lifepage.jokepage;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

import xh.lifenews.model.AppRepository;
import xh.lifenews.model.local.AppLocalData;
import xh.lifenews.model.remote.AppRemoteData;

/**
 * Created by bamboo on 16-12-3.
 */

public class JokePageAdapter extends FragmentStatePagerAdapter {
    private Context mContext;
    private ArrayList<String> titles = new ArrayList<>();
    private JokePageContract.Presenter mPresenter;

    private String[] title = new String[] {
            "最新笑话",
            "最新趣图",
            "随机笑话或趣图",
    };

    public JokePageAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        JokePageFragment fragment = JokePageFragment.newInstance("test", position);
        AppRepository repository = AppRepository.getInstance(
                AppLocalData.getInstance(),
                AppRemoteData.getInstance());
        mPresenter = new JokePagePresenter(repository, fragment, position);
        return fragment;
    }

    @Override
    public int getCount() {
        return title.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
