package com.klabcyscorpions.exercises;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	TextView tvOut;
	Button btnOk, btnContext, btnCancel,btnSwitch, btnMobile, btnLayout, btnName, btnDialog, btnMap;
	static Context context;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tvOut = (TextView) findViewById(R.id.tvOut);
		btnOk = (Button) findViewById(R.id.btnOk);
		btnCancel = (Button) findViewById(R.id.btnCancel);
		btnSwitch = (Button) findViewById(R.id.btnSwitch);
		context = this.getApplicationContext();
		btnMobile = (Button) findViewById(R.id.btnMobile);
		btnLayout = (Button) findViewById(R.id.btnLayout);
		btnContext = (Button) findViewById(R.id.btnContext);
		btnDialog = (Button) findViewById(R.id.btnDialog);
		btnName = (Button) findViewById(R.id.btnName);
		btnMap = (Button) findViewById(R.id.btnMap);
		OnClickListener oclBtn = new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				switch (v.getId()) {
				case R.id.btnOk:
					tvOut.setText("OK button was clicked");
					break;
				case R.id.btnCancel:
					// Cancel button					
					tvOut.setText("Cancel button was clicked");
					break;
				case R.id.btnSwitch:
					Intent i = new Intent(context, ListFruitActivity.class);
					startActivity(i);
					break;
				case R.id.btnMobile:
					Intent p = new Intent(context, ListMobileActivity.class);
					startActivity(p);
					break;
				case R.id.btnLayout:
					Intent a = new Intent(context, LayoutElements.class);
					startActivity(a);
					break;
				case R.id.btnContext:
					Intent s = new Intent(context, ContextMenu.class);
					startActivity(s);
					break;
				case R.id.btnName:
					Intent j = new Intent(context, NameActivity.class);
					startActivity(j);
					break;
				case R.id.btnDialog:
					AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
					builder.setTitle("Alert Dialog");
				    builder.setMessage("Warning Warning");
					builder.setPositiveButton("OK", null);
		            builder.setNegativeButton("Cancel", null);
		            builder.show();
					break;
				case R.id.btnMap:
					Intent o = new Intent(context, Map.class);
					startActivity(o);
					break;
				}
			}

		};
		btnOk.setOnClickListener(oclBtn);
		btnCancel.setOnClickListener(oclBtn);
		btnSwitch.setOnClickListener(oclBtn);
		btnMobile.setOnClickListener(oclBtn);
		btnLayout.setOnClickListener(oclBtn);
		btnContext.setOnClickListener(oclBtn);
		btnName.setOnClickListener(oclBtn);
		btnDialog.setOnClickListener(oclBtn);
		btnMap.setOnClickListener(oclBtn);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		menu.add("Una");
		menu.add("Ikalawa");
		menu.add("Ikatlo");
		menu.add("Ikaapat");

		return super.onCreateOptionsMenu(menu);

	}
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
      // TODO Auto-generated method stub
      Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
      return super.onOptionsItemSelected(item);
    }	

}
