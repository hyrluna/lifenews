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

public interface AppData {

    Observable<NewsRequestResult> getNews(String type);

    Observable<PhoneEntry> getPhoneInfo(int phone);

    //constellation
    Observable<ConsTodayEntry> getTodayConsInfo(String consName);
    Observable<ConsTomorrowEntry> getTomorrowConsInfo(String consName);
    Observable<ConsWeekEntry> getWeekConsInfo(String consName);
    Observable<ConsNextWeekEntry> getNextWeekConsInfo(String consName);
    Observable<ConsMonthEntry> getMonthConsInfo(String consName);
    Observable<ConsYearEntry> getYearConsInfo(String consName);

    //joke
    Observable<RandomJokeResult> getRandomJoke(String type);

    Observable<NewestJokeResult> getNewestJoke(int page, int pagesize);

    Observable<NewestPicResult> getNewestPic(int page, int pagesize);

    //almanac
    Observable<AlmanacHourResult> getAlmanacHourData(String date);

    Observable<AlmanacDayResult> getAlmanacDayData(String date);

    Observable<NewsTitle> getSinaNews();

    Observable<String> getNewsDetail(String url);
}
