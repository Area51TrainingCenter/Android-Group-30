package com.jcodee.mod1class5.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jcodee.mod1class5.R;
import com.jcodee.mod1class5.models.Persona;

import java.util.ArrayList;

/**
 * Created by johannfjs on 26/01/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class PersonaAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Persona> lista;

    public PersonaAdapter(Context context, ArrayList<Persona> lista) {
        this.context = context;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        //La cantidad de elementos que tendrá nuestra lista (ListView)
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        //Obtener un objeto de la lista
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        //Obtener el id unico por un elemento de la lista
        return lista.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Es el metodo en el cual se crea el diseño y se settean los datos a mostrar

        //Añadimos el diseño a nuestra variable de vista
        convertView = LayoutInflater.from(context).inflate(R.layout.item_lista, parent, false);

        //Creación de variables y vinculación cin el diseño
        TextView nombre = (TextView) convertView.findViewById(R.id.tvNombre),
                genero = (TextView) convertView.findViewById(R.id.tvGenero),
                estadoCivil = (TextView) convertView.findViewById(R.id.tvEstadoCivil);
        ImageView imagen = (ImageView) convertView.findViewById(R.id.ivImagen);

        //Obtenemos datos de un elemento de la lista
        Persona persona = (Persona) getItem(position);

        //Setteamos los datos de los componentes con los obtenidos en la lista
        nombre.setText(persona.getNombre());
        genero.setText(persona.getGenero());
        estadoCivil.setText(persona.getEstadoCivil());

        //Consultamos si la persona es de genero Masculino o Femenino para poder
        //mostrar la imagen correcta
        if (persona.getGenero().equals("Masculino"))
            imagen.setImageResource(R.drawable.male);
        else if (persona.getGenero().equals("Femenino"))
            imagen.setImageResource(R.drawable.female);


        //Se retorna el diseño con los datos
        return convertView;
    }

     /*
        lista
                1     johann      jara        lista.get(0)
                2     juan        perez       lista.get(1)
          */
}
