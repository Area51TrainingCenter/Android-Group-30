package com.jcodee.mod2class7;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.renderscript.Double2;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.jcodee.mod2class7.services.GPSTracker;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.etLatitud)
    EditText etLatitud;
    @BindView(R.id.etLongitud)
    EditText etLongitud;
    @BindView(R.id.tvUbicacion)
    TextView tvUbicacion;

    MapFragment mapa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapa = (MapFragment) getFragmentManager().findFragmentById(R.id.mapa);
    }

    @OnClick({R.id.btnBuscar, R.id.btnObtener})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnBuscar:

                //Obtenemos los datos de las cajas de texto
                String latitud = etLatitud.getText().toString();
                String longitud = etLongitud.getText().toString();

                //Obtenemos los valores en tipo double
                final double valorLatitud = Double.parseDouble(latitud);
                final double valorLongitud = Double.parseDouble(longitud);

                Geocoder geocoder = new Geocoder(MainActivity.this);
                try {
                    List<Address> result = geocoder.getFromLocation(valorLatitud, valorLongitud, 1);

                    if (result != null && result.size() > 0) {
                        Address address = result.get(0);
                        if (address.getAddressLine(0) != null) {
                            final String direccion = address.getAddressLine(0);
                            tvUbicacion.setText(direccion);

                            mapa.getMapAsync(new OnMapReadyCallback() {
                                @Override
                                public void onMapReady(GoogleMap googleMap) {
                                    googleMap.addMarker(
                                            new MarkerOptions()
                                                    .icon(BitmapDescriptorFactory.defaultMarker())
                                                    .position(new LatLng(valorLatitud, valorLongitud))
                                                    .title(direccion));
                                    googleMap.animateCamera(
                                            CameraUpdateFactory.newLatLng(
                                                    new LatLng(valorLatitud, valorLongitud)));
                                }
                            });
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                break;
            case R.id.btnObtener:

                GPSTracker gpsTracker = new GPSTracker(MainActivity.this);

                if (gpsTracker.canGetLocation()) {
                    double latitudGPS = gpsTracker.getLatitude();
                    double longitudGPS = gpsTracker.getLongitude();

                    etLatitud.setText(String.valueOf(latitudGPS));
                    etLongitud.setText(String.valueOf(longitudGPS));
                } else {
                    gpsTracker.showSettingsAlert();
                }

                break;
        }
    }

}
