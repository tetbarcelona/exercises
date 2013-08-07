package com.klabcyscorpions.exercises;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class LayoutElements extends Activity {
	Button plainButton;
	TextView plainText;
	CheckBox plainCheckbox;
	TextView checkboxText;
	EditText editText;
	TextView inputText;
	ToggleButton toggleButton;
	TextView toggleText;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_elements);
		
		plainButton = (Button)findViewById(R.id.button1);
		plainCheckbox = (CheckBox)findViewById(R.id.button_checkbox);
		plainText = (TextView)findViewById(R.id.simple_text);
		checkboxText = (TextView)findViewById(R.id.simple_text1);
		editText = (EditText)findViewById(R.id.edit_text);
		inputText = (TextView)findViewById(R.id.simple_text2);
		toggleButton = (ToggleButton)findViewById(R.id.toggle_button);
		toggleText = (TextView)findViewById(R.id.simple_text3);
		OnClickListener btnClicked = new OnClickListener(){
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				plainText.setText("Hello World!");
			
			}
			
		};
		plainButton.setOnClickListener(btnClicked);
		plainCheckbox.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(plainCheckbox.isChecked()){
					checkboxText.setAllCaps(true);
				} else {
					checkboxText.setAllCaps(false);
				}
				
			}
			
		});
		editText.getText();
		
		
	}
		
}
