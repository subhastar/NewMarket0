package com.ul.newmarket0;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ShirtActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shirt);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.shirt, menu);
		return true;
	}

}
