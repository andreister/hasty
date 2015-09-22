package com.blunderer.materialdesignlibrary.sample.navigationdrawers;

import android.content.Intent;
import android.view.View;

import com.blunderer.materialdesignlibrary.handlers.ActionBarDefaultHandler;
import com.blunderer.materialdesignlibrary.handlers.ActionBarHandler;
import com.blunderer.materialdesignlibrary.handlers.NavigationDrawerAccountsHandler;
import com.blunderer.materialdesignlibrary.handlers.NavigationDrawerAccountsMenuHandler;
import com.blunderer.materialdesignlibrary.handlers.NavigationDrawerBottomHandler;
import com.blunderer.materialdesignlibrary.handlers.NavigationDrawerStyleHandler;
import com.blunderer.materialdesignlibrary.handlers.NavigationDrawerTopHandler;
import com.blunderer.materialdesignlibrary.models.Account;
import com.blunderer.materialdesignlibrary.sample.R;
import com.blunderer.materialdesignlibrary.sample.listviews.ListViewFragment;
import com.blunderer.materialdesignlibrary.sample.viewpagers.ViewPagerActivity;

public class NavigationDrawerWithAccountsActivity
        extends com.blunderer.materialdesignlibrary.activities.NavigationDrawerActivity {

    @Override
    public NavigationDrawerStyleHandler getNavigationDrawerStyleHandler() {
        return null;
    }

    @Override
    protected boolean enableActionBarShadow() {
        return false;
    }

    @Override
    public NavigationDrawerAccountsHandler getNavigationDrawerAccountsHandler() {
        return new NavigationDrawerAccountsHandler(this)
                .enableSmallAccountsLayout()
                .addAccount("John Smith", "jsmith@gmail.com", R.drawable.profile, R.drawable.profile_bg);
    }

    @Override
    public NavigationDrawerAccountsMenuHandler getNavigationDrawerAccountsMenuHandler() {
        return new NavigationDrawerAccountsMenuHandler(this)
                .addAddAccount(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                })
                .addManageAccounts(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                });
    }

    @Override
    public void onNavigationDrawerAccountChange(Account account) {
    }

    @Override
    public NavigationDrawerTopHandler getNavigationDrawerTopHandler() {
        return new NavigationDrawerTopHandler(this)
                .addSection("My service calls")
                .addItem("Today: job #1234, asap", new ListViewFragment())
                .addItem("Today: job #5678, afternoon", new ListViewFragment())
                .addItem("Tomorrow: job #9023, afternoon", new ListViewFragment())
                .addSection("My purchase orders")
                .addItem("#1234.1", new Intent(getApplicationContext(), ViewPagerActivity.class))
                .addItem("#1234.2", new Intent(getApplicationContext(), ViewPagerActivity.class))
                .addSection("My timesheets");
    }

    @Override
    public NavigationDrawerBottomHandler getNavigationDrawerBottomHandler() {
        return new NavigationDrawerBottomHandler(this)
                .addSettings(null);
    }

    @Override
    public boolean overlayActionBar() {
        return false;
    }

    @Override
    public boolean replaceActionBarTitleByNavigationDrawerItemTitle() {
        return true;
    }

    @Override
    public int defaultNavigationDrawerItemSelectedPosition() {
        return 1;
    }

    @Override
    protected ActionBarHandler getActionBarHandler() {
        return new ActionBarDefaultHandler(this);
    }

}
