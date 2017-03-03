package com.jcodee.clase05.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jcodee.clase05.R;
import com.jcodee.clase05.activities.MapaActivity;
import com.jcodee.clase05.entidades.Posicion;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.RealmResults;

/**
 * Created by johannfjs on 28/02/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class PosicionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private RealmResults<Posicion> lista;

    public PosicionAdapter(Context context, RealmResults<Posicion> lista) {
        this.context = context;
        this.lista = lista;
    }

    class ViewHolderPosicion extends RecyclerView.ViewHolder {
        @BindView(R.id.tvTitulo)
        TextView tvTitulo;
        @BindView(R.id.tvDescripcion)
        TextView tvDescripcion;
        @BindView(R.id.tvLatitud)
        TextView tvLatitud;
        @BindView(R.id.tvLongitud)
        TextView tvLongitud;
        @BindView(R.id.cardView)
        CardView cardView;

        public ViewHolderPosicion(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View convertView = LayoutInflater.from(context).inflate(R.layout.item_posicion,
                parent,
                false);
        return new ViewHolderPosicion(convertView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolderPosicion viewHolderPosicion = (ViewHolderPosicion) holder;
        if (viewHolderPosicion != null) {
            final Posicion posicion = lista.get(position);

            viewHolderPosicion.tvTitulo.setText(posicion.getTitulo());
            viewHolderPosicion.tvDescripcion.setText(posicion.getDescripcion());
            viewHolderPosicion.tvLatitud.setText(String.valueOf(posicion.getLatitud()));
            viewHolderPosicion.tvLongitud.setText(String.valueOf(posicion.getLongitud()));

            viewHolderPosicion.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, MapaActivity.class);
                    intent.putExtra("titulo", posicion.getTitulo());
                    intent.putExtra("descripcion", posicion.getDescripcion());
                    intent.putExtra("latitud", posicion.getLatitud());
                    intent.putExtra("longitud", posicion.getLongitud());
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
}
