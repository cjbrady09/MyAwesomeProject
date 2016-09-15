package css188.drake.myapplication2;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Main2Activity extends Activity {
    private TextView textView;
    private RelativeLayout bg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView = (TextView) findViewById(R.id.textView);
        textView.setText(getIntent().getStringExtra("value"));

        bg = (RelativeLayout) findViewById(R.id.bg);

        if(getIntent().getStringExtra("color") != null)
        {
            if(getIntent().getStringExtra("color").equals("Green"))
            {
                bg.setBackgroundColor(ContextCompat.getColor(this, R.color.greenColor));
            }

            if(getIntent().getStringExtra("color").equals("Blue"))
            {
                bg.setBackgroundColor(ContextCompat.getColor(this, R.color.blueColor));
            }
        }
    }


}
