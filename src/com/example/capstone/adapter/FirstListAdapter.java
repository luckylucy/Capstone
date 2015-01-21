package com.example.capstone.adapter;

import info.androidhive.slidingmenu.R;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.capstone.model.Calamity;

public class FirstListAdapter extends ArrayAdapter<Calamity> {
	private Context context;
	private TextView textView1;
	private TextView textView2;
	
	public FirstListAdapter(Context context, List<Calamity> list) {
		super(context, 0, list);
		// TODO Auto-generated constructor stub
		this.context = context;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View view = convertView;
		if (view == null) {
			LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = inflater.inflate(R.layout.adapter_layout_first, parent, false);
		}
		
		final Calamity calamity = this.getItem(position);
		
		if (calamity != null) {
			textView1 = (TextView)view.findViewById(R.id.adapter_layout_first_text_view1);
			textView2 = (TextView)view.findViewById(R.id.adapter_layout_first_text_view2);
			
			textView1.setText(calamity.getData1());
			textView2.setText(calamity.getData2());
		}
		
		return view;
	}
	
	

}
