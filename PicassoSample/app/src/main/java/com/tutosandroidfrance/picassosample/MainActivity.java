package com.tutosandroidfrance.picassosample;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;


public class MainActivity extends ActionBarActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);

        Picasso.with(getBaseContext()).load("http://i.imgur.com/DvpvklR.png")
                //.transform(new BlurTransformation(this))
                //.transform(new ResizeTransformation(50))
                //.resize(50,50)
                //.fit().centerCrop()
                .fit().centerInside()
                .into(imageView);
    }

    public class ResizeTransformation implements Transformation{

        //la largeur voulue
        private int targetWidth;

        public ResizeTransformation(int width) {
            this.targetWidth = width;
        }

        @Override
        public Bitmap transform(Bitmap source) {
            double aspectRatio = (double) source.getHeight() / (double) source.getWidth();
            int targetHeight = (int) (targetWidth * aspectRatio);
            Bitmap result = Bitmap.createScaledBitmap(source, targetWidth, targetHeight, false);
            if (result != source) {
                // Same bitmap is returned if sizes are the same
                source.recycle();
            }
            return result;
        }

        @Override
        public String key() {
            return "ResizeTransformation"+targetWidth;
        }
    }

    public class BlurTransformation implements Transformation {
        private Context context;

        public BlurTransformation(Context context) {
            this.context = context;
        }

        @Override
        public Bitmap transform(Bitmap source) {
            //Source from : https://raw.githubusercontent.com/PomepuyN/BlurEffectForAndroidDesign/master/BlurEffect/src/com/npi/blureffect/Blur.java
            //Copyright : PomepuyN
            Bitmap result = Blur.fastblur(context,source,10);

            //si l'image a été modifiée, on désalloue la mémoire occupée par l'ancienne Bitmap
            if (result != source) {
                source.recycle();
            }
            return result;
        }

        //la clé va être utilisée lors de la sauvegarde en cache
        @Override
        public String key() {
            return "BlurTransformation";
        }
    }
}
