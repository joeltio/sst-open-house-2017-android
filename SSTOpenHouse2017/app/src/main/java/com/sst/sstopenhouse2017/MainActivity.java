package com.sst.sstopenhouse2017;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import com.sst.sstopenhouse2017.fragments.HomeFragment;
import com.sst.sstopenhouse2017.fragments.RedemptionFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
            Fragment homeFragment = new HomeFragment();
            getSupportFragmentManager().beginTransaction().replace(
                    R.id.main_content_layout, homeFragment
            ).commit();
        } else if (id == R.id.navigation_website) {

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.sst.edu.sg/"));
            startActivity(intent);
            bottomNavigationView.setSelectedItemId(R.id.navigation_home);
            bottomNavigationView.getMenu().getItem(1).setChecked(true);
        }
        return true;
    }
}
