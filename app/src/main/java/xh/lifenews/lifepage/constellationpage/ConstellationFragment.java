package xh.lifenews.lifepage.constellationpage;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aigestudio.wheelpicker.WheelPicker;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import xh.lifenews.GlideLoader;
import xh.lifenews.R;
import xh.lifenews.model.Constants;
import xh.lifenews.model.object.constellation.ConsMonthEntry;
import xh.lifenews.model.object.constellation.ConsNextWeekEntry;
import xh.lifenews.model.object.constellation.ConsTodayEntry;
import xh.lifenews.model.object.constellation.ConsTomorrowEntry;
import xh.lifenews.model.object.constellation.ConsWeekEntry;
import xh.lifenews.model.object.constellation.ConsYearEntry;
import xh.lifenews.utils.Util;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ConstellationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ConstellationFragment extends Fragment
        implements ConstellationContract.View, WheelPicker.OnItemSelectedListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    private String mConsName;
    private String mConsQueryTime;

    private ConstellationContract.Presenter mPresenter;
    private TextView textView;
    private LinearLayout consContentLayout;
    private LayoutInflater mInflater;
    private LinearLayout mTodayLayout;
    private LinearLayout mTomorrowLayout;
    private LinearLayout mWeekLayout;
    private ImageView contentBackground;

    public ArrayList<View> mViews = new ArrayList<>();

    public ConstellationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ConstellationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ConstellationFragment newInstance(String param1, String param2) {
        ConstellationFragment fragment = new ConstellationFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void setPresenter(ConstellationContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showErrorInfo(String s) {
        Util.showToast(getActivity(), s);
    }

    @Override
    public void updateConsTodayView(ConsTodayEntry entry) {
        LinearLayout todayLayout = (LinearLayout) mInflater.inflate(R.layout.dynamic_cons_today_layout, null);
        TodayViewHolder holder = new TodayViewHolder(todayLayout);
        if (entry != null) {
            holder.bindView(entry);
        }
        replaceView(consContentLayout, todayLayout);
    }

    @Override
    public void updateConsTomorrowView(ConsTomorrowEntry entry) {
        LinearLayout tomorrowLayout =
                (LinearLayout) mInflater.inflate(R.layout.dynamic_cons_tomorrow_layout, null);
        TomorrowViewHolder holder = new TomorrowViewHolder(tomorrowLayout);
        if (entry != null)
            holder.bindView(entry);
        replaceView(consContentLayout, tomorrowLayout);
    }

    @Override
    public void updateConsWeekView(ConsWeekEntry entry) {
        LinearLayout weekLayout =
                (LinearLayout) mInflater.inflate(R.layout.dynamic_cons_week_layout, null);
        WeekViewHolder holder = new WeekViewHolder(weekLayout);
        if (entry != null) {
            holder.bindView(entry);
        }
        replaceView(consContentLayout, weekLayout);
    }

    @Override
    public void updateConsNextWeekView(ConsNextWeekEntry entry) {
        LinearLayout nextweekLayout =
                (LinearLayout) mInflater.inflate(R.layout.dynamic_cons_nextweek_layout, null);
        NextWeekViewHolder holder = new NextWeekViewHolder(nextweekLayout);
        if (entry != null) {
            holder.bindView(entry);
        }
        replaceView(consContentLayout, nextweekLayout);
    }

    @Override
    public void updateConsMonthView(ConsMonthEntry entry) {
        LinearLayout monthLayout =
                (LinearLayout) mInflater.inflate(R.layout.dynamic_cons_month_layout, null);
        MonthViewHolder holder = new MonthViewHolder(monthLayout);
        if (entry != null) {
            holder.bindView(entry);
        }
        replaceView(consContentLayout, monthLayout);
    }

    @Override
    public void updateConsYearView(ConsYearEntry entry) {
        LinearLayout yearLayout =
                (LinearLayout) mInflater.inflate(R.layout.dynamic_cons_year_layout, null);
        YearViewHolder holder = new YearViewHolder(yearLayout);
        if (entry != null) {
            holder.bindView(entry);
        }
        replaceView(consContentLayout, yearLayout);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        mConsName = Constants.CONS_NAMES[0];
        mConsQueryTime = Constants.CONS_QUERY_TIMES[0];
        mPresenter.getConsInfo(mConsName, mConsQueryTime);

        mInflater = LayoutInflater.from(getActivity());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_constellation, container, false);

        consContentLayout = (LinearLayout) v.findViewById(R.id.cons_content_layout);

        WheelPicker wheelNames = (WheelPicker) v.findViewById(R.id.cons_wheel_view_names);
        List<String> items = new ArrayList<>();
        items.addAll(Arrays.asList(Constants.CONS_NAMES));
        wheelNames.setData(items);
        wheelNames.setOnItemSelectedListener(this);

        WheelPicker wheelTimes = (WheelPicker) v.findViewById(R.id.cons_wheel_view_times);
        wheelTimes.setData(Arrays.asList(Constants.CONS_QUERY_TIMES_CN));
        wheelTimes.setOnItemSelectedListener(this);

        Button queryButton = (Button) v.findViewById(R.id.cons_query_button);
        queryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.getConsInfo(mConsName, mConsQueryTime);
            }
        });
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onItemSelected(WheelPicker picker, Object data, int position) {
        String item = "";
        if (data instanceof String) {
            item = (String) data;
        }
        switch (picker.getId()) {
            case R.id.cons_wheel_view_names:
                mConsName = item;
                break;
            case R.id.cons_wheel_view_times:
                mConsQueryTime = item;
                break;
        }
    }

    public void replaceView(LinearLayout layout, View v) {
        layout.removeAllViews();
        layout.addView(v);
    }

    private class TodayViewHolder {
        TextView nameText;
        TextView qfriendText;
        TextView summaryText;
        TextView dateText;

        public TodayViewHolder(View contentView) {
            nameText = (TextView) contentView.findViewById(R.id.dynamic_today_cons_name);
            qfriendText = (TextView) contentView.findViewById(R.id.dynamic_today_cons_qfirend);
            summaryText = (TextView) contentView.findViewById(R.id.dynamic_today_cons_summary);
            dateText = (TextView) contentView.findViewById(R.id.dynamic_today_cons_datetime);
        }

        public void bindView(ConsTodayEntry entry) {
            nameText.setText("星座名： "+entry.getName());
            qfriendText.setText("友好星座： "+entry.getQFriend());
            summaryText.setText("总结： "+entry.getSummary());
            dateText.setText("日期： "+entry.getDatetime());
        }
    }

    private class TomorrowViewHolder {
        TextView nameText;
        TextView qfriendText;
        TextView summaryText;
        TextView dateText;

        public TomorrowViewHolder(View contentView) {
            nameText = (TextView) contentView.findViewById(R.id.dynamic_tomorrow_cons_name);
            qfriendText = (TextView) contentView.findViewById(R.id.dynamic_tomorrow_cons_qfirend);
            summaryText = (TextView) contentView.findViewById(R.id.dynamic_tomorrow_cons_summary);
            dateText = (TextView) contentView.findViewById(R.id.dynamic_tomorrow_cons_datetime);
        }

        public void bindView(ConsTomorrowEntry entry) {
            nameText.setText("星座名： "+entry.getName());
            qfriendText.setText("友好星座： "+entry.getQFriend());
            summaryText.setText("总结： "+entry.getSummary());
            dateText.setText("日期： "+entry.getDatetime());
        }
    }

    private class WeekViewHolder {
        TextView nameText;
        TextView heathText;
        TextView jobText;
        TextView loveText;
        TextView moneyText;
        TextView workText;

        public WeekViewHolder(View contentView) {
            nameText = (TextView) contentView.findViewById(R.id.dynamic_week_cons_name);
            heathText = (TextView) contentView.findViewById(R.id.dynamic_week_cons_health);
            jobText = (TextView) contentView.findViewById(R.id.dynamic_week_cons_job);
            loveText = (TextView) contentView.findViewById(R.id.dynamic_week_cons_love);
            moneyText = (TextView) contentView.findViewById(R.id.dynamic_week_cons_money);
            workText = (TextView) contentView.findViewById(R.id.dynamic_week_cons_work);
        }

        public void bindView(ConsWeekEntry entry) {
            nameText.setText("星座名： "+entry.getName());
            heathText.setText("健康： "+entry.getHealth());
            jobText.setText("求职： "+entry.getJob());
            loveText.setText("爱情： "+entry.getLove());
            moneyText.setText("财运： "+entry.getMoney());
            workText.setText("工作： "+entry.getWork());
        }
    }

    private class NextWeekViewHolder {
        TextView nameText;
        TextView heathText;
        TextView jobText;
        TextView loveText;
        TextView moneyText;
        TextView workText;

        public NextWeekViewHolder(View contentView) {
            nameText = (TextView) contentView.findViewById(R.id.dynamic_nextweek_cons_name);
            heathText = (TextView) contentView.findViewById(R.id.dynamic_nextweek_cons_health);
            jobText = (TextView) contentView.findViewById(R.id.dynamic_nextweek_cons_job);
            loveText = (TextView) contentView.findViewById(R.id.dynamic_nextweek_cons_love);
            moneyText = (TextView) contentView.findViewById(R.id.dynamic_nextweek_cons_money);
            workText = (TextView) contentView.findViewById(R.id.dynamic_nextweek_cons_work);
        }

        public void bindView(ConsNextWeekEntry entry) {
            nameText.setText("星座名： "+entry.getName());
            heathText.setText("健康： "+entry.getHealth());
            jobText.setText("求职： "+entry.getJob());
            loveText.setText("爱情： "+entry.getLove());
            moneyText.setText("财运： "+entry.getMoney());
            workText.setText("工作： "+entry.getWork());
        }
    }

    private class MonthViewHolder {
        TextView nameText;
        TextView heathText;
        TextView allText;
        TextView loveText;
        TextView moneyText;
        TextView workText;

        public MonthViewHolder(View contentView) {
            nameText = (TextView) contentView.findViewById(R.id.dynamic_month_cons_name);
            heathText = (TextView) contentView.findViewById(R.id.dynamic_month_cons_health);
            allText = (TextView) contentView.findViewById(R.id.dynamic_month_cons_all);
            loveText = (TextView) contentView.findViewById(R.id.dynamic_month_cons_love);
            moneyText = (TextView) contentView.findViewById(R.id.dynamic_month_cons_money);
            workText = (TextView) contentView.findViewById(R.id.dynamic_month_cons_work);
        }

        public void bindView(ConsMonthEntry entry) {
            nameText.setText("星座名： "+entry.getName());
            heathText.setText("健康： "+entry.getHealth());
            allText.setText("总结： "+entry.getAll());
            loveText.setText("爱情： "+entry.getLove());
            moneyText.setText("财运： "+entry.getMoney());
            workText.setText("工作： "+entry.getWork());
        }
    }

    private class YearViewHolder {
        TextView nameText;
        TextView heathText;
        TextView infoText;
        TextView loveText;
        TextView textText;
        TextView careerText;
        TextView financeText;
        TextView luckyStoneText;
        TextView futureText;

        public YearViewHolder(View contentView) {
            nameText = (TextView) contentView.findViewById(R.id.dynamic_year_cons_name);
            heathText = (TextView) contentView.findViewById(R.id.dynamic_year_cons_health);
            infoText = (TextView) contentView.findViewById(R.id.dynamic_year_cons_info);
            loveText = (TextView) contentView.findViewById(R.id.dynamic_year_cons_love);
            textText = (TextView) contentView.findViewById(R.id.dynamic_year_cons_text);
            careerText = (TextView) contentView.findViewById(R.id.dynamic_year_cons_career);
            financeText = (TextView) contentView.findViewById(R.id.dynamic_year_cons_finance);
            luckyStoneText = (TextView) contentView.findViewById(R.id.dynamic_year_cons_luckyStone);
            futureText = (TextView) contentView.findViewById(R.id.dynamic_year_cons_future);
        }

        public void bindView(ConsYearEntry entry) {
            nameText.setText("星座名： "+entry.getName());
            heathText.setText("健康： "+entry.getHealth());
            infoText.setText("信息： "+entry.getMima().getInfo());
            loveText.setText("爱情： "+entry.getLove());
            textText.setText("文本： "+entry.getMima().getText());
            careerText.setText("职业： "+entry.getCareer());
            financeText.setText("财政： "+entry.getFinance());
            luckyStoneText.setText("幸运石： "+entry.getLuckyStone());
            futureText.setText("未来： "+entry.getFuture());
        }
    }

}
