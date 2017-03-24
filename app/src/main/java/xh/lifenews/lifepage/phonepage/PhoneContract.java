package xh.lifenews.lifepage.phonepage;

import xh.lifenews.BasePresenter;
import xh.lifenews.BaseView;
import xh.lifenews.model.object.phone.PhoneEntry;

/**
 * Created by bamboo on 16-12-4.
 */

public interface PhoneContract {
    interface Presenter extends BasePresenter {
        void loadPhoneInfo(int phoneNumber);
    }

    interface View extends BaseView<Presenter> {
        void updatePhoneView(PhoneEntry entry);
    }
}
