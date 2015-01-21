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

public class ThirdFragment extends Fragment {
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
		
		
		Calamity calamity1 = new Calamity("교통사고", "교통사고 국민행동요령 매뉴얼");
		calamity1.setUrl("https://www.evernote.com/shard/s431/sh/0a03b31c-da5e-4063-aac7-1ddeab4ca385/4be760227672bb9ee542910c3c1d3a09");

		Calamity calamity2 = new Calamity("승강기사고", "승강기사고 국민행동요령 매뉴얼");
		calamity2.setUrl("https://www.evernote.com/shard/s431/sh/34703a7c-f620-41b0-bfab-91659ec53ffc/f47bb569d6e8b3d8a883aa92de7e69bc");
		Calamity calamity3 = new Calamity("철도사고", "지하철 사고 발생시 국민행동요령");
		calamity3.setUrl("https://www.evernote.com/shard/s431/sh/58d00cfb-5f84-4741-93ae-4390ab0ac87d/b79b515b715750234ec5048acefe898d");
		
		list.add(calamity1);
		list.add(calamity2);
		list.add(calamity3);
		
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
