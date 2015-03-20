package com.tutosandroidfrance.wearsample;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.LruCache;

public class BitmapManager extends LruCache<Integer, Drawable> {

    public static final String TAG = BitmapManager.class.getCanonicalName();

    private static BitmapManager INSTANCE;

    public static BitmapManager init(int size) {
        if (INSTANCE == null)
            INSTANCE = new BitmapManager(size);
        return INSTANCE;
    }

    private BitmapManager(int size) {
        super(size);
    }

    public static BitmapManager getInstance() {
        return INSTANCE;
    }

    @Override
    protected Drawable create(final Integer entry) {
        return new ColorDrawable(Color.TRANSPARENT);
    }
}
