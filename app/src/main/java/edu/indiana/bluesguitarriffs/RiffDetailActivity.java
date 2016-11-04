package edu.indiana.bluesguitarriffs;

import android.os.Bundle;
import android.app.Activity;
import android.widget.ImageButton;
import android.widget.ImageView;

public class RiffDetailActivity extends Activity {

    String riffNumber = "1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riff_detail);
        Bundle bundle = getIntent().getExtras();
        this.riffNumber = Integer.toString(bundle.getInt("riffNumber"));
        setContentView(R.layout.activity_riff_detail);

        ImageButton playButton = (ImageButton)findViewById(R.id.playButton);
        ImageView tabImage = (ImageView)findViewById(R.id.riffImage);

        // set tab image
        int tabImageIdentifier = getApplicationContext().getResources().getIdentifier("riff" + riffNumber + "tab.png", "drawable", getApplicationContext().getPackageName());
        tabImage.setImageResource(tabImageIdentifier);

        // set audio to play
    }

}
