package xh.lifenews.lifepage.phonepage;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import xh.lifenews.R;
import xh.lifenews.model.object.phone.PhoneEntry;
import xh.lifenews.utils.Util;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PhoneFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PhoneFragment extends Fragment implements PhoneContract.View {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private PhoneContract.Presenter mPresenter;
    private TextView phoneInfoText;
    private Button queryButton;
    private EditText inputText;


    public PhoneFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PhoneFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PhoneFragment newInstance(String param1, String param2) {
        PhoneFragment fragment = new PhoneFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void setPresenter(PhoneContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void updatePhoneView(PhoneEntry entry) {
        if (entry != null)
            phoneInfoText.setText(entry.getResult().getProvince()+" "+entry.getResult().getCity());
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
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_phone, container, false);
        phoneInfoText = (TextView) v.findViewById(R.id.test_phone_info);
        inputText = (EditText) v.findViewById(R.id.phone_edit_text);
        queryButton = (Button) v.findViewById(R.id.phone_query_button);

//        inputText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//                if (hasFocus) {
//                    getActivity().getWindow().setSoftInputMode(
//                            WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
//                }
//            }
//        });

        queryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = inputText.getText().toString();
                if (input.length() > 7) {
                    Util.showToast(getActivity(), "请输入手机号前7位数字");
                    return;
                }
                Util.showToast(getActivity(), input);
                int phone = Integer.valueOf(input);
                mPresenter.loadPhoneInfo(phone);
                InputMethodManager manager =
                        (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                if (getActivity().getCurrentFocus() != null)
                    manager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(),
                            InputMethodManager.HIDE_NOT_ALWAYS);
//                getActivity().getWindow().setSoftInputMode(
//                        WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
            }
        });

        return v;
    }

}
