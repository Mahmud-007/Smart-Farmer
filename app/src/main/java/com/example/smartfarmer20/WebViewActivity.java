package com.example.smartfarmer20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {

    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        //setTitle(s);

        WebView webView = (WebView) findViewById(R.id.WebViewID);

        Intent intent=getIntent();
        String website=intent.getStringExtra("links");
        //webView.loadUrl("https://www.youtube.com/watch?v=SJgDswVRuXA");
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(website);
        WebSettings websettings = webView.getSettings();
        websettings.setJavaScriptEnabled(true);

    }

    @Override
    public void onBackPressed() {
        System.out.println(webView);
        if(webView == null){
            super.onBackPressed();
        }
        else if (webView.canGoBack()){
            webView.goBack();
        }
        else{
            super.onBackPressed();
        }
    }
    }

