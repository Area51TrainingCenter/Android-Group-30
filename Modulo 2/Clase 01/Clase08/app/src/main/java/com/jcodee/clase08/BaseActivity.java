package com.jcodee.clase08;

import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import butterknife.ButterKnife;

/**
 * Created by johannfjs on 14/02/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class BaseActivity extends AppCompatActivity {
    public String datos;

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        //Cargamos el butterKnife después de cargar el diseño
        ButterKnife.bind(this);
        Log.d("TAG", "setContentView");
    }
}
