package info.androidhive.slidingmenu;

import com.example.capstone.activities.SampleActivityBase;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

public class FragmentEmergencyInfo extends Fragment  {
	
	public static final String TAG = "Method";

    // Whether the Log Fragment is currently shown
    private boolean mLogShown;

//   @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.fragment_content);
//        if (savedInstanceState == null) {
//            FragmentTransaction transaction = getFragmentManager().beginTransaction();
//            SlidingTabsBasicFragment fragment = new SlidingTabsBasicFragment();
//            transaction.replace(R.id.sample_content_fragment, fragment);
//            transaction.commit();
//        }
//    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }

	public FragmentEmergencyInfo(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_content, container, false);
         
        if (savedInstanceState == null) {
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            SlidingTabsBasicFragment fragment = new SlidingTabsBasicFragment();
            transaction.replace(R.id.sample_content_fragment, fragment);
            transaction.commit();
        }
        
        return rootView;
    }
}
