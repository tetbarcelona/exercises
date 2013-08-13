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
	static Context context;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tvOut = (TextView) findViewById(R.id.tvOut);
		context = this.getApplicationContext();
		OnClickListener clickButton = new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent i = null;
				i = new Intent();
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
					i = new Intent(context, ListFruitActivity.class);
					startActivity(i);
					break;
				case R.id.btnMobile:
					i = new Intent(context, ListMobileActivity.class);
					startActivity(i);
					break;
				case R.id.btnLayout:
					i = new Intent(context, LayoutElements.class);
					startActivity(i);
					break;
				case R.id.btnContext:
					i = new Intent(context, ContextMenu.class);
					startActivity(i);
					break;
				case R.id.btnName:
					i= new Intent(context, NameActivity.class);
					startActivity(i);
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
					i = new Intent(context, Map.class);
					startActivity(i);
					break;
				case R.id.btnJson:
					i = new Intent(context, JSONActivity.class);
					startActivity(i);
					break;
				}
			}
		};
		findViewById(R.id.btnCancel).setOnClickListener(clickButton);
		findViewById(R.id.btnOk).setOnClickListener(clickButton);
		findViewById(R.id.btnSwitch).setOnClickListener(clickButton);
		findViewById(R.id.btnMobile).setOnClickListener(clickButton);
		findViewById(R.id.btnLayout).setOnClickListener(clickButton);
		findViewById(R.id.btnContext).setOnClickListener(clickButton);
		findViewById(R.id.btnDialog).setOnClickListener(clickButton);
		findViewById(R.id.btnName).setOnClickListener(clickButton);
		findViewById(R.id.btnMap).setOnClickListener(clickButton);
		findViewById(R.id.btnJson).setOnClickListener(clickButton);
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
