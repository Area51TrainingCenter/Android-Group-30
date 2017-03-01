package pe.area51.clase2.aplicacion;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by alumno on 2/16/17.
 */

public class Clase2App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(getApplicationContext());
        RealmConfiguration realmConfiguration =
                new RealmConfiguration.Builder()
                        .name("clase2.realm")
                        .schemaVersion(1)
                        /*
                        .initialData(new Realm.Transaction() {
                            @Override
                            public void execute(Realm realm) {

                            }
                        })
                        */
                        .build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }
}
