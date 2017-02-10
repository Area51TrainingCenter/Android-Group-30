package com.jcodee.clase07;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.jcodee.clase07.adapters.GaleriaAdapter;
import com.jcodee.clase07.modelos.Foto;

import java.util.ArrayList;

/**
 * Created by johannfjs on 7/02/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class GaleriaActivity extends AppCompatActivity {
    private GridView gvDatos;
    private GaleriaAdapter adapter;
    private ArrayList<Foto> lista;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galeria);

        gvDatos = (GridView) findViewById(R.id.gvDatos);

    }

    @Override
    protected void onResume() {
        super.onResume();

        //Iniciamos la lista
        lista = new ArrayList<>();

        //Agregamos fotos
        Foto foto1 = new Foto();
        foto1.setId(1);
        foto1.setNombre("Paisaje");
        foto1.setRuta("https://i.stack.imgur.com/TdLCr.png");
        lista.add(foto1);

        for (int i = 0; i < 20; i++) {
            Foto foto2 = new Foto();
            foto2.setId(2 + i);
            foto2.setNombre("Paisaje " + i);
            foto2.setRuta("res:/" + R.drawable.template);
            lista.add(foto2);
        }

        //Agregamos la lista al adapter y lo reflejamos en el gridView
        adapter = new GaleriaAdapter(GaleriaActivity.this, lista);
        gvDatos.setAdapter(adapter);

        //Seleccionar un elemento y obtener los datos
        gvDatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Foto foto = lista.get(position);
                /*Toast.makeText(GaleriaActivity.this,
                        "Nombre->" + foto.getNombre(),
                        Toast.LENGTH_SHORT).show();*/
                Intent intent = new Intent(GaleriaActivity.this, DetalleActivity.class);
                intent.putExtra("ruta", foto.getRuta());
                intent.putExtra("nombre", foto.getNombre());
                startActivity(intent);
            }
        });
    }
}
