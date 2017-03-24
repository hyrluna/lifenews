package xh.lifenews.model.object.phone;

import com.google.gson.annotations.SerializedName;

/**
 * Created by bamboo on 16-11-30.
 */

public class PhoneEntry {

    @SerializedName("resultcode")
    private String resultcode;
    @SerializedName("reason")
    private String reason;
    @SerializedName("result")
    private Result result;
    @SerializedName("error_code")
    private int errorCode;

    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
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

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public static class Result {
        @SerializedName("province")
        private String province;
        @SerializedName("city")
        private String city;
        @SerializedName("areacode")
        private String areacode;
        @SerializedName("zip")
        private String zip;
        @SerializedName("company")
        private String company;
        @SerializedName("card")
        private String card;

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getAreacode() {
            return areacode;
        }

        public void setAreacode(String areacode) {
            this.areacode = areacode;
        }

        public String getZip() {
            return zip;
        }

        public void setZip(String zip) {
            this.zip = zip;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public String getCard() {
            return card;
        }

        public void setCard(String card) {
            this.card = card;
        }
    }
}
