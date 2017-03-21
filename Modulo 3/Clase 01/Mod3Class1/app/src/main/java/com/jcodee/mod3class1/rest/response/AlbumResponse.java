package com.jcodee.mod3class1.rest.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by johannfjs on 14/03/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class AlbumResponse {
    @SerializedName("userId")
    private int userId;
    @SerializedName("id")
    private int id;
    @SerializedName("title")
    private String title;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
