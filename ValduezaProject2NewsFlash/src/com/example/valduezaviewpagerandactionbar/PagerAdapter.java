package com.example.valduezaviewpagerandactionbar;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


public class PagerAdapter extends FragmentStatePagerAdapter {
	private List<Fragment> fragmentList;

	
	public PagerAdapter(FragmentManager fm,
			List<Fragment> fragmentList) {
		// TODO Auto-generated constructor stub
		super(fm);
		this.fragmentList = fragmentList;
	}

	@Override
	public Fragment getItem(int position){
		return fragmentList.get(position);
	}
	
	@Override
	public int getCount(){
		return fragmentList.size();
	}
}
