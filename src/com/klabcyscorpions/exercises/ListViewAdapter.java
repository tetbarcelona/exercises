package com.klabcyscorpions.exercises;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListViewAdapter extends BaseAdapter{
	
		 
	    // Declare Variables
	    Context context;
	    LayoutInflater inflater;
	    ArrayList<HashMap<String, String>> data;
	    ImageLoader imageLoader;
	 
	    public ListViewAdapter(Context context,
	            ArrayList<HashMap<String, String>> arraylist) {
	        this.context = context;
	        data = arraylist;
	        imageLoader = new ImageLoader(context);
	 
	    }
	 
	    @Override
	    public int getCount() {
	        return data.size();
	    }
	 
	    @Override
	    public Object getItem(int position) {
	        return null;
	    }
	 
	    @Override
	    public long getItemId(int position) {
	        return 0;
	    }
	 
	    public View getView(final int position, View convertView, ViewGroup parent) {
	        // Declare Variables
	        TextView name;
	        TextView location;
	        TextView contact;
	        ImageView image;
	 
	        inflater = (LayoutInflater) context
	                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	 
	        View itemView = inflater.inflate(R.layout.listview_item, parent, false);
	        // Get the position from the results
	        HashMap<String, String> resultp = new HashMap<String, String>();
	        resultp = data.get(position);
	 
	        // Locate the TextViews in listview_item.xml
	        name = (TextView) itemView.findViewById(R.id.name); 
	        location = (TextView) itemView.findViewById(R.id.location); 
	        contact = (TextView) itemView.findViewById(R.id.contact); 
	        // Locate the ImageView in listview_item.xml
	        image = (ImageView) itemView.findViewById(R.id.image); 
	 
	        // Capture position and set results to the TextViews
	        name.setText(resultp.get(JSONActivity.NAME));
	        location.setText(resultp.get(JSONActivity.LOCATION));
	        contact.setText(resultp.get(JSONActivity.CONTACT));
	        // Capture position and set results to the ImageView
	        // Passes flag images URL into ImageLoader.class to download and cache
	        // images
	        imageLoader.DisplayImage(resultp.get(JSONActivity.IMAGE), image);
	        // Capture button clicks on ListView items
	        itemView.setOnClickListener(new OnClickListener() {
	 
	            @Override
	            public void onClick(View v) {
	                // Get the position from the results
	                HashMap<String, String> resultp = new HashMap<String, String>();
	                resultp = data.get(position);
	                // Send single item click data to SingleItemView Class
	                Intent intent = new Intent(context, SingleItemView.class);
	                // Pass all data name
	                intent.putExtra("name", resultp.get(JSONActivity.NAME));
	                // Pass all data location
	                intent.putExtra("location", resultp.get(JSONActivity.LOCATION));
	                // Pass all data contact
	                intent.putExtra("contact",
	                        resultp.get(JSONActivity.CONTACT));
	                // Pass all data img
	                intent.putExtra("image", resultp.get(JSONActivity.IMAGE));
	                // Start SingleItemView Class
	                context.startActivity(intent);
	 
	            }
	        });
	 
	        return itemView;
	    }

}
