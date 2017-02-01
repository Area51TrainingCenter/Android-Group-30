package com.jcodee.mod1class5;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;

/**
 * Created by alumno on 1/31/17.
 */
public class VerActivity extends AppCompatActivity {
    private Spinner spDeportes;
    private SimpleDraweeView sdvImagen;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ver);

        spDeportes = (Spinner) findViewById(R.id.spDeportes);
        sdvImagen = (SimpleDraweeView) findViewById(R.id.sdvImagen);

        sdvImagen.setTag(true);
    }

    @Override
    protected void onResume() {
        super.onResume();

        //Creamos donde se agregaran los datos
        ArrayList<String> listaDeportes = new ArrayList<>();
        //Agregamos los datos
        listaDeportes.add("Fútbol");
        listaDeportes.add("Volley");
        listaDeportes.add("Basketball");
        listaDeportes.add("Natación");
        //Agregamos las fechas desde el 2010 al 2017
        for (int i = 2010; i <= 2017; i++) {
            listaDeportes.add(String.valueOf(i));
        }

        //Creamos un ArrayAdapter para cargar la estructura de los datos que tendrá
        // el spinner
        ArrayAdapter arrayAdapter = new ArrayAdapter(
                VerActivity.this,
                android.R.layout.simple_spinner_dropdown_item,
                listaDeportes);
        //Le decimos al spinner que cambie la estructura a mostrar
        spDeportes.setAdapter(arrayAdapter);

        if((boolean)sdvImagen.getTag()) {
            sdvImagen.setImageURI(Uri.parse("res:/" + R.drawable.male));
        }else{
            sdvImagen.setImageURI(Uri.parse("res:/" + R.drawable.female));
        }

        sdvImagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((boolean)sdvImagen.getTag()) {
                    sdvImagen.setTag(false);
                    sdvImagen.setImageURI(Uri.parse("res:/" + R.drawable.female));
                }else{
                    sdvImagen.setTag(true);
                    sdvImagen.setImageURI(Uri.parse("res:/" + R.drawable.male));
                }
            }
        });
    }
}
