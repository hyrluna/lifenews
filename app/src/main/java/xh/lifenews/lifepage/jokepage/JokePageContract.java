package xh.lifenews.lifepage.jokepage;

import java.util.List;

import xh.lifenews.BasePresenter;
import xh.lifenews.BaseView;
import xh.lifenews.model.object.joke.NewestJokeEntry;
import xh.lifenews.model.object.joke.NewestPicEntry;
import xh.lifenews.model.object.joke.RandomJokeEntry;

/**
 * Created by bamboo on 16-12-3.
 */

public interface JokePageContract {
    interface Presenter extends BasePresenter {
        void loadRandomJoke(String type);
        void loadNewestJoke(int page, int pagesize);
        void loadNewestPic(int page, int pagesize);
    }

    interface View extends BaseView<Presenter> {
        void showErrorInfo(String s);
        void updateRandomJokeOrPicView(List<RandomJokeEntry> entries);
        void updateNewestJokeView(List<NewestJokeEntry> entries);
        void updateNewestPicView(List<NewestPicEntry> entries);
    }
}
