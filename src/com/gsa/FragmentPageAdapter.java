package com.gsa;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class FragmentPageAdapter extends FragmentPagerAdapter{

	public FragmentPageAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public Fragment getItem(int arg0) {
		
		switch (arg0) {
		case 0:
			return new FragmentLocation1();
		case 1:
			return new FragmentLocation2();
		case 2:
			return new FragmentLocation3();

		default:
			return new FragmentLocation1();
		}
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 3;
	}

}
