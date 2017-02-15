package com.jcodee.clase08.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.jcodee.clase08.fragments.FotoFragment;
import com.jcodee.clase08.modelos.Catalogo;

import java.util.ArrayList;

/**
 * Created by johannfjs on 14/02/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class FotoAdapter extends FragmentStatePagerAdapter {
    private ArrayList<Catalogo> lista;

    public FotoAdapter(FragmentManager fm, ArrayList<Catalogo> lista) {
        super(fm);
        this.lista = lista;
    }

    @Override
    public Fragment getItem(int position) {
        //Creamos un fragmento de tipo foto
        FotoFragment fotoFragment = new FotoFragment();
        //Creamos un bundle para poder enviar la información
        Bundle bundle = new Bundle();
        //Añadimos los parametros a enviar
        bundle.putInt("posicion", position);
        //Cargamos los datos que añadimos a nuestro bundle a nuestro fragmento
        fotoFragment.setArguments(bundle);
        //Retornamos el fragmento
        return fotoFragment;
    }

    @Override
    public int getCount() {
        return lista.size();
    }
}
