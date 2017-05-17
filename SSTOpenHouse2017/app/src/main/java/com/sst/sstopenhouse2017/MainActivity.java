package com.sst.sstopenhouse2017;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton redeemFab = (FloatingActionButton) findViewById(R.id.redeem_fab);
        redeemFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), RedemptionActivity.class);
                startActivity(intent);
            }
        });

        WebView mainWebView = (WebView) findViewById(R.id.main_webView);
        // TODO: Set the webpage to view
        String webpage = "";
        mainWebView.loadData(webpage, "text/html; charset=utf-8", "utf-8");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // TODO: fill up menu with items
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO: Setup item on item selected
        return super.onOptionsItemSelected(item);
    }
}
