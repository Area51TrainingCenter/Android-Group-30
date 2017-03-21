package com.jcodee.mod3class1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jcodee.mod3class1.activities.BaseActivity;
import com.jcodee.mod3class1.adapters.UsuarioAdapter;
import com.jcodee.mod3class1.modelos.Usuario;
import com.jcodee.mod3class1.rest.HelperWS;
import com.jcodee.mod3class1.rest.TypicodeWS;
import com.jcodee.mod3class1.rest.response.UsersResponse;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity {

    @BindView(R.id.rvDatos)
    RecyclerView rvDatos;

    private UsuarioAdapter adapter;
    private ArrayList<Usuario> lista = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();

        TypicodeWS typicodeWS = HelperWS.obtenerConfiguracion().create(TypicodeWS.class);
        Call<ArrayList<UsersResponse>> respuesta = typicodeWS.obtenerUsuarios();
        respuesta.enqueue(new Callback<ArrayList<UsersResponse>>() {
            @Override
            public void onResponse(Call<ArrayList<UsersResponse>> call, Response<ArrayList<UsersResponse>> response) {
                ArrayList<UsersResponse> usuarios = response.body();
                lista.clear();
                for (UsersResponse user : usuarios) {
                    Usuario usuario = new Usuario();
                    usuario.setId(user.getId());
                    usuario.setCorreo(user.getCorreo());
                    usuario.setUsuario(user.getUsuario());
                    lista.add(usuario);
                }

                adapter = new UsuarioAdapter(MainActivity.this, lista);
                rvDatos.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                rvDatos.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ArrayList<UsersResponse>> call, Throwable t) {

            }
        });
    }
}
