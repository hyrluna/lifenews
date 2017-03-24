package xh.lifenews.model.object.constellation;

import com.google.gson.annotations.SerializedName;

/**
 * Created by bamboo on 16-12-3.
 */

public class ConsWeekEntry {

    @SerializedName("date")
    private String date;
    @SerializedName("name")
    private String name;
    @SerializedName("health")
    private String health;
    @SerializedName("job")
    private String job;
    @SerializedName("love")
    private String love;
    @SerializedName("money")
    private String money;
    @SerializedName("weekth")
    private int weekth;
    @SerializedName("work")
    private String work;
    @SerializedName("resultcode")
    private String resultcode;
    @SerializedName("error_code")
    private int errorCode;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
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

    public int getWeekth() {
        return weekth;
    }

    public void setWeekth(int weekth) {
        this.weekth = weekth;
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
