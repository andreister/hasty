package com.blunderer.materialdesignlibrary.sample.listviews;

import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

import com.blunderer.materialdesignlibrary.handlers.ActionBarDefaultHandler;
import com.blunderer.materialdesignlibrary.handlers.ActionBarHandler;
import com.blunderer.materialdesignlibrary.sample.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListViewWithRefreshActivity
        extends com.blunderer.materialdesignlibrary.activities.ListViewActivity {

    @Override
    protected boolean enableActionBarShadow() {
        return false;
    }

    private List<String> mObjects;
    private ArrayAdapter<String> mAdapter;

    @Override
    public ListAdapter getListAdapter() {
        mObjects = new ArrayList<>(Arrays.asList(
                getString(R.string.title_item1),
                getString(R.string.title_item2),
                getString(R.string.title_item3)
        ));
        return (mAdapter = new ArrayAdapter<>(this, R.layout.listview_row, mObjects));
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
                mObjects.add("Item " + (mObjects.size() + 1));
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
        return true;
    }

    @Override
    protected ActionBarHandler getActionBarHandler() {
        return new ActionBarDefaultHandler(this);
    }

}
