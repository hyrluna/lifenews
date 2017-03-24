package xh.lifenews.model.remote;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import xh.lifenews.model.object.phone.PhoneEntry;

/**
 * Created by bamboo on 16-11-30.
 */

public interface PhoneService {
    @GET("/mobile/get")
    Observable<PhoneEntry> getPhoneInfo(@Query("phone") int phone,
                                        @Query("dtype") String dtype,
                                        @Query("key") String key);
}
