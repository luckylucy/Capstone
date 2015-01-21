package info.androidhive.slidingmenu;
/*
 * Copyright (C) 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.capstone.view.SlidingTabLayout;

/**
 * A basic sample which shows how to use {@link com.example.capstone.view.SlidingTabLayout}
 * to display a custom {@link ViewPager} title strip which gives continuous feedback to the user
 * when scrolling.
 */
public class SlidingTabsBasicFragment extends Fragment {

    static final String LOG_TAG = "SlidingTabsBasicFragment";
    private SlidingTabLayout mSlidingTabLayout;
    private ViewPager mViewPager;
	
    
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_emergencyinfo, container, false);
     
    }
	
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // BEGIN_INCLUDE (setup_viewpager)
        // Get the ViewPager and set it's PagerAdapter so that it can display items
        mViewPager = (ViewPager) view.findViewById(R.id.viewpager);
        mViewPager.setAdapter(new SamplePagerAdapter());
        // END_INCLUDE (setup_viewpager)

        // BEGIN_INCLUDE (setup_slidingtablayout)
        // Give the SlidingTabLayout the ViewPager, this must be done AFTER the ViewPager has had
        // it's PagerAdapter set.
        mSlidingTabLayout = (SlidingTabLayout) view.findViewById(R.id.sliding_tabs);
        mSlidingTabLayout.setViewPager(mViewPager);
        // END_INCLUDE (setup_slidingtablayout)
    }
   
    // END_INCLUDE (fragment_onviewcreated)

    public class SamplePagerAdapter extends PagerAdapter{

    	private ArrayList<View> views; 
    	
    	
        public int getCount() {
            return 6;
        }

        public boolean isViewFromObject(View view, Object o) {
            return o == view;
        }

        // BEGIN_INCLUDE (pageradapter_getpagetitle)
      

        @Override
        public CharSequence getPageTitle(int position) {
        	switch(position){
        		case 0 : return "해양";
        		case 1 : return "산악";
        		case 2 : return "화재";
        		case 3 : return "환자";
        		case 4 : return "지하철/건물";
        		case 5 : return "유괴/아이실종";
        		default : return "Item " + (position + 1);
        	}
        	
           
        }
        // END_INCLUDE (pageradapter_getpagetitle)

        
        public Object instantiateItem(ViewGroup container, int position) {
        	View view = getActivity().getLayoutInflater().inflate(R.layout.pager_item,
                    container, false);
        	container.addView(view);
        	//ImageView image = (ImageView)view.findViewById(R.id.item_title1);
        	//image.setBackgroundResource(drawable.sample_0);
        	//TextView title = (TextView) view.findViewById(R.id.item_title);
            //title.setText(String.valueOf(position + 1));
            return view;
        }
        
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
            Log.i(LOG_TAG, "destroyItem() [position: " + position + "]");
        }
    }
}