package com.tutosandroidfrance.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Created by florentchampigny on 27/06/15.
 */
public class HelloWorldView extends FrameLayout {

    //on stock la couleur du hello défini en attribut
    private int helloColor;
    //on stock la couleur du world défini en attribut
    private int worldColor;

    //récupère les valeurs affectées en attribut
    private void handleAttributes(Context context, AttributeSet attrs) {
        try {
            TypedArray styledAttrs = context.obtainStyledAttributes(attrs, R.styleable.HelloWorldView);

            helloColor = styledAttrs.getColor(R.styleable.HelloWorldView_helloColor, Color.BLACK);
            worldColor = styledAttrs.getColor(R.styleable.HelloWorldView_worldColor, Color.BLACK);

            styledAttrs.recycle();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public HelloWorldView(Context context) {
        super(context);
    }

    public HelloWorldView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //je récupère les attributs
        handleAttributes(context, attrs);
    }

    public HelloWorldView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        handleAttributes(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        //à l'ajout d'un HelloWorldView, je demande de rajouter dans celui-ci le contenu de layout/hello_world.xml
        View helloWorld = LayoutInflater.from(getContext())
                .inflate(R.layout.hello_world, this, false);
        addView(helloWorld);

        //je récupère les TextView de layout/hello_world.xml
        TextView hello = (TextView) findViewById(R.id.hello);
        TextView world = (TextView) findViewById(R.id.world);

        //puis je change leurs couleurs
        hello.setTextColor(helloColor);
        world.setTextColor(worldColor);
    }
}
