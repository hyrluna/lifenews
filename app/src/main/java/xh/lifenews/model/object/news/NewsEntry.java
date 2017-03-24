package xh.lifenews.model.object.news;

import com.google.gson.annotations.SerializedName;

/**
 * Created by bamboo on 16-11-28.
 */

public class NewsEntry {

    @SerializedName("title")
    private String title;
    @SerializedName("date")
    private String date;
    @SerializedName("category")
    private String category;
    @SerializedName("author_name")
    private String authorName;
    @SerializedName("thumbnail_pic_s")
    private String thumbnailPicS;
    @SerializedName("url")
    private String url;
    @SerializedName("thumbnail_pic_s03")
    private String thumbnailPicS03;
    @SerializedName("realtype")
    private String realType;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getThumbnailPicS() {
        return thumbnailPicS;
    }

    public void setThumbnailPicS(String thumbnailPicS) {
        this.thumbnailPicS = thumbnailPicS;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnailPicS03() {
        return thumbnailPicS03;
    }

    public void setThumbnailPicS03(String thumbnailPicS03) {
        this.thumbnailPicS03 = thumbnailPicS03;
    }

    public String getRealType() {
        return realType;
    }

    public void setRealType(String realType) {
        this.realType = realType;
    }
}
