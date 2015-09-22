package com.blunderer.materialdesignlibrary.sample.cardviews;

import com.blunderer.materialdesignlibrary.handlers.ActionBarDefaultHandler;
import com.blunderer.materialdesignlibrary.handlers.ActionBarHandler;
import com.blunderer.materialdesignlibrary.sample.R;

public class CardViewNormalActivity
        extends com.blunderer.materialdesignlibrary.activities.Activity {

    @Override
    protected boolean enableActionBarShadow() { return false; }

    @Override
    protected int getContentView() {
        return R.layout.activity_cardview_normal;
    }

    @Override
    protected ActionBarHandler getActionBarHandler() {
        return new ActionBarDefaultHandler(this);
    }

}
