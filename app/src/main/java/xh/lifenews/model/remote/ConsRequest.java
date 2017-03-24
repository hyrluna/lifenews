package xh.lifenews.model.remote;

import rx.Observable;
import xh.lifenews.model.object.constellation.ConsMonthEntry;
import xh.lifenews.model.object.constellation.ConsNextWeekEntry;
import xh.lifenews.model.object.constellation.ConsTodayEntry;
import xh.lifenews.model.object.constellation.ConsTomorrowEntry;
import xh.lifenews.model.object.constellation.ConsWeekEntry;
import xh.lifenews.model.object.constellation.ConsYearEntry;

/**
 * Created by bamboo on 16-12-3.
 */

public class ConsRequest extends RemoteRequest {
    public static final String APPKEY_CONSTELLATION = "b8027275215f89da0e4eacee7372803c";
    public static final String BASE_URL_CONSTELLATION = "http://web.juhe.cn:8080";
    public static final String TYPE_TODAY = "today";
    public static final String TYPE_TOMORROW = "tomorrow";
    public static final String TYPE_WEEK = "week";
    public static final String TYPE_NEXT_WEEK = "nextweek";
    public static final String TYPE_MONTH = "month";
    public static final String TYPE_YEAR = "year";

    private ConstellationService mConsService;

    public ConsRequest() {
        mConsService = getRetrofit(BASE_URL_CONSTELLATION).create(ConstellationService.class);
    }

    public Observable<ConsTodayEntry> getTodayConsInfo(String consName) {
        return mConsService.getConsTodayEntry(consName, TYPE_TODAY, APPKEY_CONSTELLATION);
    }

    public Observable<ConsTomorrowEntry> getTomorrowConsInfo(String consName) {
        return mConsService.getConsTomorrowEntry(consName, TYPE_TOMORROW, APPKEY_CONSTELLATION);
    }

    public Observable<ConsWeekEntry> getWeekConsInfo(String consName) {
        return mConsService.getConsWeekEntry(consName, TYPE_WEEK, APPKEY_CONSTELLATION);
    }

    public Observable<ConsNextWeekEntry> getNextWeekConsInfo(String consName) {
        return mConsService.getConsNextWeekEntry(consName, TYPE_NEXT_WEEK, APPKEY_CONSTELLATION);
    }

    public Observable<ConsMonthEntry> getMonthConsInfo(String consName) {
        return mConsService.getConsMonthEntry(consName, TYPE_MONTH, APPKEY_CONSTELLATION);
    }

    public Observable<ConsYearEntry> getYearConsInfo(String consName) {
        return mConsService.getConsYearEntry(consName, TYPE_YEAR, APPKEY_CONSTELLATION);
    }

}
