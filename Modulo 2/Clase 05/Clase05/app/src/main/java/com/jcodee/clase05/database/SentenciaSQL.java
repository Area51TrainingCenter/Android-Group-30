package com.jcodee.clase05.database;

import com.jcodee.clase05.entidades.Posicion;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by johannfjs on 28/02/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class SentenciaSQL {
    public static int getNextPosicion() {
        Realm realm = Realm.getDefaultInstance();
        long cantidad = realm.where(Posicion.class).count();
        return (int) cantidad + 1;
    }

    public static boolean insertarPosicion(Posicion posicion) {
        boolean resultado = false;
        Realm realm = Realm.getDefaultInstance();
        try {
            realm.beginTransaction();

            realm.copyToRealm(posicion);

            realm.commitTransaction();
            resultado = true;
        } catch (Exception e) {
            realm.cancelTransaction();
        }
        return resultado;
    }

    public static RealmResults<Posicion> getPosiciones() {
        Realm realm = Realm.getDefaultInstance();
        return realm.where(Posicion.class).findAll();
    }
}
