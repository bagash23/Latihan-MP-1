package com.example.latihanactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class PindahWebActivity extends AppCompatActivity {

    Button btn_pindah_web;
    Button logout_keluar;
    WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pindah_web);
        webView = findViewById(R.id.situs_bsi);
        logout_keluar = findViewById(R.id.btn_logout);
        btn_pindah_web = findViewById(R.id.btn_web);
        btn_pindah_web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webView.setVisibility(View.VISIBLE);
                btn_pindah_web.setVisibility(View.GONE);
                logout_keluar.setVisibility(View.GONE);
                webView.loadUrl("https://www.bsi.ac.id/ubsi/index.js");
            }
        });
        logout_keluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}