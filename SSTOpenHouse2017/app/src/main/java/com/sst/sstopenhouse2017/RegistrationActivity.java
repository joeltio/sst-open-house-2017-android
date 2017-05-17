package com.sst.sstopenhouse2017;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class RegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        String googleFormUrl = getString(R.string.registration_form_url);
        WebView formWebView = (WebView) findViewById(R.id.form_webView);
        formWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);

                if (url.endsWith("formResponse")) {
                    Intent intent = new Intent(view.getContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
        formWebView.getSettings().setJavaScriptEnabled(true);
        formWebView.loadUrl(googleFormUrl);
    }
}
