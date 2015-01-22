package info.androidhive.slidingmenu;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class FragmentSendMessage extends Activity {
	private static final int SHOW_CONTACT=1;
	CheckBox address, e1,e2,e3,e4,e5,e6,e7,e8,e9;
	EditText message;
	Button send;
	CurrentLocation location;
	
	String FullMessage;
	String CheckList=" ";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.message);
		
		location= new CurrentLocation(FragmentSendMessage.this);
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
				if(e1.isChecked()) CheckList +=e1.getText().toString();
				if(e2.isChecked()) CheckList +=e2.getText().toString();
				if(e3.isChecked()) CheckList +=e3.getText().toString();
				if(e4.isChecked()) CheckList +=e4.getText().toString();
				if(e5.isChecked()) CheckList +=e5.getText().toString();
				if(e6.isChecked()) CheckList +=e6.getText().toString();
				if(e7.isChecked()) CheckList +=e7.getText().toString();
				if(e8.isChecked()) CheckList +=e8.getText().toString();
				if(e9.isChecked()) CheckList +=e9.getText().toString();

				FullMessage = address.getText().toString()+"##"+CheckList+"##"+message.getText().toString();

				
				Intent contactPeople1 = new Intent(Intent.ACTION_PICK);
				contactPeople1.setData(ContactsContract.CommonDataKinds.Phone.CONTENT_URI);
				startActivityForResult(contactPeople1,0);
				
//				Intent SendIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:"));
//				SendIntent.putExtra("sms_body", FullMessage);
//				startActivity(SendIntent);
			}
			
		});
		
			
	}
	public void onActivityResult(int requestCode, int resultCode, Intent data){
		super.onActivityResult(requestCode, resultCode, data);
		
	}
	
	
}