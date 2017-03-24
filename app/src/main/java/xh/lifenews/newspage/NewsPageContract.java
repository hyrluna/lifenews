package xh.lifenews.newspage;

import java.util.List;

import xh.lifenews.BasePresenter;
import xh.lifenews.BaseView;
import xh.lifenews.model.object.news.NewsEntry;

/**
 * Created by bamboo on 16-11-28.
 */

public class NewsPageContract {

    interface Presenter extends BasePresenter {
        void loadNews(boolean isShowProgressBar);
        void loadDetailNews(NewsEntry newsEntry);
    }

    interface View extends BaseView<Presenter> {
        void updatePreviewImage(List<NewsEntry> imageEntries);
        void updateListItem(List<NewsEntry> entries);
        void showErrorInfo(String error);
        void showProgressBar();
        void completeRefresh();
        void showDetailPage(NewsEntry newsEntry);
    }

}
