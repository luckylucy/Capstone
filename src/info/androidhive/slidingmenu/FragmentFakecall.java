package info.androidhive.slidingmenu;

import java.util.ArrayList;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class FragmentFakecall extends Fragment implements OnClickListener {
	private static final int SHOW_CONTACT=1;
	private static final int SHOW_RING=2;
	
	ArrayList arraylist=null;
	
	Button phoneBook, date, ring, ok;
	Button start, start5, start30, start60, start300;
	EditText callerName, callerPhoneNumber;
	
	String stringcallername=null, stringcallerphonenumber=null;
	AlertDialog.Builder empty=null;
	
	Switch vibrationSwitch;
	
	Spinner secSpinner;
	
	Ringtone ringtone ;
	String ringtoneName;
	Uri ringtoneUri;
	
	int year, month, day;
	int second;
	int vibrateState=1;
	
	public FragmentFakecall(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_fackecall, container, false);
         
        callerName = (EditText)rootView.findViewById(R.id.callerName);
		callerPhoneNumber=(EditText)rootView.findViewById(R.id.callerPhoneNumber);
		
		phoneBook=(Button)rootView.findViewById(R.id.phoneBook); 
		phoneBook.setOnClickListener(new Button.OnClickListener(){
		
			@Override
			public void onClick(View v) {
				Intent contactPeople = new Intent(Intent.ACTION_PICK);
				contactPeople.setData(ContactsContract.CommonDataKinds.Phone.CONTENT_URI);
				startActivityForResult(contactPeople,SHOW_CONTACT);
				
			}
		});
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		ring=(Button)rootView.findViewById(R.id.ring);
		ring.setOnClickListener(new OnClickListener(){
		
			@Override
			public void onClick(View arg0) {
				Intent ringIntent = new Intent(RingtoneManager.ACTION_RINGTONE_PICKER);
				startActivityForResult(ringIntent, SHOW_RING);
			}
		});
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		vibrationSwitch= (Switch)rootView.findViewById(R.id.vibrationSwitch);
		vibrationSwitch.setChecked(true);
		vibrationSwitch.setOnCheckedChangeListener(new OnCheckedChangeListener(){
		
			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
				if(arg1==true)vibrateState=1; 
				else vibrateState=0;
				
				}
			});
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
//		secSpinner = (Spinner) rootView.findViewById(R.id.secSpinner);
//		
//		arraylist = new ArrayList<String>();
//		arraylist.add("	바로시작");
//		arraylist.add("5초 후 ");
//		arraylist.add("15초 후 ");
//		arraylist.add("30초 후 ");
//		arraylist.add("1분 후");
//		arraylist.add("5분 후");
//		arraylist.add("30분 후 ");
//		
//		ArrayAdapter <String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item,arraylist);
//		secSpinner.setPrompt("골라봐!");
//		secSpinner.setAdapter(adapter);
//		
//		secSpinner.setOnItemSelectedListener(new OnItemSelectedListener(){
//		
//			@Override
//			public void onItemSelected(AdapterView<?> arg0, View arg1,int arg2, long arg3) {
//			switch(arg2){
//				case 1: second=5; break;
//				case 2: second=15; break;
//				case 3: second=30; break;
//				case 4: second=60; break;
//				case 5: second=60*5; break;
//				case 6: second=60*30; break;
//				default: second=0;	
//			}
//		}
//			@Override
//			public void onNothingSelected(AdapterView<?> arg0) {
//				
//			}
//		});
		start=(Button)rootView.findViewById(R.id.start);
		start5=(Button)rootView.findViewById(R.id.start5);
		start30=(Button)rootView.findViewById(R.id.start30);
		start60=(Button)rootView.findViewById(R.id.start60);
		start300=(Button)rootView.findViewById(R.id.start300);
		
		start.setOnClickListener(this);
		start5.setOnClickListener(this);
		start30.setOnClickListener(this);
		start60.setOnClickListener(this);
		start300.setOnClickListener(this);

		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		

		ok=(Button)rootView.findViewById(R.id.OK);
		ok.setOnClickListener(new OnClickListener(){
		
			@Override
			public void onClick(View arg0) {
				if(stringcallername==null || stringcallerphonenumber ==null){
					Toast.makeText(getActivity(), "null", Toast.LENGTH_SHORT).show();

					AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
					alert.setPositiveButton("확인", new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							dialog.dismiss();
						}
					});
					alert.setMessage("이름과 전화번호를 입력해주세요");
					alert.show();
				}
				else
					setAlarm(getActivity(), second);
			}
		});
        return rootView;
    }
	
	private void setAlarm(Context context, long second){
		
		AlarmManager alarmManager = (AlarmManager) getActivity().getSystemService(Context.ALARM_SERVICE);
		Intent incommingIntent = new Intent(getActivity() , IncommingCall.class);
		
		incommingIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
		incommingIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		
		stringcallername=callerName.getText().toString();
		stringcallerphonenumber=callerPhoneNumber.getText().toString();
		
		if(stringcallername==null || stringcallerphonenumber==null){
			empty = new AlertDialog.Builder(getActivity());
			empty.setTitle("이름과 전화번호를 입력해주세요!");
			empty.setCancelable(false);
			empty.setPositiveButton("확인", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				//getActivity().finish();
			}
		});
		
		empty.show();
		}
		else{
	
			incommingIntent.putExtra("stringcallername", stringcallername);
			incommingIntent.putExtra("stringcallerphonenumber", stringcallerphonenumber);
			incommingIntent.putExtra("vibrateState", vibrateState);
			
			if(ringtoneUri==null)
				incommingIntent.putExtra("ringtoneUri", "null");
			else
				incommingIntent.putExtra("ringtoneUri", ringtoneUri.toString());
			
			PendingIntent pIntent = PendingIntent.getActivity(getActivity().getApplicationContext(), 0, incommingIntent, PendingIntent.FLAG_UPDATE_CURRENT);
			
			alarmManager.set(AlarmManager.RTC, System.currentTimeMillis()+second*1000, pIntent);
			
			stringcallername=null;
			stringcallerphonenumber=null;
		}
	}
	
	public void onActivityResult(int requestCode, int resultCode, Intent data){
		super.onActivityResult(requestCode, resultCode, data);
		
		if(data==null){
		Toast.makeText(getActivity().getApplicationContext(), "Data null", Toast.LENGTH_SHORT).show();
		
		}
		
		switch(requestCode){
			case SHOW_CONTACT:
			if(data==null){
				callerName.setText(null);
				callerPhoneNumber.setText(null);
				break;
			}
			else{
				Cursor cursor = getActivity().getContentResolver().query(data.getData(), 
						new String[]{ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,ContactsContract.CommonDataKinds.Phone.NUMBER}, null,null,null);
		
			cursor.moveToFirst();
			
			callerName.setText(cursor.getString(0));
			callerPhoneNumber.setText(cursor.getString(1));
			cursor.close();
			
			stringcallername=callerName.getText().toString();
			stringcallerphonenumber=callerPhoneNumber.getText().toString();
			
			Toast.makeText(getActivity().getApplicationContext(), stringcallername, Toast.LENGTH_SHORT).show();
			Toast.makeText(getActivity().getApplicationContext(), stringcallerphonenumber, Toast.LENGTH_SHORT).show();
			
//			stringcallername=null;
//			stringcallerphonenumber=null;
			break;
		}
		
		
		case SHOW_RING:
			if(data==null){
				ring.setText("벨소리▶무음◀");
			break;
			}
			
			else{
			ringtoneUri = data.getParcelableExtra(RingtoneManager.EXTRA_RINGTONE_PICKED_URI);
			
			ringtone = RingtoneManager.getRingtone(getActivity(),  ringtoneUri);
			ringtoneName = ringtone.getTitle(getActivity());
			ring.setText("벨소리▶"+ringtoneName+"◀");
			break;
		}
	}
}

	@Override
	public void onClick(View v) {
		if(v==start){
			start.setSelected(true);
			start5.setSelected(false);
			start30.setSelected(false);
			start60.setSelected(false);
			start300.setSelected(false);
			second=0;
		}
		else if(v==start5){
			start.setSelected(false);
			start5.setSelected(true);
			start30.setSelected(false);
			start60.setSelected(false);
			start300.setSelected(false);	
			second=5;
		}
		else if(v==start30){
			start.setSelected(false);
			start5.setSelected(false);
			start30.setSelected(true);
			start60.setSelected(false);
			start300.setSelected(false);
			second=30;
		}
		else if(v==start60){
			start.setSelected(false);
			start5.setSelected(false);
			start30.setSelected(false);
			start60.setSelected(true);
			start300.setSelected(false);	
			second=60;	
		}
		else {
			start.setSelected(false);
			start5.setSelected(false);
			start30.setSelected(false);
			start60.setSelected(false);
			start300.setSelected(true);
			second=60*30;
		}
			
		
	}	
	
}
