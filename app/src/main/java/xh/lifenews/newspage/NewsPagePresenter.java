package xh.lifenews.newspage;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;
import xh.lifenews.model.Constants;
import xh.lifenews.model.AppRepository;
import xh.lifenews.model.NewsTitle;
import xh.lifenews.model.object.news.NewsEntry;
import xh.lifenews.model.object.news.NewsRequestResult;

/**
 * Created by bamboo on 16-11-28.
 * 可以不接受position，让Fragment来处理position
 */

public class NewsPagePresenter implements NewsPageContract.Presenter {


    private AppRepository mNewsRepository;
    private NewsPageContract.View mView;
    private int mPosition;
    private CompositeSubscription mSubscriptions;

    public NewsPagePresenter(AppRepository repository,
                             NewsPageContract.View view,
                             int position) {
        mNewsRepository = repository;
        mView = view;
        mView.setPresenter(this);
        mPosition = position;
        mSubscriptions = new CompositeSubscription();
    }

    @Override
    public void loadNews(boolean isShowProgressBar) {
        Log.d("loadNews", "type = "+getNewsType());
        if (isShowProgressBar) {
            mView.showProgressBar();
        }

        mSubscriptions.clear();
        Subscription subscription = mNewsRepository.getNews(getNewsType())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<NewsRequestResult>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("loadNews", "error");
                        mView.showErrorInfo(e.getMessage());
                    }

                    @Override
                    public void onNext(NewsRequestResult result) {
                        if (result == null) return;
                        updateView(result.getResult().getNewsEntries());
                    }
                });
        mSubscriptions.add(subscription);

        mNewsRepository.getSinaNews()
                .toList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<NewsTitle>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("test", "error: "+e.getLocalizedMessage());
                    }

                    @Override
                    public void onNext(List<NewsTitle> newsTitles) {
                        for (NewsTitle newsTitle : newsTitles) {
                            Log.d("test", "news: "+newsTitle.getTitle()+", "+newsTitle.getUrl());
                            loadNewsDetail(newsTitle.getUrl());
                        }
                    }
                });
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {
        mSubscriptions.clear();
    }

    private String getNewsType() {
        return Constants.NEWS_TYPES[mPosition];
    }

    @Override
    public void loadDetailNews(NewsEntry newsEntry) {
        mView.showDetailPage(newsEntry);
    }

    private void updateView(List<NewsEntry> entries) {
        int imageNum = 0;
        switch (mPosition) {
            case Constants.POSITION_TOP_NEWS:
                imageNum = 3;
                break;
            case Constants.POSITION_SHEHUI_NEWS:
                imageNum = 1;
                break;
            case Constants.POSITION_YULE_NEWS:
                imageNum = 2;
                break;
            case Constants.POSITION_SHISHANG_NEWS:
                imageNum = 3;
                break;
            case Constants.POSITION_KEJI_NEWS:
                imageNum = 2;
                break;
            default:
                imageNum = 0;
        }

        ArrayList<NewsEntry> imageEntries = new ArrayList<>();
        ArrayList<NewsEntry> newsEntries = new ArrayList<>();
        for (int i = 0; i < entries.size(); i++) {
            if (i < imageNum) {
                imageEntries.add(entries.get(i));
            } else {
                newsEntries.add(entries.get(i));
            }
        }
        mView.updatePreviewImage(imageEntries);
        mView.updateListItem(newsEntries);
        mView.completeRefresh();
    }

    public void loadNewsDetail(String url) {
        mNewsRepository.getNewsDetail(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("test", "error: "+e.getLocalizedMessage());
                    }

                    @Override
                    public void onNext(String s) {
                        Log.d("testdetail", "news detail: "+s);
                    }
                });
    }
}
