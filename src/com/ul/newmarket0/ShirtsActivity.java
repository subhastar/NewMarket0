package com.ul.newmarket0;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class ShirtsActivity extends Activity {
	private static int REQUEST_CODE_SHIRT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shirts);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.shirts, menu);
        return true;
    }
    
    public boolean onOptionsItemSelected(MenuItem item) {
    	switch(item.getItemId()) {
    	case R.id.action_add:
    		launchAddShirtView();
    		return true;
    	default:
    		return super.onOptionsItemSelected(item);
    	}
    }
    
    private void launchAddShirtView() {
    	Intent i = new Intent(getApplicationContext(), ShirtActivity.class);
    	startActivityForResult(i, REQUEST_CODE_SHIRT);
    }
}