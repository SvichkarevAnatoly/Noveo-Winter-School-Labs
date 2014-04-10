package ru.noveogroup.winterschool.svichkarev.twoactivitylogin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class SecondActivity extends Activity {

	private EditText firstName;
	private EditText lastName;
	private EditText birthday;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		firstName = (EditText) findViewById( R.id.first_name_output );
		lastName = (EditText) findViewById( R.id.last_name_output );
		birthday = (EditText) findViewById( R.id.age_output );
 
        Intent intent=getIntent();
        firstName.setText(intent.getCharSequenceExtra(getString(R.string.first_name)));
        lastName.setText(intent.getCharSequenceExtra(getString(R.string.last_name)));
		
		// TODO без возраста 
	}
	
	
}
