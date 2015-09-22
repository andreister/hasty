package com.blunderer.materialdesignlibrary.models;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;

import com.bumptech.glide.DrawableTypeRequest;
import com.bumptech.glide.Glide;

public class Account {

    private String mTitle;
    private String mDescription;
    private Drawable mPictureResource;
    private DrawableTypeRequest<String> mPictureUrl;
    private int mBackgroundResource;
    private Drawable mBackgroundDrawable;
    private DrawableTypeRequest<String> mBackgroundUrl;

    private boolean mUseBackgroundDrawable;
    private boolean mUseBackgroundUrl;
    private boolean mUsePictureUrl;

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String name) {
        this.mTitle = name;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String email) {
        this.mDescription = email;
    }

    public Drawable getPictureResource() {
        return mPictureResource;
    }

    public DrawableTypeRequest<String> getPictureUrl() {
        return mPictureUrl;
    }

    public void setPicture(Context context, int pictureResource) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mPictureResource = context.getDrawable(pictureResource);
        } else mPictureResource = context.getResources().getDrawable(pictureResource);
    }

    public void setPicture(Drawable picture) {
        mUsePictureUrl = false;
        mPictureResource = picture;
    }

    public void setPicture(Context context, String pictureUrl) {
        mUsePictureUrl = true;
        mPictureUrl = Glide.with(context).load(pictureUrl);
    }

    public int getBackgroundResource() {
        return mBackgroundResource;
    }

    public Drawable getBackgroundDrawable() {
        return mBackgroundDrawable;
    }

    public DrawableTypeRequest<String> getBackgroundUrl() {
        return mBackgroundUrl;
    }

    public void setBackground(int backgroundResource) {
        mUseBackgroundDrawable = false;
        mUseBackgroundUrl = false;
        mBackgroundResource = backgroundResource;
    }

    public void setBackground(Drawable background) {
        mUseBackgroundDrawable = true;
        mUseBackgroundUrl = false;
        mBackgroundDrawable = background;
    }

    public void setBackground(Context context, String backgroundUrl) {
        mUseBackgroundDrawable = false;
        mUseBackgroundUrl = true;
        mBackgroundUrl = Glide.with(context).load(backgroundUrl);
    }

    public boolean useBackgroundDrawable() {
        return mUseBackgroundDrawable;
    }

    public boolean useBackgroundUrl() {
        return mUseBackgroundUrl;
    }

    public boolean usePictureUrl() {
        return mUsePictureUrl;
    }

}
