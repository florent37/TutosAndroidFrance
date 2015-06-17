package com.github.florent37.myyoutube.videolist;

/**
 * Created by florentchampigny on 17/06/15.
 */
public class SearchEvent {

    String query;

    public SearchEvent(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
