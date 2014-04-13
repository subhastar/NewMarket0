package com.ul.newmarket0;

import java.io.File;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.ul.newmarket0.model.Shirt;

public class ShirtActivity extends Activity {
	private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 5;

	private EditText etShirtName;
	private ImageView ivShirtPic;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shirt);
		
		etShirtName = (EditText) findViewById(R.id.etShirtName);
		ivShirtPic = (ImageView) findViewById(R.id.ivShirtPic);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.shirt, menu);
		return true;
	}
	
	public Uri getPhotoFileUri(String fileName) {
		File mediaStorageDir = new File(
				Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
				"MyCameraApp");

		// Create the storage directory if it does not exist
		if (!mediaStorageDir.exists() && !mediaStorageDir.mkdirs()){
			Log.d("MyCameraApp", "failed to create directory");
		}
		// Specify the file target for the photo
		return Uri.fromFile(new File(mediaStorageDir.getPath() + File.separator +
				fileName));
	}

	public void onLaunchCamera(View view) {
		// create Intent to take a picture and return control to the calling application
		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		intent.putExtra(MediaStore.EXTRA_OUTPUT, getPhotoFileUri("photo.jpg")); // set the image file name
		// start the image capture Intent
		startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
			Uri takenPhotoUri = getPhotoFileUri("photo.jpg");
			ivShirtPic.setImageURI(takenPhotoUri);
			// by this point we have the camera photo on disk
			//Bitmap takenImage = BitmapFactory.decodeFile(filepath);
		}
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