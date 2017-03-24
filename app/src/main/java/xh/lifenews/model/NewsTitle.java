package xh.lifenews.model;

/**
 * Created by bamboo on 17-3-22.
 */

public class NewsTitle {
    private String title;
    private String type;
    private String url;

    public NewsTitle(String title, String type, String url) {
        this.title = title;
        this.type = type;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public String getUrl() {
        return url;
    }
}
