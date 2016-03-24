package ucl.testtest;

import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class QuizHelper extends SQLiteOpenHelper 
{
	private static final int DATABASE_VERSION = 1;
	// Database Name
	private static final String DATABASE_NAME = "UCL Trivia Quizzes";
	// Table Name
	private static final String TABLE_QUEST = "quest";
	// Table Column Names
	private static final String KEY_QUESNO = "qid";
	private static final String KEY_QUES = "question";
	private static final String KEY_ANSWER = "answer";
	private static final String KEY_TRUE = "true"; 
	private static final String KEY_FALSE = "false";
	private SQLiteDatabase dbase;
	
	public QuizHelper(Context context)
	{
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) 
	{
		dbase = db;
		String sql = "CREATE TABLE IF NOT EXISTS" + TABLE_QUEST + " ( "
				+ KEY_QUESNO + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
				+ " TEXT, " + KEY_ANSWER + " TEXT, " + KEY_TRUE + " TEXT, "
				+ KEY_FALSE + " TEXT)";
		db.execSQL(sql);
		addQuestion();
	//Closes database
	}
	
	//Add the questions to the database
	private void addQuestion() 
	{
		Question q1 = new Question("Was UCL founded in 1825?", "TRUE", "FALSE", "FALSE");
		this.addQuestion(q1);
		Question q2 = new Question("Lightning never strikes in the same place twice.", "TRUE", "FALSE", "FALSE");
		this.addQuestion(q2);
		Question q3 = new Question("Goldfish only have a memory of three seconds.", "TRUE", "FALSE", "FALSE");
		this.addQuestion(q3);
		Question q4 = new Question("Birds are dinosaurs.", "TRUE", "FALSE", "TRUE");
		this.addQuestion(q4);
		Question q5 = new Question("The top of the Eiffel Tower leans away from the sun.", "TRUE", "FALSE", "TRUE");
		this.addQuestion(q5);
		Question q6 = new Question("Tomato is a fruit.", "TRUE", "FALSE", "TRUE");
		this.addQuestion(q6);
		Question q7 = new Question("Adults have fewer bones than babies do", "TRUE", "FALSE", "TRUE");
		this.addQuestion(q7);
		Question q8 = new Question("Ostriches stick their head in the sand when feel threatened.", "TRUE", "FALSE", "FALSE");
		this.addQuestion(q8);
		Question q9 = new Question("Louis Braille was blind himself.", "TRUE", "FALSE", "TRUE");
		this.addQuestion(q9);
		Question q10 = new Question("Flight recorders onboard planes are painted black boxes.", "TRUE", "FALSE", "FALSE");
		this.addQuestion(q10);
		Question q11 = new Question("Coffee is the 2nd most popular drink.","TRUE", "FALSE", "TRUE");
		this.addQuestion(q11);
		Question q12 = new Question("The 'funny bone' is really a bone.", "TRUE", "FALSE", "FALSE");
		this.addQuestion(q12);
		Question q13 = new Question("The flying squirrel is the only flying mammal.", "TRUE", "FALSE", "FALSE");
		this.addQuestion(q13);
		Question q14 = new Question("Red grapes can make white wine.", "TRUE", "FALSE", "TRUE");
		this.addQuestion(q14);
		Question q15 = new Question("Sneezes regularly exceed 161km/h.", "TRUE", "FALSE", "TRUE");
		this.addQuestion(q15);
		Question q16 = new Question("Virtually all Las Vegas gambling casinos ensure that they have no clocks.","TRUE", "FALSE", "TRUE");
		this.addQuestion(q16);
		Question q17 = new Question("2 is a prime number.", "TRUE", "FALSE", "TRUE");
		this.addQuestion(q17);
		Question q18 = new Question("According to an old wives' tale, bread baked on Christmas day will never grow moldy.","TRUE", "FALSE", "TRUE");
		this.addQuestion(q18);
		Question q19 = new Question("Dragon fruit is a fruit.", "TRUE", "FALSE", "TRUE");
		this.addQuestion(q19);
		Question q20 = new Question(" Zero is a real number", "TRUE", "FALSE", "TRUE");
		this.addQuestion(q20);
		Question q21 = new Question("The answer is False.", "TRUE", "FALSE", "NO ANSWER");
		this.addQuestion(q21);	
	}
	
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldV, int newV) 
	{
		// Drop table if aready exists
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
		// Create tables again
		onCreate(db);
	}
	
	// Adding new question
	public void addQuestion(Question quest) 
	{	
		ContentValues values = new ContentValues();
		values.put(KEY_QUES, quest.getQUESTION());
		values.put(KEY_ANSWER, quest.getANSWER());
		values.put(KEY_TRUE, quest.getTRUE());
		values.put(KEY_FALSE, quest.getFALSE());
		// Inserting Row
		dbase.insert(TABLE_QUEST, null, values);
	}
	
	public List<Question> getAllQuestions() 
	{
		List<Question> quesList = new ArrayList<Question>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
		dbase = this.getReadableDatabase();
		Cursor cursor = dbase.rawQuery(selectQuery, null);
		// looping through all rows and adding to list
		
		//Moves the cursor to the first row
		if (cursor.moveToFirst()) 
		{
			do
			{
				Question quest = new Question();
				quest.setID(cursor.getInt(0));
				quest.setQUESTION(cursor.getString(1));
				quest.setANSWER(cursor.getString(2));
				quest.setTRUE(cursor.getString(3));
				quest.setFALSE(cursor.getString(4));
				quesList.add(quest);
			} 
			
			while (cursor.moveToNext());
		}
		
		return quesList;
	}
}