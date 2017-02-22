package pe.area51.clase2.activities;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.RealmResults;
import pe.area51.clase2.R;
import pe.area51.clase2.adapters.MascotaAdapter;
import pe.area51.clase2.database.SentenciaSQL;
import pe.area51.clase2.entidades.MascotaEntidad;

public class ListadoActivity extends BaseActivity {

    @BindView(R.id.tvUsuario)
    TextView tvUsuario;
    @BindView(R.id.etNombreMascota)
    EditText etNombreMascota;
    @BindView(R.id.lvLista)
    ListView lvLista;

    String usuario;
    int idUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        if (getIntent() != null) {
            usuario = getIntent().getStringExtra("usuario");
            idUsuario = getIntent().getIntExtra("id", 0);

            tvUsuario.setText(usuario);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        etNombreMascota.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String nombreMascota = etNombreMascota.getText().toString();
                RealmResults<MascotaEntidad> mascotas =
                        SentenciaSQL.obtenerMascotas(nombreMascota, idUsuario);
                MascotaAdapter mascotaAdapter = new MascotaAdapter(ListadoActivity.this, mascotas);
                lvLista.setAdapter(mascotaAdapter);
            }
        });
    }
}
