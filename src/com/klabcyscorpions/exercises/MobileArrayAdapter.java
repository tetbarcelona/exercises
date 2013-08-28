package com.klabcyscorpions.exercises;

import java.util.ArrayList;
import java.util.HashMap;

import com.klabcyscorpions.exercises.ListViewAdapter.ContactsViewHolder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MobileArrayAdapter extends ArrayAdapter<String> {
	private final Context context;
	ArrayList<HashMap<String, String>> mobiles;
	ImageLoader imageLoader;

	static class mobileViewHolder {
		TextView mobileText;
		ImageView mobileImage;
	}

	public MobileArrayAdapter(Context context,
			ArrayList<HashMap<String, String>> mobiles) {
		super(context, R.layout.list_mobile);
		this.context = context;
		this.mobiles = mobiles;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mobiles.size();
	}

	@Override
	public String getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		mobileViewHolder viewHolder;
		if (convertView == null) {
			viewHolder = new mobileViewHolder();
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.list_mobile, parent, false);

			HashMap<String, String> mobile = mobiles.get(position);
			((TextView) convertView.findViewById(R.id.label)).setText(mobile
					.get("name"));
			((ImageView) convertView.findViewById(R.id.logo))
					.setImageResource(Integer.valueOf(mobile.get("pic")));
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (mobileViewHolder) convertView.getTag();
			HashMap<String, String> mobile = mobiles.get(position);
			viewHolder.mobileText.setText((CharSequence) mobile);
			if (mobile != null) {
				if (mobile.equals("WindowsMobile")) {
					viewHolder.mobileImage
							.setImageResource(R.drawable.windowsmobile_logo);
				} else if (mobile.equals("iOS")) {
					viewHolder.mobileImage
							.setImageResource(R.drawable.ios_logo);
				} else if (mobile.equals("Blackberry")) {
					viewHolder.mobileImage
							.setImageResource(R.drawable.blackberry_logo);
				} else {
					viewHolder.mobileImage
							.setImageResource(R.drawable.android_logo);
				}
			}
		}
		return convertView;
	}
}