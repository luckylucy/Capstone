package info.androidhive.slidingmenu;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import android.app.Activity;
import android.content.Context;
import android.location.Address;
import android.location.Geocoder;

public class CurrentLocation {
    private final Context mContext;

	public GPSInfo gps;

	String address;

	 public CurrentLocation(Context context) {
	        this.mContext = context;
	    }
	 
	public String ReadyForSendMessage() {

		 gps = new GPSInfo(mContext);
          
		 if (gps.isGetLocation()) {
               double latitude = gps.getLatitude();
               double longitude = gps.getLongitude();
               address=String.valueOf(findAddress(latitude, longitude));
           } else 
           {
               gps.showSettingsAlert();
           }
			return address;
	}

	public StringBuffer findAddress(double lat, double lng) {
		StringBuffer bf = new StringBuffer();
       Geocoder geocoder =  new Geocoder(mContext, Locale.KOREA);

       List<Address> address;
       try {
         if (geocoder != null) {
               address = geocoder.getFromLocation(lat, lng, 1);
              if (address != null && address.size() > 0) {
                   String currentLocationAddress = address.get(0).getAddressLine(0).toString();
                   
                   bf.append(currentLocationAddress).append("#");
                   bf.append(lat).append("#");
                   bf.append(lng);
               }
           }
           
        } catch (IOException e) {
         //  Toast.makeText(getApplicationContext(), "Exception Error", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
		return bf;			
	}

}
