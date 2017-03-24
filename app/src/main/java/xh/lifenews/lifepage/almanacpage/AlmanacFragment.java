package xh.lifenews.lifepage.almanacpage;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import xh.lifenews.R;
import xh.lifenews.model.object.almanac.AlmanacDayEntry;
import xh.lifenews.model.object.almanac.AlmanacHourEntry;
import xh.lifenews.utils.Util;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AlmanacFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AlmanacFragment extends Fragment implements AlmanacContract.View {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private AlmanacContract.Presenter mPresenter;
    private TextView textView;


    public AlmanacFragment() {
        // Required empty public constructor
    }

    public static AlmanacFragment newInstance(String param1, String param2) {
        AlmanacFragment fragment = new AlmanacFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void setPresenter(AlmanacContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showErrorInfo(String error) {
        Util.showToast(getActivity(), error);
    }

    @Override
    public void updateAlmanacHourView(List<AlmanacHourEntry> entries) {
        if (entries != null && entries.size() > 0) {
            textView.setText(entries.get(0).getDes());
        }
    }

    @Override
    public void updateAlmanacDayView(AlmanacDayEntry entry) {
        if (entry != null) {
            textView.setText(entry.getYi());
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        mPresenter.loadAlmanacDayData("2016-12-1");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_almanac, container, false);
        textView = (TextView) v.findViewById(R.id.test_info);
        return v;
    }

}
