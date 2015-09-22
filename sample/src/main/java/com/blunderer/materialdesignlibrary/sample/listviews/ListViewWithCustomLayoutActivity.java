package com.blunderer.materialdesignlibrary.sample.listviews;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

import com.blunderer.materialdesignlibrary.handlers.ActionBarDefaultHandler;
import com.blunderer.materialdesignlibrary.handlers.ActionBarHandler;
import com.blunderer.materialdesignlibrary.sample.R;

import java.util.ArrayList;
import java.util.Arrays;

public class ListViewWithCustomLayoutActivity
        extends com.blunderer.materialdesignlibrary.activities.ListViewActivity {

    @Override
    protected boolean enableActionBarShadow() {
        return false;
    }

    @Override
    public ListAdapter getListAdapter() {
        return new ArrayAdapter<>(
                this,
                R.layout.listview_row,
                new ArrayList<>(Arrays.asList(
                        getString(R.string.title_item1),
                        getString(R.string.title_item2),
                        getString(R.string.title_item3)
                ))
        );
    }

    @Override
    public boolean useCustomContentView() {
        return true;
    }

    @Override
    public int getCustomContentView() {
        return R.layout.activity_listview_with_custom_layout;
    }

    @Override
    public boolean pullToRefreshEnabled() {
        return false;
    }

    @Override
    public int[] getPullToRefreshColorResources() {
        return new int[0];
    }

    @Override
    public void onRefresh() {
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
