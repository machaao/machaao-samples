package com.machaao.sample.generic;
import android.content.Intent;
import android.content.SharedPreferences;
import androidx.multidex.MultiDexApplication;
import com.machaao.android.sdk.Machaao;


public class Application extends MultiDexApplication {

    private static final String TAG = "Rasa.Sample";
    public static final String PREFERENCES = TAG + ".preferences";
    public static final String IS_SHORTCUT_CREATED = PREFERENCES + ".shortcut";

    @Override
    public void onCreate() {


        super.onCreate();

        Machaao.initialize(this);

        if(!Application.hasShortcut()){
            addShortcut();
        }
    }

    public static boolean hasShortcut() {
        return Machaao.getSharedPreferences().getBoolean(IS_SHORTCUT_CREATED, false) || Machaao.getSharedPreferences().getBoolean(Machaao.IS_OLD_BUILD_SHORTCUT_CREATED, false);
    }

    public static void createShortcut() {
        if(Machaao.getSharedPreferences() != null) {
            SharedPreferences.Editor edit = Machaao.getSharedPreferences().edit();
            edit.putBoolean(IS_SHORTCUT_CREATED, true);
            edit.apply();
            edit.commit();
        }
    }

    private void addShortcut() {
        Intent shortcutIntent = new Intent(getApplicationContext(),
                SplashActivity.class);

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

    @Override
    public void onTerminate() {

        if(Machaao.getInstance() != null) {
            Machaao.getInstance().shutdown();
        }

        super.onTerminate();
    }
}