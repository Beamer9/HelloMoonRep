package com.comsi.android.hellomoon;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;

public class HelloMoonActivity extends FragmentActivity  {
	
	private static final String TAG = "HelloMoonActivity class";
	
	
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
		Log.i (TAG,"onSaveInstanceState"+ getFragmentManager() );
    	
    }

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.i (TAG,"onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hello_moon);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.hello_moon, menu);
		return true;
	}

}
