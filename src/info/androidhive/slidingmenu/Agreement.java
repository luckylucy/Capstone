package info.androidhive.slidingmenu;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.Toast;

public class Agreement extends Activity{
	CheckBox Agreement;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.agreement);
		
		 Agreement = (CheckBox) findViewById(R.id.agreement);
	     Agreement.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View arg0) {
					Intent goMain = new Intent(Agreement.this, MainActivity.class);
					startActivity(goMain);
				}
	        	
	        });
	     
	     WifiManager wManager_ = null;
	     wManager_ = (WifiManager)getSystemService(Context.WIFI_SERVICE);
	     wManager_.setWifiEnabled(true);
	        
	     chkGpsService();
	 }
	//GPS ���� üũ
    private boolean chkGpsService() {
     
     String gps = android.provider.Settings.Secure.getString(getContentResolver(), android.provider.Settings.Secure.LOCATION_PROVIDERS_ALLOWED);
       
     Log.d(gps, "aaaa");  
     
     if (!(gps.matches(".*gps.*") && gps.matches(".*network.*"))) {
    
	      // GPS OFF �϶� Dialog ǥ�� 
	      AlertDialog.Builder gsDialog = new AlertDialog.Builder(this); 
	      gsDialog.setTitle("��ġ ���� ����");   
	      gsDialog.setMessage("���� ��Ʈ��ũ ���, GPS ���� ����� ��� üũ�ϼž� ��Ȯ�� ��ġ ���񽺰� �����մϴ�.\n��ġ ���� ����� �����Ͻðڽ��ϱ�?"); 
	      gsDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() { 
	       
	    	  public void onClick(DialogInterface dialog, int which) { 
	    		  // GPS���� ȭ������ �̵� 
	    		  Intent intent = new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS); 
	    		  intent.addCategory(Intent.CATEGORY_DEFAULT); 
	    		  startActivity(intent); 
	    	  } 
	      }) .setNegativeButton("NO", new DialogInterface.OnClickListener() {
	    	  	public void onClick(DialogInterface dialog, int which) {
	    	  		return;
	    	  	}
	      }).create().show();
      
	      return false;
      } 
     else { 
    	 return true; 
     } 
   }
}
