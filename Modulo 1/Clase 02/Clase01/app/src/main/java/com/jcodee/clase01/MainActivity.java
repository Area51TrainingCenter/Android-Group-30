package com.jcodee.clase01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    /*

    Ciclo de vida de un Activity

    onCreate = se ejecuta al momento que ustedes hacen clic
                en el icono de la aplicación
    onStart = carga variables o elementos que ayudan al desarrollo
                o que tienen que volverse a cargar cuando se levante
                la aplicación
              --------Hasta este punto, la aplicación no es visible----------
    onResume = la pantalla o actividad es visible para el usuario

    onPause = pausar la actividad
    onStop = detiene la actividad y es cerrada

    onRestart = carga la información que habían dejado antes de salir
                de la pantalla

    onDestroy = se quita la aplicación del segundo plano

     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Se define el diseño que irá vinculado a la clase JAVA
        setContentView(R.layout.activity_main);

        Log.d("EventosApp","onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d("EventosApp","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d("EventosApp","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d("EventosApp","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d("EventosApp","onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.d("EventosApp","onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d("EventosApp","onDestroy");
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
    }
}
