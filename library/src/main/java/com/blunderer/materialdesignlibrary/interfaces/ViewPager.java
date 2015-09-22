package com.blunderer.materialdesignlibrary.interfaces;

import com.blunderer.materialdesignlibrary.handlers.ViewPagerHandler;

public interface ViewPager {

    ViewPagerHandler getViewPagerHandler();

    void selectPage(int position);

    void setOnPageChangeListener(
            android.support.v4.view.ViewPager.OnPageChangeListener onPageChangeListener);

    void updateNavigationDrawerTopHandler(ViewPagerHandler viewPagerHandler,
                                          int defaultViewPagerPageSelectedPosition);

    int defaultViewPagerPageSelectedPosition();

}
