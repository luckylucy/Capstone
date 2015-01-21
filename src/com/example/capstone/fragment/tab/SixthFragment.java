package com.example.capstone.fragment.tab;

import info.androidhive.slidingmenu.R;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.example.capstone.activities.WebViewActivity;
import com.example.capstone.adapter.FirstListAdapter;
import com.example.capstone.model.Calamity;


public class SixthFragment extends Fragment {
	ListView listView;
	FirstListAdapter adapter;
	List<Calamity> list;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreateView(inflater, container, savedInstanceState);
		View view = inflater.inflate(R.layout.fragment_first, container, false);
		list = new ArrayList<Calamity>();
		adapter = new FirstListAdapter(getActivity(), list);
		
		listView = (ListView)view.findViewById(R.id.first_list_view);
		
		listView.setAdapter(adapter);
		
		
		Calamity calamity1 = new Calamity("성인심폐소생술", "응급처치법 자료");
		calamity1.setUrl("https://www.evernote.com/shard/s431/sh/d3f48c22-aff7-4521-bdb2-49de0d6c424d/febf95aa3e6ece5815ad32853179da76");
		Calamity calamity2 = new Calamity("기도폐쇄", "응급처치법 자료");
		
		Calamity calamity3 = new Calamity("심장질환", "응급처치법 자료");
		Calamity calamity4 = new Calamity("출혈", "응급처치법 자료");
		Calamity calamity5 = new Calamity("골절", "응급처치법 자료");

		
		
		list.add(calamity1);
		list.add(calamity2);
		list.add(calamity3);
		list.add(calamity4);
		list.add(calamity5);
		
		adapter.notifyDataSetChanged();
		
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Calamity calamity = list.get(position);
				String url = calamity.getUrl();
				Intent intent = new Intent(getActivity(), WebViewActivity.class);
				intent.putExtra("url", url);
				startActivity(intent);
			}
		});
		
		return view;
	}
}
