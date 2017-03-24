package xh.lifenews.lifepage.jokepage;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import xh.lifenews.R;
import xh.lifenews.model.object.joke.RandomJokeEntry;

/**
 * Created by bamboo on 16-12-3.
 */

public class JokePageRandomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private static final int ITEM_TYPE_HEADER = 0;
    private static final int ITEM_TYPE_CONTENT = 1;
    private List<RandomJokeEntry> mItems = new ArrayList<>();
    private JokePageContract.Presenter mPresenter;

    public static class ContentViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public ContentViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.joke_content);
        }
    }

    public static class HeaderViewHolder extends RecyclerView.ViewHolder {
        Button randomJokeButton;
        public HeaderViewHolder(View itemView) {
            super(itemView);
            randomJokeButton = (Button) itemView.findViewById(R.id.random_joke);
        }
    }

    public JokePageRandomAdapter(Context context, JokePageContract.Presenter presenter) {
        mContext = context;
        mPresenter = presenter;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = null;
        RecyclerView.ViewHolder holder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if (viewType == ITEM_TYPE_HEADER) {
            v = inflater.inflate(R.layout.item_recycler_view_header_joke, parent, false);
            holder = new HeaderViewHolder(v);
        } else {
            v = inflater.inflate(R.layout.item_recycler_view_joke, parent, false);
            holder = new ContentViewHolder(v);
        }

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder.getItemViewType() == ITEM_TYPE_HEADER) {
            HeaderViewHolder header = (HeaderViewHolder) holder;
            header.randomJokeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mPresenter.loadRandomJoke(JokePageFragment.TYPE_JOKE);
                }
            });
        } else {
            ContentViewHolder content = (ContentViewHolder) holder;
            content.textView.setText(mItems.get(position).getContent());
        }
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return ITEM_TYPE_HEADER;
        } else {
            return ITEM_TYPE_CONTENT;
        }
    }

    public void addItems(List<RandomJokeEntry> items) {
        mItems.addAll(items);
    }

    public void clearItems() {
        mItems.clear();
    }

}
