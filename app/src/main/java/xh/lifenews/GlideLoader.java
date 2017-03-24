package xh.lifenews;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/**
 * Created by bamboo on 16-11-28.
 */

public class GlideLoader {

    //有内存缓存，不带磁盘缓存，居中显示并剪裁，result存小图
    public static void loadImageWithDiskCache(Context context, String url, ImageView v) {
        Glide.with(context)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .skipMemoryCache(true)
                .centerCrop()
                .into(v);
    }

    public static void loadGifWithDiskCache(Context context, String url, ImageView v) {
        Glide.with(context)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .skipMemoryCache(false)
                .into(v);
    }

    public static void loadImageWithMemAndDiskCache(Context context, String url, ImageView v) {
        Glide.with(context)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .skipMemoryCache(false)
                .centerCrop()
                .into(v);
    }

    public static void loadLocalResWithMemCache(Context context, int res, ImageView v) {
        Glide.with(context)
                .load(res)
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .skipMemoryCache(false)
                .centerCrop()
                .into(v);
    }

    public static void loadLocalResWithDiskCache(Context context, int res, boolean needMemCache, ImageView v) {
        Glide.with(context)
                .load(res)
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .skipMemoryCache(needMemCache)
                .centerCrop()
                .into(v);
    }

    public static void loadLocalResNoDiskCache(Context context, int res, boolean needMemCache, ImageView v) {
        Glide.with(context)
                .load(res)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(needMemCache)
                .centerCrop()
                .into(v);
    }

}
