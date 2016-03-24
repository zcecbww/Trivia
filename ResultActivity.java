package ucl.testtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
public class ResultActivity extends Activity 
{
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);

		//Get data of score from QuestionActivity
		TextView textResult = (TextView) findViewById(R.id.textResult);
		Bundle b = getIntent().getExtras();
		int score = b.getInt("score");
		
		if (score == 20 )
		{
			textResult.setText("");
			textResult.setText("PERFECT SCORE! " +score+ "/20.");
		}
		else if (score ==19 || score ==18 || score ==17 || score ==16|| score ==15 || score ==14 )
		{
			textResult.setText("");
			textResult.setText("Congratulations! Your score is " + " " + score + "/20.");
		}
		else if (score ==13 || score ==12 || score ==11|| score ==10 || score ==9 )
		{
			textResult.setText("");
			textResult.setText("  Good! Your score is " + " " + score + "/20.");
		}
		else if (score ==8 || score ==7 || score ==6 || score ==5 || score ==4 || score ==3)
		{
			textResult.setText("");
			textResult.setText("  Not Bad! Your score is " + " " + score + "/20.");
		}
		else if (score ==2 || score ==1 || score ==0)
		{
			textResult.setText("");
			textResult.setText("That's terrible! Your score is " + " " + score + "/20.");
		}
	}

	public void playagain(View o) 
	{
		//Returns to main page
		Intent intent = new Intent(this, HighScore.class);
		startActivity(intent);
		finish();
	}
}