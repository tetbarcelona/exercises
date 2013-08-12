package com.klabcyscorpions.exercises;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

public class SingleBitmap extends Activity {
	Bitmap bmImg = null;
	String image;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.single_bitmap);
		
		new loadImage().execute();
	}
	public class loadImage extends AsyncTask<String, String, String>{

		@Override
		protected String doInBackground(String... args) {
			// TODO Auto-generated method stub
			try {
				 Intent i = getIntent();
				 image = i.getStringExtra("image");
				 URL url = new URL(image);
	                HttpURLConnection conn = (HttpURLConnection) url
	                        .openConnection();
	                conn.setDoInput(true);
	                conn.connect();
	                InputStream is = conn.getInputStream();
	                bmImg = BitmapFactory.decodeStream(is);
			}catch (IOException e) {
               /* Log.e("Error",e.getMessage());
                e.printStackTrace();*/
			}
			return null;
		}
		@Override
        protected void onPostExecute(String args) {
			  final ImageView img = (ImageView) findViewById(R.id.image_holder);
			  img.setImageBitmap(bmImg); 
			  Log.v("tina","Image is Set");
		}
	}

}
