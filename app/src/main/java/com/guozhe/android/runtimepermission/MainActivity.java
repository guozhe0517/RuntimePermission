package com.guozhe.android.runtimepermission;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    WebView webView;
    Button button1,button2,button3;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1= (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        editText=(EditText)findViewById(R.id.editText);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);

        webView = (WebView)findViewById(R.id.webView);

        webView.setWebViewClient(new WebViewClient());





    }
    private void loadUrl(String url){
        if(!url.startsWith("http")) {
            url="http://"+ url;

        }
        webView.loadUrl(url);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                if(webView.canGoBack()) {
                    webView.goBack();
                }
                break;
            case R.id.button2:
                if(webView.canGoForward()) {
                    webView.goForward();
                }
                break;
            case R.id.button3:
                String temp = editText.getText().toString();
                if(!"".equals(temp)) {
                    loadUrl(temp);
                }
                break;
        }


    }
}



