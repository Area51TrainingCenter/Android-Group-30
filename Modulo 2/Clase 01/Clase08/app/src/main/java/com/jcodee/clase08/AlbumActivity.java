package com.jcodee.clase08;

import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.jcodee.clase08.adapters.FotoAdapter;
import com.jcodee.clase08.views.DepthPageTransformer;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AlbumActivity extends BaseActivity {

    @BindView(R.id.vpAlbum)
    ViewPager vpAlbum;

    private FotoAdapter fotoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);

        fotoAdapter = new FotoAdapter(getSupportFragmentManager(),
                MainActivity.lista);
        vpAlbum.setAdapter(fotoAdapter);
        //https://developer.android.com/training/animation/screen-slide.html
        vpAlbum.setPageTransformer(true, new DepthPageTransformer());

        Bundle bundle = getIntent().getExtras();
        int posicion = bundle.getInt("posicion");
        vpAlbum.setCurrentItem(posicion);

    }
}
