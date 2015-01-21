package info.androidhive.slidingmenu;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.TabHost.TabSpec;

public class IncommingCall extends Activity {
	  Button reply, reject;
	  TextView callerName, callerPhoneNumber;
	  String stringcallername1, stringcallerphonenumber1;
	  String ringtoneUri;
	  
	  int vibrateState;
	  Vibrator vibrator;
	  
	  Ringtone ringtone;
	  
	protected void onCreate(Bundle savedInstanceState) {
		  super.onCreate(savedInstanceState);
	       setContentView(R.layout.incommingcall);
	       
	       callerName = (TextView) findViewById(R.id.name);
	       callerPhoneNumber = (TextView)findViewById(R.id.number);
	       
	       
	       Intent intent= getIntent();
	    	   
	       stringcallername1= intent.getExtras().getString("stringcallername");
	       stringcallerphonenumber1= intent.getExtras().getString("stringcallerphonenumber");
	       vibrateState=intent.getExtras().getInt("vibrateState");
	       
	       ringtoneUri=intent.getExtras().getString("ringtoneUri");
	       Toast.makeText(getApplicationContext(), String.valueOf(ringtoneUri), Toast.LENGTH_SHORT).show();

	       if(vibrateState==1){
	    	  long[] pattern ={2000,1000};
	    	   vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
	    	   vibrator.vibrate(pattern, 0);

	       }
	    
	       if(ringtoneUri != null){
	    	   ringtone = RingtoneManager.getRingtone(this,  Uri.parse(ringtoneUri));
		       ringtone.play();
	       }
	       
	       callerName.setText(stringcallername1);
	       callerPhoneNumber.setText(stringcallerphonenumber1);
	       
	       
	       reply =(Button)findViewById(R.id.reply);
	       reject= (Button)findViewById(R.id.reject);
	       
	       
	       reply.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				
				Intent WaitingState = new Intent(IncommingCall.this, WaitingState.class);
				
				WaitingState.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
				WaitingState.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				
				WaitingState.putExtra("stringcallername", stringcallername1);
				WaitingState.putExtra("stringcallerphonenumber", stringcallerphonenumber1);
				startActivity(WaitingState);
				
				ringtone.stop();
				vibrator.cancel();

			}
	       });
	       reject.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent BackToTheMain = new Intent(IncommingCall.this, MainActivity.class);
				
				BackToTheMain.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
				BackToTheMain.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(BackToTheMain);
				
				ringtone.stop();
				vibrator.cancel();
				
			}

	       });
	  } 
}
