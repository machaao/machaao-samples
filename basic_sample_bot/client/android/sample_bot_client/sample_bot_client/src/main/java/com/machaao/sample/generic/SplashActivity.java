package com.machaao.sample.generic;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.google.firebase.FirebaseApp;
import com.google.firebase.messaging.FirebaseMessaging;
import com.machaao.android.sdk.Machaao;
import com.machaao.android.sdk.activities.SingleBotActivity;
import com.machaao.android.sdk.helpers.LogUtils;

import org.apache.commons.lang3.StringUtils;

public class SplashActivity extends AppCompatActivity {

    private static final String TAG = "SplashActivity";

    @Override
    public void onResume() {

        if (!Machaao.isInitialized()) {
            LogUtils.d(TAG, "waiting for initialization of SDK...");
            LocalBroadcastManager.getInstance(this).registerReceiver(mInitialized,
                    new IntentFilter("machaao.sdk.initialized"));
        } else {
            launch();
        }

        super.onResume();
    }

    @Override
    public void onDestroy() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mInitialized);
        super.onDestroy();
    }

    private BroadcastReceiver mInitialized = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, final Intent intent) {
            LogUtils.d(TAG, "received intent -> " + intent.toString());
            launch();
        }
    };

    private void launch() {
        Intent intent = null;
        try {
            ApplicationInfo app = getApplication().getPackageManager().getApplicationInfo(getApplication().getPackageName(), PackageManager.GET_META_DATA);
            Bundle bundle = app.metaData;

            final String registeredClass = bundle.getString("com.machaao.android.sdk.single.activity.registered");

            if(!StringUtils.isEmpty(registeredClass)) {
                intent = new Intent(this, Class.forName(registeredClass));
            } else {
                intent = new Intent(this, SingleBotActivity.class);
            }

            intent.putExtra("botToken", Machaao.getApiToken());
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(intent != null) {
            startActivity(intent);
        }

        // close splash activity
        finish();
    }
}