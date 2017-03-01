package pe.area51.clase2.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.RealmResults;
import pe.area51.clase2.R;
import pe.area51.clase2.activities.ListadoActivity;
import pe.area51.clase2.activities.MainActivity;
import pe.area51.clase2.entidades.MascotaEntidad;

/**
 * Created by johannfjs on 21/02/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class MascotaAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private RealmResults<MascotaEntidad> lista;

    public MascotaAdapter(Context context, RealmResults<MascotaEntidad> lista) {
        this.context = context;
        this.lista = lista;
    }

    class ViewHolderMascota extends RecyclerView.ViewHolder {
        @BindView(R.id.tvNombreMascota)
        TextView tvNombreMascota;
        @BindView(R.id.tvGenero)
        TextView tvGenero;
        @BindView(R.id.tvNotificaciones)
        TextView tvNotificaciones;
        @BindView(R.id.btnAccion)
        Button btnAccion;

        public ViewHolderMascota(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    //En este método es donde se define el diseño
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View convertView = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        //OnClickListener es el evento que le estamos asignando para que al seleccionar un
        //elemento de la lista se cargue una acción
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "cargo", Toast.LENGTH_SHORT).show();
            }
        });
        return new ViewHolderMascota(convertView);
    }

    //Donde obtenemos las variables y podemos poner los datos
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final MascotaEntidad mascotaEntidad = lista.get(position);
        ViewHolderMascota holderMascota = (ViewHolderMascota) holder;
        holderMascota.tvGenero.setText(mascotaEntidad.getGenero() == 1 ? "Macho" : "Hembra");
        holderMascota.tvNombreMascota.setText(mascotaEntidad.getNombreMascota());
        holderMascota.tvNotificaciones.setText((mascotaEntidad.isNotificaciones() ? "Si" : "No") + " Recibe Notificaciones");

        holderMascota.tvNombreMascota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "desde nombre mascota", Toast.LENGTH_SHORT).show();
            }
        });

        holderMascota.btnAccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Desde boton " + mascotaEntidad.getNombreMascota(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(context, MainActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
}
