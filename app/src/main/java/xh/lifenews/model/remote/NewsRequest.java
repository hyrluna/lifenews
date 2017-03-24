package xh.lifenews.model.remote;

import rx.Observable;
import xh.lifenews.model.object.news.NewsRequestResult;

/**
 * Created by bamboo on 16-12-4.
 */

public class NewsRequest extends RemoteRequest {
    public static final String APPKEY_NEWS = "4ad9aac48c9b4a83c575e4b65471b466";
    public static final String BASE_URL_NEWS = "http://v.juhe.cn";

    private NewsService mNewsService;

    public NewsRequest() {
        mNewsService = getRetrofit(BASE_URL_NEWS).create(NewsService.class);
    }

    public Observable<NewsRequestResult> getNews(String type) {
        return mNewsService.getNews(type, APPKEY_NEWS);
    }
}
