package com.tutosandroidfrance.dagger2sample.model;

/**
 * Created by florentchampigny on 03/06/15.
 */
public class Repo {
    private int id;
    private String name;
    private String full_name;
    private String html_url;

    //getters & setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }
}
