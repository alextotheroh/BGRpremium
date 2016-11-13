package edu.indiana.bluesguitarriffsrockstar;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class RiffDetailActivity extends Activity {

    String riffNumber = "1";
    int riffNumberAsInt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riff_detail);
        Bundle bundle = getIntent().getExtras();
        this.riffNumberAsInt = bundle.getInt("riffNumber");
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

        // show rateBeg if on riff 50 and set onclick listener
        if (riffNumber.equals("50")) {
            ImageButton rateBegButton = (ImageButton)findViewById(R.id.rateBeg);

            rateBegButton.setVisibility(View.VISIBLE);

            rateBegButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Uri uri = Uri.parse("market://details?id=" + getPackageName());
                    Intent myAppLinkToMarket = new Intent(Intent.ACTION_VIEW, uri);
                    try {
                        startActivity(myAppLinkToMarket);
                    } catch (ActivityNotFoundException e) {
                        Toast.makeText(getApplicationContext(), "Unable to find market app", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        // set audio to play
        int audioFileIdentifier = getApplicationContext().getResources().getIdentifier("riff" + riffNumber, "raw", getApplicationContext().getPackageName());
        final MediaPlayer mp = MediaPlayer.create(getApplicationContext(), audioFileIdentifier);

        // slightly turn down volume if not on riff 1-10
        if (riffNumberAsInt > 10) {
            mp.setVolume(0.8f, 0.8f);
        }

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
