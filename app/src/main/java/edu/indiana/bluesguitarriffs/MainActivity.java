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

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.pixplicity.sharp.Sharp;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        final ViewPager pager = (ViewPager) findViewById(R.id.viewPager);
        //setSupportActionBar(toolbar);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Page 1"));
        tabLayout.addTab(tabLayout.newTab().setText("Page 2"));
        tabLayout.addTab(tabLayout.newTab().setText("Page 3"));
        tabLayout.addTab(tabLayout.newTab().setText("Page 4"));
        tabLayout.addTab(tabLayout.newTab().setText("Page 5"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        pager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount()));
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class MyFragmentPagerAdapter extends FragmentPagerAdapter {
        int mNumberOfTabs;

        public MyFragmentPagerAdapter(FragmentManager fm, int tabs) {
            super(fm);
            this.mNumberOfTabs = tabs;
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
            return this.mNumberOfTabs;
        }

        @Override
        public CharSequence getPageTitle(int position) {

            //return "Page " + (position + 1);
            return "";
        }
    }
}
