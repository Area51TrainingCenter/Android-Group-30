package pe.area51.clase2.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.OnClick;
import pe.area51.clase2.R;
import pe.area51.clase2.database.SentenciaSQL;
import pe.area51.clase2.entidades.UsuarioEntidad;

public class MainActivity extends BaseActivity {

    @BindView(R.id.etCorreo)
    EditText etCorreo;
    @BindView(R.id.etContrasenia)
    EditText etContrasenia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @OnClick({R.id.btnLogin, R.id.btnRegistrar})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnLogin:

                String correo = etCorreo.getText().toString(),
                        contrasenia = etContrasenia.getText().toString();

                UsuarioEntidad usuarioEntidad = SentenciaSQL.validarUsuario(correo, contrasenia);
                if (usuarioEntidad != null) {
                    Intent intent = new Intent(MainActivity.this, RegistroMascotaActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "Usuario y/o contraseña no valido.", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.btnRegistrar:

                Intent intent = new Intent(MainActivity.this, RegistrarActivity.class);
                startActivity(intent);

                break;
        }
    }
}
