package france.android.tutos.jsoup;

import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

import france.android.tutos.jsoup.adapter.AdapterTuto;
import france.android.tutos.jsoup.modele.Tuto;


public class MainActivity extends ActionBarActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private ArrayList<Tuto> tutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        charger();
    }

    private void charger() {

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);


        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        tutos = new ArrayList<>();
        mAdapter = new AdapterTuto(tutos, this);
        mRecyclerView.setAdapter(mAdapter);

        new TutoAndroidFranceTask().execute();

    }


    class TutoAndroidFranceTask extends AsyncTask<Void, String, ArrayList<Tuto>> {

        @Override
        protected ArrayList<Tuto> doInBackground(Void... params) {

            Document document;
            try {

                // need http protocol
                document = Jsoup.connect("http://tutos-android-france.com/").get();


                ArrayList<Tuto> cl = new ArrayList<>();

                Tuto item;

                //Element classement = document.getElementById("classement");

                Elements elements = document.getElementsByClass("post-inner");

                for (Element e : elements) {

                    item = new Tuto();

                    // On récupère l'image
                    item.setUrl(e.getElementsByTag("img").first().absUrl("src"));
                    item.setTitre(e.getElementsByClass("post-title").first().getElementsByTag("a").first().attr("title").toString());
                    item.setDescription(e.getElementsByClass("entry").first().getElementsByTag("p").first().text());

                    cl.add(item);
                }



                return cl;

            } catch (IOException e) {
                e.printStackTrace();
                Log.e("Error", e.getMessage());
            }

            return null;
        }

        @Override
        protected void onPostExecute(ArrayList<Tuto> ts) {
            super.onPostExecute(ts);

            try {
                if (tutos == null)
                    tutos = new ArrayList<>();

                tutos.addAll(ts);
                mAdapter.notifyDataSetChanged();
            } catch (Exception e) {

            }

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
