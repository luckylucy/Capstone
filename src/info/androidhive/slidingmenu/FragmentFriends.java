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

public class FragmentFriends extends Fragment {

	Button Kakao;
	Button SMS;
	Button Community;
	
	public FragmentFriends(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_friends, container, false);
         
    	Kakao = (Button)rootView.findViewById(R.id.KakaoTalkToFriend);
		Kakao.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				Intent sendMessage = new Intent(getActivity(), SendMessage.class);
				startActivity(sendMessage);
			}
			
		});
	
		SMS= (Button)rootView.findViewById(R.id.SMSToFriend);
		SMS.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent SendIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:01020158382"));
				SendIntent.putExtra("sms_body", "살려주세요");
				startActivity(SendIntent);
			}			
		});
		
		Community = (Button)rootView.findViewById(R.id.AskCommunityForHelp);
		Community.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				
			}
			
		});
		return rootView;
	}
}

