package xh.lifenews.model.object.joke;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by bamboo on 16-12-3.
 */

public class NewestPicResult {

    @SerializedName("error_code")
    private int errorCode;
    @SerializedName("reason")
    private String reason;
    @SerializedName("result")
    private Result result;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public static class Result {
        @SerializedName("data")
        private List<NewestPicEntry> data;

        public List<NewestPicEntry> getData() {
            return data;
        }

        public void setData(List<NewestPicEntry> data) {
            this.data = data;
        }
    }
}
