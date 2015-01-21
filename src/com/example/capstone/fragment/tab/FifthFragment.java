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


public class FifthFragment extends Fragment {
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
		
		Calamity calamity1 = new Calamity("원전사고", "원전시설 방사능 누출시 행동요령");
		calamity1.setUrl("https://www.evernote.com/shard/s431/sh/cc94f2c8-2a06-4c00-bcd7-92d28c322e9f/ac20e0cf0083c119e3f6fd181874a7fd");
		Calamity calamity2 = new Calamity("공동구재난", "공동구재난 사고 발생시 국민행동요령");
		calamity2.setUrl("https://www.evernote.com/shard/s431/sh/3d49c617-da7e-484a-b463-31ac4141643b/edd5248f913e092d390fe486ecf37713");
		Calamity calamity3 = new Calamity("가축질병", "국가재난형 가축질병 국민행동요령");
		calamity3.setUrl("https://www.evernote.com/shard/s431/sh/c24a1ea0-9e7a-4217-b1bf-5f3e2ffd1e79/a1c4eb0c3fe78e54e753891d075310f0");
		Calamity calamity4 = new Calamity("전력분야 ", "전력분야 정전시 국민행동요령");
		calamity4.setUrl("https://www.evernote.com/shard/s431/sh/c0c3f608-f799-4a55-a54c-b87e7fcc8656/b3351b30d9d8a18de2f329bd0b5d0257");
		Calamity calamity5 = new Calamity("금융전산", "금융전산(보이스피싱) 국민행동요령");
		calamity5.setUrl("https://www.evernote.com/shard/s431/sh/e9d37884-1ae4-4994-9e52-a7efd910056b/8d8002641d08d94d06c8fb447cbe32c6");
		Calamity calamity6 = new Calamity("감염병예방", "감염병 예방을 위한 국민행동요령");
		calamity6.setUrl("https://www.evernote.com/shard/s431/sh/b9c239da-fe5a-473e-bafb-40bb83177900/b4ae0741d523a4809224aaaa94af7867");
		Calamity calamity7 = new Calamity("화확물질사고", "화학물질 사고 발생시 국민행동요령");
		calamity7.setUrl("https://www.evernote.com/shard/s431/sh/1377b6cd-c619-4f07-9346-7f5ea46ef92c/9ca40c3a967dce1ed97c6273b7907e3f");
		
		list.add(calamity1);
		list.add(calamity2);
		list.add(calamity3);
		list.add(calamity4);
		list.add(calamity5);
		list.add(calamity6);
		list.add(calamity7);
		
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
