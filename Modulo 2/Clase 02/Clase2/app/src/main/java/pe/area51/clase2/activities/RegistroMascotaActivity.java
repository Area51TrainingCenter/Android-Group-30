package pe.area51.clase2.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Spinner;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import io.realm.RealmResults;
import pe.area51.clase2.R;
import pe.area51.clase2.database.SentenciaSQL;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_mascota);

        RealmResults<UsuarioEntidad> usuarios= SentenciaSQL.obtenerUsuarios();
        ArrayList<String> listaUsuarios=new ArrayList<>();
        for(UsuarioEntidad usuarioEntidad:usuarios){
            listaUsuarios.add(usuarioEntidad.getNombre());
        }

        ArrayAdapter arrayAdapter=new ArrayAdapter(RegistroMascotaActivity.this,
                android.R.layout.simple_spinner_dropdown_item,
                listaUsuarios);
        spUsuario.setAdapter(arrayAdapter);

    }

    @OnClick({R.id.btnRegistrar, R.id.btnMisMascotas})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnRegistrar:
                break;
            case R.id.btnMisMascotas:
                break;
        }
    }
}
