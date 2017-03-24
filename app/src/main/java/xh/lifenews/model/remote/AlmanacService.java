package xh.lifenews.model.remote;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import xh.lifenews.model.object.almanac.AlmanacDayResult;
import xh.lifenews.model.object.almanac.AlmanacHourResult;

/**
 * Created by bamboo on 16-12-4.
 */

public interface AlmanacService {

    @GET("/laohuangli/h")
    Observable<AlmanacHourResult> getAlmanacHourData(@Query("date") String date,
                                                     @Query("key") String key);

    @GET("/laohuangli/d")
    Observable<AlmanacDayResult> getAlmanacDayData(@Query("date") String date,
                                                   @Query("key") String key);
}
