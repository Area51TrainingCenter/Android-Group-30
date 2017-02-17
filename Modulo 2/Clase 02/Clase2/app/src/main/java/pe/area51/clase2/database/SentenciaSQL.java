package pe.area51.clase2.database;

import io.realm.Case;
import io.realm.Realm;
import io.realm.RealmResults;
import pe.area51.clase2.entidades.MascotaEntidad;
import pe.area51.clase2.entidades.UsuarioEntidad;

/**
 * Created by alumno on 2/16/17.
 */

public class SentenciaSQL {
    public static int nextUsuario() {
        Realm realm = Realm.getDefaultInstance();

        long cantidad = realm.where(UsuarioEntidad.class)
                .count();
        return ((int) cantidad + 1);
    }

    public static boolean insertarUsuario(UsuarioEntidad usuarioEntidad) {
        boolean result = false;

        //Obtenemos la referencia de la base de datos
        Realm realm = Realm.getDefaultInstance();
        try {
            //Creando una transaccion
            realm.beginTransaction();

            //Insert a base de datos
            realm.copyToRealm(usuarioEntidad);

            //Se guarda en base de datos
            realm.commitTransaction();
            result = true;
        } catch (Exception e) {
            //Realiza un rollback
            realm.cancelTransaction();
        }

        return result;
    }

    public static UsuarioEntidad validarUsuario(String correo, String contrasenia) {
        Realm realm = Realm.getDefaultInstance();
        return realm.where(UsuarioEntidad.class)
                .equalTo("correo", correo)
                .equalTo("contrasenia", contrasenia)
                .findFirst();
    }

    public static RealmResults<UsuarioEntidad> obtenerUsuarios() {
        Realm realm = Realm.getDefaultInstance();
        return realm.where(UsuarioEntidad.class)
                .findAll();
    }

    public static boolean insertarMascota(MascotaEntidad mascotaEntidad) {
        boolean result = false;

        //Obtenemos la referencia de la base de datos
        Realm realm = Realm.getDefaultInstance();
        try {
            //Creando una transaccion
            realm.beginTransaction();

            //Insert a base de datos
            realm.copyToRealm(mascotaEntidad);

            //Se guarda en base de datos
            realm.commitTransaction();
            result = true;
        } catch (Exception e) {
            //Realiza un rollback
            realm.cancelTransaction();
        }

        return result;
    }


    public static RealmResults<MascotaEntidad> obtenerMascotas(String nombreMascota) {
        Realm realm = Realm.getDefaultInstance();
        return realm.where(MascotaEntidad.class)
                .contains("nombreMascota", nombreMascota, Case.INSENSITIVE)
                .findAll();
    }
}
