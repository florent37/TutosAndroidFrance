package tutosandroidfrance.butterknifesample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.view1)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        textView.setText("Hello !");
    }

    @OnClick(R.id.view1)
    void clicVueHaute() {
        Toast.makeText(this, "Hello World !", Toast.LENGTH_SHORT).show();
    }

    @OnClick({R.id.view2, R.id.view3, R.id.view4})
    void clicVue(TextView textView) {
        Toast.makeText(this, textView.getText().toString(), Toast.LENGTH_SHORT).show();

    }
}
