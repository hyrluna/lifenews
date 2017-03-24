package xh.lifenews.model.object.constellation;

import com.google.gson.annotations.SerializedName;

/**
 * Created by bamboo on 16-12-3.
 */

public class ConsMonthEntry {

    @SerializedName("date")
    private String date;
    @SerializedName("name")
    private String name;
    @SerializedName("all")
    private String all;
    @SerializedName("happyMagic")
    private String happyMagic;
    @SerializedName("health")
    private String health;
    @SerializedName("love")
    private String love;
    @SerializedName("money")
    private String money;
    @SerializedName("month")
    private int month;
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

    public String getAll() {
        return all;
    }

    public void setAll(String all) {
        this.all = all;
    }

    public String getHappyMagic() {
        return happyMagic;
    }

    public void setHappyMagic(String happyMagic) {
        this.happyMagic = happyMagic;
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

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
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
