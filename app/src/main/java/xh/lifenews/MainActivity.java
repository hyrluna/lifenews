package xh.lifenews;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import net.cachapa.expandablelayout.ExpandableLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import xh.lifenews.lifepage.LifeFragment;
import xh.lifenews.newspage.NewsFragment;
import xh.lifenews.newspage.NewsPageFragment;
import xh.lifenews.utils.Util;
import xh.lifenews.widget.TabButton;

public class MainActivity extends AppCompatActivity
        implements View.OnTouchListener, NewsPageFragment.NewsPageFragmentListener {

    private Fragment[] mFragments;

    @Bind(R.id.tab_button_news)
    TabButton newsButton;
    @Bind(R.id.tab_button_life)
    TabButton lifeButton;
    @Bind(R.id.tab_button_profile)
    TabButton profileButton;
    @Bind(R.id.tab_root)
    LinearLayout tabRoot;

    private BottomSheetBehavior mBottomSheetBehavior;
    private boolean isTabExpand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mFragments = new Fragment[] {
                NewsFragment.newInstance("test1", "test2"),
                LifeFragment.newInstance("test1", "test2"),
                ProfileFragment.newInstance("test1", "test2")
        };

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fragment_container, mFragments[0])
                .show(mFragments[0])
                .add(R.id.fragment_container, mFragments[1])
                .hide(mFragments[1])
                .add(R.id.fragment_container, mFragments[2])
                .hide(mFragments[2])
                .commit();

        newsButton.setOnTouchListener(this);
        lifeButton.setOnTouchListener(this);
        profileButton.setOnTouchListener(this);

        mBottomSheetBehavior = BottomSheetBehavior.from(tabRoot);
        expandTabHost();

        //拦截对bottomsheet的拖动事件
        mBottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                if (newState == BottomSheetBehavior.STATE_DRAGGING) {
                    mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        int id = 0;
        switch (v.getId()) {
            case R.id.tab_button_news:
                id = 0;
                break;
            case R.id.tab_button_life:
                id = 1;
                break;
            case R.id.tab_button_profile:
                id = 2;
                break;
            default:
        }
        for (Fragment fragment : mFragments) {
            if (fragment.isVisible()) {
                transaction.hide(fragment);
            }
        }
        transaction.show(mFragments[id]);
        transaction.commit();
        return true;
    }

    @Override
    public void showTabHostLayout() {
        expandTabHost();
    }

    @Override
    public void hideTabHostLayout() {
        collapsedTabHost();

    }

    public void expandTabHost() {
        if (!isTabExpand) {
            mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            isTabExpand = true;
        }
    }

    public void collapsedTabHost() {
        if (isTabExpand) {
            mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            isTabExpand = false;
        }
    }
}
