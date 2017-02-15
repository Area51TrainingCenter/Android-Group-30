package com.jcodee.clase08;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodee.clase08.modelos.Catalogo;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.spTipo)
    Spinner spTipo;
    @BindView(R.id.etNombre)
    EditText etNombre;
    @BindView(R.id.sdvImagen1)
    SimpleDraweeView sdvImagen1;
    @BindView(R.id.sdvImagen2)
    SimpleDraweeView sdvImagen2;
    @BindView(R.id.sdvImagen3)
    SimpleDraweeView sdvImagen3;
    @BindView(R.id.btnRegistrar)
    Button btnRegistrar;
    @BindView(R.id.btnVisualizar)
    Button btnVisualizar;
    @BindView(R.id.llImagen1)
    LinearLayout llImagen1;
    @BindView(R.id.llImagen2)
    LinearLayout llImagen2;
    @BindView(R.id.llImagen3)
    LinearLayout llImagen3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("TAG","onCreate, antes");
        setContentView(R.layout.activity_main);
        Log.d("TAG","onCreate, después");

        sdvImagen1.setTag(false);
        sdvImagen2.setTag(false);
        sdvImagen3.setTag(false);
    }

    @Override
    protected void onResume() {
        super.onResume();

        ArrayAdapter arrayAdapter = new ArrayAdapter(
                MainActivity.this,
                android.R.layout.simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.tipos));
        spTipo.setAdapter(arrayAdapter);
    }

    public static ArrayList<Catalogo> lista = new ArrayList<>();

    @OnClick({R.id.btnRegistrar, R.id.btnVisualizar,
            R.id.sdvImagen1, R.id.sdvImagen2, R.id.sdvImagen3})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnRegistrar:

                //Obtenemos el estado de las imagenes
                boolean foto1 = (boolean) sdvImagen1.getTag();
                boolean foto2 = (boolean) sdvImagen2.getTag();
                boolean foto3 = (boolean) sdvImagen3.getTag();

                //Validando los datos, que todo este ingresado
                if (!etNombre.getText().toString().equals("") &&
                        !spTipo.getSelectedItem().toString().equals("") &&
                        (foto1 || foto2 || foto3)) {

                    //Creamos un objeto que vamos a almacenar
                    Catalogo catalogo = new Catalogo();
                    catalogo.setId(lista.size());
                    catalogo.setNombre(etNombre.getText().toString());
                    catalogo.setTipo(spTipo.getSelectedItem().toString());

                    if (foto1) {
                        catalogo.setImagen("res:/" + R.drawable.instagram);
                    } else if (foto2) {
                        catalogo.setImagen("res:/" + R.drawable.twitter);
                    } else if (foto3) {
                        catalogo.setImagen("res:/" + R.drawable.facebook);
                    }
                    lista.add(catalogo);
                } else {
                    Toast.makeText(this, "Falta completar un dato.",
                            Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.btnVisualizar:

                Intent intent = new Intent(MainActivity.this, GaleriaActivity.class);
                startActivity(intent);

                break;
            case R.id.sdvImagen1:
                sdvImagen1.setTag(true);
                llImagen1.setBackgroundColor(
                        getResources().getColor(R.color.transparente));
                sdvImagen2.setTag(false);
                llImagen2.setBackgroundColor(0);
                sdvImagen3.setTag(false);
                llImagen3.setBackgroundColor(0);
                break;
            case R.id.sdvImagen2:
                sdvImagen1.setTag(false);
                llImagen1.setBackgroundColor(0);
                sdvImagen2.setTag(true);
                llImagen2.setBackgroundColor(
                        getResources().getColor(R.color.transparente));
                sdvImagen3.setTag(false);
                llImagen3.setBackgroundColor(0);
                break;
            case R.id.sdvImagen3:
                sdvImagen1.setTag(false);
                llImagen1.setBackgroundColor(0);
                sdvImagen2.setTag(false);
                llImagen2.setBackgroundColor(0);
                sdvImagen3.setTag(true);
                llImagen3.setBackgroundColor(
                        getResources().getColor(R.color.transparente));
                break;
        }
    }

}
