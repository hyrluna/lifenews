package xh.lifenews.lifepage.phonepage;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import xh.lifenews.model.AppRepository;
import xh.lifenews.model.object.phone.PhoneEntry;

/**
 * Created by bamboo on 16-12-4.
 */

public class PhonePresenter implements PhoneContract.Presenter {

    private AppRepository mAppRepository;
    private PhoneContract.View mView;

    public PhonePresenter(AppRepository repository,
                          PhoneContract.View view) {
        mAppRepository = repository;
        mView = view;
        mView.setPresenter(this);
    }

    @Override
    public void loadPhoneInfo(int phoneNumber) {
        mAppRepository.getPhoneInfo(phoneNumber)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<PhoneEntry>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(PhoneEntry phoneEntry) {
                        mView.updatePhoneView(phoneEntry);
                    }
                });
    }

    @Override
    public void unsubscribe() {

    }

    @Override
    public void subscribe() {

    }

}
