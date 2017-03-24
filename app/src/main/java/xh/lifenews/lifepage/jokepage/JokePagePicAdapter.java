package xh.lifenews.lifepage.jokepage;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import xh.lifenews.GlideLoader;
import xh.lifenews.R;
import xh.lifenews.model.object.joke.NewestPicEntry;

/**
 * Created by bamboo on 16-12-3.
 */

public class JokePagePicAdapter extends RecyclerView.Adapter<JokePagePicAdapter.PicViewHolder> {

    private Context mContext;
    private List<NewestPicEntry> mItems = new ArrayList<>();

    public JokePagePicAdapter(Context context) {
        mContext = context;
    }

    @Override
    public PicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recycler_view_joke_pic, parent, false);
        return new PicViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PicViewHolder holder, int position) {
        holder.picTextView.setText(mItems.get(position).getContent());
        GlideLoader.loadGifWithDiskCache(mContext, mItems.get(position).getUrl(), holder.picImage);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public void addItems(List<NewestPicEntry> items) {
        mItems.addAll(items);
    }

    public void clearItems() {
        mItems.clear();
    }

    public static class PicViewHolder extends RecyclerView.ViewHolder {
        TextView picTextView;
        ImageView picImage;
        public PicViewHolder(View itemView) {
            super(itemView);
            picTextView = (TextView) itemView.findViewById(R.id.pic_content);
            picImage = (ImageView) itemView.findViewById(R.id.pic_image);
        }
    }

}
