package com.jcodee.mod1class5.aplicacion;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by alumno on 1/31/17.
 */
public class Mod1Class6App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        //Al momento de inicializar la aplicación se cargara la siguiente configuración
        Fresco.initialize(getApplicationContext());
    }
}
