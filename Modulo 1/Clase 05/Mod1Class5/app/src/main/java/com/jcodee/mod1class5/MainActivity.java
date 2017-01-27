package com.jcodee.mod1class5;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    private Spinner estadoCivil;
    private EditText nombres;
    private RadioButton masculino, femenino;
    private CheckBox terminos;
    private Button procesar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Vinculamos las variables con nuestro diseño
        estadoCivil = (Spinner) findViewById(R.id.spEstadoCivil);
        nombres = (EditText) findViewById(R.id.etNombres);
        masculino = (RadioButton) findViewById(R.id.rbMasculino);
        femenino = (RadioButton) findViewById(R.id.rbFemenino);
        terminos = (CheckBox) findViewById(R.id.cbTerminos);
        procesar = (Button) findViewById(R.id.btnProcesar);
    }

    @Override
    protected void onResume() {
        super.onResume();

        procesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String estadoCivilValor =
                        estadoCivil.getSelectedItem().toString();
                String nombreValor =
                        nombres.getText().toString();
                String genero = "";
                if (masculino.isChecked()) {
                    genero = "Masculino";
                } else if (femenino.isChecked()) {
                    genero = "Femenino";
                }
                boolean terminoValor = terminos.isChecked();

                //Validamos que los datos esten cargados
                if (estadoCivilValor.length() > 0 &&
                        nombreValor.length() > 0 &&
                        genero.length() > 0 &&
                        terminoValor) {

                    //Pasamos de la pantalla de MainActivity al Detalle Activity
                    Intent intent =
                            new Intent(MainActivity.this, DetalleActivity.class);

                    //Envio de parametros o datos
                    intent.putExtra("estado_civil", estadoCivilValor);

                    Bundle bundle = new Bundle();
                    bundle.putString("nombres", nombreValor);
                    bundle.putString("genero", genero);
                    intent.putExtras(bundle);

                    startActivity(intent);
                    //Elimina la pantalla o activity actual del historial
                    finish();

                } else {

                    //Mostramos un mensaje
                    AlertDialog.Builder dialog =
                            new AlertDialog.Builder(MainActivity.this);
                    //Cambiamos el texto del titulo
                    dialog.setTitle("Alerta");
                    //Indicamos que el dialogo no se pueda cerrar, a menos que seleccione
                    //una opción
                    dialog.setCancelable(false);
                    //Indicamos el texto del mensaje que se pondrá
                    dialog.setMessage("No se obtuvo los datos correctamente");
                    //Editamos la configuración del boton positivo, también
                    //al editar, se va a mostrar el boton
                    dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //Cerramos el dialogo
                            dialog.dismiss();
                        }
                    });
                    //Se crea y construye el dialogo
                    dialog.create().show();

                }

            }
        });
    }
}
