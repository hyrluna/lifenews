package xh.lifenews.model.object.joke;

import com.google.gson.annotations.SerializedName;

/**
 * Created by bamboo on 16-12-3.
 */

public class RandomJokeEntry {
    @SerializedName("content")
    private String content;
    @SerializedName("hashId")
    private String hashId;
    @SerializedName("unixtime")
    private String unixtime;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHashId() {
        return hashId;
    }

    public void setHashId(String hashId) {
        this.hashId = hashId;
    }

    public String getUnixtime() {
        return unixtime;
    }

    public void setUnixtime(String unixtime) {
        this.unixtime = unixtime;
    }
}
