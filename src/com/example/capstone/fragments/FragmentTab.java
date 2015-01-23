package com.example.capstone.fragments;


import info.androidhive.slidingmenu.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.capstone.adapter.PagerAdapter;
import com.example.capstone.view.PagerSlidingTabStrip;


public class FragmentTab extends Fragment{

	private ViewPager viewPager;
	private PagerAdapter pagerAdapter;
	private PagerSlidingTabStrip tabs;


	public FragmentTab() {
		super();
	}


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		View view = inflater.inflate(R.layout.fragment_tab, container, false);
		
		viewPager = (ViewPager) view.findViewById(R.id.square_tab_frag_pager);
		tabs = (PagerSlidingTabStrip) view.findViewById(R.id.square_tab_frag_tab);

		/*
		 * Set Tab
		 */
		
		// Create the adapter that will return a fragment for each of the three
		// primary sections of the activity.
		pagerAdapter = new PagerAdapter(getFragmentManager());

		// Set up the ViewPager with the sections adapter.
		viewPager.setAdapter(pagerAdapter);
		viewPager.setCurrentItem(0);

		// Set up tabs with the view pager
		tabs.setStartTab(0);
		tabs.setViewPager(viewPager);
		tabs.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int position) {
			}
			@Override
			public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
			}
			@Override
			public void onPageScrollStateChanged(int state) {
			}
		});

		return view;
	}
}

