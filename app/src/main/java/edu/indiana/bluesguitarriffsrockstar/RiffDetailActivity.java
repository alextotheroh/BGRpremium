package edu.indiana.bluesguitarriffsrockstar;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

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
        FloatingActionButton backButton = (FloatingActionButton)findViewById(R.id.fab);

        // set tab image
        int tabImageIdentifier = getApplicationContext().getResources().getIdentifier("riff" + riffNumber + "tab", "drawable", getApplicationContext().getPackageName());
        tabImage.setImageResource(tabImageIdentifier);

        // adjust margins if riff is a problem riff
        if (riffNumber.equals("14") || riffNumber.equals("16") || riffNumber.equals("23") || riffNumber.equals("25") || riffNumber.equals("31") || riffNumber.equals("33")) {
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(65, 25, 65, 0);
            tabImage.setLayoutParams(params);
        }

        // set audio to play
        int audioFileIdentifier = getApplicationContext().getResources().getIdentifier("riff" + riffNumber, "raw", getApplicationContext().getPackageName());
        final MediaPlayer mp = MediaPlayer.create(getApplicationContext(), audioFileIdentifier);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
            }
        });

        // set back button to return to previous screen
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.stop();
                finish();
            }
        });
    }

}
