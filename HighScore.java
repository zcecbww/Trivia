package ucl.testtest;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HighScore extends Activity implements OnClickListener
{
	public EditText naming;	
	private Button button_Start,button_Description, button_Disclaimer;

	//ArrayList for our text
	ArrayList<String> my_array = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.frontscreen);

		//Buttons
		button_Start = (Button) findViewById(R.id.startbutton);
		button_Start.setOnClickListener(this);
		button_Description = (Button) findViewById(R.id.descriptionbutton);
		button_Description.setOnClickListener(this);
		button_Disclaimer = (Button) findViewById(R.id.disclaimerbutton);
		button_Disclaimer.setOnClickListener(this);

		//Array Data
		my_array.add("The quiz is a 20 question true or false quiz that has a 2 minutes time limit. Let's see how many you can get correct");
		my_array.add("Trivia Version 1.5 done by Ben & Chien Loong.");
	}

	@Override
	public void onClick(View v) 
	{
		switch(	v.getId())
		{
		//Start Button 
		case R.id.startbutton:
			Intent intent = new Intent(HighScore.this,QuestionActivity.class);
			startActivity(intent);		
			break;
		//Description Button
		case R.id.descriptionbutton:
			String word = my_array.get(0);
			TextView descriptions= (TextView) findViewById(R.id.EmptyBox);
			descriptions.setText("");
			descriptions.setText("" +word +"");
			break;
		//Disclaimer Button
		case R.id.disclaimerbutton:
			String word1 = my_array.get(1);
			TextView description= (TextView) findViewById(R.id.EmptyBox);
			description.setText("");
			description.setText("" +word1 +"");
			break;
		}
	}
}



