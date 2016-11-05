package edu.indiana.bluesguitarriffs;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ViewPager pager = (ViewPager) findViewById(R.id.viewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("1 - 10"));
        tabLayout.addTab(tabLayout.newTab().setText("11 - 20"));
        tabLayout.addTab(tabLayout.newTab().setText("21 - 30"));
        tabLayout.addTab(tabLayout.newTab().setText("31 - 40"));
        tabLayout.addTab(tabLayout.newTab().setText("41 - 50"));
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
    /**
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
     **/

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
