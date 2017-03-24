package xh.lifenews.model.local;

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

public class AppLocalData implements AppData {

    private static AppLocalData INSTANCE = null;

    public static AppLocalData getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AppLocalData();
        }
        return INSTANCE;
    }

    private AppLocalData() {
        super();
    }

    @Override
    public Observable<NewsRequestResult> getNews(String type) {
        return null;
    }

    @Override
    public Observable<PhoneEntry> getPhoneInfo(int phone) {
        return null;
    }

    @Override
    public Observable<ConsTodayEntry> getTodayConsInfo(String consName) {
        return null;
    }

    @Override
    public Observable<ConsTomorrowEntry> getTomorrowConsInfo(String consName) {
        return null;
    }

    @Override
    public Observable<ConsWeekEntry> getWeekConsInfo(String consName) {
        return null;
    }

    @Override
    public Observable<ConsNextWeekEntry> getNextWeekConsInfo(String consName) {
        return null;
    }

    @Override
    public Observable<ConsMonthEntry> getMonthConsInfo(String consName) {
        return null;
    }

    @Override
    public Observable<ConsYearEntry> getYearConsInfo(String consName) {
        return null;
    }

    @Override
    public Observable<RandomJokeResult> getRandomJoke(String type) {
        return null;
    }

    @Override
    public Observable<NewestJokeResult> getNewestJoke(int page, int pagesize) {
        return null;
    }

    @Override
    public Observable<NewestPicResult> getNewestPic(int page, int pagesize) {
        return null;
    }

    @Override
    public Observable<AlmanacDayResult> getAlmanacDayData(String date) {
        return null;
    }

    @Override
    public Observable<AlmanacHourResult> getAlmanacHourData(String date) {
        return null;
    }

    @Override
    public Observable<NewsTitle> getSinaNews() {
        return null;
    }

    @Override
    public Observable<String> getNewsDetail(String url) {
        return null;
    }
}
