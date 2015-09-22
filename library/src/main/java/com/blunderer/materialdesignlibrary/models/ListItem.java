package com.blunderer.materialdesignlibrary.models;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;

import com.bumptech.glide.DrawableTypeRequest;

public abstract class ListItem {

    private String mTitle;
    private int mTitleStyle;
    private int mBackgroundStyle;
    private Drawable mIcon;
    private Drawable mSelectedIcon;
    private DrawableTypeRequest<String> mIconUrl;
    private DrawableTypeRequest<String> mSelectedIconUrl;
    private boolean mUseTitle = false;
    private boolean mUseTitleStyle = false;
    private boolean mUseBackgroundStyle = false;
    private boolean mUseIconResource = false;
    private boolean mUseIconUrl = false;
    private boolean mUseSelectedIconResource = false;
    private boolean mUseSelectedIconUrl = false;

    public void setTitle(Context context, int titleResource) {
        mUseTitle = true;
        mTitle = context.getString(titleResource);
    }

    public void setTitle(String title) {
        mUseTitle = true;
        mTitle = title;
    }

    public void setTitleStyle(int titleStyle) {
        mUseTitleStyle = true;
        mTitleStyle = titleStyle;
    }

    public void setBackgroundStyle(int backgroundStyle) {
        mUseBackgroundStyle = true;
        mBackgroundStyle = backgroundStyle;
    }

    public void setIcon(Context context, int iconResource) {
        mUseIconResource = true;
        mUseIconUrl = false;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mIcon = context.getDrawable(iconResource);
        } else mIcon = context.getResources().getDrawable(iconResource);
    }

    public void setIcon(Drawable icon) {
        mUseIconResource = true;
        mUseIconUrl = false;
        mIcon = icon;
    }

    public void setIcon(DrawableTypeRequest<String> iconUrl) {
        mUseIconResource = false;
        mUseIconUrl = true;
        mIconUrl = iconUrl;
    }

    public void setSelectedIcon(Context context, int selectedIconResource) {
        mUseSelectedIconResource = true;
        mUseSelectedIconUrl = false;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mSelectedIcon = context.getDrawable(selectedIconResource);
        } else mSelectedIcon = context.getResources().getDrawable(selectedIconResource);
    }

    public void setSelectedIcon(Drawable selectedIcon) {
        mUseSelectedIconResource = true;
        mUseSelectedIconUrl = false;
        mSelectedIcon = selectedIcon;
    }

    public void setSelectedIcon(DrawableTypeRequest<String> selectedIconUrl) {
        mUseSelectedIconResource = false;
        mUseSelectedIconUrl = true;
        mSelectedIconUrl = selectedIconUrl;
    }

    public String getTitle() {
        return mTitle;
    }

    public int getTitleStyle() {
        return mTitleStyle;
    }

    public int getBackgroundStyle() {
        return mBackgroundStyle;
    }

    public Drawable getIconDrawable() {
        return mIcon;
    }

    public DrawableTypeRequest<String> getIconUrl() {
        return mIconUrl;
    }

    public Drawable getSelectedIconDrawable() {
        return mSelectedIcon;
    }

    public DrawableTypeRequest<String> getSelectedIconUrl() {
        return mSelectedIconUrl;
    }

    public boolean useTitle() {
        return mUseTitle;
    }

    public boolean useTitleStyle() {
        return mUseTitleStyle;
    }

    public boolean useBackgroundStyle() {
        return mUseBackgroundStyle;
    }

    public boolean useIconResource() {
        return mUseIconResource;
    }

    public boolean useIconUrl() {
        return mUseIconUrl;
    }

    public boolean useSelectedIconResource() {
        return mUseSelectedIconResource;
    }

    public boolean useSelectedIconUrl() {
        return mUseSelectedIconUrl;
    }

}
