package com.tutosandroidfrance.recyclerviewsample;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by florentchampigny on 01/05/15.
 */
public class MyViewHolder extends RecyclerView.ViewHolder{

    private TextView textViewView;
    private ImageView imageView;

    //itemView est la vue correspondante à 1 cellule
    public MyViewHolder(View itemView) {
        super(itemView);

        //c'est ici que l'on fait nos findView

        textViewView = itemView.findViewById(R.id.text);
        imageView = itemView.findViewById(R.id.image);
    }

    //puis ajouter une fonction pour remplir la cellule en fonction d'un MyObject
    public void bind(MyObject myObject){
        textViewView.setText(myObject.getText());
        Picasso.with(imageView.getContext()).load(myObject.getImageUrl()).centerCrop().fit().into(imageView);
    }
}