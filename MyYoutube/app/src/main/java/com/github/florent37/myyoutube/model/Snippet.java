package com.github.florent37.myyoutube.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by florentchampigny on 17/06/15.
 */
public class Snippet  implements Parcelable{

    String title;
    String description;
    Thumbnails thumbnails;
    String channelTitle;

    public Snippet(){}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Thumbnails getThumbnails() {
        return thumbnails;
    }

    public void setThumbnails(Thumbnails thumbnails) {
        this.thumbnails = thumbnails;
    }

    public String getChannelTitle() {
        return channelTitle;
    }

    public void setChannelTitle(String channelTitle) {
        this.channelTitle = channelTitle;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(description);
        dest.writeParcelable(thumbnails, flags);
        dest.writeString(channelTitle);
    }

    protected Snippet(Parcel in) {
        title = in.readString();
        description = in.readString();
        thumbnails = in.readParcelable(Thumbnails.class.getClassLoader());
        channelTitle = in.readString();
    }

    public static final Creator<Snippet> CREATOR = new Creator<Snippet>() {
        @Override
        public Snippet createFromParcel(Parcel in) {
            return new Snippet(in);
        }

        @Override
        public Snippet[] newArray(int size) {
            return new Snippet[size];
        }
    };
}
