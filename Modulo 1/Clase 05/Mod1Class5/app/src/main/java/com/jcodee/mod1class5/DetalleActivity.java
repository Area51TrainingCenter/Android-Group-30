package com.jcodee.mod1class5;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.widget.TextView;

/**
 * Created by johannfjs on 26/01/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class DetalleActivity extends AppCompatActivity {
    private TextView dato;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        dato = (TextView) findViewById(R.id.tvTexto);

        //Validamos que se esten enviando datos a través del intent
        if (getIntent() != null) {
            //Creamos una variable de tipo string para mantener los datos
            String texto = "";
            //Validamos que en el intent se este pasando el dato de
            //estado_civil
            if (getIntent().hasExtra("estado_civil")) {
                //Obtenemos el dato de estado_civil
                String estadoCivil =
                        getIntent().getStringExtra("estado_civil");
                //Agregamos el estado_civil a nuestra variable texto
                texto += estadoCivil;
            }
            //Consultamos que el bundle tenga datos
            Bundle bundle = getIntent().getExtras();
            if (bundle != null) {
                //Validamos que en el bundle se este pasando el dato del
                //key nombres
                if (bundle.containsKey("nombres")) {
                    //Obtenemos el dato de nombres
                    String nombres = bundle.getString("nombres");
                    //Agregamos nombres a nuestra variable texto
                    texto += "<br/>" + nombres;
                }
                //Validamos que en el bundle se este pasando el dato del
                //key genero
                if (bundle.containsKey("genero")) {
                    //Obtenemos el dato de genero
                    String genero = bundle.getString("genero");
                    //Agregamos genero a nuestra variable texto
                    texto += "<br/>" + genero;
                }
            }
            //Enviamos el texto obtenido al TextView
            dato.setText(Html.fromHtml(texto));
        }
    }
}
