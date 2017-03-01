package pe.area51.clase2.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import io.realm.RealmResults;
import pe.area51.clase2.R;
import pe.area51.clase2.database.SentenciaSQL;
import pe.area51.clase2.entidades.MascotaEntidad;
import pe.area51.clase2.entidades.UsuarioEntidad;

public class RegistroMascotaActivity extends BaseActivity {

    @BindView(R.id.btnLogout)
    ImageButton btnLogout;
    @BindView(R.id.spUsuario)
    Spinner spUsuario;
    @BindView(R.id.etNombreMascota)
    EditText etNombreMascota;
    @BindView(R.id.rbMacho)
    RadioButton rbMacho;
    @BindView(R.id.rbHembra)
    RadioButton rbHembra;
    @BindView(R.id.cbNotificaciones)
    CheckBox cbNotificaciones;
    RealmResults<UsuarioEntidad> usuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_mascota);

        usuarios = SentenciaSQL.obtenerUsuarios();
        ArrayList<String> listaUsuarios = new ArrayList<>();
        for (UsuarioEntidad usuarioEntidad : usuarios) {
            listaUsuarios.add(usuarioEntidad.getNombre());
        }

        ArrayAdapter arrayAdapter = new ArrayAdapter(RegistroMascotaActivity.this,
                android.R.layout.simple_spinner_dropdown_item,
                listaUsuarios);
        spUsuario.setAdapter(arrayAdapter);

    }

    @OnClick({R.id.btnRegistrar, R.id.btnMisMascotas})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnRegistrar:

                String usuario = spUsuario.getSelectedItem().toString();
                /* Se va a recorrer la lista de usuarios que se trajo de 
                 * la base de datos, va a consultar que el nombre que se obtiene
                  * desde el spinner sea igual a alguno de los registros que 
                  * se encuentra en el listado, para poder obtener el id */
                int idUsuario = 0;
                for (UsuarioEntidad item : usuarios) {
                    if (item.getNombre().equals(usuario)) {
                        idUsuario = item.getId();
                        break;
                    }
                }

                String nombreMascota = etNombreMascota.getText().toString();
                boolean genero = (
                        rbMacho.isChecked() ?
                                rbMacho.isChecked() :
                                rbHembra.isChecked()
                );
                boolean notificaciones = cbNotificaciones.isChecked();

                MascotaEntidad mascotaEntidad = new MascotaEntidad();
                mascotaEntidad.setId(SentenciaSQL.nextMascota());
                mascotaEntidad.setGenero(genero ? 1 : 0);
                mascotaEntidad.setNombreMascota(nombreMascota);
                mascotaEntidad.setNotificaciones(notificaciones);
                mascotaEntidad.setIdUsuario(idUsuario);
                //mascotaEntidad.setIdUsuario(SentenciaSQL.obtenerUsuarioPorNombre(usuario));
                boolean resultado = SentenciaSQL.insertarMascota(mascotaEntidad);
                if (resultado) {
                    Toast.makeText(this, "Se registro correctamente.",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Ocurrio un error.",
                            Toast.LENGTH_SHORT).show();
                }
                
                /*
                Con varias opciones
                boolean resultado = (
                        rbMacho.isChecked() ? rbMacho.isChecked() :
                                (rbHembra.isChecked() ?
                                        rbHembra.isChecked() :
                                        (rbMacho.isChecked()) ?
                                                rbMacho.isChecked() :
                                                rbHembra.isChecked())
                );
                IF normal
                boolean resultado = false;
                if (rbMacho.isChecked()) {
                    resultado = rbMacho.isChecked();
                } else if (rbHembra.isChecked()) {
                    resultado = rbHembra.isChecked();
                }
                */
                break;
            case R.id.btnMisMascotas:

                //Pasamos de la pantalla de Registro de Mascotas
                //al listado de mascotas por usuario logueado
                Intent intent = new Intent(
                        RegistroMascotaActivity.this,
                        ListadoActivity.class);
                String usua = spUsuario.getSelectedItem().toString();
                intent.putExtra("id", SentenciaSQL.obtenerUsuarioPorNombre(usua));
                intent.putExtra("usuario", usua);
                startActivity(intent);

                break;
        }
    }
}
