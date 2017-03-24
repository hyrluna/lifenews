package xh.lifenews.model.object.almanac;

import com.google.gson.annotations.SerializedName;

/**
 * Created by bamboo on 16-12-4.
 */

public class AlmanacDayResult {

    @SerializedName("reason")
    private String reason;
    @SerializedName("result")
    private AlmanacDayEntry result;
    @SerializedName("error_code")
    private int errorCode;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public AlmanacDayEntry getResult() {
        return result;
    }

    public void setResult(AlmanacDayEntry result) {
        this.result = result;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

}
