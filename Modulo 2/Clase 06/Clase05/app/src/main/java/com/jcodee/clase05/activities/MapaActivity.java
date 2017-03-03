package com.jcodee.clase05.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.jcodee.clase05.R;

//https://developers.google.com/maps/documentation/android-api/intro
public class MapaActivity extends AppCompatActivity {
    MapFragment mapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);

        mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
    }

    @Override
    protected void onResume() {
        super.onResume();

        //Aqui stamos iniciando el mapa (todo referente al mapa se puede ver aqui)
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {

                double latitud = getIntent().getDoubleExtra("latitud", 0);
                double longitud = getIntent().getDoubleExtra("longitud", 0);
                String titulo = getIntent().getStringExtra("titulo");
                String descripcion = getIntent().getStringExtra("descripcion");

                LatLng latLng = new LatLng(latitud, longitud);

                //Agregamos un pin al mapa
                googleMap.addMarker(
                        new MarkerOptions()
                                .icon(BitmapDescriptorFactory.defaultMarker())
                                .position(latLng)
                                .snippet(descripcion)
                                .title(titulo)
                );

                //googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                //googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10));
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10));

            }
        });
    }
}
