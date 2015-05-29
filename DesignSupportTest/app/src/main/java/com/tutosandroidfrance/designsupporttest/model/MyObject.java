package com.tutosandroidfrance.designsupporttest.model;

import java.io.Serializable;

/**
 * Created by florentchampigny on 29/05/15.
 */
public class MyObject implements Serializable{
    private String text;
    private String imageUrl;

    public MyObject(String text, String imageUrl) {
        this.text = text;
        this.imageUrl = imageUrl;
    }

    //getters & setters


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


}