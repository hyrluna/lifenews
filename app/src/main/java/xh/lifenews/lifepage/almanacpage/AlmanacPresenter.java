package xh.lifenews.lifepage.almanacpage;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import xh.lifenews.model.AppRepository;
import xh.lifenews.model.object.almanac.AlmanacDayResult;
import xh.lifenews.model.object.almanac.AlmanacHourResult;

/**
 * Created by bamboo on 16-12-4.
 */

public class AlmanacPresenter implements AlmanacContract.Presenter {

    private AppRepository mAppRepository;
    private AlmanacContract.View mView;

    public AlmanacPresenter(AppRepository repository,
                            AlmanacContract.View view) {
        mAppRepository = repository;
        mView = view;
        mView.setPresenter(this);
    }

    @Override
    public void loadAlmanacHourData(String date) {
        mAppRepository.getAlmanacHourData(date)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<AlmanacHourResult>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showErrorInfo(e.getMessage());
                    }

                    @Override
                    public void onNext(AlmanacHourResult almanacHourResult) {
                        mView.updateAlmanacHourView(almanacHourResult.getResult());
                    }
                });
    }

    @Override
    public void loadAlmanacDayData(String date) {
        mAppRepository.getAlmanacDayData(date)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<AlmanacDayResult>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showErrorInfo(e.getMessage());
                    }

                    @Override
                    public void onNext(AlmanacDayResult almanacDayResult) {
                        mView.updateAlmanacDayView(almanacDayResult.getResult());
                    }
                });
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }
}
