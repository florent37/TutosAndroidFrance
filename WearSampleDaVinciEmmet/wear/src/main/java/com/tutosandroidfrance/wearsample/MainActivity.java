package com.tutosandroidfrance.wearsample;

import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.view.DotsPageIndicator;
import android.support.wearable.view.GridViewPager;

import com.github.florent37.Emmet;
import com.tutosandroidfrance.wearprotocol.AndroidVersion;
import com.tutosandroidfrance.wearprotocol.SmartphoneProtocol;
import com.tutosandroidfrance.wearprotocol.WearProtocol;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements WearProtocol {

    private final static String TAG = MainActivity.class.getCanonicalName();

    private GridViewPager pager;
    private DotsPageIndicator dotsPageIndicator;

    //la liste des éléments à afficher
    private List<AndroidVersion> elementList = new ArrayList<>();

    private Emmet emmet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = (GridViewPager) findViewById(R.id.pager);
        dotsPageIndicator = (DotsPageIndicator) findViewById(R.id.page_indicator);
        dotsPageIndicator.setPager(pager);

        //initialise Emmet
        emmet = new Emmet();
        emmet.onCreate(this);

        emmet.registerReceiver(WearProtocol.class, this);
        SmartphoneProtocol smartphoneProtocol = emmet.createSender(SmartphoneProtocol.class);

        smartphoneProtocol.hello(); //envoie le message hello smartphone
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        emmet.onDestroy(); //ne pas oublier
    }

    //envoyé depuis le smartphone
    @Override
    public void onAndroidVersionsReceived(List<AndroidVersion> androidVersions) {
        if (androidVersions != null && this.elementList != null && this.elementList.isEmpty()) {
            this.elementList.addAll(androidVersions);
            startMainScreen();
        }
    }

    public void startMainScreen() {
        //penser à effectuer les actions graphiques dans le UIThread
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //nous affichons ici dans notre viewpager

                if (pager != null && pager.getAdapter() == null)
                    pager.setAdapter(new ElementGridPagerAdapter(MainActivity.this, elementList, getFragmentManager()));
            }
        });
    }
}
