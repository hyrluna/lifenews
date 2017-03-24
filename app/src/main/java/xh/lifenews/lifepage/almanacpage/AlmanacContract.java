package xh.lifenews.lifepage.almanacpage;

import java.util.List;

import xh.lifenews.BasePresenter;
import xh.lifenews.BaseView;
import xh.lifenews.model.object.almanac.AlmanacDayEntry;
import xh.lifenews.model.object.almanac.AlmanacHourEntry;

/**
 * Created by bamboo on 16-12-4.
 */

public interface AlmanacContract {
    interface Presenter extends BasePresenter {
        void loadAlmanacHourData(String date);
        void loadAlmanacDayData(String date);
    }

    interface View extends BaseView<Presenter> {
        void showErrorInfo(String error);
        void updateAlmanacHourView(List<AlmanacHourEntry> entries);
        void updateAlmanacDayView(AlmanacDayEntry entry);
    }
}
