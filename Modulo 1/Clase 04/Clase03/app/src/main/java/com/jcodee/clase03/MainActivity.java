package com.jcodee.clase03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText texto, nombre, apellido;
    private Button procesar, siguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        texto = (EditText) findViewById(R.id.etTexto);
        procesar = (Button) findViewById(R.id.btnProcesar);
        siguiente = (Button) findViewById(R.id.btnSiguiente);
        nombre = (EditText) findViewById(R.id.etNombre);
        apellido = (EditText) findViewById(R.id.etApellido);
    }

    @Override
    protected void onStart() {
        super.onStart();

        //texto.setText("OnStart");
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
                /*
                Toast.makeText(MainActivity.this,
                        "Hola que tal? " + valor,
                        Toast.LENGTH_SHORT).show();*/
                //Primero configuramos el mensaje a mostrar
                Toast toast = Toast.makeText(
                        MainActivity.this,
                        valor,
                        Toast.LENGTH_SHORT);
                //Cambiamos la ubicación en la cual se mostrará
                toast.setGravity(Gravity.CENTER, 0, 0);
                //Le indicamos que se muestre el mensaje
                toast.show();
            }
        });

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Obtenemos los datos de la caja de texto
                String textoNombre = nombre.getText().toString(),
                        textoApellido = apellido.getText().toString();

                //Pasamos a la siguiente pantalla
                Intent intent = new Intent(MainActivity.this,
                        SiguienteActivity.class);

                //Enviar información a través del intent
                intent.putExtra("nombre", textoNombre);
                intent.putExtra("apellido", textoApellido);

                //Indicamos a la aplicación que ejecute el cambio
                //de pantalla
                startActivity(intent);
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
