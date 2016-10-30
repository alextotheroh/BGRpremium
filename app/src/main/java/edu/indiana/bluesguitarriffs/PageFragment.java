package edu.indiana.bluesguitarriffs;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.pixplicity.sharp.Sharp;

import java.util.ArrayList;

public class PageFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int pageNumber = getArguments().getInt("page_number");
        View v = inflater.inflate(R.layout.page_layout, container, false);

        //TextView tv = (TextView)v.findViewById(R.id.PageTitle);
        //tv.setText("Page " + Integer.toString(pageNumber));

        final View imageButton1 = v.findViewById(R.id.button1);
        final View imageButton2 = v.findViewById(R.id.button2);
        final View imageButton3 = v.findViewById(R.id.button3);
        final View imageButton4 = v.findViewById(R.id.button4);
        final View imageButton5 = v.findViewById(R.id.button5);
        final View imageButton6 = v.findViewById(R.id.button6);
        final View imageButton7 = v.findViewById(R.id.button7);
        final View imageButton8 = v.findViewById(R.id.button8);
        final View imageButton9 = v.findViewById(R.id.button9);
        final View imageButton10 = v.findViewById(R.id.button10);

        final TextView buttonText1 = (TextView)v.findViewById(R.id.button1text);
        final TextView buttonText2 = (TextView)v.findViewById(R.id.button2text);
        final TextView buttonText3 = (TextView)v.findViewById(R.id.button3text);
        final TextView buttonText4 = (TextView)v.findViewById(R.id.button4text);
        final TextView buttonText5 = (TextView)v.findViewById(R.id.button5text);
        final TextView buttonText6 = (TextView)v.findViewById(R.id.button6text);
        final TextView buttonText7 = (TextView)v.findViewById(R.id.button7text);
        final TextView buttonText8 = (TextView)v.findViewById(R.id.button8text);
        final TextView buttonText9 = (TextView)v.findViewById(R.id.button9text);
        final TextView buttonText10 = (TextView)v.findViewById(R.id.button10text);

        final FrameLayout button1Frame = (FrameLayout)v.findViewById(R.id.frame1);
        final FrameLayout button2Frame = (FrameLayout)v.findViewById(R.id.frame2);
        final FrameLayout button3Frame = (FrameLayout)v.findViewById(R.id.frame3);
        final FrameLayout button4Frame = (FrameLayout)v.findViewById(R.id.frame4);
        final FrameLayout button5Frame = (FrameLayout)v.findViewById(R.id.frame5);
        final FrameLayout button6Frame = (FrameLayout)v.findViewById(R.id.frame6);
        final FrameLayout button7Frame = (FrameLayout)v.findViewById(R.id.frame7);
        final FrameLayout button8Frame = (FrameLayout)v.findViewById(R.id.frame8);
        final FrameLayout button9Frame = (FrameLayout)v.findViewById(R.id.frame9);
        final FrameLayout button10Frame = (FrameLayout)v.findViewById(R.id.frame10);

        ArrayList<View> buttonImages = new ArrayList<>();
        buttonImages.add(imageButton1);
        buttonImages.add(imageButton2);
        buttonImages.add(imageButton3);
        buttonImages.add(imageButton4);
        buttonImages.add(imageButton5);
        buttonImages.add(imageButton6);
        buttonImages.add(imageButton7);
        buttonImages.add(imageButton8);
        buttonImages.add(imageButton9);
        buttonImages.add(imageButton10);

        ArrayList<TextView> buttonTexts = new ArrayList<>();
        buttonTexts.add(buttonText1);
        buttonTexts.add(buttonText2);
        buttonTexts.add(buttonText3);
        buttonTexts.add(buttonText4);
        buttonTexts.add(buttonText5);
        buttonTexts.add(buttonText6);
        buttonTexts.add(buttonText7);
        buttonTexts.add(buttonText8);
        buttonTexts.add(buttonText9);
        buttonTexts.add(buttonText10);

        // load the vector image of a vinyl record into each button
        for (View button: buttonImages) {
            Sharp.loadResource(getResources(), R.raw.record).into(button);
        }

        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "Prisma.ttf");

        // set the text for each button based on the page number
        int currentButtonText = pageNumber + (9 * (pageNumber-1));
        for (TextView buttonText: buttonTexts) {
            buttonText.setTypeface(font);
            buttonText.setText(Integer.toString(currentButtonText));
            FrameLayout.LayoutParams params = (FrameLayout.LayoutParams)buttonText.getLayoutParams();
            params.setMargins(0, (-1 * Math.round(buttonText.getTextSize())/30), 0, 0);
            buttonText.setLayoutParams(params);
            buttonText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    v.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.shake));
                }
            });
            currentButtonText++;
        }

        return v;
    }

    public static PageFragment newInstance(int pageNumber){
        PageFragment f = new PageFragment();
        Bundle b = new Bundle();
        b.putInt("page_number", pageNumber);

        f.setArguments(b);

        return f;
    }

}
