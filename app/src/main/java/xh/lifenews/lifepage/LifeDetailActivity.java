package xh.lifenews.lifepage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.annotation.ColorRes;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import xh.lifenews.ConstantsTest;
import xh.lifenews.GlideLoader;
import xh.lifenews.R;
import xh.lifenews.lifepage.almanacpage.AlmanacContract;
import xh.lifenews.lifepage.almanacpage.AlmanacFragment;
import xh.lifenews.lifepage.almanacpage.AlmanacPresenter;
import xh.lifenews.lifepage.constellationpage.ConstellationContract;
import xh.lifenews.lifepage.constellationpage.ConstellationFragment;
import xh.lifenews.lifepage.constellationpage.ConstellationPresenter;
import xh.lifenews.lifepage.jokepage.JokeFragment;
import xh.lifenews.lifepage.phonepage.PhoneContract;
import xh.lifenews.lifepage.phonepage.PhoneFragment;
import xh.lifenews.lifepage.phonepage.PhonePresenter;
import xh.lifenews.model.AppRepository;
import xh.lifenews.model.Constants;
import xh.lifenews.model.local.AppLocalData;
import xh.lifenews.model.remote.AppRemoteData;

public class LifeDetailActivity extends AppCompatActivity {

    public static final String EXTRA_ITEM_TYPE = ConstantsTest.PACKAGE_NAME + ".extra_item_type";

    private Interpolator interpolator;
    private static final int DELAY = 100;
    private int mItemType;

    @Bind(R.id.toolbar_life_item_detail)
    Toolbar toolbar;
    @Bind(R.id.item_title)
    TextView textView;
    @Bind(R.id.item_description)
    TextView itemDescription;
    @Bind(R.id.item_background)
    ImageView itemBackground;
    @Bind(R.id.shared_target)
    ImageView itemIcon;
    @Bind(R.id.content)
    RelativeLayout bgViewGroup;
    @Bind(R.id.appbar)
    AppBarLayout appBarLayout;

    private Fragment[] mFragments;
    private ConstellationContract.Presenter mConsPresenter;
    private AlmanacContract.Presenter mAlmanacPresenter;
    private PhoneContract.Presenter mPhonePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupWindowAnimations();
        setContentView(R.layout.activity_life_detail);
        ButterKnife.bind(this);
        mItemType = getIntent().getIntExtra(EXTRA_ITEM_TYPE, -1);

        setIconForType(itemIcon, mItemType);

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("toolbar");
            actionBar.setHomeAsUpIndicator(R.drawable.ic_keyboard_arrow_left_white_24dp);
        }
    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

//    @Override
//    public void onBackPressed() {
//        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.item_fragment_container);
//        fragment.onDestroy();
//        super.onBackPressed();
//    }

    //    private void bindData() {
