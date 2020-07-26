package com.machaao.sample.generic;

import android.util.Log;

import com.google.firebase.messaging.RemoteMessage;
import com.machaao.android.sdk.services.MachaaoMessagingService;

public class BaseMessagingService extends MachaaoMessagingService {
    public static final String TAG = "BaseMessagingService";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.d(TAG, "From: " + remoteMessage.getFrom());
//        if(remoteMessage.getFrom() != null && remoteMessage.getFrom().equalsIgnoreCase(Machaao.getFirebaseSenderId())) {
            super.onMessageReceived(remoteMessage);
//        } else {
            // your code
//        }
    }
}
