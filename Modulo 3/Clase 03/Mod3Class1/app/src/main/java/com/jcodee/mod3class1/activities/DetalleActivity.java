package com.jcodee.mod3class1.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.jcodee.mod3class1.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetalleActivity extends BaseActivity {

    @BindView(R.id.tvNombre)
    TextView tvNombre;
    @BindView(R.id.tvUsuario)
    TextView tvUsuario;
    @BindView(R.id.tvCorreo)
    TextView tvCorreo;
    @BindView(R.id.tvDireccion)
    TextView tvDireccion;

    double latitud, longitud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        ButterKnife.bind(this);

        MapFragment mapFragment =
                (MapFragment) getFragmentManager().findFragmentById(R.id.map);

        if (getIntent() != null) {
            if (getIntent().hasExtra("nombre")) {
                String nombre = getIntent().getStringExtra("nombre");
                tvNombre.setText(nombre);
            }
            if (getIntent().hasExtra("usuario")) {
                String usuario = getIntent().getStringExtra("usuario");
                tvUsuario.setText(usuario);
            }
            if (getIntent().hasExtra("correo")) {
                String correo = getIntent().getStringExtra("correo");
                tvCorreo.setText(correo);
            }
            if (getIntent().hasExtra("direccion")) {
                String direccion = getIntent().getStringExtra("direccion");
                tvDireccion.setText(direccion);
            }
            if (getIntent().hasExtra("latitud")) {
                latitud = getIntent().getDoubleExtra("latitud", 0);
            }
            if (getIntent().hasExtra("longitud")) {
                longitud = getIntent().getDoubleExtra("longitud", 0);
            }
        }

        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {

                //Obtenemos la posición
                LatLng latLng = new LatLng(latitud, longitud);
                //Pintamos un marcador en el mapa
                googleMap.addMarker(new MarkerOptions()
                        .icon(BitmapDescriptorFactory.defaultMarker())
                        .position(latLng));
                //Movemos la camara del mapa hacia el punto que marcamos
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 12));

            }
        });
    }

    @OnClick(R.id.btnAlbums)
    public void onClick() {

        Intent intent=new Intent(DetalleActivity.this,AlbumActivity.class);
        startActivity(intent);

    }
}
