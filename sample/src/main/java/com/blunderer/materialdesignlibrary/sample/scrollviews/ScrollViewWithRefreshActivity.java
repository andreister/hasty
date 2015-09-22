package com.blunderer.materialdesignlibrary.sample.scrollviews;

import android.os.Handler;

import com.blunderer.materialdesignlibrary.handlers.ActionBarDefaultHandler;
import com.blunderer.materialdesignlibrary.handlers.ActionBarHandler;
import com.blunderer.materialdesignlibrary.sample.R;

public class ScrollViewWithRefreshActivity
        extends com.blunderer.materialdesignlibrary.activities.ScrollViewActivity {

    @Override
    protected boolean enableActionBarShadow() {
        return false;
    }

    @Override
    public int getContentView() {
        return R.layout.activity_scrollview;
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
                setRefreshing(false);
            }

        }, 2000);
    }

    @Override
    protected ActionBarHandler getActionBarHandler() {
        return new ActionBarDefaultHandler(this);
    }

}
