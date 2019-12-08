package com.machaao.sample.generic;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import com.crashlytics.android.Crashlytics;
import com.machaao.android.sdk.BaseApplication;
import com.machaao.android.sdk.activities.SingleBotActivity;
//import com.squareup.leakcanary.LeakCanary;
import io.fabric.sdk.android.Fabric;
//import okhttp3.MediaType;


public class Application extends BaseApplication {

    private static final String TAG = "TheSampleBot";


    public static String getVersion() {
        return version;
    }

    public static void setVersion(String version) {
        Application.version = version;
    }

    private static String version;

    public static final String PREFERENCES = TAG + ".preferences";
    public static final String IS_SHORTCUT_CREATED = PREFERENCES + ".shortcut";
    private static final String KEY_SYNCING = "syncing";

    private String getAppVersion() {
        PackageInfo pInfo;
        try {
            pInfo = this.getPackageManager().getPackageInfo(this.getPackageName(), 0);
            return new StringBuilder("v").append(pInfo.versionName).toString();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        return "v0.9.9";
    }

    @Override
    public void onCreate() {

        // IMPORTANT - Configuration - DO NOT CHANGE

        super.setDev(true);
        super.setPREFERENCES(PREFERENCES);
        super.onCreate();
        setAllowAnonymousLogin(true);

        version = getAppVersion();
//        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
//            return;
//        }

//        LeakCanary.install(this);
        Fabric.with(this, new Crashlytics());
//        mConnectivityManager = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);

        if(!Application.hasShortcut()){
            addShortcut();
        }

    }

    public static boolean hasShortcut() {
        return getSharedPreferences().getBoolean(IS_SHORTCUT_CREATED, false);
    }

    public static boolean isSyncing() {
        return getSharedPreferences().getBoolean(KEY_SYNCING, false);
    }

    public static void createShortcut() {
        if(getSharedPreferences() != null) {
            SharedPreferences.Editor edit = getSharedPreferences().edit();
            edit.putBoolean(IS_SHORTCUT_CREATED, true);
            edit.apply();
            edit.commit();
        }
    }

    private void addShortcut() {
        Intent shortcutIntent = new Intent(getApplicationContext(),
                SingleBotActivity.class);

        shortcutIntent.setAction(Intent.ACTION_MAIN);

        Intent addIntent = new Intent();
        addIntent
                .putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortcutIntent);
        addIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME, getResources().getString(R.string.app_name));
        addIntent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE,
                Intent.ShortcutIconResource.fromContext(getApplicationContext(),
                        R.mipmap.ic_launcher));

        addIntent
                .setAction("com.android.launcher.action.INSTALL_SHORTCUT");
        addIntent.putExtra("duplicate", false);  //may it's already there so don't duplicate
        getApplicationContext().sendBroadcast(addIntent);

        Application.createShortcut();

    }
}