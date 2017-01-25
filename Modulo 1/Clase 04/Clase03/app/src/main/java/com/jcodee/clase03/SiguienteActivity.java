package com.jcodee.clase03;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.widget.TextView;

/**
 * Created by johannfjs on 24/01/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class SiguienteActivity extends AppCompatActivity {
    private TextView texto;

    //Al momento de seleccionar el método onCreate, seleccionamos
    //el que solicite un parametro que es el Bundle
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Asignamos el diseño al activity
        setContentView(R.layout.activity_siguiente);

        texto = (TextView) findViewById(R.id.tvTexto);
    }

    @Override
    protected void onResume() {
        super.onResume();

        String nombre = getIntent().getStringExtra("nombre");
        String apellido = getIntent().getStringExtra("apellido");

        texto.setText(
                Html.fromHtml
                        ("<b>" + nombre + "</b> " + apellido)
        );
    }
}
