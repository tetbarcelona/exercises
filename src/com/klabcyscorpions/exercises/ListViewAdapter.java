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
	
	    Context context;
	    ArrayList<HashMap<String, String>> data;
	    ImageLoader imageLoader;
	    
	    static class ContactsViewHolder {
	        TextView contactName;
	        TextView contactLocation;
	        TextView contactNumber;
	        ImageView image;
	    }
 
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
	    	ContactsViewHolder viewHolder;
	    	
	        if (convertView == null) {
	    	    LayoutInflater inflater = (LayoutInflater) context
		                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		        
		        convertView = inflater.inflate(R.layout.listview_item, parent, false);
		        viewHolder = new ContactsViewHolder();
	        // Locate the TextViews in listview_item.xml
	        viewHolder.contactName = (TextView) convertView.findViewById(R.id.name); 
	        viewHolder.contactLocation = (TextView) convertView.findViewById(R.id.location); 
	        viewHolder.contactNumber = (TextView) convertView.findViewById(R.id.contact); 
	        // Locate the ImageView in listview_item.xml
	        viewHolder.image = (ImageView) convertView.findViewById(R.id.image); 
	        convertView.setTag(viewHolder);
	        }else {
	            viewHolder = (ContactsViewHolder) convertView.getTag();
	        }
	        HashMap<String, String> contactInfo = data.get(position);
	        // Capture position and set results to the TextViews
	        if(contactInfo != null){
	        viewHolder.contactName.setText(contactInfo.get(JSONActivity.NAME));
	        viewHolder.contactLocation.setText(contactInfo.get(JSONActivity.LOCATION));
	        viewHolder.contactNumber.setText(contactInfo.get(JSONActivity.CONTACT));
	        // Capture position and set results to the ImageView
	        // Passes flag images URL into ImageLoader.class to download and cache
	        // images

	        imageLoader.DisplayImage(contactInfo.get(JSONActivity.IMAGE), viewHolder.image);
	        // Capture button clicks on ListView items

	        convertView.setOnClickListener(new OnClickListener() {
	 
	            @Override
	            public void onClick(View v) {
	                // Get the position from the results
	                HashMap<String, String> contactInfo = data.get(position);
	                
	                // Send single item click data to SingleItemView Class
	                Intent intent = new Intent(context, SingleItemView.class);
	                // Pass all data name
	                intent.putExtra("name", contactInfo.get(JSONActivity.NAME));
	                // Pass all data location
	                intent.putExtra("location", contactInfo.get(JSONActivity.LOCATION));
	                // Pass all data contact
	                intent.putExtra("contact",
	                		contactInfo.get(JSONActivity.CONTACT));
	                // Pass all data img
	                intent.putExtra("image", contactInfo.get(JSONActivity.IMAGE));
	                // Start SingleItemView Class
	                context.startActivity(intent);
	 
	            }
	        });
	 
	       
	    }
			return convertView;
	 }
}
