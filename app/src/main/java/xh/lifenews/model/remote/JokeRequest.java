package xh.lifenews.model.remote;

import rx.Observable;
import xh.lifenews.model.object.joke.NewestJokeResult;
import xh.lifenews.model.object.joke.NewestPicResult;
import xh.lifenews.model.object.joke.RandomJokeResult;

/**
 * Created by bamboo on 16-12-3.
 */

public class JokeRequest extends RemoteRequest {
    public static final String APPKEY_JOKE = "05e41242e8cbf1ecb3917100aec48a10";
    public static final String BASE_URL_JOKE_RANDOM = "http://v.juhe.cn";
    public static final String BASE_URL_JOKE_NEWEST = "http://japi.juhe.cn";

    private JokeService mJokeService;
    private Class<JokeService> service;

    public JokeRequest() {
        service = JokeService.class;
    }

    public Observable<RandomJokeResult> getRandomJoke(String type) {
        mJokeService = getRetrofit(BASE_URL_JOKE_RANDOM).create(service);
        return mJokeService.getRandomJoke(type, APPKEY_JOKE);
    }

    public Observable<NewestJokeResult> getNewestJoke(int page, int pagesize) {
        mJokeService = getRetrofit(BASE_URL_JOKE_NEWEST).create(service);
        return mJokeService.getNewestJoke(page, pagesize, APPKEY_JOKE);
    }

    public Observable<NewestPicResult> getNewestPic(int page, int pagesize) {
        mJokeService = getRetrofit(BASE_URL_JOKE_NEWEST).create(service);
        return mJokeService.getNewestPic(page, pagesize, APPKEY_JOKE);
    }

}
