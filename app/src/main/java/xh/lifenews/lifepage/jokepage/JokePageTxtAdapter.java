package xh.lifenews.lifepage.jokepage;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import xh.lifenews.R;
import xh.lifenews.model.object.joke.NewestJokeEntry;

/**
 * Created by bamboo on 16-12-3.
 */

public class JokePageTxtAdapter extends RecyclerView.Adapter<JokePageTxtAdapter.TxtViewHolder> {

    private List<NewestJokeEntry> mItems = new ArrayList<>();

    public static class TxtViewHolder extends RecyclerView.ViewHolder {
        TextView contentTextView;
        public TxtViewHolder(View itemView) {
            super(itemView);
            contentTextView = (TextView) itemView.findViewById(R.id.joke_content);
        }
    }

    @Override
    public TxtViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recycler_view_joke, parent, false);
        return new TxtViewHolder(v);
    }

    @Override
    public void onBindViewHolder(TxtViewHolder holder, int position) {
        holder.contentTextView.setText(mItems.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public void addItems(List<NewestJokeEntry> items) {
        mItems.addAll(items);
    }

    public void clearItems() {
        mItems.clear();
    }

}
