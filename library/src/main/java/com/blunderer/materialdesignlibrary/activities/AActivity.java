package com.blunderer.materialdesignlibrary.activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.blunderer.materialdesignlibrary.R;
import com.blunderer.materialdesignlibrary.handlers.ActionBarHandler;
import com.blunderer.materialdesignlibrary.handlers.ActionBarSearchHandler;
import com.blunderer.materialdesignlibrary.views.Toolbar;
import com.blunderer.materialdesignlibrary.views.ToolbarDefault;
import com.blunderer.materialdesignlibrary.views.ToolbarSearch;

public abstract class AActivity extends AppCompatActivity {

    private final static String TOOLBAR_SEARCH_CONSTRAINT_KEY = "ToolbarSearchConstraint";
    private final static String TOOLBAR_SEARCH_IS_SHOWN = "ToolbarSearchIsShown";

    private Toolbar mCustomToolbar;
    private View mShadowView;
    private View mCustomSearchButton;
    private ActionBarHandler mActionBarHandler;

    public void onCreate(Bundle savedInstanceState, int contentView) {
        super.onCreate(savedInstanceState);

        setContentView(contentView);

        // Toolbar Shadow View
        mShadowView = findViewById(R.id.toolbar_shadow);
        if (mShadowView != null && (this instanceof ViewPagerWithTabsActivity)) {
            FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) mShadowView
                    .getLayoutParams();
            params.topMargin = (int) getResources()
                    .getDimension(R.dimen.mdl_viewpager_with_tabs_height);
        }
        if (enableActionBarShadow()) showActionBarShadow();

        mActionBarHandler = getActionBarHandler();
        if (mActionBarHandler == null) mCustomToolbar = new ToolbarDefault(this);
        else mCustomToolbar = mActionBarHandler.build();

        // Toolbar Search
        if (mCustomToolbar instanceof ToolbarSearch) {
            ToolbarSearch toolbarSearch = (ToolbarSearch) mCustomToolbar;
            toolbarSearch.setActivity(this);

            if (savedInstanceState != null) {
                toolbarSearch
                        .setConstraint(savedInstanceState.getString(TOOLBAR_SEARCH_CONSTRAINT_KEY));
                if (savedInstanceState.getBoolean(TOOLBAR_SEARCH_IS_SHOWN)) {
                    toolbarSearch.showSearchBar();
                    hideActionBarShadow();
                }
            }
        }

        ViewGroup rootView = (ViewGroup) ((ViewGroup) findViewById(android.R.id.content))
                .getChildAt(0);
        if (this instanceof NavigationDrawerActivity) rootView.addView(mCustomToolbar, 1);
        else rootView.addView(mCustomToolbar);

        mCustomToolbar.getToolbar()
                .setTitleTextColor(getResources().getColor(android.R.color.white));
        setSupportActionBar(mCustomToolbar.getToolbar());
        if (getSupportActionBar() != null) getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        // Custom Search Button
        if (mActionBarHandler instanceof ActionBarSearchHandler) {
            int customSearchButtonId = ((ActionBarSearchHandler) mActionBarHandler)
                    .getCustomSearchButtonId();
            if (customSearchButtonId != 0) mCustomSearchButton = findViewById(customSearchButtonId);
            else mCustomSearchButton = ((ActionBarSearchHandler) mActionBarHandler)
                    .getCustomSearchButton();
            if (mCustomSearchButton != null) {
                mCustomSearchButton.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        showActionBarSearch();
                        hideActionBarShadow();
                    }

                });
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        if (mCustomToolbar instanceof ToolbarSearch) {
            ToolbarSearch toolbarSearch = (ToolbarSearch) mCustomToolbar;
            outState.putBoolean(TOOLBAR_SEARCH_IS_SHOWN, toolbarSearch.isSearchBarShown());
            outState.putString(TOOLBAR_SEARCH_CONSTRAINT_KEY, toolbarSearch.getConstraint());
        }

        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (mCustomToolbar instanceof ToolbarSearch && mCustomSearchButton == null) {
            MenuItem searchItem = menu
                    .add(0, R.id.mdl_toolbar_search_menu_item, Menu.NONE, "Search")
                    .setIcon(R.drawable.ic_action_search);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                searchItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
            }
        }

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.mdl_toolbar_search_menu_item) {
            showActionBarSearch();
            hideActionBarShadow();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (mCustomToolbar instanceof ToolbarSearch) {
            ToolbarSearch toolbarSearch = ((ToolbarSearch) mCustomToolbar);
            if (toolbarSearch.isSearchBarShown()) {
                toolbarSearch.hideSearchBar();
                showActionBarShadow();
                return;
            }
        }
        super.onBackPressed();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == ToolbarSearch.SEARCH_REQUEST_CODE) {
            ((ToolbarSearch) mCustomToolbar).onActivityResult(requestCode, resultCode, data);
        }
    }

    public android.support.v7.widget.Toolbar getMaterialDesignActionBar() {
        return mCustomToolbar.getToolbar();
    }

    public View getActionBarShadowView() {
        return mShadowView;
    }


    public void showActionBarSearch() {
        if (mCustomToolbar instanceof ToolbarSearch) {
            ((ToolbarSearch) mCustomToolbar).showSearchBar();
        }
    }

    public void hideActionBarSearch() {
        if (mCustomToolbar instanceof ToolbarSearch) {
            ((ToolbarSearch) mCustomToolbar).hideSearchBar();
        }
    }

    public void showActionBarShadow() {
        if (mShadowView != null) mShadowView.setVisibility(View.VISIBLE);
    }

    public void hideActionBarShadow() {
        if (mShadowView != null) mShadowView.setVisibility(View.INVISIBLE);
    }

    protected abstract boolean enableActionBarShadow();

    protected abstract ActionBarHandler getActionBarHandler();

}
