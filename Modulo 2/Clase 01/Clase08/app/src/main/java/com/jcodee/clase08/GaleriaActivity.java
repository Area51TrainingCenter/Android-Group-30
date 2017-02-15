package com.jcodee.clase08;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;

import com.jcodee.clase08.adapters.GaleriaAdapter;
import com.jcodee.clase08.modelos.Catalogo;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GaleriaActivity extends BaseActivity {
    @BindView(R.id.spTipo)
    Spinner spTipo;
    @BindView(R.id.gvDatos)
    GridView gvDatos;
    private GaleriaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galeria);
    }

    @Override
    protected void onResume() {
        super.onResume();

        ArrayAdapter arrayAdapter = new ArrayAdapter(
                GaleriaActivity.this,
                android.R.layout.simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.tipos));
        spTipo.setAdapter(arrayAdapter);

        adapter = new GaleriaAdapter(
                GaleriaActivity.this, MainActivity.lista);
        gvDatos.setAdapter(adapter);

        spTipo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ArrayList<Catalogo> listaTemp = new ArrayList<Catalogo>();
                for (Catalogo item : MainActivity.lista) {
                    if (item.getTipo().equals(spTipo.getSelectedItem().toString())) {
                        listaTemp.add(item);
                    }
                }
                adapter = new GaleriaAdapter(
                        GaleriaActivity.this, listaTemp);
                gvDatos.setAdapter(adapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        gvDatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(GaleriaActivity.this, AlbumActivity.class);

                Bundle bundle = new Bundle();
                bundle.putInt("posicion", position);
                intent.putExtras(bundle);

                //intent.putExtra("posicion", position);
                startActivity(intent);
            }
        });
    }
}
