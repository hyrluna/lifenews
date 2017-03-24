package xh.lifenews.newspage;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import xh.lifenews.GlideLoader;
import xh.lifenews.R;
import xh.lifenews.model.object.news.NewsEntry;

/**
 * Created by bamboo on 16-12-4.
 */

public class NewsPageRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int ITEM_TYPE_HEADER = 0;
    private static final int ITEM_TYPE_A = 1;
    private static final int ITEM_TYPE_B = 2;

    private View mHeader = null;
    private List<NewsEntry> mItems;
    private Context mContext;
    private NewsPageContract.Presenter mPresenter;

    public NewsPageRecyclerAdapter(Context context, List<NewsEntry> items, NewsPageContract.Presenter presenter) {
        mContext = context;
        mItems = items;
        mPresenter = presenter;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        View v = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        switch (viewType) {
            case ITEM_TYPE_HEADER:
                if (mHeader != null) {
                    holder = new HeaderViewHolder(mHeader);
                }
                break;
            case ITEM_TYPE_A:
                v = inflater.inflate(R.layout.item_a_recycler_view_news, parent, false);
                holder = new ItemAViewHolder(v);
                break;
            case ITEM_TYPE_B:
                v = inflater.inflate(R.layout.item_b_recycler_view_news, parent, false);
                holder = new ItemBViewHolder(v);
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        final NewsEntry entry = mItems.get(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("test", "url: "+entry.getUrl());
                mPresenter.loadDetailNews(entry);
            }
        });
        switch (getItemViewType(position)) {
            case ITEM_TYPE_HEADER:
                break;
            case ITEM_TYPE_A:
                ItemAViewHolder itemAViewHolder = (ItemAViewHolder) holder;
                itemAViewHolder.updateItemA(mContext, entry);
                break;
            case ITEM_TYPE_B:
                ItemBViewHolder itemBViewHolder = (ItemBViewHolder) holder;
                itemBViewHolder.updateItemB(mContext, entry);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mItems == null ? 0 : mItems.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            if (mHeader != null) {
                return ITEM_TYPE_HEADER;
            } else {
                return ITEM_TYPE_A;
            }
        } else if (position % 3 == 0 || position % 7 == 0) {
            return ITEM_TYPE_A;
        } else {
            return ITEM_TYPE_B;
        }
    }

    public void addHeaderView(View header) {
        mHeader = header;
    }

    public void removeHeaderView() {
        mHeader = null;
    }

    public static class HeaderViewHolder extends RecyclerView.ViewHolder {
        public HeaderViewHolder(View itemView) {
            super(itemView);
        }
    }

    public static class ItemAViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView titleTextView;
        TextView categoryTextView;
        public ItemAViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.item_image);
            titleTextView = (TextView) itemView.findViewById(R.id.item_title);
            categoryTextView = (TextView) itemView.findViewById(R.id.item_category);
        }

        public void updateItemA(Context context, NewsEntry entry) {
            titleTextView.setText(entry.getTitle());
            GlideLoader.loadImageWithDiskCache(context,
                    entry.getThumbnailPicS03(),
                    imageView);
            if (entry.getRealType() != null) {
                categoryTextView.setText(entry.getRealType());
            } else {
                categoryTextView.setText(entry.getCategory());
            }
        }
    }

    public static class ItemBViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView titleView;
        TextView categoryView;
        public ItemBViewHolder(View itemView) {
            super(itemView);
            titleView = (TextView) itemView.findViewById(R.id.item_title_2);
            imageView = (ImageView) itemView.findViewById(R.id.item_image_2);
            categoryView = (TextView) itemView.findViewById(R.id.item_category_2);
        }

        private void updateItemB(Context context, NewsEntry entry) {
            if (entry != null) {
                GlideLoader.loadImageWithDiskCache(context,
                        entry.getThumbnailPicS03(),
                        imageView);
                titleView.setText(entry.getTitle());
                if (entry.getRealType() != null) {
                    categoryView.setText(entry.getRealType());
                } else {
                    categoryView.setText(entry.getCategory());
                }
            }
        }
    }
}
