package com.sst.sstopenhouse2017;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class RegistrationActivity extends AppCompatActivity {

    private static final String PREFERENCE_FORM_COMPLETED = "com.sst.sstopenhouse2017.RegistrationActivity.FORM_COMPLETED";

    SharedPreferences preferences;

    private void finishActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        finishActivity();

        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean formCompleted = preferences.getBoolean(PREFERENCE_FORM_COMPLETED, false);

        if (formCompleted) {
            finishActivity();
        }

        String googleFormUrl = getString(R.string.registration_form_url);
        WebView formWebView = (WebView) findViewById(R.id.form_webView);
        formWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);

                if (url.endsWith("formResponse")) {
                    preferences.edit().putBoolean(PREFERENCE_FORM_COMPLETED, true).apply();
                    finishActivity();
                }
            }
        });
        formWebView.getSettings().setJavaScriptEnabled(true);
        formWebView.loadUrl(googleFormUrl);
    }
}
