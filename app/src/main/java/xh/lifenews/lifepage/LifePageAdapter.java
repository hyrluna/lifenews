package xh.lifenews.lifepage;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import xh.lifenews.GlideLoader;
import xh.lifenews.R;
import xh.lifenews.model.Constants;
import xh.lifenews.utils.Util;
import xh.lifenews.model.object.LifeEntry;

/**
 * Created by bamboo on 16-11-29.
 */

public class LifePageAdapter extends RecyclerView.Adapter<LifePageAdapter.ItemViewHolder> {

    private List<LifeEntry> mItems;
    private Context mContext;
    private ItemClickCallBack callBack;

    public LifePageAdapter(Context context, List<LifeEntry> items, ItemClickCallBack callBack) {
        mItems = items;
        mContext = context;
        this.callBack = callBack;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_recycle_view_life_item, parent, false);
        return new ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {

        final LifeEntry entry = mItems.get(position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBack.onItemClick(v, entry);
            }
        });
        holder.textView.setText(entry.getName());

        ViewGroup.LayoutParams params = holder.itemView.getLayoutParams();
        int height = 0;
        switch (entry.getType()) {
            case Constants.LIFE_ITEM_TYPE_XINGZUO:
                height = (int) Util.getDimension(mContext, R.dimen.item_card_xingzuo);
                GlideLoader.loadLocalResWithMemCache(mContext,
                        R.drawable.constellation_icon, holder.itemIcon);
                GlideLoader.loadLocalResWithMemCache(mContext,
                        R.drawable.constellation_background, holder.itemBackground);
                break;
            case Constants.LIFE_ITEM_TYPE_JIEMENG:
                height = (int) Util.getDimension(mContext, R.dimen.item_card_jiemeng);
                GlideLoader.loadLocalResWithMemCache(mContext,
                        R.drawable.test_icon, holder.itemIcon);
                break;
            case Constants.LIFE_ITEM_TYPE_XIAOHUA:
                height = (int) Util.getDimension(mContext, R.dimen.item_card_xiaohua);
                GlideLoader.loadLocalResWithMemCache(mContext,
                        R.drawable.laugh_icon, holder.itemIcon);
                GlideLoader.loadLocalResWithMemCache(mContext,
                        R.drawable.laugh_background, holder.itemBackground);
                break;
            case Constants.LIFE_ITEM_TYPE_LAOHUANGLI:
                height = (int) Util.getDimension(mContext, R.dimen.item_card_laohuangli);
                GlideLoader.loadLocalResWithMemCache(mContext,
                        R.drawable.test_icon, holder.itemIcon);
                break;
            case Constants.LIFE_ITEM_TYPE_LISHI:
                height = (int) Util.getDimension(mContext, R.dimen.item_card_lishi);
                GlideLoader.loadLocalResWithMemCache(mContext,
                        R.drawable.test_icon, holder.itemIcon);
                break;
            case Constants.LIFE_ITEM_TYPE_HAOMA:
                height = (int) Util.getDimension(mContext, R.dimen.item_card_hama);
                GlideLoader.loadLocalResWithMemCache(mContext,
                        R.drawable.test_icon, holder.itemIcon);
                break;
//            case Constants.LIFE_ITEM_TYPE_WEATHER:
//                height = (int) Util.getDimension(mContext, R.dimen.item_card_weather);
//                GlideLoader.loadLocalResWithMemCache(mContext,
//                        R.drawable.test_icon, holder.itemIcon);
//                break;
        }
        params.height = height;
        holder.itemView.setLayoutParams(params);

    }

    @Override
    public int getItemCount() {
        return mItems == null ? 0 : mItems.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        ImageView itemBackground;
        ImageView itemIcon;
        public ItemViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.test_txt);
            itemBackground = (ImageView) itemView.findViewById(R.id.item_life_background);
            itemIcon = (ImageView) itemView.findViewById(R.id.item_life_icon);
        }

        public void bindView(int resIDIcon, int resIDBackground) {
            itemIcon.setImageResource(resIDIcon);
//            itemBackground.setImageResource(resIDBackground);
        }

    }

    public interface ItemClickCallBack {
        void onItemClick(View v, LifeEntry item);
    }

}
