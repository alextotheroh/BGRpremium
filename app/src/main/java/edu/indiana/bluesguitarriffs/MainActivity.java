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

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ActionBar actionBar = getActionBar();
        final ViewPager pager = (ViewPager) findViewById(R.id.viewPager);
        pager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager()));

        pager.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                pager.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
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
