package com.klabcyscorpions.exercises;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
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
	Button getEditTextValue;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_elements);

		plainButton = (Button) findViewById(R.id.button1);
		plainCheckbox = (CheckBox) findViewById(R.id.button_checkbox);
		plainText = (TextView) findViewById(R.id.simple_text);
		checkboxText = (TextView) findViewById(R.id.checkbox_text);
		editText = (EditText) findViewById(R.id.edit_text);
		inputText = (TextView) findViewById(R.id.edit_text_value);
		toggleButton = (ToggleButton) findViewById(R.id.toggle_button);
		toggleText = (TextView) findViewById(R.id.toggle_text);
		OnClickListener btnClicked = new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				plainText.setText("Hello World!");

			}

		};
		plainButton.setOnClickListener(btnClicked);
		plainCheckbox.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (plainCheckbox.isChecked()) {
					checkboxText.setAllCaps(true);
				} else {
					checkboxText.setAllCaps(false);
				}

			}

		});

		getEditTextValue = (Button) findViewById(R.id.get_edit_text_value);
		getEditTextValue.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String input = editText.getText().toString(); // Get the input
				inputText.setText(input);
				InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

				inputManager.hideSoftInputFromWindow(getCurrentFocus()
						.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
			}
		});
	}
}