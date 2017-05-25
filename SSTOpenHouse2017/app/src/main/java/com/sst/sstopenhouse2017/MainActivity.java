package com.sst.sstopenhouse2017;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.sst.sstopenhouse2017.fragments.HomeFragment;
import com.sst.sstopenhouse2017.fragments.RedemptionFragment;

public class MainActivity extends AppCompatActivity implements
        BottomNavigationView.OnNavigationItemSelectedListener, DefaultHardwareBackBtnHandler {
    private BottomNavigationView bottomNavigationView;

    private HomeFragment homeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        if (savedInstanceState == null) {
            this.homeFragment = new HomeFragment();
            bottomNavigationView.setSelectedItemId(R.id.navigation_home);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.navigation_redemption) {
            getSupportFragmentManager().beginTransaction().replace(
                    R.id.main_content_layout, new RedemptionFragment()
            ).commit();
        } else if (id == R.id.navigation_home) {
            getSupportFragmentManager().beginTransaction().replace(
                    R.id.main_content_layout, this.homeFragment
            ).commit();
        } else if (id == R.id.navigation_website) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.sst.edu.sg/"));
            startActivity(intent);
            bottomNavigationView.setSelectedItemId(R.id.navigation_home);
            bottomNavigationView.getMenu().getItem(1).setChecked(true);
        }
        return true;
    }

    @Override
    public void invokeDefaultOnBackPressed() {
        super.onBackPressed();
    }

    public void onBackPressedReactNull() {
        super.onBackPressed();
    }

    @Override
    public void onBackPressed() {
        this.homeFragment.onBackPressed();
    }

    @Override
    public void onPause() {
        super.onPause();

        this.homeFragment.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();

        this.homeFragment.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        this.homeFragment.onDestroy();
    }
}
