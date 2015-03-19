package com.tutosandroidfrance.wearsample;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.wearable.view.CardFragment;
import android.support.wearable.view.FragmentGridPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ElementGridPagerAdapter extends FragmentGridPagerAdapter {

    private Context context;
    private List<Row> mRows = new ArrayList<Row>();
    private List<Element> mElements;

    public ElementGridPagerAdapter(Context context, List<Element> elements, FragmentManager fm) {
        super(fm);
        this.context = context;
        this.mElements = elements;

        //Construit le tableau des éléménts à afficher
        for (Element element : elements) {
            mRows.add(new Row(
                            //pour l'instant nous ne mettrons qu'un élément par ligne
                            CardFragment.create(element.getTitre(), element.getTexte())
                    )
            );
        }
    }

    //Le fragment à afficher p
    @Override
    public Fragment getFragment(int row, int col) {
        Row adapterRow = mRows.get(row);
        return adapterRow.getColumn(col);
    }

    //le drawable affichée en background pour la ligne [row]
    @Override
    public Drawable getBackgroundForRow(final int row) {
        Bitmap bitmap = ((MainActivity) context).getBitmap(row);
        if (bitmap != null)
            return new BitmapDrawable(context.getResources(), bitmap);
        else
            return BACKGROUND_NONE;
    }

    @Override
    public Drawable getBackgroundForPage(final int row, final int column) {
        //nous pouvons spécifier un drawable différent pour le swipe horizontal
        return getBackgroundForRow(row);
    }

    //Le nombre de lignes dans la grille
    @Override
    public int getRowCount() {
        return mRows.size();
    }

    //Le nombre de colonnes par ligne
    @Override
    public int getColumnCount(int rowNum) {
        return mRows.get(rowNum).getColumnCount();
    }

    /**
     * Représentation d'une ligne - Contient une liste de fragments
     */
    private class Row {
        final List<Fragment> columns = new ArrayList<Fragment>();

        public Row(Fragment... fragments) {
            for (Fragment f : fragments) {
                add(f);
            }
        }

        public void add(Fragment f) {
            columns.add(f);
        }

        Fragment getColumn(int i) {
            return columns.get(i);
        }

        public int getColumnCount() {
            return columns.size();
        }
    }
}