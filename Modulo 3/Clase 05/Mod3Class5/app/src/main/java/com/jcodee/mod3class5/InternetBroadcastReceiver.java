package com.jcodee.mod3class5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

/**
 * Created by johannfjs on 28/03/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class InternetBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager connectivityManager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if (networkInfo != null) {
                boolean status = networkInfo.isConnected();
                Toast.makeText(context, "Estado de Internet: " + status, Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(context, "Estado de Internet: " + false, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
