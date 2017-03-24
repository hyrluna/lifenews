package xh.lifenews.model.remote;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import xh.lifenews.model.object.constellation.ConsMonthEntry;
import xh.lifenews.model.object.constellation.ConsNextWeekEntry;
import xh.lifenews.model.object.constellation.ConsTodayEntry;
import xh.lifenews.model.object.constellation.ConsTomorrowEntry;
import xh.lifenews.model.object.constellation.ConsWeekEntry;
import xh.lifenews.model.object.constellation.ConsYearEntry;

/**
 * Created by bamboo on 16-11-30.
 */

public interface ConstellationService {
    @GET("/constellation/getAll")
    Observable<ConsTodayEntry> getConsTodayEntry(@Query("consName") String consName,
                                                 @Query("type") String type,
                                                 @Query("key") String key);

    @GET("/constellation/getAll")
    Observable<ConsTomorrowEntry> getConsTomorrowEntry(@Query("consName") String consName,
                                                       @Query("type") String type,
                                                       @Query("key") String key);

    @GET("/constellation/getAll")
    Observable<ConsWeekEntry> getConsWeekEntry(@Query("consName") String consName,
                                               @Query("type") String type,
                                               @Query("key") String key);

    @GET("/constellation/getAll")
    Observable<ConsNextWeekEntry> getConsNextWeekEntry(@Query("consName") String consName,
                                                       @Query("type") String type,
                                                       @Query("key") String key);

    @GET("/constellation/getAll")
    Observable<ConsMonthEntry> getConsMonthEntry(@Query("consName") String consName,
                                                 @Query("type") String type,
                                                 @Query("key") String key);

    @GET("/constellation/getAll")
    Observable<ConsYearEntry> getConsYearEntry(@Query("consName") String consName,
                                               @Query("type") String type,
                                               @Query("key") String key);

}
