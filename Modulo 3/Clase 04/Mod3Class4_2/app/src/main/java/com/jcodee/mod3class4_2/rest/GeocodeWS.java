package com.jcodee.mod3class4_2.rest;

import com.jcodee.mod3class4_2.rest.response.GeocodeResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by johannfjs on 23/03/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public interface GeocodeWS {
    //?address=1600+Amphitheatre+Parkway,+Mountain+View,+CA&key=AIzaSyCykvdeyahGdyDjxd-4jdMFFvLTM4gbhQ4
    //@GET("geocode/json?address={address}&key={key}")
    //@Field = post
    @GET("geocode/json")
    Call<GeocodeResponse> obtenerLugar(@Query("address") String address,
                                       @Query("key") String key);
}
