package com.jcodee.mod2class7;

import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by johannfjs on 7/03/17.
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
