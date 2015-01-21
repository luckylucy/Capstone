package com.example.capstone.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.example.capstone.fragment.tab.FifthFragment;
import com.example.capstone.fragment.tab.FirstFragment;
import com.example.capstone.fragment.tab.FourthFragment;
import com.example.capstone.fragment.tab.SecondFragment;
import com.example.capstone.fragment.tab.SixthFragment;
import com.example.capstone.fragment.tab.ThirdFragment;


public class PagerAdapter extends android.support.v4.app.FragmentStatePagerAdapter {

	private Fragment[] fragmentList;
	private String[] titles = new String[]{"�ؾ���", "ȭ��","����ö/�ǹ�","�ر�,����","��Ÿ�����糭","����óġ��"};
	

	public PagerAdapter(FragmentManager fm) {
		super(fm);
		fragmentList = new Fragment[titles.length];
		fragmentList[0] = new FirstFragment();
		fragmentList[1] = new SecondFragment();
		fragmentList[2] = new ThirdFragment();
		fragmentList[3] = new FourthFragment();
		fragmentList[4] = new FifthFragment();
		fragmentList[5] = new SixthFragment();
	}



	@Override
	public CharSequence getPageTitle(int position) {
		return titles[position];
	}

	@Override
	public Fragment getItem(int position) {
		return fragmentList[position];
	}


	@Override
	public int getCount() {
		return this.fragmentList.length;
	}
}
