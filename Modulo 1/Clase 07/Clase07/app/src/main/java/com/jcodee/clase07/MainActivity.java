package com.jcodee.clase07;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

public class MainActivity extends AppCompatActivity {
    private SimpleDraweeView sdvImagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sdvImagen = (SimpleDraweeView) findViewById(R.id.sdvImagen);
    }

    @Override
    protected void onResume() {
        super.onResume();

        sdvImagen.setImageURI(
                Uri.parse("http://www.paisajesbonitos.org/wp-content/uploads/2015/11/paisajes-bonitos-de-oto%C3%B1o-lago.jpg"));

        //Acción de click a la imagen
        sdvImagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Pasar de la pantalla Main a Galeria
                /*
                Intent intent =
                        new Intent(MainActivity.this, GaleriaActivity.class);
                startActivity(intent);
                */
                startActivity(new Intent(MainActivity.this, GaleriaActivity.class));
                //Elimina la actividad del historial de activities abiertos
                finish();
            }
        });
    }
}
