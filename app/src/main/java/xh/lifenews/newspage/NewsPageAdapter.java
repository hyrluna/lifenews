package xh.lifenews.newspage;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import java.util.ArrayList;

import xh.lifenews.R;
import xh.lifenews.utils.Util;
import xh.lifenews.model.Constants;
import xh.lifenews.model.AppRepository;
import xh.lifenews.model.local.AppLocalData;
import xh.lifenews.model.remote.AppRemoteData;

/**
 * Created by bamboo on 16-11-27.
 */

public class NewsPageAdapter extends FragmentStatePagerAdapter {

    private Context mContext;
    private NewsPageContract.Presenter mPresenter;
    private ArrayList<String> titles = new ArrayList<>();

    public NewsPageAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        NewsPageFragment fragment = NewsPageFragment.newInstance("test", position);
        AppRepository repository = AppRepository.getInstance(
                AppLocalData.getInstance(),
                AppRemoteData.getInstance());
        mPresenter = new NewsPagePresenter(repository, fragment, position);
        return fragment;
    }

    @Override
    public int getCount() {
        return Constants.NEWS_TYPE_CN.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
       return Constants.NEWS_TYPE_CN[position];
    }
}
