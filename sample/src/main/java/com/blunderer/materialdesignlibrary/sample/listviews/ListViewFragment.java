package com.blunderer.materialdesignlibrary.sample.listviews;

import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

import com.blunderer.materialdesignlibrary.sample.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListViewFragment
        extends com.blunderer.materialdesignlibrary.fragments.ListViewFragment {

    private List<String> mObjects;
    private ArrayAdapter<String> mAdapter;

    @Override
    public ListAdapter getListAdapter() {
        mObjects = new ArrayList<>(Arrays.asList(
                "1. ...",
                "2. ...",
                "3. ...",
                "4. Swipe down to refresh this list! Not sure it's user friendly but it's definitely cool!"
        ));
        return (mAdapter = new ArrayAdapter<>(getActivity(), R.layout.listview_row, mObjects));
    }

    @Override
    public boolean useCustomContentView() {
        return false;
    }

    @Override
    public int getCustomContentView() {
        return 0;
    }

    @Override
    public boolean pullToRefreshEnabled() {
        return true;
    }

    @Override
    public int[] getPullToRefreshColorResources() {
        return new int[]{R.color.color_primary};
    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                mObjects.add((mObjects.size() + 1) + ". Someone added this while you've been offline");
                mAdapter.notifyDataSetChanged();
                setRefreshing(false);
            }

        }, 2000);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
        return false;
    }

}
