package xh.lifenews.model.object.constellation;

import com.google.gson.annotations.SerializedName;

/**
 * Created by bamboo on 16-11-30.
 */

public class ConsTodayEntry {

    @SerializedName("name")
    private String name;
    @SerializedName("datetime")
    private String datetime;
    @SerializedName("date")
    private int date;
    @SerializedName("all")
    private String all;
    @SerializedName("color")
    private String color;
    @SerializedName("health")
    private String health;
    @SerializedName("love")
    private String love;
    @SerializedName("money")
    private String money;
    @SerializedName("number")
    private int number;
    @SerializedName("QFriend")
    private String QFriend;
    @SerializedName("summary")
    private String summary;
    @SerializedName("work")
    private String work;
    @SerializedName("resultcode")
    private String resultcode;
    @SerializedName("error_code")
    private int errorCode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getAll() {
        return all;
    }

    public void setAll(String all) {
        this.all = all;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getLove() {
        return love;
    }

    public void setLove(String love) {
        this.love = love;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getQFriend() {
        return QFriend;
    }

    public void setQFriend(String QFriend) {
        this.QFriend = QFriend;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
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
}
