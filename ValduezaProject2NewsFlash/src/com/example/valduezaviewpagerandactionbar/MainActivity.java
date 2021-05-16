package com.example.valduezaviewpagerandactionbar;

import java.util.List;
import java.util.Vector;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.app.ActionBar.Tab;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;

public class MainActivity extends FragmentActivity implements ActionBar.TabListener {

	private ViewPager viewPager;
	private PagerAdapter pagerAdapter;
	private ActionBar actionBar;
	
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        setTitle("News Flash");
        getActionBar().setIcon(R.drawable.newsflashicon);
        
        List<Fragment> fragments = new Vector<Fragment>();
        fragments.add(Fragment.instantiate(this, Fragment1.class.getName()));
        fragments.add(Fragment.instantiate(this, Fragment2.class.getName()));
        
        pagerAdapter = new PagerAdapter(getSupportFragmentManager(), fragments);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(pagerAdapter);
        
        actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        
		actionBar.addTab(actionBar.newTab().setText("Technology").setTabListener(this));
		actionBar.addTab(actionBar.newTab().setText("Sports").setTabListener(this));
		
		viewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
			public void onPageSelected(int position){
				actionBar.setSelectedNavigationItem(position);
			}
		});
		
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    /*on swiping, make respective tab selected*/
    public void onTabReselected(Tab tab, FragmentTransaction ft) {
    }
    public void onTabSelected(Tab tab, FragmentTransaction ft) {
        // on tab selected
        // show respected fragment view
        viewPager.setCurrentItem(tab.getPosition());
    }
    public void onTabUnselected(Tab tab, FragmentTransaction ft) {
    }
    
}
