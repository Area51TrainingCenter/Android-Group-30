package com.jcodee.clase08.fragments;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodee.clase08.MainActivity;
import com.jcodee.clase08.R;
import com.jcodee.clase08.modelos.Catalogo;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class FotoFragment extends Fragment {


    @BindView(R.id.sdvImagen)
    SimpleDraweeView sdvImagen;
    @BindView(R.id.tvNombre)
    TextView tvNombre;

    public FotoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_foto, container, false);
        ButterKnife.bind(this, view);

        Bundle bundle = getArguments();
        int posicion = bundle.getInt("posicion");
        Catalogo catalogo = MainActivity.lista.get(posicion);
        tvNombre.setText(catalogo.getNombre());
        sdvImagen.setImageURI(Uri.parse(catalogo.getImagen()));


        return view;
    }

}
