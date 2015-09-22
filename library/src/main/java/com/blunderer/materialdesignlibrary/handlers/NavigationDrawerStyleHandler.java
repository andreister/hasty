package com.blunderer.materialdesignlibrary.handlers;

public class NavigationDrawerStyleHandler {

    private int mBackgroundResource;

    public NavigationDrawerStyleHandler() {
        mBackgroundResource = 0;
    }

    public NavigationDrawerStyleHandler setBackgroundResource(int backgroundResource) {
        mBackgroundResource = backgroundResource;
        return this;
    }

    public int getBackgroundResource() {
        return mBackgroundResource;
    }

}
