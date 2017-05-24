package com.sst.sstopenhouse2017;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.shell.MainReactPackage;
import com.sst.sstopenhouse2017.fragments.RedemptionFragment;

public class MainActivity extends AppCompatActivity implements
        BottomNavigationView.OnNavigationItemSelectedListener, DefaultHardwareBackBtnHandler {
    private BottomNavigationView bottomNavigationView;

    ReactInstanceManager reactInstanceManager;
    ReactRootView reactRootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        this.reactRootView = (ReactRootView) this.findViewById(R.id.react_root_view);
        this.reactInstanceManager = ReactInstanceManager.builder()
                .setApplication(this.getApplication())
                .setBundleAssetName("index.android.bundle")
                .setJSMainModuleName("index.android")
                .addPackage(new MainReactPackage())
                .setUseDeveloperSupport(BuildConfig.DEBUG)
                .setInitialLifecycleState(LifecycleState.RESUMED)
                .build();
        this.reactRootView.startReactApplication(reactInstanceManager, "MainPage", null);

        this.bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.navigation_home);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.navigation_redemption) {
            Fragment redemptionFragment = new RedemptionFragment();
            getSupportFragmentManager().beginTransaction().replace(
                    R.id.main_content_layout, redemptionFragment
            ).commit();
        } else if (id == R.id.navigation_home) {
//            Fragment homeFragment = new HomeFragment();
//            getSupportFragmentManager().beginTransaction().replace(
//                    R.id.main_content_layout, homeFragment
//            ).commit();
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (this.reactInstanceManager != null) {
            this.reactInstanceManager.onBackPressed();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onPause() {
        super.onPause();

        if (this.reactInstanceManager != null) {
            this.reactInstanceManager.onHostPause(this);
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        if (this.reactInstanceManager != null) {
            this.reactInstanceManager.onHostResume(this, this);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (this.reactInstanceManager != null) {
            this.reactInstanceManager.onHostDestroy(this);
        }
    }
}
