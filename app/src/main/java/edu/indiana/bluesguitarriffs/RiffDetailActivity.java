package edu.indiana.bluesguitarriffs;

import android.os.Bundle;
import android.app.Activity;

public class RiffDetailActivity extends Activity {

    int riffNumber = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riff_detail);
        Bundle bundle = getIntent().getExtras();
        this.riffNumber = bundle.getInt("riffNumber");
    }

}
