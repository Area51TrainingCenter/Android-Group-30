package com.jcodee.mod2class8.fragmentos;


import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jcodee.mod2class8.R;

import java.io.FileNotFoundException;
import java.io.InputStream;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class FotoFragment extends Fragment {


    @BindView(R.id.ivImage)
    ImageView ivImage;

    public FotoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_foto, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.btnSeleccionar)
    public void onClick() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent, 100);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == Activity.RESULT_OK) {
            if (data != null) {
                try {
                    InputStream inputStream = getContext()
                            .getContentResolver()
                            .openInputStream(data.getData());

                    ivImage.setImageBitmap(BitmapFactory.decodeStream(inputStream));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
