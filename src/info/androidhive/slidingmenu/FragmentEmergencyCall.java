package info.androidhive.slidingmenu;

import java.io.IOException;
import java.util.logging.Level;

import android.os.*;
import android.app.Activity;
import android.content.*;
import android.widget.*;
import java.util.List;
import java.util.Locale;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.BatteryManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class FragmentEmergencyCall extends Fragment implements OnClickListener {
	
	Button phone;
	Button sms;
	Button first_aid;
	String targetName=null;
	String targetNumber;
	public ProgressBar pb1=null;
	
	private GPSInfo gps;
	private CurrentLocation location;
	String address;
	
	public FragmentEmergencyCall(){}
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_emergencycall, container, false);
        final CharSequence [] itmes ={"화재신고 119", "범죄신고 112", "해양신고 122", "국가안보 111", "산악신고 1688-3119", "TEST용"};
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
      
        builder.setSingleChoiceItems(itmes, 0, new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				switch(which){
				case 0 :
					targetName="화재신고 119"; targetNumber="119";
					break;
				case 1:
					targetName="범죄신고 112"; targetNumber="112";
					break;
				case 2:
					targetName="해양신고 122"; targetNumber="122";
					break;
				case 3:
					targetName="국가안보 111"; targetNumber="111";
					break;
				case 4:
					targetName="산악신고 1688-3119"; targetNumber="16883119";
					break;
				case 5:
					targetName="TEST용"; targetNumber="01024226891";
					break;
				default:
					targetName="화재신고 119"; targetNumber="119";
				}
				dialog.dismiss();
			}
		});
        builder.show();
        
        phone = (Button)rootView.findViewById(R.id.phone);
        phone.setOnClickListener(this);
        
        sms = (Button)rootView.findViewById(R.id.sms);
        sms.setOnTouchListener(new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				if(v.getId() == R.id.sms){
					switch (event.getAction()){
				
					case MotionEvent.ACTION_DOWN:
						pb1.setVisibility(ProgressBar.VISIBLE);
			   			startProgressBarThread();
						break;
					case MotionEvent.ACTION_UP:
						if (CurrentPosition != 100){
							stopProgressBarThread();
							break;
						}
						
						else if (CurrentPosition == 100){
							location = new CurrentLocation(getActivity());
							stopProgressBarThread();
							String destination = targetNumber;
							String message = location.ReadyForSendMessage();
							Toast.makeText(getActivity().getApplicationContext(), message, Toast.LENGTH_SHORT).show();
							SmsManager smsMgr = SmsManager.getDefault();
							smsMgr.sendTextMessage(destination, null, message, null, null);
							break;
						}
					default:
						break;
					}
				}
				
				return false;
			}

		});
        
 
        pb1 = (ProgressBar)rootView.findViewById(R.id.pb1);
        pb1.setVisibility(ProgressBar.GONE);
        
        IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        filter.addAction(Intent.ACTION_BATTERY_LOW);  // ���͸��� ����
        filter.addAction(Intent.ACTION_BATTERY_OKAY);  // ���͸��� ����
        filter.addAction(Intent.ACTION_POWER_CONNECTED);  // �������̺� ����
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED);  // �������̺� �и�
        getActivity().registerReceiver(mBatteryRecv, filter);
        
		return rootView;
    }

	public void onDestroy() {
        super.onDestroy();
        getActivity().unregisterReceiver(mBatteryRecv);
    }
 
    public void showLevel(Intent intent) {
        int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, 100);
        int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
        int percent = (int)((float)level / (float)scale * 100.);

        if( percent <= 90){
			android.provider.Settings.System.putInt(getActivity().getContentResolver(),"screen_brightness",80);

        }
    }
    
    BroadcastReceiver mBatteryRecv = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            showLevel(intent);
        }
    };
    
	@Override
	public void onClick(View v) {
		
		switch(v.getId()){
			case R.id.phone :
				Intent i = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+targetNumber));
                startActivity(i);
	   			break;
			default:
				break;
		}
	}
	
	private volatile Thread theProgressBarThread1;
   	public int CurrentPosition = 0;
   	
   	private synchronized void startProgressBarThread(){
   		if(theProgressBarThread1 == null){
   			theProgressBarThread1 = new Thread(null, backgroundThread1, "startProgressBarThread");
   			CurrentPosition = 0;
   			theProgressBarThread1.start();
   		}
   	}
   	
   	private synchronized void stopProgressBarThread(){
   		if(theProgressBarThread1 != null){
   			Thread tmpThread = theProgressBarThread1;
   			theProgressBarThread1 = null;
   			tmpThread.interrupt();
   		}
   		pb1.setVisibility(ProgressBar.GONE);
   	}
   	
   	private Runnable backgroundThread1 = new Runnable(){
   		@Override
   		public void run(){
   			if(Thread.currentThread() == theProgressBarThread1){
   				CurrentPosition = 0;
   				final int total = 100;
   				while(CurrentPosition < total) {
   					try{
   						progressBarHandle.sendMessage(progressBarHandle.obtainMessage());
   						Thread.sleep(30);
   					} catch(final InterruptedException e) {
   						return;
   					} catch(final Exception e) {
   						return;
   					}
   				}
   			}
   		}
   		
   		Handler progressBarHandle = new Handler() {
   			@Override
   			public void handleMessage(Message msg) {
   				CurrentPosition++;
   				pb1.setProgress(CurrentPosition);
   					if(CurrentPosition == 100){
   		   	   			
   		   	   			stopProgressBarThread();
   		   	   		}
   			}
   		};
   	};
}
