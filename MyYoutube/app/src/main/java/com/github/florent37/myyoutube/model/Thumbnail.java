package com.github.florent37.myyoutube.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by florentchampigny on 17/06/15.
 */
public class Thumbnail implements Parcelable{
    String url;

    public Thumbnail(){}

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(url);
    }

    protected Thumbnail(Parcel in) {
        url = in.readString();
    }

    public static final Creator<Thumbnail> CREATOR = new Creator<Thumbnail>() {
        @Override
        public Thumbnail createFromParcel(Parcel in) {
            return new Thumbnail(in);
        }

        @Override
        public Thumbnail[] newArray(int size) {
            return new Thumbnail[size];
        }
    };

}
