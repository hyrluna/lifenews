package xh.lifenews.model;

/**
 * Created by bamboo on 16-11-28.
 */

public class Constants {

    public static final int POSITION_TOP_NEWS = 0;
    public static final int POSITION_GUONEI_NEWS = 1;
    public static final int POSITION_SHEHUI_NEWS = 2;
    public static final int POSITION_GUOJI_NEWS = 3;
    public static final int POSITION_YULE_NEWS = 4;
    public static final int POSITION_TIYU_NEWS = 5;
    public static final int POSITION_JUNSHI_NEWS = 6;
    public static final int POSITION_KEJI_NEWS = 7;
    public static final int POSITION_CAIJING_NEWS = 8;
    public static final int POSITION_SHISHANG_NEWS = 9;
    /*
      * 请求地址：http://v.juhe.cn/toutiao/index
      * 请求参数：type=keji&key=4ad9aac48c9b4a83c575e4b65471b466
      * 请求方式：GET
      * 类型,,top(头条，默认),shehui(社会),guonei(国内),guoji(国际),yule(娱乐),
      * tiyu(体育)junshi(军事),keji(科技),caijing(财经),shishang(时尚)
      */
    public static final String NEWS_TOP = "top";
    public static final String NEWS_GUONEI = "guonei";
    public static final String NEWS_SHEHUI = "shehui";
    public static final String NEWS_GUOJI = "guoji";
    public static final String NEWS_YULE = "yule";
    public static final String NEWS_TIYU = "tiyu";
    public static final String NEWS_JUNSHI = "junshi";
    public static final String NEWS_KEJI = "keji";
    public static final String NEWS_CAIJIANG = "caijing";
    public static final String NEWS_SHISHANG = "shishang";

    public static String[] NEWS_TYPES = {
            NEWS_TOP,
            NEWS_SHEHUI,
            NEWS_GUONEI,
            NEWS_GUOJI,
            NEWS_YULE,
            NEWS_TIYU,
            NEWS_JUNSHI,
            NEWS_KEJI,
            NEWS_CAIJIANG,
            NEWS_SHISHANG
    };

    public static String[] NEWS_TYPE_CN = {
            "头条",
            "社会",
            "国内",
            "国际",
            "娱乐",
            "体育",
            "军事",
            "科技",
            "财经",
            "时尚",
    };

    public static final String LIFE_ITEM_NAME_XINGZUO = "星座运势";
    public static final String LIFE_ITEM_NAME_JIEMENG = "周公解梦";
    public static final String LIFE_ITEM_NAME_XIAOHUA = "笑话大全";
    public static final String LIFE_ITEM_NAME_LAOHUANGLI = "老黄历";
    public static final String LIFE_ITEM_NAME_LISHI = "历史上的今天";
    public static final String LIFE_ITEM_NAME_HAOMA = "号码归属地";

    public static final int LIFE_ITEM_TYPE_XINGZUO = 0;
    public static final int LIFE_ITEM_TYPE_JIEMENG = 1;
    public static final int LIFE_ITEM_TYPE_XIAOHUA = 2;
    public static final int LIFE_ITEM_TYPE_LAOHUANGLI = 3;
    public static final int LIFE_ITEM_TYPE_LISHI = 4;
    public static final int LIFE_ITEM_TYPE_HAOMA = 5;

    public static String[] LIEF_ITEM_NAMES = {
            LIFE_ITEM_NAME_XINGZUO,
            LIFE_ITEM_NAME_JIEMENG,
            LIFE_ITEM_NAME_XIAOHUA,
            LIFE_ITEM_NAME_LAOHUANGLI,
            LIFE_ITEM_NAME_LISHI,
            LIFE_ITEM_NAME_HAOMA,
    };

    public static final String CONSTELLATION_QUERY_TYPE_TODAY = "today";
    public static final String CONSTELLATION_QUERY_TYPE_TOMORROW = "tomorrow";
    public static final String CONSTELLATION_QUERY_TYPE_WEEK = "week";
    public static final String CONSTELLATION_QUERY_TYPE_NEXTWEEK = "nextweek";
    public static final String CONSTELLATION_QUERY_TYPE_MONTH = "month";
    public static final String CONSTELLATION_QUERY_TYPE_YEAR = "year";

    public static final String CONSTELLATION_ARIES = "白羊座";
    public static final String CONSTELLATION_TRURUS = "金牛座";
    public static final String CONSTELLATION_GEMINI = "双子座";
    public static final String CONSTELLATION_CANCER = "巨蟹座";
    public static final String CONSTELLATION_LEO = "狮子座";
    public static final String CONSTELLATION_VIRGO = "处女座";
    public static final String CONSTELLATION_LIBRA = "天秤座";
    public static final String CONSTELLATION_SCORPIO = "天蝎座";
    public static final String CONSTELLATION_SAGITTARIUS = "射手座";
    public static final String CONSTELLATION_CAPRICORN = "摩羯座";
    public static final String CONSTELLATION_AQUARIUS = "水瓶座";
    public static final String CONSTELLATION_PIESCES = "双鱼座";

    public static final String[] CONS_NAMES = {
            CONSTELLATION_ARIES,
            CONSTELLATION_TRURUS,
            CONSTELLATION_GEMINI,
            CONSTELLATION_CANCER,
            CONSTELLATION_LEO,
            CONSTELLATION_VIRGO,
            CONSTELLATION_SCORPIO,
            CONSTELLATION_SAGITTARIUS,
            CONSTELLATION_CAPRICORN,
            CONSTELLATION_AQUARIUS,
            CONSTELLATION_PIESCES,
    };

    public static final String[] CONS_QUERY_TIMES = {
            CONSTELLATION_QUERY_TYPE_TODAY,
            CONSTELLATION_QUERY_TYPE_TOMORROW,
            CONSTELLATION_QUERY_TYPE_WEEK,
            CONSTELLATION_QUERY_TYPE_NEXTWEEK,
            CONSTELLATION_QUERY_TYPE_MONTH,
            CONSTELLATION_QUERY_TYPE_YEAR,
    };

    public static final String[] CONS_QUERY_TIMES_CN = {
            "今天",
            "明天",
            "本周",
            "下周",
            "本月",
            "今年",
    };

}
