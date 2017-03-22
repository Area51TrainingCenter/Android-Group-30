package com.jcodee.mod3class1.rest.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by johannfjs on 14/03/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class AddressResponse {
    @SerializedName("street")
    private String calle;
    @SerializedName("suite")
    private String numero;
    @SerializedName("city")
    private String ciudad;
    @SerializedName("zipcode")
    private String codigoZip;
    @SerializedName("geo")
    private GeoResponse geo;

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCodigoZip() {
        return codigoZip;
    }

    public void setCodigoZip(String codigoZip) {
        this.codigoZip = codigoZip;
    }

    public GeoResponse getGeo() {
        return geo;
    }

    public void setGeo(GeoResponse geo) {
        this.geo = geo;
    }
}
