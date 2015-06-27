package tutosandroidfrance.butterknifesample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.view1)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        textView.setText("Hello !");
    }

    @OnClick(R.id.view1)
    void clicVueHaute(){
        Toast.makeText(this,"Hello World !",Toast.LENGTH_SHORT).show();
    }

    @OnClick({R.id.view2,R.id.view3,R.id.view4})
    void clicVue(TextView textView){
        Toast.makeText(this,textView.getText().toString(),Toast.LENGTH_SHORT).show();

    }
}
