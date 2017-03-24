package xh.lifenews.model.remote;

import rx.Observable;
import xh.lifenews.model.object.almanac.AlmanacDayResult;
import xh.lifenews.model.object.almanac.AlmanacHourResult;

/**
 * Created by bamboo on 16-12-4.
 */

public class AlmanacRequest extends RemoteRequest {
    public static final String APPKEY_ALMANAC = "1a903c627a050f25ca29a9bcd3d8606a";
    public static final String BASE_URL_ALMANAC = "http://v.juhe.cn";

    private AlmanacService mAlmanacService;

    public AlmanacRequest() {
        mAlmanacService = getRetrofit(BASE_URL_ALMANAC).create(AlmanacService.class);
    }

    public Observable<AlmanacHourResult> getAlmanacHourData(String date) {
        return mAlmanacService.getAlmanacHourData(date, APPKEY_ALMANAC);
    }

    public Observable<AlmanacDayResult> getAlmanacDayData(String date) {
        return mAlmanacService.getAlmanacDayData(date, APPKEY_ALMANAC);
    }
}
