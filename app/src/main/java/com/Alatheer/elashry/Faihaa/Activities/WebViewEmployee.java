package com.Alatheer.elashry.Faihaa.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.Alatheer.elashry.Faihaa.R;

public class WebViewEmployee extends AppCompatActivity {

    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_employee);

        webView =  findViewById(R.id.webView1);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://anwaralfyaha.anwaralfyaha.com/login");
    }
}