//        ActivityNewChatBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_new_chat);
//        RevealData data = new RevealData("Test DataBinding", ContextCompat.getColor(this, R.color.sample_red));
//        binding.setRevealData(data);
//    }

    public void showFragmentForType(int itemType) {
        AppRepository repository = AppRepository.getInstance(
                AppLocalData.getInstance(),
                AppRemoteData.getInstance());
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        Fragment fragment = null;
        switch (itemType) {
            case Constants.LIFE_ITEM_TYPE_XINGZUO:
                ConstellationFragment consFragment = ConstellationFragment.newInstance("p1", "p2");
                fragment = consFragment;
                mConsPresenter = new ConstellationPresenter(repository, consFragment);
                break;
            case Constants.LIFE_ITEM_TYPE_JIEMENG:
                fragment = new TestFragment();
                break;
            case Constants.LIFE_ITEM_TYPE_XIAOHUA:
                JokeFragment jokeFragment = JokeFragment.newInstance("joke", "p2");
                fragment = jokeFragment;
                break;
            case Constants.LIFE_ITEM_TYPE_LAOHUANGLI:
                AlmanacFragment almanacFragment = AlmanacFragment.newInstance("almanac", "p2");
                fragment = almanacFragment;
                mAlmanacPresenter = new AlmanacPresenter(repository, almanacFragment);
                break;
            case Constants.LIFE_ITEM_TYPE_LISHI:
                break;
            case Constants.LIFE_ITEM_TYPE_HAOMA:
                PhoneFragment phoneFragment = PhoneFragment.newInstance("phone", "p2");
                fragment = phoneFragment;
                mPhonePresenter = new PhonePresenter(repository, phoneFragment);
                break;
        }
        if (fragment != null) {
            transaction.replace(R.id.item_fragment_container, fragment);
            transaction.commit();
        }
    }

    public void hideFragmentView() {
//        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        transaction.hide(fragment);
//        transaction.commit();
    }

    private void setupWindowAnimations() {
        interpolator = AnimationUtils.loadInterpolator(this, android.R.interpolator.linear_out_slow_in);
        setupEnterAnimations();
        setupExitAnimations();
    }

    private void setupEnterAnimations() {
        Transition transition = TransitionInflater.from(this).inflateTransition(R.transition.changebounds_with_arcmotion);
        getWindow().setSharedElementEnterTransition(transition);
        transition.addListener(new Transition.TransitionListener() {
            @Override
            public void onTransitionStart(Transition transition) {
            }

            @Override
            public void onTransitionEnd(Transition transition) {
                // Removing listener here is very important because shared element
                // transition is executed again backwards on exit. If we don't remove
                // the listener this code will be triggered again.
                transition.removeListener(this);
//                hideTarget();
                animateRevealColor(itemIcon, bgViewGroup, R.color.ripple_life_item_big_image);
                textView.setText(Constants.LIEF_ITEM_NAMES[mItemType]);
                itemDescription.setText("description "+ Constants.LIEF_ITEM_NAMES[mItemType]);
                setBackgroundForType(itemBackground, mItemType);
                showFragmentForType(mItemType);
//                animateRevealShow(toolbar);
//                animateButtonsIn();
            }

            @Override
            public void onTransitionCancel(Transition transition) {
            }

            @Override
            public void onTransitionPause(Transition transition) {
            }

            @Override
            public void onTransitionResume(Transition transition) {
            }
        });
    }

    private void setupExitAnimations() {
        Fade returnTransition = new Fade();
        getWindow().setReturnTransition(returnTransition);
        returnTransition.setDuration(getResources().getInteger(R.integer.anim_duration_medium));
        returnTransition.setStartDelay(getResources().getInteger(R.integer.anim_duration_medium));
        returnTransition.addListener(new Transition.TransitionListener() {
            @Override
            public void onTransitionStart(Transition transition) {
                transition.removeListener(this);
//                animateButtonsOut();
                hideFragmentView();
                animateRevealHide(itemIcon, bgViewGroup);
//                textView.setText(Constants.LIEF_ITEM_NAMES[mItemType]);
//                itemDescription.setText("description "+ Constants.LIEF_ITEM_NAMES[mItemType]);
            }

            @Override
            public void onTransitionEnd(Transition transition) {
            }

            @Override
            public void onTransitionCancel(Transition transition) {
            }

            @Override
            public void onTransitionPause(Transition transition) {
            }

            @Override
            public void onTransitionResume(Transition transition) {
            }
        });
    }

//    private void setupLayout() {
//        bgViewGroup = (RelativeLayout) findViewById(R.id.reveal_root);
//        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        body = ((TextView) findViewById(R.id.sample_body));
//        View btnGreen = findViewById(R.id.square_green);
//        btnGreen.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                revealGreen();
//            }
//        });
//        btnRed = findViewById(R.id.square_red);
//        btnRed.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                revealRed();
//            }
//        });
//        View btnBlue = findViewById(R.id.square_blue);
//        btnBlue.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                revealBlue();
//            }
//        });
//        findViewById(R.id.square_yellow).setOnTouchListener(this);
//    }

