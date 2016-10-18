/*MainActivity.java
*
*Contains the Java code for the
*Primary Activity in this project
*
*Created by: Alex Totheroh
*Created on: 3/1/15
*Last Modified by: Alex Totheroh
*Last Modified on: 3/6/2015
*Assignment/Project: A290 Android Development Final Project
*Part of: BluesGuitarRiffs, refers to activity_main.xml layout file
**/

package edu.indiana.bluesguitarriffs;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;
import java.util.Vector;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button rateBeg = (Button)this.findViewById(R.id.ratebeg);
        final ViewPager pager = (ViewPager) findViewById(R.id.viewPager);
        pager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager()));

        pager.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                pager.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });
        
        // setting up the ability to go to rating page        
        rateBeg.setOnClickListener(new OnClickListener(){

            public void onClick(View v) {
            	final Uri uri = Uri.parse("market://details?id=" + getApplicationContext().getPackageName());
            	final Intent rateAppIntent = new Intent(Intent.ACTION_VIEW, uri);

            	if (getPackageManager().queryIntentActivities(rateAppIntent, 0).size() > 0) {
            	    startActivity(rateAppIntent);
            	}
            	else {
            		Toast.makeText(getApplicationContext(), "Unable to open Marketplace.", Toast.LENGTH_SHORT).show();
            	}
            }
        });
        
    }

    private class MyFragmentPagerAdapter extends FragmentPagerAdapter {

        public MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch(position) {
                case 0: return PageFragment.newInstance(1);
                case 1: return PageFragment.newInstance(2);
                case 2: return PageFragment.newInstance(3);
                case 3: return PageFragment.newInstance(4);
                case 4: return PageFragment.newInstance(5);
                default: return PageFragment.newInstance(1);
            }
        }

        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "Page " + (position + 1);
        }
    }
}
