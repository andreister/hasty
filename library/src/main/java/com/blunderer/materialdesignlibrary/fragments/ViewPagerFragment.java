package com.blunderer.materialdesignlibrary.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blunderer.materialdesignlibrary.R;
import com.blunderer.materialdesignlibrary.adapters.ViewPagerAdapter;
import com.blunderer.materialdesignlibrary.handlers.ViewPagerHandler;
import com.blunderer.materialdesignlibrary.models.ViewPagerItem;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.List;

public abstract class ViewPagerFragment extends AFragment
        implements com.blunderer.materialdesignlibrary.interfaces.ViewPager {

    protected ViewPager mViewPager;
    protected CirclePageIndicator mViewPagerIndicator;
    private List<ViewPagerItem> mViewPagerItems;
    private int mCurrentPagePosition = 0;
    private ViewPager.OnPageChangeListener mUserOnPageChangeListener;
    private ViewPagerAdapter mViewPagerAdapter;
    private final ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager
            .OnPageChangeListener() {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            if (mUserOnPageChangeListener != null) {
                mUserOnPageChangeListener.onPageScrolled(position, positionOffset,
                        positionOffsetPixels);
            }
        }

        @Override
        public void onPageSelected(int position) {
            mCurrentPagePosition = position;
            replaceTitle(getTitle());
            if (mUserOnPageChangeListener != null) {
                mUserOnPageChangeListener.onPageSelected(position);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {
            if (mUserOnPageChangeListener != null) {
                mUserOnPageChangeListener.onPageScrollStateChanged(state);
            }
        }

    };

    public ViewPagerFragment() {
        mViewPagerItems = new ArrayList<>();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        ViewPagerHandler viewPagerHandler = getViewPagerHandler();
        if (viewPagerHandler == null) viewPagerHandler = new ViewPagerHandler(getActivity());
        mViewPagerItems = viewPagerHandler.getViewPagerItems();
    }

    @Override
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener userOnPageChangeListener) {
        mUserOnPageChangeListener = userOnPageChangeListener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mdl_fragment_view_pager, container, false);

        mViewPager = (ViewPager) view.findViewById(R.id.viewpager);
        mViewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager(), mViewPagerItems);
        mViewPager.setAdapter(mViewPagerAdapter);

        int defaultViewPagerItemSelectedPosition = defaultViewPagerPageSelectedPosition();
        if (defaultViewPagerItemSelectedPosition >= 0 &&
                defaultViewPagerItemSelectedPosition < mViewPagerItems.size()) {
            selectPage(defaultViewPagerItemSelectedPosition);
            replaceTitle(mViewPagerItems
                    .get(defaultViewPagerItemSelectedPosition).getTitle());
        }

        showIndicator(view, mViewPager);

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (mViewPagerItems != null && mViewPagerItems.size() > 0 && mViewPager != null) {
            int tabPosition = mViewPager.getCurrentItem();
            if (tabPosition >= 0 && tabPosition < mViewPagerItems.size()) {
                mViewPagerItems.get(tabPosition).getFragment()
                        .onActivityResult(requestCode, resultCode, data);
            }
        }
    }

    @Override
    public void selectPage(int position) {
        mViewPager.setCurrentItem(position);
    }

    @Override
    public void updateNavigationDrawerTopHandler(ViewPagerHandler viewPagerHandler,
                                                 int defaultViewPagerPageSelectedPosition) {
        if (viewPagerHandler == null) viewPagerHandler = new ViewPagerHandler(getActivity());
        mViewPagerItems.clear();
        mViewPagerItems.addAll(viewPagerHandler.getViewPagerItems());
        mViewPagerAdapter.notifyDataSetChanged();

        selectPage(defaultViewPagerPageSelectedPosition);
    }

    public String getTitle() {
        if (mViewPagerItems == null || mCurrentPagePosition < 0
                || mCurrentPagePosition >= mViewPagerItems.size()) {
            return null;
        }
        return mViewPagerItems.get(mCurrentPagePosition).getTitle();
    }

    private void showIndicator(View view, ViewPager pager) {
        if (!showViewPagerIndicator()) pager.addOnPageChangeListener(mOnPageChangeListener);
        else {
            mViewPagerIndicator = (CirclePageIndicator) view.findViewById(R.id.viewpagerindicator);
            mViewPagerIndicator.setViewPager(pager);
            mViewPagerIndicator.setVisibility(View.VISIBLE);
            mViewPagerIndicator.setOnPageChangeListener(mOnPageChangeListener);
        }
    }

    private void replaceTitle(String title) {
        ActionBar supportActionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (supportActionBar != null && replaceActionBarTitleByViewPagerPageTitle()) {
            supportActionBar.setTitle(title);
        }
    }

    public abstract boolean showViewPagerIndicator();

    public abstract boolean replaceActionBarTitleByViewPagerPageTitle();

}
