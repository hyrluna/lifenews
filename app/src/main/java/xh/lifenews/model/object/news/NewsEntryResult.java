package xh.lifenews.model.object.news;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by bamboo on 16-11-28.
 */

public class NewsEntryResult {

    @SerializedName("stat")
    private String stat;
    @SerializedName("data")
    private List<NewsEntry> newsEntries;

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public List<NewsEntry> getNewsEntries() {
        return newsEntries;
    }

    public void setNewsEntries(List<NewsEntry> newsEntries) {
        this.newsEntries = newsEntries;
    }
}
