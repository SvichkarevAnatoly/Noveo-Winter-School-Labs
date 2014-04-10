package ru.noveogroup.winterschool.svichkarev.twoactivitylogin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	private Button btn;
	
	private EditText firstNameEditText;
	private EditText lastNameEditText;
	private EditText birthdayEditText;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        firstNameEditText = (EditText) findViewById( R.id.edit_text_first_name );
        lastNameEditText = (EditText) findViewById( R.id.edit_text_last_name );
        birthdayEditText = (EditText) findViewById( R.id.edit_text_birthday );
        
        btn = (Button) findViewById( R.id.button );
        btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startSecondActivity();
			}
		});
    }
    
    private void startSecondActivity(){
    	Intent intent = new Intent( this, SecondActivity.class );
    	
    	// TODO можно как-то хитро передать
    	intent.putExtra( getString(R.string.first_name) , firstNameEditText.getText() );
    	intent.putExtra( getString(R.string.last_name) , lastNameEditText.getText() );
    	// TODO без даты пока
    	
    	startActivity( intent );
    }
}
