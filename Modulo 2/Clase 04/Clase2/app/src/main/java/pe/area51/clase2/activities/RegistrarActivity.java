package pe.area51.clase2.activities;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.OnClick;
import pe.area51.clase2.R;
import pe.area51.clase2.database.SentenciaSQL;
import pe.area51.clase2.entidades.UsuarioEntidad;

public class RegistrarActivity extends BaseActivity {

    @BindView(R.id.etNombre)
    EditText etNombre;
    @BindView(R.id.etCorreo)
    EditText etCorreo;
    @BindView(R.id.etContrasenia)
    EditText etContrasenia;
    @BindView(R.id.etRepContrasenia)
    EditText etRepContrasenia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
    }

    @OnClick(R.id.btnRegistrar)
    public void onClick() {
        String nombre = etNombre.getText().toString(),
                correo = etCorreo.getText().toString(),
                contrasenia = etContrasenia.getText().toString(),
                repContrasenia = etRepContrasenia.getText().toString();

        if(contrasenia.equals(repContrasenia)) {
            UsuarioEntidad usuarioEntidad = new UsuarioEntidad();
            usuarioEntidad.setId(SentenciaSQL.nextUsuario());
            usuarioEntidad.setNombre(nombre);
            usuarioEntidad.setCorreo(correo);
            usuarioEntidad.setContrasenia(contrasenia);

            boolean resultado = SentenciaSQL.insertarUsuario(usuarioEntidad);
            if (resultado) {
                Toast.makeText(this, "Se guardo correctamente", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "No se guardo", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Contraseñas no coinciden", Toast.LENGTH_SHORT).show();
        }
    }
}
