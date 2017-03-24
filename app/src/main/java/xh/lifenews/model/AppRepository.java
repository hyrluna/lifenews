package xh.lifenews.model;

import rx.Observable;
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

public class AppRepository implements AppData {

    private AppData mLocalData;
    private AppData mRemoteData;
    private static AppRepository INSTANCE = null;

    public static AppRepository getInstance(AppData localData, AppData remoteData) {
        if (INSTANCE == null) {
            INSTANCE = new AppRepository(localData, remoteData);
        }
        return INSTANCE;
    }

    private AppRepository(AppData localData, AppData remoteData) {
        mLocalData = localData;
        mRemoteData = remoteData;
    }

    @Override
    public Observable<NewsRequestResult> getNews(String type) {
        return mRemoteData.getNews(type);
    }

    @Override
    public Observable<PhoneEntry> getPhoneInfo(int phone) {
        return mRemoteData.getPhoneInfo(phone);
    }

    @Override
    public Observable<ConsTodayEntry> getTodayConsInfo(String consName) {
        return mRemoteData.getTodayConsInfo(consName);
    }

    @Override
    public Observable<ConsTomorrowEntry> getTomorrowConsInfo(String consName) {
        return mRemoteData.getTomorrowConsInfo(consName);
    }

    @Override
    public Observable<ConsWeekEntry> getWeekConsInfo(String consName) {
        return mRemoteData.getWeekConsInfo(consName);
    }

    @Override
    public Observable<ConsNextWeekEntry> getNextWeekConsInfo(String consName) {
        return mRemoteData.getNextWeekConsInfo(consName);
    }

    @Override
    public Observable<ConsMonthEntry> getMonthConsInfo(String consName) {
        return mRemoteData.getMonthConsInfo(consName);
    }

    @Override
    public Observable<ConsYearEntry> getYearConsInfo(String consName) {
        return mRemoteData.getYearConsInfo(consName);
    }

    @Override
    public Observable<RandomJokeResult> getRandomJoke(String type) {
        return mRemoteData.getRandomJoke(type);
    }

    @Override
    public Observable<NewestJokeResult> getNewestJoke(int page, int pagesize) {
        return mRemoteData.getNewestJoke(page, pagesize);
    }

    @Override
    public Observable<NewestPicResult> getNewestPic(int page, int pagesize) {
        return mRemoteData.getNewestPic(page, pagesize);
    }

    @Override
    public Observable<AlmanacHourResult> getAlmanacHourData(String date) {
        return mRemoteData.getAlmanacHourData(date);
    }

    @Override
    public Observable<AlmanacDayResult> getAlmanacDayData(String date) {
        return mRemoteData.getAlmanacDayData(date);
    }

    @Override
    public Observable<NewsTitle> getSinaNews() {
        return mRemoteData.getSinaNews();
    }

    @Override
    public Observable<String> getNewsDetail(String url) {
        return mRemoteData.getNewsDetail(url);
    }
}
