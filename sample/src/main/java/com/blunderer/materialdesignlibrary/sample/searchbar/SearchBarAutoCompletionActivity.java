package com.blunderer.materialdesignlibrary.sample.searchbar;

import android.widget.Toast;

import com.blunderer.materialdesignlibrary.activities.Activity;
import com.blunderer.materialdesignlibrary.handlers.ActionBarHandler;
import com.blunderer.materialdesignlibrary.handlers.ActionBarSearchHandler;
import com.blunderer.materialdesignlibrary.listeners.OnSearchListener;
import com.blunderer.materialdesignlibrary.sample.R;
import com.blunderer.materialdesignlibrary.views.ToolbarSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchBarAutoCompletionActivity extends Activity {

    private final static List<String> mItems = new ArrayList<>(
            Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
                    "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
                    "seventeen", "eighteen", "nineteen", "twenty"));

    @Override
    protected boolean enableActionBarShadow() {
        return false;
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_searchbar_autocompletion;
    }

    @Override
    protected ActionBarHandler getActionBarHandler() {
        return new ActionBarSearchHandler(this, new OnSearchListener() {

            @Override
            public void onSearched(String text) {
                Toast.makeText(getApplicationContext(),
                        "Searching \"" + text + "\"", Toast.LENGTH_SHORT).show();
            }

        })
                .enableAutoCompletion()
                .setAutoCompletionSuggestions(mItems)
                .setAutoCompletionMode(ToolbarSearch.AutoCompletionMode.CONTAINS);
    }

}
