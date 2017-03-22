package com.jcodee.mod3class1.rest;

import com.jcodee.mod3class1.rest.response.AlbumResponse;
import com.jcodee.mod3class1.rest.response.FotoResponse;
import com.jcodee.mod3class1.rest.response.UsersResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by johannfjs on 14/03/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public interface TypicodeWS {
    @GET("users")
    Call<ArrayList<UsersResponse>> obtenerUsuarios();

    @GET("albums")
    Call<ArrayList<AlbumResponse>> obtenerAlbums();

    @GET("photos")
    Call<ArrayList<FotoResponse>> obtenerFotos();
}
