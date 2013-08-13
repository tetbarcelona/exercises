package com.klabcyscorpions.exercises;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.TextView;

public class SingleItemView extends Activity {
    // Declare Variables 
    String name;
    String location;
    String contact;
    String image;
    ProgressDialog mProgressDialog;
    Bitmap bmImg = null;
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from singleitemview.xml
        setContentView(R.layout.single_item_view);


		//Convert JSON image string to Bitmap	
        try {
 		URL url = new URL(getIntent().getStringExtra("image"));
                HttpURLConnection conn = (HttpURLConnection) url
                        .openConnection();
                conn.setDoInput(true);
                conn.connect();
                InputStream is = conn.getInputStream();
                bmImg = BitmapFactory.decodeStream(is);
        }
                catch (IOException e) {
                    Log.e("Error", e.getMessage());
                    e.printStackTrace();
                }

           TextView txtrank = (TextView) findViewById(R.id.name);
            TextView txtcountry = (TextView) findViewById(R.id.location);
            TextView txtpopulation = (TextView) findViewById(R.id.contact);
            final ImageView img = (ImageView) findViewById(R.id.image);
 
            
            txtrank.setText(getIntent().getStringExtra("name"));
            txtcountry.setText(getIntent().getStringExtra("location"));
            txtpopulation.setText(getIntent().getStringExtra("contact"));
 
            // Set results to the ImageView
            img.setImageBitmap(bmImg);      
            img.setOnTouchListener(new OnTouchListener(){

				@Override
				public boolean onTouch(View v, MotionEvent event) {
					// TODO Auto-generated method stub
					Log.v("tet", "CLICKED");					
						Intent i = new Intent(getBaseContext(), SingleBitmap.class);
						i.putExtra("image", bmImg);
						startActivity(i);
						return true;
				}
            	
            });
    }
    
}