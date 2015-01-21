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


public class SecondFragment extends Fragment {
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
		
		
		Calamity calamity1 = new Calamity("화재", "화재 국민행동요령 매뉴얼");
		calamity1.setUrl("https://www.evernote.com/shard/s431/sh/0bcb3a32-f3f3-4c4c-b446-70cd29420bb1/99edf712dcfead3eca844230d0ab5ecd");

		Calamity calamity2 = new Calamity("산불", "산불 국민행동요령 매뉴얼");
		calamity2.setUrl("https://www.evernote.com/shard/s431/sh/a4be3786-9a24-41aa-b1bf-d0965191198a/2c369db44e5a045b94975705848d3f62");

		list.add(calamity1);
		list.add(calamity2);
		
		
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
