package com.jcodee.mod3class1.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.jcodee.mod3class1.R;
import com.jcodee.mod3class1.activities.DetalleActivity;
import com.jcodee.mod3class1.modelos.Usuario;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by johannfjs on 14/03/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class UsuarioAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private ArrayList<Usuario> lista;

    public UsuarioAdapter(Context context, ArrayList<Usuario> lista) {
        this.context = context;
        this.lista = lista;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvUsuario)
        TextView tvUsuario;
        @BindView(R.id.tvCorreo)
        TextView tvCorreo;
        @BindView(R.id.btnTodo)
        Button btnTodo;
        @BindView(R.id.ivInfo)
        ImageView ivInfo;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_datos, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final Usuario usuario = lista.get(position);
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.tvUsuario.setText(usuario.getUsuario());
        myViewHolder.tvCorreo.setText(usuario.getCorreo());

        myViewHolder.btnTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetalleActivity.class);
                intent.putExtra("nombre", usuario.get);
                intent.putExtra("usuario", usuario.getUsuario());
                intent.putExtra("correo", usuario.getCorreo());
                intent.putExtra("direccion", usuario.get);
                intent.putExtra("latitud", usuario.get);
                intent.putExtra("longitud", usuario.get);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
}
