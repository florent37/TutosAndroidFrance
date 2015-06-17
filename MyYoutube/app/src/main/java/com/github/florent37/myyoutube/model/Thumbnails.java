package com.github.florent37.myyoutube.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by florentchampigny on 17/06/15.
 */
public class Thumbnails implements Parcelable{

    @SerializedName("default")
    Thumbnail _default;
    Thumbnail medium;
    Thumbnail hight;

    public Thumbnails(){}

    protected Thumbnails(Parcel in) {
        _default = in.readParcelable(Thumbnail.class.getClassLoader());
        medium = in.readParcelable(Thumbnail.class.getClassLoader());
        hight = in.readParcelable(Thumbnail.class.getClassLoader());
    }


    public Thumbnail getDefault() {
        return _default;
    }

    public void setDefault(Thumbnail _default) {
        this._default = _default;
    }

    public Thumbnail getMedium() {
        return medium;
    }

    public void setMedium(Thumbnail medium) {
        this.medium = medium;
    }

    public Thumbnail getHight() {
        return hight;
    }

    public void setHight(Thumbnail hight) {
        this.hight = hight;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(_default, flags);
        dest.writeParcelable(medium, flags);
        dest.writeParcelable(hight, flags);
    }

    public static final Creator<Thumbnails> CREATOR = new Creator<Thumbnails>() {
        @Override
        public Thumbnails createFromParcel(Parcel in) {
            return new Thumbnails(in);
        }

        @Override
        public Thumbnails[] newArray(int size) {
            return new Thumbnails[size];
        }
    };
}
