package com.jcodee.clase05;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.Toast;

import com.jcodee.clase05.activities.BaseActivity;
import com.jcodee.clase05.adapters.PosicionAdapter;
import com.jcodee.clase05.database.SentenciaSQL;
import com.jcodee.clase05.entidades.Posicion;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.etTitulo)
    EditText etTitulo;
    @BindView(R.id.tilTitulo)
    TextInputLayout tilTitulo;
    @BindView(R.id.etDescripcion)
    EditText etDescripcion;
    @BindView(R.id.tilDescripcion)
    TextInputLayout tilDescripcion;
    @BindView(R.id.etLatitud)
    EditText etLatitud;
    @BindView(R.id.tilLatitud)
    TextInputLayout tilLatitud;
    @BindView(R.id.etLongitud)
    EditText etLongitud;
    @BindView(R.id.tilLongitud)
    TextInputLayout tilLongitud;
    @BindView(R.id.rvPosiciones)
    RecyclerView rvPosiciones;

    private PosicionAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @OnClick(R.id.btnRegistrar)
    public void onClick() {

        String titulo = etTitulo.getText().toString();
        if (titulo.trim().length() > 0) {
            tilTitulo.setError(null);
        } else {
            tilTitulo.setError("El campo es requerido.");
            return;
        }

        String descripcion = etDescripcion.getText().toString();
        if (descripcion.trim().length() > 0) {
            tilDescripcion.setError(null);
        } else {
            tilDescripcion.setError("El campo es requerido");
            return;
        }

        String latitud = etLatitud.getText().toString();
        if (latitud.trim().length() > 0) {
            tilLatitud.setError(null);
        } else {
            tilLatitud.setError("El campo es requerido");
            return;
        }

        String longitud = etLongitud.getText().toString();
        if (longitud.trim().length() > 0) {
            tilLongitud.setError(null);
        } else {
            tilLongitud.setError("El campo es requerido");
            return;
        }

        Posicion posicion = new Posicion();
        posicion.setId(SentenciaSQL.getNextPosicion());
        posicion.setTitulo(etTitulo.getText().toString());
        posicion.setDescripcion(etDescripcion.getText().toString());
        posicion.setLatitud(Double.parseDouble(etLatitud.getText().toString()));
        posicion.setLongitud(Double.parseDouble(etLongitud.getText().toString()));
        boolean resultado = SentenciaSQL.insertarPosicion(posicion);
        if (resultado) {
            Toast.makeText(this, "Se registro correctamente", Toast.LENGTH_SHORT).show();
            adapter.notifyDataSetChanged();
            /*
            adapter = new PosicionAdapter(MainActivity.this, SentenciaSQL.getPosiciones());
            rvPosiciones.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            rvPosiciones.setAdapter(adapter);
            */
        } else {
            Toast.makeText(this, "Ocurrio un error", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        adapter = new PosicionAdapter(MainActivity.this, SentenciaSQL.getPosiciones());
        rvPosiciones.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        rvPosiciones.setAdapter(adapter);
    }
}
