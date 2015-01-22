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
				
			}
			
		});
	
		SMS= (Button)rootView.findViewById(R.id.SMSToFriend);
		SMS.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent sendMessage = new Intent(getActivity(), FragmentSendMessage.class);
				startActivity(sendMessage);
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

