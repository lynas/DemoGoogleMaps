package com.gsa;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.widget.TextView;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.graphics.drawable.ColorDrawable;

public class LastFiveLocationActivity extends BaseActivity implements ActionBar.TabListener {
	ActionBar actionber;
	ViewPager viewpager;
	FragmentPageAdapter fpa;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.last_five_location_layout);
		viewpager = (ViewPager) findViewById(R.id.lfviewpager);
		fpa = new FragmentPageAdapter(getSupportFragmentManager());
		actionber = getActionBar();
		viewpager.setAdapter(fpa);
		
		
		actionber.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		actionber.addTab(actionber.newTab().setTabListener(this));
		actionber.addTab(actionber.newTab().setTabListener(this));
		
		
		
		Tab tab = actionber.newTab();
		tab.setTabListener(this);
		tab.setCustomView(R.layout.custom_tab);
		
		TextView ttv = (TextView)tab.getCustomView().findViewById(R.id.textViewTabTitle);
		ttv.setText("TTTAB");
		
		actionber.addTab(tab);
		
		//actionber.setStackedBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.c1)));
		
		viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				actionber.setSelectedNavigationItem(arg0);
				
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	@Override
	public void onTabReselected(Tab arg0, android.app.FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabSelected(Tab arg0, android.app.FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabUnselected(Tab arg0, android.app.FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}



}
