package xh.lifenews.model.object.almanac;

import com.google.gson.annotations.SerializedName;

/**
 * Created by bamboo on 16-12-4.
 */

public class AlmanacDayEntry {
    @SerializedName("id")
    private String id;
    @SerializedName("yangli")
    private String yangli;
    @SerializedName("yinli")
    private String yinli;
    @SerializedName("wuxing")
    private String wuxing;
    @SerializedName("chongsha")
    private String chongsha;
    @SerializedName("baiji")
    private String baiji;
    @SerializedName("jishen")
    private String jishen;
    @SerializedName("yi")
    private String yi;
    @SerializedName("xiongshen")
    private String xiongshen;
    @SerializedName("ji")
    private String ji;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getYangli() {
        return yangli;
    }

    public void setYangli(String yangli) {
        this.yangli = yangli;
    }

    public String getYinli() {
        return yinli;
    }

    public void setYinli(String yinli) {
        this.yinli = yinli;
    }

    public String getWuxing() {
        return wuxing;
    }

    public void setWuxing(String wuxing) {
        this.wuxing = wuxing;
    }

    public String getChongsha() {
        return chongsha;
    }

    public void setChongsha(String chongsha) {
        this.chongsha = chongsha;
    }

    public String getBaiji() {
        return baiji;
    }

    public void setBaiji(String baiji) {
        this.baiji = baiji;
    }

    public String getJishen() {
        return jishen;
    }

    public void setJishen(String jishen) {
        this.jishen = jishen;
    }

    public String getYi() {
        return yi;
    }

    public void setYi(String yi) {
        this.yi = yi;
    }

    public String getXiongshen() {
        return xiongshen;
    }

    public void setXiongshen(String xiongshen) {
        this.xiongshen = xiongshen;
    }

    public String getJi() {
        return ji;
    }

    public void setJi(String ji) {
        this.ji = ji;
    }
}
