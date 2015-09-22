package com.blunderer.materialdesignlibrary.handlers;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;

import com.blunderer.materialdesignlibrary.models.NavigationDrawerListItemBottom;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class NavigationDrawerBottomHandler {

    private final Context mContext;
    private List<NavigationDrawerListItemBottom> mItems;

    public NavigationDrawerBottomHandler(Context context) {
        mContext = context;
        mItems = new ArrayList<>();
    }

    public NavigationDrawerBottomHandler addSettings(View.OnClickListener onClickListener) {
        NavigationDrawerListItemBottom item = new NavigationDrawerListItemBottom(mContext,
                NavigationDrawerListItemBottom.SETTINGS);
        item.setOnClickListener(onClickListener);
        mItems.add(item);
        return this;
    }

    public NavigationDrawerBottomHandler addSettings(View.OnClickListener onClickListener,
                                                     int titleStyle) {
        NavigationDrawerListItemBottom item = new NavigationDrawerListItemBottom(mContext,
                NavigationDrawerListItemBottom.SETTINGS);
        item.setOnClickListener(onClickListener);
        item.setTitleStyle(titleStyle);
        mItems.add(item);
        return this;
    }

    public NavigationDrawerBottomHandler addSettings(View.OnClickListener onClickListener,
                                                     int titleStyle,
                                                     int backgroundStyle) {
        NavigationDrawerListItemBottom item = new NavigationDrawerListItemBottom(mContext,
                NavigationDrawerListItemBottom.SETTINGS);
        item.setOnClickListener(onClickListener);
        item.setTitleStyle(titleStyle);
        item.setBackgroundStyle(backgroundStyle);
        mItems.add(item);
        return this;
    }

    public NavigationDrawerBottomHandler addHelpAndFeedback(View.OnClickListener onClickListener) {
        NavigationDrawerListItemBottom item = new NavigationDrawerListItemBottom(mContext,
                NavigationDrawerListItemBottom.HELP_AND_FEEDBACK);
        item.setOnClickListener(onClickListener);
        mItems.add(item);
        return this;
    }

    public NavigationDrawerBottomHandler addHelpAndFeedback(View.OnClickListener onClickListener,
                                                            int titleStyle) {
        NavigationDrawerListItemBottom item = new NavigationDrawerListItemBottom(mContext,
                NavigationDrawerListItemBottom.HELP_AND_FEEDBACK);
        item.setOnClickListener(onClickListener);
        item.setTitleStyle(titleStyle);
        mItems.add(item);
        return this;
    }

    public NavigationDrawerBottomHandler addHelpAndFeedback(View.OnClickListener onClickListener,
                                                            int titleStyle,
                                                            int backgroundStyle) {
        NavigationDrawerListItemBottom item = new NavigationDrawerListItemBottom(mContext,
                NavigationDrawerListItemBottom.HELP_AND_FEEDBACK);
        item.setOnClickListener(onClickListener);
        item.setTitleStyle(titleStyle);
        item.setBackgroundStyle(backgroundStyle);
        mItems.add(item);
        return this;
    }

    public NavigationDrawerBottomHandler addItem(int titleResource,
                                                 View.OnClickListener onClickListener) {
        NavigationDrawerListItemBottom item = new NavigationDrawerListItemBottom(mContext,
                NavigationDrawerListItemBottom.CUSTOM);
        item.setTitle(mContext, titleResource);
        item.setOnClickListener(onClickListener);
        mItems.add(item);
        return this;
    }

    public NavigationDrawerBottomHandler addItem(int titleResource,
                                                 View.OnClickListener onClickListener,
                                                 int titleStyle) {
        NavigationDrawerListItemBottom item = new NavigationDrawerListItemBottom(mContext,
                NavigationDrawerListItemBottom.CUSTOM);
        item.setTitle(mContext, titleResource);
        item.setOnClickListener(onClickListener);
        item.setTitleStyle(titleStyle);
        mItems.add(item);
        return this;
    }

    public NavigationDrawerBottomHandler addItem(int titleResource,
                                                 View.OnClickListener onClickListener,
                                                 int titleStyle,
                                                 int backgroundStyle) {
        NavigationDrawerListItemBottom item = new NavigationDrawerListItemBottom(mContext,
                NavigationDrawerListItemBottom.CUSTOM);
        item.setTitle(mContext, titleResource);
        item.setOnClickListener(onClickListener);
        item.setTitleStyle(titleStyle);
        item.setBackgroundStyle(backgroundStyle);
        mItems.add(item);
        return this;
    }

    public NavigationDrawerBottomHandler addItem(String title,
                                                 View.OnClickListener onClickListener) {
        NavigationDrawerListItemBottom item = new NavigationDrawerListItemBottom(mContext,
                NavigationDrawerListItemBottom.CUSTOM);
        item.setTitle(title);
        item.setOnClickListener(onClickListener);
        mItems.add(item);
        return this;
    }

    public NavigationDrawerBottomHandler addItem(String title,
                                                 View.OnClickListener onClickListener,
                                                 int titleStyle) {
        NavigationDrawerListItemBottom item = new NavigationDrawerListItemBottom(mContext,
                NavigationDrawerListItemBottom.CUSTOM);
        item.setTitle(title);
        item.setOnClickListener(onClickListener);
        item.setTitleStyle(titleStyle);
        mItems.add(item);
        return this;
    }

    public NavigationDrawerBottomHandler addItem(String title,
                                                 View.OnClickListener onClickListener,
                                                 int titleStyle,
                                                 int backgroundStyle) {
        NavigationDrawerListItemBottom item = new NavigationDrawerListItemBottom(mContext,
                NavigationDrawerListItemBottom.CUSTOM);
        item.setTitle(title);
        item.setOnClickListener(onClickListener);
        item.setTitleStyle(titleStyle);
        item.setBackgroundStyle(backgroundStyle);
        mItems.add(item);
        return this;
    }

    public NavigationDrawerBottomHandler addItem(int titleResource,
                                                 int iconResource,
                                                 View.OnClickListener onClickListener) {
        NavigationDrawerListItemBottom item = new NavigationDrawerListItemBottom(mContext,
                NavigationDrawerListItemBottom.CUSTOM);
        item.setTitle(mContext, titleResource);
        item.setIcon(mContext, iconResource);
        item.setOnClickListener(onClickListener);
        mItems.add(item);
        return this;
    }

    public NavigationDrawerBottomHandler addItem(int titleResource,
                                                 int iconResource,
                                                 View.OnClickListener onClickListener,
                                                 int titleStyle) {
        NavigationDrawerListItemBottom item = new NavigationDrawerListItemBottom(mContext,
                NavigationDrawerListItemBottom.CUSTOM);
        item.setTitle(mContext, titleResource);
        item.setIcon(mContext, iconResource);
        item.setOnClickListener(onClickListener);
        item.setTitleStyle(titleStyle);
        mItems.add(item);
        return this;
    }

    public NavigationDrawerBottomHandler addItem(int titleResource,
                                                 int iconResource,
                                                 View.OnClickListener onClickListener,
                                                 int titleStyle,
                                                 int backgroundStyle) {
        NavigationDrawerListItemBottom item = new NavigationDrawerListItemBottom(mContext,
                NavigationDrawerListItemBottom.CUSTOM);
        item.setTitle(mContext, titleResource);
        item.setIcon(mContext, iconResource);
        item.setOnClickListener(onClickListener);
        item.setTitleStyle(titleStyle);
        item.setBackgroundStyle(backgroundStyle);
        mItems.add(item);
        return this;
    }

    public NavigationDrawerBottomHandler addItem(String title,
                                                 int iconResource,
                                                 View.OnClickListener onClickListener) {
        NavigationDrawerListItemBottom item = new NavigationDrawerListItemBottom(mContext,
                NavigationDrawerListItemBottom.CUSTOM);
        item.setTitle(title);
        item.setIcon(mContext, iconResource);
        item.setOnClickListener(onClickListener);
        mItems.add(item);
        return this;
    }

    public NavigationDrawerBottomHandler addItem(String title,
                                                 int iconResource,
                                                 View.OnClickListener onClickListener,
                                                 int titleStyle) {
        NavigationDrawerListItemBottom item = new NavigationDrawerListItemBottom(mContext,
                NavigationDrawerListItemBottom.CUSTOM);
        item.setTitle(title);
        item.setIcon(mContext, iconResource);
        item.setOnClickListener(onClickListener);
        item.setTitleStyle(titleStyle);
        mItems.add(item);
        return this;
    }

    public NavigationDrawerBottomHandler addItem(String title,
                                                 int iconResource,
                                                 View.OnClickListener onClickListener,
                                                 int titleStyle,
                                                 int backgroundStyle) {
        NavigationDrawerListItemBottom item = new NavigationDrawerListItemBottom(mContext,
                NavigationDrawerListItemBottom.CUSTOM);
        item.setTitle(title);
        item.setIcon(mContext, iconResource);
        item.setOnClickListener(onClickListener);
        item.setTitleStyle(titleStyle);
        item.setBackgroundStyle(backgroundStyle);
        mItems.add(item);
        return this;
    }

    public NavigationDrawerBottomHandler addItem(int titleResource,
                                                 Drawable icon,
                                                 View.OnClickListener onClickListener) {
        NavigationDrawerListItemBottom item = new NavigationDrawerListItemBottom(mContext,
                NavigationDrawerListItemBottom.CUSTOM);
        item.setTitle(mContext, titleResource);
        item.setIcon(icon);
        item.setOnClickListener(onClickListener);
        mItems.add(item);
        return this;
    }

    public NavigationDrawerBottomHandler addItem(int titleResource,
                                                 Drawable icon,
                                                 View.OnClickListener onClickListener,
                                                 int titleStyle) {
        NavigationDrawerListItemBottom item = new NavigationDrawerListItemBottom(mContext,
                NavigationDrawerListItemBottom.CUSTOM);
        item.setTitle(mContext, titleResource);
        item.setIcon(icon);
        item.setOnClickListener(onClickListener);
        item.setTitleStyle(titleStyle);
        mItems.add(item);
        return this;
    }

    public NavigationDrawerBottomHandler addItem(int titleResource,
                                                 Drawable icon,
                                                 View.OnClickListener onClickListener,
                                                 int titleStyle,
                                                 int backgroundStyle) {
        NavigationDrawerListItemBottom item = new NavigationDrawerListItemBottom(mContext,
                NavigationDrawerListItemBottom.CUSTOM);
        item.setTitle(mContext, titleResource);
        item.setIcon(icon);
        item.setOnClickListener(onClickListener);
        item.setTitleStyle(titleStyle);
        item.setBackgroundStyle(backgroundStyle);
        mItems.add(item);
        return this;
    }

    public NavigationDrawerBottomHandler addItem(String title,
                                                 Drawable icon,
                                                 View.OnClickListener onClickListener) {
        NavigationDrawerListItemBottom item = new NavigationDrawerListItemBottom(mContext,
                NavigationDrawerListItemBottom.CUSTOM);
        item.setTitle(title);
        item.setIcon(icon);
        item.setOnClickListener(onClickListener);
        mItems.add(item);
        return this;
    }

    public NavigationDrawerBottomHandler addItem(String title,
                                                 Drawable icon,
                                                 View.OnClickListener onClickListener,
                                                 int titleStyle) {
        NavigationDrawerListItemBottom item = new NavigationDrawerListItemBottom(mContext,
                NavigationDrawerListItemBottom.CUSTOM);
        item.setTitle(title);
        item.setIcon(icon);
        item.setOnClickListener(onClickListener);
        item.setTitleStyle(titleStyle);
        mItems.add(item);
        return this;
    }

    public NavigationDrawerBottomHandler addItem(String title,
                                                 Drawable icon,
                                                 View.OnClickListener onClickListener,
                                                 int titleStyle,
                                                 int backgroundStyle) {
        NavigationDrawerListItemBottom item = new NavigationDrawerListItemBottom(mContext,
                NavigationDrawerListItemBottom.CUSTOM);
        item.setTitle(title);
        item.setIcon(icon);
        item.setOnClickListener(onClickListener);
        item.setTitleStyle(titleStyle);
        item.setBackgroundStyle(backgroundStyle);
        mItems.add(item);
        return this;
    }

    public NavigationDrawerBottomHandler addItem(int titleResource,
                                                 String iconUrl,
                                                 View.OnClickListener onClickListener) {
        NavigationDrawerListItemBottom item = new NavigationDrawerListItemBottom(mContext,
                NavigationDrawerListItemBottom.CUSTOM);
        item.setTitle(mContext, titleResource);
        item.setIcon(Glide.with(mContext).load(iconUrl));
        item.setOnClickListener(onClickListener);
        mItems.add(item);
        return this;
    }

    public NavigationDrawerBottomHandler addItem(int titleResource,
                                                 String iconUrl,
                                                 View.OnClickListener onClickListener,
                                                 int titleStyle) {
        NavigationDrawerListItemBottom item = new NavigationDrawerListItemBottom(mContext,
                NavigationDrawerListItemBottom.CUSTOM);
        item.setTitle(mContext, titleResource);
        item.setIcon(Glide.with(mContext).load(iconUrl));
        item.setOnClickListener(onClickListener);
        item.setTitleStyle(titleStyle);
        mItems.add(item);
        return this;
    }

    public NavigationDrawerBottomHandler addItem(int titleResource,
                                                 String iconUrl,
                                                 View.OnClickListener onClickListener,
                                                 int titleStyle,
                                                 int backgroundStyle) {
        NavigationDrawerListItemBottom item = new NavigationDrawerListItemBottom(mContext,
                NavigationDrawerListItemBottom.CUSTOM);
        item.setTitle(mContext, titleResource);
        item.setIcon(Glide.with(mContext).load(iconUrl));
        item.setOnClickListener(onClickListener);
        item.setTitleStyle(titleStyle);
        item.setBackgroundStyle(backgroundStyle);
        mItems.add(item);
        return this;
    }

    public NavigationDrawerBottomHandler addItem(String title,
                                                 String iconUrl,
                                                 View.OnClickListener onClickListener) {
        NavigationDrawerListItemBottom item = new NavigationDrawerListItemBottom(mContext,
                NavigationDrawerListItemBottom.CUSTOM);
        item.setTitle(title);
        item.setIcon(Glide.with(mContext).load(iconUrl));
        item.setOnClickListener(onClickListener);
        mItems.add(item);
        return this;
    }

    public NavigationDrawerBottomHandler addItem(String title,
                                                 String iconUrl,
                                                 View.OnClickListener onClickListener,
                                                 int titleStyle) {
        NavigationDrawerListItemBottom item = new NavigationDrawerListItemBottom(mContext,
                NavigationDrawerListItemBottom.CUSTOM);
        item.setTitle(title);
        item.setIcon(Glide.with(mContext).load(iconUrl));
        item.setOnClickListener(onClickListener);
        item.setTitleStyle(titleStyle);
        mItems.add(item);
        return this;
    }

    public NavigationDrawerBottomHandler addItem(String title,
                                                 String iconUrl,
                                                 View.OnClickListener onClickListener,
                                                 int titleStyle,
                                                 int backgroundStyle) {
        NavigationDrawerListItemBottom item = new NavigationDrawerListItemBottom(mContext,
                NavigationDrawerListItemBottom.CUSTOM);
        item.setTitle(title);
        item.setIcon(Glide.with(mContext).load(iconUrl));
        item.setOnClickListener(onClickListener);
        item.setTitleStyle(titleStyle);
        item.setBackgroundStyle(backgroundStyle);
        mItems.add(item);
        return this;
    }

    public List<NavigationDrawerListItemBottom> getNavigationDrawerBottomItems() {
        return mItems;
    }

}
