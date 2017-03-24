package xh.lifenews.model.object.almanac;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by bamboo on 16-12-4.
 */

public class AlmanacHourResult {

    @SerializedName("reason")
    private String reason;
    @SerializedName("error_code")
    private int errorCode;
    @SerializedName("result")
    private List<AlmanacHourEntry> result;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public List<AlmanacHourEntry> getResult() {
        return result;
    }

    public void setResult(List<AlmanacHourEntry> result) {
        this.result = result;
    }

}
