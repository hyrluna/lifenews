package xh.lifenews.model.remote;


import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import xh.lifenews.model.NewsTitle;

/**
 * Created by bamboo on 17-3-22.
 */

public class SpiderNetworkRequest {

    public Observable<NewsTitle> getNewsTitles() {
        return Observable.just("http://news.sina.com.cn/")
                .flatMap(new Func1<String, Observable<Element>>() {
                    @Override
                    public Observable<Element> call(String s) {
                        Elements els = new Elements();
                        try {
                            Document doc = Jsoup.connect(s)
                                    .userAgent("Mozilla")
                                    .get();
                            els = doc.select("div");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return Observable.from(els);
                    }
                })
                .filter(new Func1<Element, Boolean>() {
                    @Override
                    public Boolean call(Element element) {
                        return element.attr("data-sudaclick").equals("yaowen")
                                || element.attr("id").equals("ad_entry_b2_b")
                                || element.attr("id").equals("ad_entry_b2");
                    }
                })
                .flatMap(new Func1<Element, Observable<Element>>() {
                    @Override
                    public Observable<Element> call(Element element) {
                        Elements elements = element.select("a");
                        return Observable.from(elements);
                    }
                })
                .flatMap(new Func1<Element, Observable<NewsTitle>>() {
                    @Override
                    public Observable<NewsTitle> call(Element element) {
                        String url = element.absUrl("href");
                        String title = element.text();
                        NewsTitle newsTitle = new NewsTitle(title, "yaowen", url);
                        return Observable.just(newsTitle);
                    }
                });
    }

    public Observable<String> getNewsDetail(String url) {
        return Observable.just(url)
                .flatMap(new Func1<String, Observable<Element>>() {
                    @Override
                    public Observable<Element> call(String s) {
                        Elements els = new Elements();
                        try {
                            Document doc = Jsoup.connect(s)
                                    .userAgent("Mozilla")
                                    .get();
                            els = doc.select("p");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return Observable.from(els);
                    }
                })
                .filter(new Func1<Element, Boolean>() {
                    @Override
                    public Boolean call(Element element) {
                        return element.text().matches("^\\s\\s.*");
                    }
                })
                .flatMap(new Func1<Element, Observable<String>>() {
                    @Override
                    public Observable<String> call(Element element) {
                        return Observable.just(element.text());
                    }
                })
                .toList()
                .flatMap(new Func1<List<String>, Observable<String>>() {
                    @Override
                    public Observable<String> call(List<String> strings) {
                        String content = "";
                        for (String s : strings) {
                            content += s + "\n";
                        }
                        return Observable.just(content);
                    }
                });
    }

}
