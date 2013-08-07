package com.klabcyscorpions.exercises;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class NameActivity extends Activity implements OnClickListener {
	TextView tvName;
	  Button btnName;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.name_activity);
		
		tvName = (TextView) findViewById(R.id.tvName);
        btnName = (Button) findViewById(R.id.btnName);
        btnName.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(this, NameActivity2.class);
	    startActivityForResult(intent, 1);
	}
	 @Override
	  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	    if (data == null) {return;}
	    String name = data.getStringExtra("name");
	    tvName.setText("Your name is " + name);
	  }
	
	
}
