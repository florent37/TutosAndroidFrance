package com.github.florent37.myyoutube.videodetail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.github.florent37.myyoutube.R;
import com.github.florent37.myyoutube.model.Video;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by florentchampigny on 17/06/15.
 */
public class DetailActivity extends AppCompatActivity {

    public static final String VIDEO = "VIDEO";

    @InjectView(R.id.toobar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ButterKnife.inject(this);

        Video video = getIntent().getExtras().getParcelable(VIDEO);

        setSupportActionBar(toolbar);
        setTitle("");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        supportPostponeEnterTransition();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, VideoDetailFragment.newInstance(video))
                .commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
