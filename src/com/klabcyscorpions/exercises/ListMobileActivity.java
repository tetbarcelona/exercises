package com.klabcyscorpions.exercises;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;
 
public class ListMobileActivity extends ListActivity {
 Context context;
	static ArrayList<HashMap<String, String>> MOBILE_OS = new ArrayList<HashMap<String, String>>();
	String mobiles[] = {"WindowsMobile","iOS", "Blackberry", "Android" };
     int pic[] = {R.drawable.android_logo,R.drawable.blackberry_logo,R.drawable.ios_logo,R.drawable.windowsmobile_logo};        
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		int mobileCount = mobiles.length;
		for(int i = 0; i < mobileCount; i++){
			HashMap<String, String> mobile = new HashMap<String, String>();
			
			mobile.put("name", mobiles[i]);
			mobile.put("pic", String.valueOf(pic[i]));
			MOBILE_OS.add(mobile);
		}
		setListAdapter(new MobileArrayAdapter(this, MOBILE_OS));
	}
 
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
 
		//get selected items
		String selectedValue = (String) getListAdapter().getItem(position);
		Toast.makeText(this, selectedValue, Toast.LENGTH_SHORT).show();
 
	}
 
}

