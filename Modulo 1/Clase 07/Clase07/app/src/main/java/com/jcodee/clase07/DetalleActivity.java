package com.jcodee.clase07;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import org.w3c.dom.Text;

public class DetalleActivity extends AppCompatActivity {
    private SimpleDraweeView sdvImagen;
    private TextView tvTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        sdvImagen = (SimpleDraweeView) findViewById(R.id.sdvImagen);
        tvTexto = (TextView) findViewById(R.id.tvTexto);
    }

    @Override
    protected void onResume() {
        super.onResume();

        String nombre = getIntent().getStringExtra("nombre"),
                ruta = getIntent().getStringExtra("ruta");
        sdvImagen.setImageURI(Uri.parse(ruta));
        tvTexto.setText(nombre);
    }
}
