package xh.lifenews.lifepage.constellationpage;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import xh.lifenews.model.AppRepository;
import xh.lifenews.model.Constants;
import xh.lifenews.model.object.constellation.ConsMonthEntry;
import xh.lifenews.model.object.constellation.ConsNextWeekEntry;
import xh.lifenews.model.object.constellation.ConsTodayEntry;
import xh.lifenews.model.object.constellation.ConsTomorrowEntry;
import xh.lifenews.model.object.constellation.ConsWeekEntry;
import xh.lifenews.model.object.constellation.ConsYearEntry;

/**
 * Created by bamboo on 16-12-3.
 */

public class ConstellationPresenter implements ConstellationContract.Presenter {

    private AppRepository mAppRepository;
    private ConstellationContract.View mView;

    public ConstellationPresenter(AppRepository repository,
                                  ConstellationContract.View view) {
        mAppRepository = repository;
        mView = view;
        mView.setPresenter(this);
    }

    @Override
    public void getConsTodayEntry(String cons) {
        mAppRepository.getTodayConsInfo(cons)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ConsTodayEntry>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showErrorInfo(e.getMessage());
                    }

                    @Override
                    public void onNext(ConsTodayEntry consTodayEntry) {
                        mView.updateConsTodayView(consTodayEntry);
                    }
                });
    }

    @Override
    public void getConsTomorrowEntry(String cons) {
        mAppRepository.getTomorrowConsInfo(cons)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ConsTomorrowEntry>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showErrorInfo(e.getMessage());
                    }

                    @Override
                    public void onNext(ConsTomorrowEntry consTomorrowEntry) {
                        mView.updateConsTomorrowView(consTomorrowEntry);
                    }
                });
    }

    @Override
    public void getConsWeekEntry(String cons) {
        mAppRepository.getWeekConsInfo(cons)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ConsWeekEntry>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showErrorInfo(e.getMessage());
                    }

                    @Override
                    public void onNext(ConsWeekEntry consWeekEntry) {
                        mView.updateConsWeekView(consWeekEntry);
                    }
                });
    }

    @Override
    public void getConsNextWeekEntry(String cons) {
        mAppRepository.getNextWeekConsInfo(cons)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ConsNextWeekEntry>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showErrorInfo(e.getMessage());
                    }

                    @Override
                    public void onNext(ConsNextWeekEntry consNextWeekEntry) {
                        mView.updateConsNextWeekView(consNextWeekEntry);
                    }
                });
    }

    @Override
    public void getConsMonthEntry(String cons) {
        mAppRepository.getMonthConsInfo(cons)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ConsMonthEntry>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showErrorInfo(e.getMessage());
                    }

                    @Override
                    public void onNext(ConsMonthEntry consMonthEntry) {
                        mView.updateConsMonthView(consMonthEntry);
                    }
                });
    }

    @Override
    public void getConsYearEntry(String cons) {
        mAppRepository.getYearConsInfo(cons)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ConsYearEntry>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showErrorInfo(e.getMessage());
                    }

                    @Override
                    public void onNext(ConsYearEntry consYearEntry) {
                        mView.updateConsYearView(consYearEntry);
                    }
                });
    }

    @Override
    public void getConsInfo(String cons, String time) {
        if (time.equals(Constants.CONSTELLATION_QUERY_TYPE_TODAY)) {
            getConsTodayEntry(cons);
        } if (time.equals(Constants.CONSTELLATION_QUERY_TYPE_TOMORROW)) {
            getConsTomorrowEntry(cons);
        } if (time.equals(Constants.CONSTELLATION_QUERY_TYPE_WEEK)) {
            getConsWeekEntry(cons);
        } if (time.equals(Constants.CONSTELLATION_QUERY_TYPE_NEXTWEEK)) {
            getConsNextWeekEntry(cons);
        } if (time.equals(Constants.CONSTELLATION_QUERY_TYPE_MONTH)) {
            getConsMonthEntry(cons);
        } if (time.equals(Constants.CONSTELLATION_QUERY_TYPE_YEAR)) {
            getConsYearEntry(cons);
        }
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }
}
