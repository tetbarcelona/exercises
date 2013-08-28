package com.klabcyscorpions.exercises;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;

public class JSONActivity extends Activity{
	JSONObject jsonobject;
    JSONArray jsonarray;
    ListView listview;
    ListViewAdapter adapter;
    ProgressDialog mProgressDialog;
    ArrayList<HashMap<String, String>> arraylist;
    static String NAME = "name";
    static String LOCATION = "location";
    static String CONTACT = "contact";
    static String IMAGE = "image";
    static String LARGE = "large";
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from listview_main.xml
        setContentView(R.layout.json_sample);
        // Execute DownloadJSON AsyncTask
        new DownloadJSON().execute();
    }
 
    // DownloadJSON AsyncTask
    private class DownloadJSON extends AsyncTask<Void, Void, Void> {
 
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Create a progressdialog
            mProgressDialog = new ProgressDialog(JSONActivity.this);
            // Set progressdialog title
            mProgressDialog.setTitle("Android JSON Parsing");
            // Set progressdialog message
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setIndeterminate(false);
            // Show progressdialog
            mProgressDialog.show();
        }
 
        @Override
        protected Void doInBackground(Void... params) {
            // Create the array 
            arraylist = new ArrayList<HashMap<String, String>>();
            // Retrive JSON Objects from the given website URL in JSONfunctions.class
            jsonobject = JSONfunctions
                    .getJSONfromURL("http://10.3.10.41/tet/contacts.json");
 
            try {
                // Locate the array name
                jsonarray = jsonobject.getJSONArray("contacts");
 
                for (int i = 0; i < jsonarray.length(); i++) {
                    HashMap<String, String> map = new HashMap<String, String>();
                    jsonobject = jsonarray.getJSONObject(i);
                    // Retrive JSON Objects
                    map.put("name", jsonobject.getString("name"));
                    map.put("location", jsonobject.getString("location"));
                    map.put("contact", jsonobject.getString("contact"));
                    map.put("image", jsonobject.getString("image"));
                    map.put("large", jsonobject.getString("large"));                    
                    // Set the JSON Objects into the array
                    arraylist.add(map);
                }
            } catch (JSONException e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return null;
        }
 
        @Override
        protected void onPostExecute(Void args) {
            // Locate the listview in listview_main.xml
            listview = (ListView) findViewById(R.id.listview);
            // Pass the results into ListViewAdapter.java
            adapter = new ListViewAdapter(JSONActivity.this, arraylist);
            // Binds the Adapter to the ListView
            listview.setAdapter((ListAdapter) adapter);
            // Close the progressdialog
            mProgressDialog.dismiss();
        }
    }
}
