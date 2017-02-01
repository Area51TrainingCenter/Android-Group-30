package com.jcodee.mod1class5;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.jcodee.mod1class5.adapters.PersonaAdapter;

/**
 * Created by johannfjs on 26/01/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class DetalleActivity extends AppCompatActivity {
    private TextView dato;
    //Declaramos los datos necesarios para poder cargar la lista
    private ListView lvLista;
    private PersonaAdapter adapter;

    private Button btnVer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        dato = (TextView) findViewById(R.id.tvTexto);
        lvLista=(ListView)findViewById(R.id.lvLista);
        btnVer=(Button)findViewById(R.id.btnVer);

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

    @Override
    protected void onResume() {
        super.onResume();

        //Inicializamos el adapter, indicando el contexto de la aplicación y la lista
        adapter=new PersonaAdapter(DetalleActivity.this,MainActivity.LISTA);
        //Indicamos que la lista (listView) tome los valores que se estaran creando en el adapter
        lvLista.setAdapter(adapter);


        btnVer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(DetalleActivity.this,VerActivity.class);
                startActivity(intent);

            }
        });
    }
}
