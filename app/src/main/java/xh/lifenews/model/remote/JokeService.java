package xh.lifenews.model.remote;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import xh.lifenews.model.object.joke.NewestJokeResult;
import xh.lifenews.model.object.joke.NewestPicResult;
import xh.lifenews.model.object.joke.RandomJokeResult;

/**
 * Created by bamboo on 16-12-3.
 */

public interface JokeService {
    @GET("/joke/randJoke.php")
    Observable<RandomJokeResult> getRandomJoke(@Query("type") String type,
                                               @Query("key") String key);

    @GET("/joke/content/text.from")
    Observable<NewestJokeResult> getNewestJoke(@Query("page") int page,
                                               @Query("pagesize") int size,
                                               @Query("key") String key);

    @GET("/joke/img/text.from")
    Observable<NewestPicResult> getNewestPic(@Query("page") int page,
                                              @Query("pagesize") int size,
                                              @Query("key") String key);
}
