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


public class FourthFragment extends Fragment {
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
		
		
		Calamity calamity1 = new Calamity("ºØ±«", "ºØ±« ±¹¹ÎÇàµ¿¿ä·É ¸Å´º¾ó");
		calamity1.setUrl("https://www.evernote.com/shard/s431/sh/6caf2e5e-a633-4cf1-9f62-869ed0e0e2b2/ca48109035ec9cd59875b2682ad3df20");

		Calamity calamity2 = new Calamity("Æø¹ß", "Æú¹ß ±¹¹ÎÇàµ¿¿ä·É ¸Å´º¾ó");
		calamity2.setUrl("https://www.evernote.com/shard/s431/sh/1c02acac-b974-4d5c-9862-7d5133477f5e/786f48aa9d526752f728b90406f75cde");
		Calamity calamity3 = new Calamity("´ï ºØ±«","´ï ºØ±« ¹ß»ý ½Ã ±¹¹ÎÇàµ¿¿ä·É");
		calamity3.setUrl("https://www.evernote.com/shard/s431/sh/2d84a906-19fe-4f50-80ff-fdf68437059f/3e8fda35ec9a14c34c4c7cf87bec856e");
		
		
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
