package pe.area51.clase2.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.RealmResults;
import pe.area51.clase2.R;
import pe.area51.clase2.entidades.MascotaEntidad;

/**
 * Created by johannfjs on 21/02/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class MascotaAdapter extends BaseAdapter {
    private Context context;
    private RealmResults<MascotaEntidad> lista;

    public MascotaAdapter(Context context, RealmResults<MascotaEntidad> lista) {
        this.context = context;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return lista.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Declaramos una clase de tipo ViewHolder (reutilizar las referencias)
        ViewHolder viewHolder = null;
        //Validamos si el diseño se encuentra disponible o no
        if (convertView == null) {
            //Incluimos el diseño a nuestra vista
            convertView = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
            //Inciializamos el ViewHolder
            viewHolder = new ViewHolder(convertView);
            //Agregamos el ViewHolder al tag del diseño para poder llamarlo
            convertView.setTag(viewHolder);
        }
        //Obtenemos el ViewHolder que se declaro y se agrego al diseño
        viewHolder = (ViewHolder) convertView.getTag();

        //Obtenemos el objeto de la lista
        MascotaEntidad mascotaEntidad = lista.get(position);
        //Seteamos los datos a mostrar
        viewHolder.tvGenero.setText(mascotaEntidad.getGenero() == 1 ? "Macho" : "Hembra");
        viewHolder.tvNombreMascota.setText(mascotaEntidad.getNombreMascota());
        viewHolder.tvNotificaciones.setText(mascotaEntidad.isNotificaciones() ? "Recibe" : "No Recibe");

        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.tvNombreMascota)
        TextView tvNombreMascota;
        @BindView(R.id.tvGenero)
        TextView tvGenero;
        @BindView(R.id.tvNotificaciones)
        TextView tvNotificaciones;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
