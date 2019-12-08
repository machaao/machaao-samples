package com.machaao.sample.generic;

import android.content.Intent;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.machaao.android.sdk.activities.SingleBotActivity;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Start home activity
        if (getIntent().getExtras() != null) {
            for (String key : getIntent().getExtras().keySet()) {
                Object value = getIntent().getExtras().get(key);
                Log.d(SplashActivity.class.toString(), "Key: " + key + " Value: " + value);
            }
        }

        startActivity(new Intent(SplashActivity.this, SingleBotActivity.class));
        // close splash activity
        finish();
    }
}