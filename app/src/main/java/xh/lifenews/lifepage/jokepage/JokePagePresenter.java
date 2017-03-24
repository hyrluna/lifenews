package xh.lifenews.lifepage.jokepage;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import xh.lifenews.model.AppRepository;
import xh.lifenews.model.object.joke.NewestJokeEntry;
import xh.lifenews.model.object.joke.NewestJokeResult;
import xh.lifenews.model.object.joke.NewestPicEntry;
import xh.lifenews.model.object.joke.NewestPicResult;
import xh.lifenews.model.object.joke.RandomJokeResult;

/**
 * Created by bamboo on 16-12-3.
 */

public class JokePagePresenter implements JokePageContract.Presenter {

    private AppRepository mAppRepository;
    private JokePageContract.View mView;
    private int mPosition;

    public JokePagePresenter(AppRepository repository,
                             JokePageContract.View view,
                             int position) {
        mAppRepository = repository;
        mView = view;
        mView.setPresenter(this);
        mPosition = position;
    }

    @Override
    public void unsubscribe() {

    }

    @Override
    public void subscribe() {

    }

    @Override
    public void loadRandomJoke(String type) {
        mAppRepository.getRandomJoke(type)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<RandomJokeResult>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showErrorInfo(e.getMessage());
                    }

                    @Override
                    public void onNext(RandomJokeResult randomJokeResult) {
                        mView.updateRandomJokeOrPicView(randomJokeResult.getRandomJokeEntry());
                    }
                });
    }

    @Override
    public void loadNewestJoke(int page, int pagesize) {
        mAppRepository.getNewestJoke(page, pagesize)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<NewestJokeResult>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showErrorInfo(e.getMessage());
                    }

                    @Override
                    public void onNext(NewestJokeResult newestJokeResult) {
                        List<NewestJokeEntry> entries = newestJokeResult.getResult().getData();
                        mView.updateNewestJokeView(entries);
                    }
                });
    }

    @Override
    public void loadNewestPic(int page, int pagesize) {
        mAppRepository.getNewestPic(page, pagesize)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<NewestPicResult>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showErrorInfo(e.getMessage());
                    }

                    @Override
                    public void onNext(NewestPicResult newestPicResult) {
                        List<NewestPicEntry> entries = newestPicResult.getResult().getData();
                        mView.updateNewestPicView(entries);
                    }
                });
    }
}
