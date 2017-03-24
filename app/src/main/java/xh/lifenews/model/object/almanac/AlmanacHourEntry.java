package xh.lifenews.model.object.almanac;

import com.google.gson.annotations.SerializedName;

/**
 * Created by bamboo on 16-12-4.
 */

public class AlmanacHourEntry {
    @SerializedName("yangli")
    private String yangli;
    @SerializedName("hours")
    private String hours;
    @SerializedName("des")
    private String des;
    @SerializedName("yi")
    private String yi;
    @SerializedName("ji")
    private String ji;

    public String getYangli() {
        return yangli;
    }

    public void setYangli(String yangli) {
        this.yangli = yangli;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getYi() {
        return yi;
    }

    public void setYi(String yi) {
        this.yi = yi;
    }

    public String getJi() {
        return ji;
    }

    public void setJi(String ji) {
        this.ji = ji;
    }
}
