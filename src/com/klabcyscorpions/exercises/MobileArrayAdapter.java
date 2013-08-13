package com.klabcyscorpions.exercises;


	import java.util.ArrayList;
import java.util.HashMap;

import com.klabcyscorpions.exercises.ListViewAdapter.ContactsViewHolder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
	 
	public class MobileArrayAdapter extends ArrayAdapter<String> {
		private final Context context;
		private final String[] values;		
		
		static class mobileViewHolder {
	        TextView mobileText;
	        ImageView mobileImage;
	    }
		public MobileArrayAdapter(Context context, String[] values) {
			super(context, R.layout.list_mobile, values);
			this.context = context;
			this.values = values;
		}
	 
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			mobileViewHolder viewHolder;
			
			if(convertView == null){
			LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			
			convertView = inflater.inflate(R.layout.list_mobile, parent, false);
			viewHolder = new mobileViewHolder();
			viewHolder.mobileText = (TextView) convertView.findViewById(R.id.label);
			viewHolder.mobileImage = (ImageView) convertView.findViewById(R.id.logo);
			viewHolder.mobileText.setText(values[position]);
			}
			else {
	            viewHolder = (mobileViewHolder) convertView.getTag();
	        }
			
			// Change icon based on name
			String s = values[position];
			System.out.println(s);
			if(s != null) {
				if (s.equals("WindowsMobile")) {
					viewHolder.mobileImage.setImageResource(R.drawable.windowsmobile_logo);
				} else if (s.equals("iOS")) {
					viewHolder.mobileImage.setImageResource(R.drawable.ios_logo);
				} else if (s.equals("Blackberry")) {
					viewHolder.mobileImage.setImageResource(R.drawable.blackberry_logo);
				} else {
					viewHolder.mobileImage.setImageResource(R.drawable.android_logo);
				}
			}
			return convertView;
		}
	}
	
