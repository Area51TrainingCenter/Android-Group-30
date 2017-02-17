package pe.area51.clase2.entidades;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by alumno on 2/16/17.
 */

public class MascotaEntidad extends RealmObject {
    @PrimaryKey
    private int id;
    private int idUsuario;
    private String nombreMascota;
    private int genero;
    private boolean notificaciones;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

    public boolean isNotificaciones() {
        return notificaciones;
    }

    public void setNotificaciones(boolean notificaciones) {
        this.notificaciones = notificaciones;
    }
}
