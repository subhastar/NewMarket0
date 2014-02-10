package com.ul.newmarket0;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.ul.newmarket0.model.Shirt;

public class ShirtsActivity extends Activity {
	private static int REQUEST_CODE_SHIRT = 1;
	
	private ArrayList<Shirt> shirts;
	private ShirtsAdapter shirtsAdapter;
	private ListView lvShirts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shirts);
        
        //TODO: update to java 7 so i can use <>
        shirts = new ArrayList<Shirt>();
        shirtsAdapter = new ShirtsAdapter(this, shirts);
        lvShirts = (ListView) findViewById(R.id.lvShirts);
        lvShirts.setAdapter(shirtsAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.shirts, menu);
        return true;
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	if (resultCode == RESULT_OK && requestCode == REQUEST_CODE_SHIRT) {
    		Shirt shirt = (Shirt) data.getSerializableExtra("shirt");
    		shirtsAdapter.add(shirt);
    		//add shirt to the list view
    	}
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