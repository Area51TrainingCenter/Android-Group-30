package com.jcodee.mod3class5;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/**
 * Created by johannfjs on 28/03/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class Configuracion extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        IntentFilter filter = new IntentFilter();
        filter.addAction(CONNECTIVITY_SERVICE);
        registerReceiver(new InternetBroadcastReceiver(), filter);
    }
}
