package com.github.florent37.myyoutube.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Map;

/**
 * Created by florentchampigny on 17/06/15.
 */
public class Video implements Parcelable {
    ItemId id;
    Snippet snippet;

    public Video(){}

    public ItemId getId() {
        return id;
    }

    public void setId(ItemId id) {
        this.id = id;
    }

    public Snippet getSnippet() {
        return snippet;
    }

    public void setSnippet(Snippet snippet) {
        this.snippet = snippet;
    }

    protected Video(Parcel in) {
        snippet = in.readParcelable(Snippet.class.getClassLoader());
    }

    public static final Creator<Video> CREATOR = new Creator<Video>() {
        @Override
        public Video createFromParcel(Parcel in) {
            return new Video(in);
        }

        @Override
        public Video[] newArray(int size) {
            return new Video[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(snippet, flags);
    }
}
