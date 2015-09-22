package com.blunderer.materialdesignlibrary.interfaces;

import com.blunderer.materialdesignlibrary.handlers.NavigationDrawerAccountsHandler;
import com.blunderer.materialdesignlibrary.handlers.NavigationDrawerAccountsMenuHandler;
import com.blunderer.materialdesignlibrary.handlers.NavigationDrawerBottomHandler;
import com.blunderer.materialdesignlibrary.handlers.NavigationDrawerStyleHandler;
import com.blunderer.materialdesignlibrary.handlers.NavigationDrawerTopHandler;
import com.blunderer.materialdesignlibrary.models.Account;

public interface NavigationDrawer {

    void updateNavigationDrawerStyleHandler(
            NavigationDrawerStyleHandler navigationDrawerStyleHandler);

    void updateNavigationDrawerTopHandler(
            NavigationDrawerTopHandler navigationDrawerTopHandler,
            int defaultNavigationDrawerItemSelectedPosition);

    void updateNavigationDrawerBottomHandler(
            NavigationDrawerBottomHandler navigationDrawerBottomHandler);

    void closeNavigationDrawer();

    void openNavigationDrawer();

    boolean isNavigationDrawerOpen();

    void performNavigationDrawerItemClick(int position);

    NavigationDrawerStyleHandler getNavigationDrawerStyleHandler();

    NavigationDrawerAccountsHandler getNavigationDrawerAccountsHandler();

    NavigationDrawerAccountsMenuHandler getNavigationDrawerAccountsMenuHandler();

    void onNavigationDrawerAccountChange(Account account);

    NavigationDrawerTopHandler getNavigationDrawerTopHandler();

    NavigationDrawerBottomHandler getNavigationDrawerBottomHandler();

    boolean overlayActionBar();

    boolean replaceActionBarTitleByNavigationDrawerItemTitle();

    int defaultNavigationDrawerItemSelectedPosition();

}
