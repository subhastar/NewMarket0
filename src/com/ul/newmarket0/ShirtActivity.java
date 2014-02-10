package com.ul.newmarket0;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

import com.ul.newmarket0.model.Shirt;

public class ShirtActivity extends Activity {
	private EditText etShirtName;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shirt);
		
		etShirtName = (EditText) findViewById(R.id.etShirtName);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.shirt, menu);
		return true;
	}
	
	/** Called when a user chooses the 'save' button. */
	public void saveShirt(View view) {
		Shirt shirt = new Shirt();
		shirt.setName(etShirtName.getText().toString());
		Intent data = new Intent();
		data.putExtra("shirt", shirt);
		setResult(RESULT_OK, data);
		finish();
	}
}