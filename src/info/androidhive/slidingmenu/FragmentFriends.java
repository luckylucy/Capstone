package info.androidhive.slidingmenu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class FragmentFriends extends Fragment implements OnClickListener{

	Button Kakao;
	Button SMS;
	Button Community;
	Button b1, b2, b3, b4, b5, b6;
	String s1, s2, s3, s4, s5, s6;
	
	CheckBox address, e1,e2,e3,e4,e5,e6,e7,e8,e9;
	EditText message;
	Button send;
	CurrentLocation location;
	
	String FullMessage;
	String CheckList=" ";
	public FragmentFriends(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_message, container, false);
         
        location= new CurrentLocation(getActivity());
		address = (CheckBox)rootView.findViewById(R.id.addressCheckBox);
		address.setText(location.ReadyForSendMessage());
		
//		e1 = (CheckBox)rootView.findViewById(R.id.emergency1);		
//		e2 = (CheckBox)rootView.findViewById(R.id.emergency2);
//		e3= (CheckBox)rootView.findViewById(R.id.emergency3);
//		e4 = (CheckBox)rootView.findViewById(R.id.emergency4);
//		e5 = (CheckBox)rootView.findViewById(R.id.emergency5);
		
		s1="물에 빠졌어요ㅠ_ㅠ";
		s2="불났쪄요ㅠ_ㅠ";
		s3="교통사고 났쪄요ㅠㅠ";
		s4="건물이 무너져여여여여ㅠㅠ";
		s5="사람이 다쳐쬬ㅠㅠ";
		s6="유괴당해쪄요ㅠㅠㅠㅠㅠ";
		b1=(Button)rootView.findViewById(R.id.button1);
		b2=(Button)rootView.findViewById(R.id.button2);
		b3=(Button)rootView.findViewById(R.id.button3);
		b4=(Button)rootView.findViewById(R.id.button4);
		b5=(Button)rootView.findViewById(R.id.button5);
		b6=(Button)rootView.findViewById(R.id.button6);
		
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		b3.setOnClickListener(this);
		b4.setOnClickListener(this);
		b5.setOnClickListener(this);
		b6.setOnClickListener(this);

		message = (EditText)rootView.findViewById(R.id.sendMessage);
    	Kakao = (Button)rootView.findViewById(R.id.KakaoToFriends);
		Kakao.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				
			}
			
		});
	
		SMS= (Button)rootView.findViewById(R.id.SMSToFriends);
		SMS.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
//				if(e1.isChecked()) CheckList +=e1.getText().toString();
//				if(e2.isChecked()) CheckList +=e2.getText().toString();
//				if(e3.isChecked()) CheckList +=e3.getText().toString();
//				if(e4.isChecked()) CheckList +=e4.getText().toString();
//				if(e5.isChecked()) CheckList +=e5.getText().toString();


				FullMessage = address.getText().toString()+"##"+CheckList+"##"+message.getText().toString();

			
				
				Intent SendIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:"));
				SendIntent.putExtra("sms_body", FullMessage);
				startActivity(SendIntent);
			}			
		});
		
		return rootView;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.button1:
			if(!b1.isSelected()){
				b1.setSelected(true);
				CheckList+=s1;
			}
			else{
				b1.setSelected(false);
				CheckList=CheckList.replace(s1, "");
			}
			break;
		case R.id.button2:
			if(!b2.isSelected()){
				b2.setSelected(true);
				CheckList+=s2;
			}
			else{
				b2.setSelected(false);
				CheckList=CheckList.replace(s2, "");
			}
			break;

		case R.id.button3:
			if(!b3.isSelected()){
				b3.setSelected(true);
				CheckList+=s3;
			}
			else{
				b3.setSelected(false);
				CheckList=CheckList.replace(s3, "");
			}
			break;

		case R.id.button4:
			if(!b4.isSelected()){
				b4.setSelected(true);
				CheckList+=s4;
			}
			else{
				b4.setSelected(false);
				CheckList=CheckList.replace(s4, "");
			}
			break;

		case R.id.button5:
			if(!b5.isSelected()){
				b5.setSelected(true);
				CheckList+=s5;
			}
			else{
				b5.setSelected(false);
				CheckList=CheckList.replace(s5, "");
			}
			break;

		case R.id.button6:
			if(!b6.isSelected()){
				b6.setSelected(true);
				CheckList+=s6;
			}
			else{
				b6.setSelected(false);
				CheckList=CheckList.replace(s6, "");
			}
			break;

		}
	}
}

