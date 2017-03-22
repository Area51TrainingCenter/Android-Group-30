package com.jcodee.mod3class1.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jcodee.mod3class1.R;
import com.jcodee.mod3class1.adapters.AlbumAdapter;
import com.jcodee.mod3class1.modelos.Album;
import com.jcodee.mod3class1.rest.HelperWS;
import com.jcodee.mod3class1.rest.TypicodeWS;
import com.jcodee.mod3class1.rest.response.AlbumResponse;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumActivity extends AppCompatActivity {

    @BindView(R.id.rvDatos)
    RecyclerView rvDatos;

    private ArrayList<Album> lista = new ArrayList<>();
    private AlbumAdapter albumAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        TypicodeWS typicodeWS = HelperWS.obtenerConfiguracion().create(TypicodeWS.class);
        Call<ArrayList<AlbumResponse>> respuesta = typicodeWS.obtenerAlbums();
        respuesta.enqueue(new Callback<ArrayList<AlbumResponse>>() {
            @Override
            public void onResponse(Call<ArrayList<AlbumResponse>> call, Response<ArrayList<AlbumResponse>> response) {
                ArrayList<AlbumResponse> listaAlbum = response.body();
                for (AlbumResponse item : listaAlbum) {
                    Album album = new Album();
                    album.setId(item.getId());
                    album.setDescripcion(item.getTitle());
                    lista.add(album);
                }
                albumAdapter = new AlbumAdapter(AlbumActivity.this, lista);
                rvDatos.setLayoutManager(new LinearLayoutManager(AlbumActivity.this));
                rvDatos.setAdapter(albumAdapter);
            }

            @Override
            public void onFailure(Call<ArrayList<AlbumResponse>> call, Throwable t) {

            }
        });
    }
}
