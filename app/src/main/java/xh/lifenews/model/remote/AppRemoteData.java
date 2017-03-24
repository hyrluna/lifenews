package xh.lifenews.model.remote;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import xh.lifenews.model.AppData;
import xh.lifenews.model.NewsTitle;
import xh.lifenews.model.object.almanac.AlmanacDayResult;
import xh.lifenews.model.object.almanac.AlmanacHourResult;
import xh.lifenews.model.object.constellation.ConsMonthEntry;
import xh.lifenews.model.object.constellation.ConsNextWeekEntry;
import xh.lifenews.model.object.constellation.ConsTodayEntry;
import xh.lifenews.model.object.constellation.ConsTomorrowEntry;
import xh.lifenews.model.object.constellation.ConsWeekEntry;
import xh.lifenews.model.object.constellation.ConsYearEntry;
import xh.lifenews.model.object.joke.NewestJokeResult;
import xh.lifenews.model.object.joke.NewestPicResult;
import xh.lifenews.model.object.joke.RandomJokeResult;
import xh.lifenews.model.object.news.NewsRequestResult;
import xh.lifenews.model.object.phone.PhoneEntry;

/**
 * Created by bamboo on 16-11-28.
 */

public class AppRemoteData implements AppData {

    private static AppRemoteData INSTANCE = null;

    private NewsRequest mNewsRequest;
    private JokeRequest mJokeRequest;
    private ConsRequest mConsRequest;
    private AlmanacRequest mAlmanacRequest;
    private PhoneRequest mPhoneRequest;
    private SpiderNetworkRequest spiderNetworkRequest;

    public static AppRemoteData getInstance () {
        if (INSTANCE == null) {
            INSTANCE = new AppRemoteData();
        }
        return INSTANCE;
    }

    private AppRemoteData() {
        mNewsRequest = new NewsRequest();
        mPhoneRequest = new PhoneRequest();
        mJokeRequest = new JokeRequest();
        mConsRequest = new ConsRequest();
        mAlmanacRequest = new AlmanacRequest();
        spiderNetworkRequest = new SpiderNetworkRequest();
    }

    @Override
    public Observable<NewsRequestResult> getNews(String type) {
        return mNewsRequest.getNews(type);
    }

    @Override
    public Observable<PhoneEntry> getPhoneInfo(int phone) {
        return mPhoneRequest.getPhoneInfo(phone);
    }

    //constellation request
    @Override
    public Observable<ConsTodayEntry> getTodayConsInfo(String consName) {
        return mConsRequest.getTodayConsInfo(consName);
    }

    @Override
    public Observable<ConsTomorrowEntry> getTomorrowConsInfo(String consName) {
        return mConsRequest.getTomorrowConsInfo(consName);
    }

    @Override
    public Observable<ConsWeekEntry> getWeekConsInfo(String consName) {
        return mConsRequest.getWeekConsInfo(consName);
    }

    @Override
    public Observable<ConsNextWeekEntry> getNextWeekConsInfo(String consName) {
        return mConsRequest.getNextWeekConsInfo(consName);
    }

    @Override
    public Observable<ConsMonthEntry> getMonthConsInfo(String consName) {
        return mConsRequest.getMonthConsInfo(consName);
    }

    @Override
    public Observable<ConsYearEntry> getYearConsInfo(String consName) {
        return mConsRequest.getYearConsInfo(consName);
    }

    //joke request
    @Override
    public Observable<RandomJokeResult> getRandomJoke(String type) {
        return mJokeRequest.getRandomJoke(type);
    }

    @Override
    public Observable<NewestJokeResult> getNewestJoke(int page, int pagesize) {
        return mJokeRequest.getNewestJoke(page, pagesize);
    }

    @Override
    public Observable<NewestPicResult> getNewestPic(int page, int pagesize) {
        return mJokeRequest.getNewestPic(page, pagesize);
    }

    //almanac data
    @Override
    public Observable<AlmanacHourResult> getAlmanacHourData(String date) {
        return mAlmanacRequest.getAlmanacHourData(date);
    }

    @Override
    public Observable<AlmanacDayResult> getAlmanacDayData(String date) {
        return mAlmanacRequest.getAlmanacDayData(date);
    }

    @Override
    public Observable<NewsTitle> getSinaNews() {
        return spiderNetworkRequest.getNewsTitles();
    }

    @Override
    public Observable<String> getNewsDetail(String url) {
        return spiderNetworkRequest.getNewsDetail(url);
    }
}
