package com.jcodee.mod3class1.activities;

import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by johannfjs on 14/03/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);

        ButterKnife.bind(this);
    }
}


/*
*
* JsonObject -> {} -> Objeto en Java
* JsonArray -> [] -> Lista de Objetos en Java -> ArrayList
*
* */
