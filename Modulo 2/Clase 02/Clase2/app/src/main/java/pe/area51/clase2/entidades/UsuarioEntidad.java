package pe.area51.clase2.entidades;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by alumno on 2/16/17.
 */

public class UsuarioEntidad extends RealmObject {
    @PrimaryKey
    private int id;
    private String correo;
    private String contrasenia;
    private String nombre;
    private boolean sesion;

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isSesion() {
        return sesion;
    }

    public void setSesion(boolean sesion) {
        this.sesion = sesion;
    }
}
