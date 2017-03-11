package com.jcodee.mod2class8;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.etNombre)
    EditText etNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnEmpezar)
    public void onClick() {

        String nombre = etNombre.getText().toString();

        SharedPreferences.Editor editor =
                getSharedPreferences("class8", Context.MODE_PRIVATE).edit();
        editor.putString("nombre", nombre);
        editor.apply();

        Intent intent = new Intent(MainActivity.this, MenuActivity.class);
        startActivity(intent);

        SharedPreferences sharedPreferences =
                getSharedPreferences("class8", Context.MODE_PRIVATE);
        Toast.makeText(this, "Nombre->" +
                sharedPreferences.getString("nombre", ""), Toast.LENGTH_SHORT).show();

    }
}
