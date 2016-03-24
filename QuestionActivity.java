package ucl.testtest;

import java.util.List;
import java.util.concurrent.TimeUnit;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionActivity extends Activity 
{
	List<Question> quesList;
	int score = 0,qid = 0;
	Question currentQ;
	TextView txtQuestion, times, scored;
	Button button1, button2;

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// The database class
		QuizHelper db = new QuizHelper(this); 
		//Retrieving the questions
		quesList = db.getAllQuestions();  
		//Current Question
		currentQ = quesList.get(qid); 
		//TestView where the question will be displayed
		txtQuestion = (TextView) findViewById(R.id.txtQuestion);

		button1 = (Button) findViewById(R.id.button1);
		button2 = (Button) findViewById(R.id.button2);

		// TextView for score
		scored = (TextView) findViewById(R.id.score);

		// TextView for timer
		times = (TextView) findViewById(R.id.timers);

		// Setting up the game
		setQuestionView();
		times.setText("00:02:00");

		// A timer of 120 seconds to play for, with an interval of 1 second (1000 milliseconds)
		CounterClass timer = new CounterClass(120000, 1000);
		timer.start();

		// button click listeners
		button1.setOnClickListener(new View.OnClickListener() 
		{
			@Override
			public void onClick(View v)
			{
				// Passing  button answer to method 
				getAnswer(button1.getText().toString());
			}
		});
		button2.setOnClickListener(new View.OnClickListener() 
		{
			@Override
			public void onClick(View v) 
			{
				getAnswer(button2.getText().toString());
			}
		});

	}

	//Checking if answer is correct and adding score
	public void getAnswer(String AnswerString) 
	{
		if (currentQ.getANSWER().equals(AnswerString)) 
		{
			Toast.makeText(QuestionActivity.this, getResources().getString(R.string.CORRECT), Toast.LENGTH_SHORT).show();
			score++;
			scored.setText("Score : " + score);
		} 
		else 
		{
			Toast.makeText(QuestionActivity.this, getResources().getString(R.string.WRONG), Toast.LENGTH_SHORT).show();
		}

		//In case not 20 questions are reached
		if (qid < 20)
		{
			currentQ = quesList.get(qid);
			setQuestionView();
		} 
		else 
		{
			Intent intent = new Intent(QuestionActivity.this, ResultActivity.class);

			//Passing the score to next activity
			Bundle b = new Bundle();
			b.putInt("score", score);
			intent.putExtras(b);
			startActivity(intent);
			finish();
		}
	}


	public class CounterClass extends CountDownTimer
	{
		public CounterClass(long millisInFuture, long countDownInterval)
		{
			super(millisInFuture, countDownInterval);

		}
		//Timer reaches 0
		@Override
		public void onFinish() 
		{
			Toast.makeText(QuestionActivity.this, getResources().getString(R.string.error), Toast.LENGTH_LONG).show();

			Intent intent = new Intent(QuestionActivity.this, ResultActivity.class);
			Bundle b = new Bundle();
			b.putInt("score", score); // Your score
			intent.putExtras(b); // Put your score to your next
			startActivity(intent);
			finish();
		}

		@Override
		public void onTick(long millisUntilFinished) 
		{
			long millis = millisUntilFinished;
			String hms = String.format("%02d:%02d:%02d",
					TimeUnit.MILLISECONDS.toHours(millis),TimeUnit.MILLISECONDS.toMinutes(millis)
					- TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
					TimeUnit.MILLISECONDS.toSeconds(millis)- TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
			System.out.println(hms);
			times.setText(hms);
		}
	}

	private void setQuestionView() 
	{
		// Combining all the information
		txtQuestion.setText(currentQ.getQUESTION());
		button1.setText(currentQ.getTRUE());
		button2.setText(currentQ.getFALSE());
		qid++;
	}
}