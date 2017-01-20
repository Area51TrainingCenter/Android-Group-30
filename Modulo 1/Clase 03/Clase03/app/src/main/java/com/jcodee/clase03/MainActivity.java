package com.jcodee.clase03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText texto;
    private Button procesar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        texto = (EditText) findViewById(R.id.etTexto);
        procesar = (Button) findViewById(R.id.btnProcesar);
    }

    @Override
    protected void onResume() {
        super.onResume();

        procesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Obtenemos el dato que se ingreso en el EditText
                String valor = texto.getText().toString();

                //Mostramos un mensaje flotante con el valor
                // que se obtuvo en el EditText
                Toast.makeText(MainActivity.this,
                        "Hola que tal? " + valor,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}

/*

Verificar si hay cambios
git status
Se agrega los archivos al paquete para subir
git add .
Se agrega el paquete de archivos a subir
git commit -m "Comentario"
Sube al repositorio remoto
git push origin master

 */
