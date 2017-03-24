package xh.lifenews.model.remote;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import xh.lifenews.model.object.news.NewsRequestResult;

/**
 * Created by bamboo on 16-11-28.
 */

public interface NewsService {
    @GET("/toutiao/index")
    Observable<NewsRequestResult> getNews(@Query("type") String type, @Query("key") String key);
}