//    private void revealBlue() {
//        animateButtonsOut();
//        Animator anim = animateRevealColorFromCoordinates(bgViewGroup, R.color.sample_blue, bgViewGroup.getWidth() / 2, 0);
//        anim.addListener(new AnimatorListenerAdapter() {
//            @Override
//            public void onAnimationEnd(Animator animation) {
//                animateButtonsIn();
//            }
//        });
//        body.setText(R.string.reveal_body4);
//        body.setTextColor(ContextCompat.getColor(this, R.color.theme_blue_background));
//    }

//    private void revealRed() {
//        final ViewGroup.LayoutParams originalParams = btnRed.getLayoutParams();
//        Transition transition = TransitionInflater.from(this).inflateTransition(R.transition.changebounds_with_arcmotion);
//        transition.addListener(new Transition.TransitionListener() {
//            @Override
//            public void onTransitionStart(Transition transition) {
//            }
//
//            @Override
//            public void onTransitionEnd(Transition transition) {
//                animateRevealColor(bgViewGroup, R.color.sample_red);
//                body.setText(R.string.reveal_body3);
//                body.setTextColor(ContextCompat.getColor(RevealActivity.this, R.color.theme_red_background));
//                btnRed.setLayoutParams(originalParams);
//            }
//
//            @Override
//            public void onTransitionCancel(Transition transition) {
//            }
//
//            @Override
//            public void onTransitionPause(Transition transition) {
//
//            }
//
//            @Override
//            public void onTransitionResume(Transition transition) {
//
//            }
//        });
//        TransitionManager.beginDelayedTransition(bgViewGroup, transition);
//        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
//        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
//        btnRed.setLayoutParams(layoutParams);
//    }

//    private void revealYellow(float x, float y) {
//        animateRevealColorFromCoordinates(bgViewGroup, R.color.sample_yellow, (int) x, (int) y);
//        body.setText(R.string.reveal_body1);
//        body.setTextColor(ContextCompat.getColor(this, R.color.theme_yellow_background));
//    }

//    private void revealGreen() {
//        animateRevealColor(bgViewGroup, R.color.sample_green);
//        body.setText(R.string.reveal_body2);
//        body.setTextColor(ContextCompat.getColor(this, R.color.theme_green_background));
//    }

    private void hideTarget() {
        findViewById(R.id.shared_target).setVisibility(View.GONE);
    }

    private void animateButtonsIn() {
        for (int i = 0; i < bgViewGroup.getChildCount(); i++) {
            View child = bgViewGroup.getChildAt(i);
            child.animate()
                    .setStartDelay(100 + i * DELAY)
                    .setInterpolator(interpolator)
                    .alpha(1)
                    .scaleX(1)
                    .scaleY(1);
        }
    }

    private void animateButtonsOut() {
        for (int i = 0; i < bgViewGroup.getChildCount(); i++) {
            View child = bgViewGroup.getChildAt(i);
            child.animate()
                    .setStartDelay(i)
                    .setInterpolator(interpolator)
                    .alpha(0)
                    .scaleX(0f)
                    .scaleY(0f);
        }
    }

