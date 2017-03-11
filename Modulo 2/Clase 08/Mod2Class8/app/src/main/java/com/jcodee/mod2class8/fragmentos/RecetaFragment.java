package com.jcodee.mod2class8.fragmentos;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodee.mod2class8.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecetaFragment extends Fragment {


    @BindView(R.id.sdvImagen)
    SimpleDraweeView sdvImagen;

    public RecetaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_receta, container, false);
        ButterKnife.bind(this, view);

        DraweeController draweeController = Fresco.newDraweeControllerBuilder()
                .setUri(Uri.parse("res:/" + R.drawable.image))
                .setAutoPlayAnimations(true)
                .build();
        sdvImagen.setController(draweeController);

        return view;
    }

}
