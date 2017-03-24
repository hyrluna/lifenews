package xh.lifenews.model.object.constellation;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by bamboo on 16-12-3.
 */

public class ConsYearEntry {

    @SerializedName("name")
    private String name;
    @SerializedName("date")
    private String date;
    @SerializedName("year")
    private int year;
    @SerializedName("resultcode")
    private String resultcode;
    @SerializedName("error_code")
    private int errorCode;
    @SerializedName("mima")
    private Mima mima;
    @SerializedName("luckyStone")
    private String luckyStone;
    @SerializedName("career")
    private List<String> career;
    @SerializedName("love")
    private List<String> love;
    @SerializedName("health")
    private List<String> health;
    @SerializedName("finance")
    private List<String> finance;
    @SerializedName("future")
    private List<String> future;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public Mima getMima() {
        return mima;
    }

    public void setMima(Mima mima) {
        this.mima = mima;
    }

    public String getLuckyStone() {
        return luckyStone;
    }

    public void setLuckyStone(String luckyStone) {
        this.luckyStone = luckyStone;
    }

    public List<String> getCareer() {
        return career;
    }

    public void setCareer(List<String> career) {
        this.career = career;
    }

    public List<String> getLove() {
        return love;
    }

    public void setLove(List<String> love) {
        this.love = love;
    }

    public List<String> getHealth() {
        return health;
    }

    public void setHealth(List<String> health) {
        this.health = health;
    }

    public List<String> getFinance() {
        return finance;
    }

    public void setFinance(List<String> finance) {
        this.finance = finance;
    }

    public List<String> getFuture() {
        return future;
    }

    public void setFuture(List<String> future) {
        this.future = future;
    }

    public static class Mima {
        @SerializedName("info")
        private String info;
        @SerializedName("text")
        private List<String> text;

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public List<String> getText() {
            return text;
        }

        public void setText(List<String> text) {
            this.text = text;
        }
    }
}
