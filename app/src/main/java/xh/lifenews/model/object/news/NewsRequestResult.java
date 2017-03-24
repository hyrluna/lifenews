package xh.lifenews.model.object.news;

import com.google.gson.annotations.SerializedName;

/**
 * Created by bamboo on 16-11-28.
 */

public class NewsRequestResult {

    @SerializedName("reason")
    private String reason;
    @SerializedName("result")
    private NewsEntryResult result;
    @SerializedName("error_code")
    private int errorCode;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public NewsEntryResult getResult() {
        return result;
    }

    public void setResult(NewsEntryResult result) {
        this.result = result;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

}
