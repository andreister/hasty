package com.blunderer.materialdesignlibrary.sample;

import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.Toast;

import com.blunderer.materialdesignlibrary.handlers.ActionBarDefaultHandler;
import com.blunderer.materialdesignlibrary.handlers.ActionBarHandler;
import com.blunderer.materialdesignlibrary.sample.cardviews.CardViewNormalActivity;
import com.blunderer.materialdesignlibrary.sample.navigationdrawers.NavigationDrawerWithAccountsActivity;
import com.blunderer.materialdesignlibrary.sample.searchbar.SearchBarAutoCompletionActivity;

import java.util.ArrayList;
import java.util.List;

import carbon.widget.Snackbar;

public class MainActivity extends com.blunderer.materialdesignlibrary.activities.ListViewActivity
                          implements NetworkStateReceiver.NetworkStateReceiverListener
{
    private NetworkStateReceiver networkStateReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        networkStateReceiver = new NetworkStateReceiver();
        networkStateReceiver.addListener(this);
        this.registerReceiver(networkStateReceiver, new IntentFilter(android.net.ConnectivityManager.CONNECTIVITY_ACTION));
    }

    public void networkAvailable() {
        Toast.makeText(getApplicationContext(), "You've gone online", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void networkUnavailable() {
        Toast.makeText(getApplicationContext(), "You've gone offline", Toast.LENGTH_SHORT).show();
    }

    @Override
    public ListAdapter getListAdapter() {
        List<MainActivityFeature> features = getFeatures();
        return new MainActivityAdapter(this, R.layout.activity_main_row, features);
    }

    @Override
    protected boolean enableActionBarShadow() { return false; }

    @Override
    public boolean useCustomContentView() {
        return false;
    }

    @Override
    public int getCustomContentView() {
        return 0;
    }

    @Override
    public boolean pullToRefreshEnabled() {
        return false;
    }

    @Override
    public int[] getPullToRefreshColorResources() {
        return new int[0];
    }

    @Override
    public void onRefresh() {
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        MainActivityFeature item = (MainActivityFeature) adapterView.getAdapter().getItem(position);
        Intent intent = new Intent(this, item.getActivity());
        startActivity(intent);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected ActionBarHandler getActionBarHandler() {
        return new ActionBarDefaultHandler(this);
    }

    private List<MainActivityFeature> getFeatures() {
        MainActivityFeature searchbar = new MainActivityFeature();
        searchbar.setActivity(SearchBarAutoCompletionActivity.class);
        searchbar.setTitle("Look for a specific job");
        searchbar.setDescription("Implemented as a search box with auto completion. Try the voice as well!");

        MainActivityFeature cardview = new MainActivityFeature();
        cardview.setActivity(CardViewNormalActivity.class);
        cardview.setTitle("List through available jobs");
        cardview.setDescription("Implemented as a basic cards view, can also have an image");

        MainActivityFeature drawer = new MainActivityFeature();
        drawer.setActivity(NavigationDrawerWithAccountsActivity.class);
        drawer.setTitle("Main actions");
        drawer.setDescription("Implemented as a navigation drawer with account view, settings etc");

        List<MainActivityFeature> objects = new ArrayList<>();
        objects.add(searchbar);
        objects.add(cardview);
        objects.add(drawer);

        return objects;
    }

}
