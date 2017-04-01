package com.jcodee.mod3class5;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

/**
 * Created by johannfjs on 28/03/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class AsyntaskCustom extends AsyncTask<String, Void, String> {

    Context context;
    ProgressDialog progressDialog;

    public AsyntaskCustom(Context context) {
        this.context = context;
        progressDialog=new ProgressDialog(context);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        progressDialog.setMessage("Cargando");
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    @Override
    protected String doInBackground(String... params) {
        //Proceso a realizar
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        progressDialog.dismiss();

    }
}
