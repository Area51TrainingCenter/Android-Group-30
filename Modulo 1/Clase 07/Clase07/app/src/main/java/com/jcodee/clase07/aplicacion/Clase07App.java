package com.jcodee.clase07.aplicacion;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by johannfjs on 7/02/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class Clase07App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        //Fresco    Picasso     Glide

        //Inicializamos la librería de FrescoLib
        Fresco.initialize(getApplicationContext());

        //Tener otras funcionalidades ...
    }
}
