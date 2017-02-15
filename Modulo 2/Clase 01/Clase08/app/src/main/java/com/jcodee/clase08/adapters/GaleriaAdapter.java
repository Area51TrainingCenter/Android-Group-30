package com.jcodee.clase08.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodee.clase08.R;
import com.jcodee.clase08.modelos.Catalogo;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by johannfjs on 9/02/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class GaleriaAdapter extends ArrayAdapter<Catalogo> {
    private Context context;
    private ArrayList<Catalogo> lista;

    public GaleriaAdapter(Context context, ArrayList<Catalogo> objects) {
        super(context, R.layout.item, objects);
        this.context = context;
        this.lista = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;

        if (convertView == null) {
            convertView = LayoutInflater.from(context)
                    .inflate(R.layout.item, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        viewHolder = (ViewHolder) convertView.getTag();
        Catalogo catalogo = lista.get(position);
        viewHolder.sdvImagen.setImageURI(catalogo.getImagen());
        viewHolder.tvNombre.setText(catalogo.getNombre());

        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.sdvImagen)
        SimpleDraweeView sdvImagen;
        @BindView(R.id.tvNombre)
        TextView tvNombre;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
