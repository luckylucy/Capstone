package info.androidhive.slidingmenu;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class FragmentFlash extends Fragment {
//flag to detect flash is on or off
	private boolean isLighOn = false;
	private Camera camera;
	private Button button;
 
	
	public FragmentFlash(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_flash, container, false);
        button = (Button)rootView.findViewById(R.id.buttonFlashlight);
        
		Context context = getActivity();
		PackageManager pm = context.getPackageManager();
 
		// if device support camera?
		if (!pm.hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
			Log.e("err", "Device has no camera!");
		}
 
		camera = Camera.open();
		final Parameters p = camera.getParameters();
 
		button.setOnClickListener(new OnClickListener() {
 
			@Override
			public void onClick(View arg0) {
 
				if (isLighOn) {
 
					Log.i("info", "torch is turn off!");
 
					p.setFlashMode(Parameters.FLASH_MODE_OFF);
					camera.setParameters(p);
					camera.stopPreview();
					isLighOn = false;
 
				} else {
 
					Log.i("info", "torch is turn on!");
 
					p.setFlashMode(Parameters.FLASH_MODE_TORCH);
 
					camera.setParameters(p);
					camera.startPreview();
					isLighOn = true;
 
				}
 
			}
		});
 
	
        return rootView;
	}

	@Override
	public void onStop() {
		super.onStop();
 
		if (camera != null) {
			camera.release();
		}
	}
}
