package com.jcodee.mod3class4_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.jcodee.mod3class4_2.rest.GeocodeWS;
import com.jcodee.mod3class4_2.rest.HelperWS;
import com.jcodee.mod3class4_2.rest.response.GeocodeResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private TextView tvRestultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvRestultado = (TextView) findViewById(R.id.tvResultado);
    }

    @Override
    protected void onResume() {
        super.onResume();

        GeocodeWS geocodeWS = HelperWS.getConfiguracion().create(GeocodeWS.class);
        Call<GeocodeResponse> respuesta = geocodeWS.obtenerLugar(
                "1600+Amphitheatre+Parkway,+Mountain+View,+CA",
                "AIzaSyCykvdeyahGdyDjxd-4jdMFFvLTM4gbhQ4");
        respuesta.enqueue(new Callback<GeocodeResponse>() {
            @Override
            public void onResponse(Call<GeocodeResponse> call, Response<GeocodeResponse> response) {
                GeocodeResponse body = response.body();
                tvRestultado.setText(body.getStatus());
            }

            @Override
            public void onFailure(Call<GeocodeResponse> call, Throwable t) {

            }
        });
    }
}
