package info.androidhive.slidingmenu;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class SendMessage extends Activity {
	CheckBox address, e1,e2,e3,e4,e5;
	EditText message;
	Button send;
	CurrentLocation location;
	
	String FullMessage;
	String CheckList=" ";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.message);
		
		location= new CurrentLocation(SendMessage.this);
		address = (CheckBox)findViewById(R.id.addressCheckBox);
		address.setText(location.ReadyForSendMessage());
		
		e1 = (CheckBox)findViewById(R.id.emergency1);		
		e2 = (CheckBox)findViewById(R.id.emergency2);
		e3= (CheckBox)findViewById(R.id.emergency3);
		e4 = (CheckBox)findViewById(R.id.emergency4);
		e5 = (CheckBox)findViewById(R.id.emergency5);
		
		
		message = (EditText)findViewById(R.id.sendMessage);
		send = (Button) findViewById(R.id.Send);
		send.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				if(e1.isChecked()) CheckList +=e1.getText().toString()+"/";
				if(e2.isChecked()) CheckList +=e2.getText().toString()+"/";
				if(e3.isChecked()) CheckList +=e3.getText().toString()+"/";
				if(e4.isChecked()) CheckList +=e4.getText().toString()+"/";
				if(e5.isChecked()) CheckList +=e5.getText().toString()+"/";
			

				FullMessage = address.getText().toString()+"##"+CheckList+"##"+message.getText().toString();

				Toast.makeText(getApplicationContext(), FullMessage, Toast.LENGTH_SHORT).show();
				Intent SendIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:01020158382"));
				SendIntent.putExtra("sms_body", FullMessage);
				startActivity(SendIntent);
			}
			
		});
		
	}
}