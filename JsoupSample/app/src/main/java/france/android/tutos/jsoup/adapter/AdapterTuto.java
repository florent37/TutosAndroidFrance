package france.android.tutos.jsoup.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import france.android.tutos.jsoup.R;
import france.android.tutos.jsoup.modele.Tuto;
import france.android.tutos.jsoup.views.cell.TutoCell;

/**
 * Created by kevindejesusferreira on 14/01/15.
 */
public class AdapterTuto extends RecyclerView.Adapter<TutoCell>{

    private ArrayList<Tuto> tutos;
    private Context context;
    private static LayoutInflater inflater=null;

    public AdapterTuto(ArrayList<Tuto> tutos, Context context) {
        this.tutos = tutos;
        this.context = context;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }


    // Create new views (invoked by the layout manager)
    @Override
    public TutoCell onCreateViewHolder(ViewGroup parent,
                                            int viewType) {

        View v = inflater.inflate(R.layout.cell_tuto, null);
        return new TutoCell(v,this.context);
    }

    @Override
    public void onBindViewHolder(TutoCell tutoCell, int i) {
        tutoCell.construire(this.tutos.get(i));
    }


    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return tutos.size();
    }

}
