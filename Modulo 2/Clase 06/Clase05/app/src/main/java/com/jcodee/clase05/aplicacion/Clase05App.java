package com.jcodee.clase05.aplicacion;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by johannfjs on 28/02/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class Clase05App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(getApplicationContext());
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .schemaVersion(1)
                .name("clase05.realm")
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }
}
