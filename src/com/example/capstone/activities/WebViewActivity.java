package com.example.capstone.activities;


import info.androidhive.slidingmenu.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends Activity {
	WebView webView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.web);
		
		webView = (WebView)findViewById(R.id.webView1);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.getSettings().setLoadWithOverviewMode(true);
		webView.getSettings().setUseWideViewPort(true);
		Intent intent = getIntent();
		String url = intent.getExtras().getString("url");
		webView.loadUrl(url);
		webView.setWebViewClient(new WebViewClientClass());
		

	}
	@Override
    public boolean onKeyDown(int keyCode, KeyEvent event) { 
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) { 
        	webView.goBack(); 
            return true; 
        } 
        return super.onKeyDown(keyCode, event);
    }
     
	private class WebViewClientClass extends WebViewClient { 
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) { 
            view.loadUrl(url); 
            return true; 
        } 
    }
}
