package xh.lifenews.lifepage;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import xh.lifenews.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TestFragment extends Fragment {


    public TestFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.test_fragment, container, false);
        TabLayout tabLayout = (TabLayout) v.findViewById(R.id.test_tab);
        ViewPager viewPager = (ViewPager) v.findViewById(R.id.test_view_pager);


        List<View> viewList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.test_item_recycle_view, null);
            RecyclerView recyclerView = (RecyclerView) layout.findViewById(R.id.test_recycle_view);
//            List<String> items = new ArrayList<>();
//            for (int j = 0; j < 20; j++) {
//                items.add("hello "+j);
//            }
//            ArrayAdapter adpter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, items);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerView.setAdapter(new RecyclerAdapter());
            viewList.add(layout);
        }
        viewPager.setAdapter(new TestPageApapter(viewList));
        tabLayout.setupWithViewPager(viewPager);
        return v;
    }

    private class TestPageApapter extends PagerAdapter {
        List<View> viewList;
        String[] title = {
                "one", "two", "three", "four", "five", "six"
        };

        public TestPageApapter(List<View> views) {
            viewList = views;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(viewList.get(position));
            return viewList.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(viewList.get(position));
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return title[position];
        }

        @Override
        public int getCount() {
            return viewList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.test_txt);
        }
    }

    private class RecyclerAdapter extends RecyclerView.Adapter<ViewHolder> {
        public RecyclerAdapter() {
            super();
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.test_simple_item, parent, false);
            return new ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.textView.setText("hello "+position);
        }

        @Override
        public int getItemCount() {
            return 20;
        }
    }

}
