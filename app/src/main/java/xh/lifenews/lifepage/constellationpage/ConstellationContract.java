package xh.lifenews.lifepage.constellationpage;

import xh.lifenews.BasePresenter;
import xh.lifenews.BaseView;
import xh.lifenews.model.object.constellation.ConsMonthEntry;
import xh.lifenews.model.object.constellation.ConsNextWeekEntry;
import xh.lifenews.model.object.constellation.ConsTodayEntry;
import xh.lifenews.model.object.constellation.ConsTomorrowEntry;
import xh.lifenews.model.object.constellation.ConsWeekEntry;
import xh.lifenews.model.object.constellation.ConsYearEntry;

/**
 * Created by bamboo on 16-12-3.
 */

public interface ConstellationContract {

    interface Presenter extends BasePresenter {
        void getConsTodayEntry(String cons);
        void getConsTomorrowEntry(String cons);
        void getConsWeekEntry(String cons);
        void getConsNextWeekEntry(String cons);
        void getConsMonthEntry(String cons);
        void getConsYearEntry(String cons);
        void getConsInfo(String cons, String time);
    }

    interface View extends BaseView<Presenter> {
        void showErrorInfo(String s);

        void updateConsTodayView(ConsTodayEntry entry);
        void updateConsTomorrowView(ConsTomorrowEntry entry);
        void updateConsWeekView(ConsWeekEntry entry);
        void updateConsNextWeekView(ConsNextWeekEntry entry);
        void updateConsMonthView(ConsMonthEntry entry);
        void updateConsYearView(ConsYearEntry entry);
    }

}
