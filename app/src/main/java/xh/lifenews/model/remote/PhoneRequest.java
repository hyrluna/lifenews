package xh.lifenews.model.remote;

import rx.Observable;
import xh.lifenews.model.object.phone.PhoneEntry;

/**
 * Created by bamboo on 16-12-4.
 */

public class PhoneRequest extends RemoteRequest {
    public static final String APPKEY_PHONE = "0bac24006b7e12e8130c0864552cbb72";
    public static final String BASE_URL_HAOMA = "http://apis.juhe.cn";

    private PhoneService mPhoneService;

    public PhoneRequest() {
        mPhoneService = getRetrofit(BASE_URL_HAOMA).create(PhoneService.class);
    }

    public Observable<PhoneEntry> getPhoneInfo(int phone) {
//        String phoneStr = String.valueOf(phone);
//        if (phoneStr.length() > 7) {
//            phoneStr = phoneStr.substring(0, 7);
//            phone = Integer.valueOf(phoneStr);
//        }
        return mPhoneService.getPhoneInfo(phone, "json", APPKEY_PHONE);
    }

}