//    @Override
//    public boolean onTouch(View view, MotionEvent motionEvent) {
//        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
//            if (view.getId() == R.id.square_yellow) {
//                revealYellow(motionEvent.getRawX(), motionEvent.getRawY());
//            }
//        }
//        return false;
//    }

    private void animateRevealShow(View viewRoot) {
        int cx = (viewRoot.getLeft() + viewRoot.getRight()) / 2;
        int cy = (viewRoot.getTop() + viewRoot.getBottom()) / 2;
        int finalRadius = Math.max(viewRoot.getWidth(), viewRoot.getHeight());

        Animator anim = ViewAnimationUtils.createCircularReveal(viewRoot, cx, cy, 0, finalRadius);
        viewRoot.setVisibility(View.VISIBLE);
        anim.setDuration(getResources().getInteger(R.integer.anim_duration_long));
        anim.setInterpolator(new AccelerateInterpolator());
        anim.start();
    }

    private void animateRevealColor(View v, ViewGroup viewRoot, @ColorRes int color) {
        int cx = (v.getLeft() + v.getRight()) / 2;
        int cy = (v.getTop() + v.getBottom()) / 2;
        animateRevealColorFromCoordinates(viewRoot, color, cx, cy);
    }

    private Animator animateRevealColorFromCoordinates(ViewGroup viewRoot, @ColorRes int color, int x, int y) {
        float finalRadius = (float) Math.hypot(viewRoot.getWidth(), viewRoot.getHeight());

        Animator anim = ViewAnimationUtils.createCircularReveal(viewRoot, x, y, 0, finalRadius);
        viewRoot.setBackgroundColor(ContextCompat.getColor(this, color));
        anim.setDuration(getResources().getInteger(R.integer.anim_duration_long));
        anim.setInterpolator(new AccelerateDecelerateInterpolator());
        anim.start();
        return anim;
    }

    private void animateRevealHide(View v, final View viewRoot) {
        int cx = (v.getLeft() + v.getRight()) / 2;
        int cy = (v.getTop() + v.getBottom()) / 2;
        int initialRadius = viewRoot.getWidth();

        Animator anim = ViewAnimationUtils.createCircularReveal(viewRoot, cx, cy, initialRadius, 0);
        anim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                viewRoot.setVisibility(View.INVISIBLE);
            }
        });
        anim.setDuration(getResources().getInteger(R.integer.anim_duration_medium));
        anim.start();
    }

    public void setIconForType(ImageView icon, int itemType) {
        switch (itemType) {
            case Constants.LIFE_ITEM_TYPE_XINGZUO:
                icon.setImageResource(R.drawable.constellation_icon);
                break;
            case Constants.LIFE_ITEM_TYPE_JIEMENG:
                icon.setImageResource(R.drawable.test_icon);
                break;
            case Constants.LIFE_ITEM_TYPE_XIAOHUA:
                icon.setImageResource(R.drawable.laugh_icon);
                break;
            case Constants.LIFE_ITEM_TYPE_LAOHUANGLI:
                icon.setImageResource(R.drawable.test_icon);
                break;
            case Constants.LIFE_ITEM_TYPE_LISHI:
                icon.setImageResource(R.drawable.test_icon);
                break;
            case Constants.LIFE_ITEM_TYPE_HAOMA:
                icon.setImageResource(R.drawable.test_icon);
                break;
        }
    }

    public void setBackgroundForType(ImageView background, int itemType) {
        switch (itemType) {
            case Constants.LIFE_ITEM_TYPE_XINGZUO:
                GlideLoader.loadLocalResWithMemCache(this,
                        R.drawable.constellation_background, background);
                break;
            case Constants.LIFE_ITEM_TYPE_JIEMENG:
                background.setImageResource(R.mipmap.ic_launcher);
                break;
            case Constants.LIFE_ITEM_TYPE_XIAOHUA:
                GlideLoader.loadLocalResWithMemCache(this,
                        R.drawable.laugh_background_big, background);
                break;
            case Constants.LIFE_ITEM_TYPE_LAOHUANGLI:
                background.setImageResource(R.mipmap.ic_launcher);
                break;
            case Constants.LIFE_ITEM_TYPE_LISHI:
                background.setImageResource(R.mipmap.ic_launcher);
                break;
            case Constants.LIFE_ITEM_TYPE_HAOMA:
                background.setImageResource(R.mipmap.ic_launcher);
                break;
        }
    }

//    public void setContactsMap(Map<String, EaseUser> contactsMap){
//        this.contactsMap = contactsMap;
//    }
}
