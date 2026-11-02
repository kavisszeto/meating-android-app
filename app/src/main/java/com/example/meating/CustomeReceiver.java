package com.example.meating;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
//import com.example.meating.BuildConfig;


public class CustomeReceiver extends BroadcastReceiver {
    private static final String ACTION_CUSTOM_BROADCAST =
            BuildConfig.APPLICATION_ID + ".ACTION_CUSTOM_BROADCAST";

    @Override
    public void onReceive(Context context, Intent intent) {
        String intentAction = intent.getAction();

        if (intentAction != null) {
            String toastMessage = "unknown intent action";
            switch (intentAction) {
                case Intent.ACTION_POWER_CONNECTED:
                    toastMessage = "充電了！";
                    break;
                case Intent.ACTION_POWER_DISCONNECTED:
                    toastMessage = "電源已斷開！";
                    break;
            }

            // Display the toast.
            Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show();
        }
    }
    public static final class BuildConfig {
        public static final boolean DEBUG = Boolean.parseBoolean("true");
        public static final String APPLICATION_ID = "com.example.meating";
        public static final String BUILD_TYPE = "debug";
        public static final int VERSION_CODE = 1;
        public static final String VERSION_NAME = "1.0";
    }

}
