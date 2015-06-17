package com.github.florent37.myyoutube.model;

import java.util.List;

/**
 * Created by florentchampigny on 17/06/15.
 */
public class YoutubeResponse {
    List<Video> items;

    public List<Video> getItems() {
        return items;
    }

    public void setItems(List<Video> items) {
        this.items = items;
    }
}
