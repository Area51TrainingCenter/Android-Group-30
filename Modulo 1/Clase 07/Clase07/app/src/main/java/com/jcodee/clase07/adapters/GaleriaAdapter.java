package com.jcodee.clase07.adapters;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodee.clase07.R;
import com.jcodee.clase07.modelos.Foto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by johannfjs on 7/02/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class GaleriaAdapter extends ArrayAdapter<Foto> {
    private Context context;
    private ArrayList<Foto> lista;

    public GaleriaAdapter(Context context, ArrayList<Foto> objects) {
        super(context, R.layout.item, objects);
        this.context = context;
        this.lista = objects;
    }

    static class ViewHolder {
        SimpleDraweeView sdvImagen;
        TextView tvTexto;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Declaramos una variable de tipo ViewHolder para poder reutilizar datos
        ViewHolder viewHolder = null;

        //Verificamos que el diseño no este cargado
        if (convertView == null) {
            //Cargamos el diseño en nuestra variable
            convertView = LayoutInflater
                    .from(context)
                    .inflate(R.layout.item, parent, false);
            //Inicializamos el ViewHolder para poder acceder a los datos
            viewHolder = new ViewHolder();
            //Vinculamos los componentes con las variables
            viewHolder.sdvImagen =
                    (SimpleDraweeView)
                            convertView.findViewById(R.id.sdvImagen);
            viewHolder.tvTexto =
                    (TextView)
                            convertView.findViewById(R.id.tvTexto);
            //Guardamos la configuración en nuestro diseño
            convertView.setTag(viewHolder);
        }
        //Obtenemos las variables que se habían almacenado
        viewHolder = (ViewHolder) convertView.getTag();

        //Obtenemos el objeto a mostrar
        Foto item = lista.get(position);
        viewHolder.sdvImagen.setImageURI(Uri.parse(item.getRuta()));
        viewHolder.tvTexto.setText(item.getNombre());

        //retornamos el diseño
        return convertView;
    }
}
