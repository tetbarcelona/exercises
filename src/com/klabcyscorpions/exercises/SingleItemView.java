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
        // Execute loadSingleView AsyncTask
        new loadSingleView().execute();
    }
 
    public class loadSingleView extends AsyncTask<String, String, String> {
 
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Create a progressdialog
            mProgressDialog = new ProgressDialog(SingleItemView.this);
            // Set progressdialog title
            mProgressDialog.setTitle("Android JSON Parsing");
            // Set progressdialog message
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setIndeterminate(false);
            // Show progressdialog
            mProgressDialog.show();
        }
 
        @Override
        protected String doInBackground(String... args) {
            try {
                // Retrieve data from ListViewAdapter on click event
                Intent i = getIntent();
                // Get the result of rank
                name = i.getStringExtra("name");
                // Get the result of country
                location = i.getStringExtra("location");
                // Get the result of population
                contact = i.getStringExtra("contact");
                // Get the result of flag
                image = i.getStringExtra("image");
 
                // Download the Image from the result URL given by flag
                URL url = new URL(image);
                HttpURLConnection conn = (HttpURLConnection) url
                        .openConnection();
                conn.setDoInput(true);
                conn.connect();
                InputStream is = conn.getInputStream();
                bmImg = BitmapFactory.decodeStream(is);
            } catch (IOException e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return null;
        }
 
        @Override
        protected void onPostExecute(String args) {
            // Locate the TextViews in singleitemview.xml
            TextView txtrank = (TextView) findViewById(R.id.name);
            TextView txtcountry = (TextView) findViewById(R.id.location);
            TextView txtpopulation = (TextView) findViewById(R.id.contact);
            // Locate the ImageView in singleitemview.xml
            final ImageView img = (ImageView) findViewById(R.id.image);
 
            // Set results to the TextViews
            txtrank.setText(name);
            txtcountry.setText(location);
            txtpopulation.setText(contact);
 
            // Set results to the ImageView
            img.setImageBitmap(bmImg);      
            img.setOnTouchListener(new OnTouchListener(){

				@Override
				public boolean onTouch(View v, MotionEvent event) {
					// TODO Auto-generated method stub
					Log.v("tet", "CLICKED");
					if(event.getAction() == MotionEvent.ACTION_DOWN){
						Intent i = new Intent(getBaseContext(), SingleBitmap.class);
						startActivity(i);
						return true;
					} else
					return false;
					
				}
            	
            });
 
            // Close the progressdialog
            mProgressDialog.dismiss();
            
        }
       
    } 
    
}
