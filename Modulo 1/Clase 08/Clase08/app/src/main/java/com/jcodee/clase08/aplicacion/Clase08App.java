package com.jcodee.clase08.aplicacion;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by johannfjs on 9/02/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class Clase08App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Fresco.initialize(getApplicationContext());
    }
}
