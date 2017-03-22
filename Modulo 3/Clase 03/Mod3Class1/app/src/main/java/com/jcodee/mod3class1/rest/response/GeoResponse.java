package com.jcodee.mod3class1.rest.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by johannfjs on 14/03/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class GeoResponse {
    @SerializedName("lat")
    private String latitud;
    @SerializedName("lng")
    private String longitud;

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }
}
