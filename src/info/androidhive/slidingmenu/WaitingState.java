package info.androidhive.slidingmenu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class WaitingState extends Activity{
	
	Button end;
	TextView name1, number1;
	
	   protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.waitingstate);
	        
	        Intent intent= getIntent();
	        String stringcallername2= intent.getStringExtra("stringcallername");
	        String stringcallerphonenumber2= intent.getStringExtra("stringcallerphonenumber");
	        
	        name1= (TextView) findViewById(R.id.name1);
	        number1=(TextView)findViewById(R.id.number1);
	        
	        name1.setText(stringcallername2);
	        number1.setText(stringcallerphonenumber2);
	        
	        end=(Button) findViewById(R.id.end);
	        end.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View arg0) {
					Intent BackToTheMain = new Intent(WaitingState.this, MainActivity.class);
					
					BackToTheMain.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
					BackToTheMain.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					
					startActivity(BackToTheMain);

				}
	        });
	   }
}
