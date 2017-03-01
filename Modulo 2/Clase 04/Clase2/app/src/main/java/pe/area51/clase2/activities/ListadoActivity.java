package pe.area51.clase2.activities;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
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

    String usuario;
    int idUsuario;
    @BindView(R.id.rvLista)
    RecyclerView rvLista;

    private MascotaAdapter mascotaAdapter;

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

    private RealmResults<MascotaEntidad> mascotas;

    @Override
    protected void onResume() {
        super.onResume();

        mascotas = SentenciaSQL.obtenerMascotas("", idUsuario);

        mascotaAdapter = new MascotaAdapter(ListadoActivity.this, mascotas);
        rvLista.setLayoutManager(new LinearLayoutManager(ListadoActivity.this));
        rvLista.setAdapter(mascotaAdapter);


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
                mascotas = SentenciaSQL.obtenerMascotas(nombreMascota, idUsuario);
                //Informa al adapter que ha habido un cambio en la estructura
                //mascotaAdapter.notifyDataSetChanged();

                mascotaAdapter = new MascotaAdapter(ListadoActivity.this, mascotas);
                rvLista.setLayoutManager(new LinearLayoutManager(ListadoActivity.this));
                rvLista.setAdapter(mascotaAdapter);
            }
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();


    }
}
