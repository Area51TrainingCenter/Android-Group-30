package com.jcodee.mod3class5;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by johannfjs on 28/03/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class InternetService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        //Verificamos estado de conexión de internet
        ConnectivityManager manager = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        if (manager != null) {
            NetworkInfo networkInfo = manager.getActiveNetworkInfo();
            if (networkInfo != null) {
                boolean conexion = networkInfo.isConnected();

                Toast.makeText(this, "Existe conexión: " + conexion, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Internet no disponible", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Internet no disponible", Toast.LENGTH_SHORT).show();
        }
        return START_STICKY;
}

    @Override
    public void onDestroy() {
        super.onDestroy();

        Toast.makeText(this, "Se destruyo la conexión", Toast.LENGTH_SHORT).show();
    }
}
