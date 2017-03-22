package com.jcodee.mod3class1.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jcodee.mod3class1.R;
import com.jcodee.mod3class1.modelos.Album;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by johannfjs on 21/03/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class AlbumAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private ArrayList<Album> lista;

    public AlbumAdapter(Context context, ArrayList<Album> lista) {
        this.context = context;
        this.lista = lista;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvTitulo)
        TextView tvTitulo;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_album, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Album album = lista.get(position);

        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.tvTitulo.setText(album.getDescripcion());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
}
