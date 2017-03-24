package xh.lifenews.model.object.joke;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by bamboo on 16-12-3.
 */

public class RandomJokeResult {

    @SerializedName("reason")
    private String reason;
    @SerializedName("error_code")
    private int errorCode;
    @SerializedName("result")
    private List<RandomJokeEntry> randomJokeEntry;

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

    public List<RandomJokeEntry> getRandomJokeEntry() {
        return randomJokeEntry;
    }

    public void setRandomJokeEntry(List<RandomJokeEntry> randomJokeEntry) {
        this.randomJokeEntry = randomJokeEntry;
    }
}
