package ucl.testtest;

import android.app.Activity;
public class Question extends Activity 
{
	private int ID;
	private String QUESTION;
	private String TRUE;
	private String FALSE;
	private String ANSWER;
	public Question() 
	{
		ID = 0;
		QUESTION = "";
		TRUE = "";
		FALSE = "";
		ANSWER = "";
	}
	public Question(String qUESTION, String tRUE, String fALSE,String aNSWER)
	{
		QUESTION = qUESTION;
		TRUE = tRUE;
		FALSE = fALSE;
		ANSWER = aNSWER;
	}
	public int getID() 
	{
		return ID;
	}
	public String getQUESTION()
	{
		return QUESTION;
	}
	public String getTRUE() 
	{
		return TRUE;
	}
	public String getFALSE()
	{
		return FALSE;
	}
	public String getANSWER()
	{
		return ANSWER;
	}
	public void setID(int id) 
	{
		ID = id;
	}
	public void setQUESTION(String qUESTION)
	{
		QUESTION = qUESTION;
	}
	public void setTRUE(String tRUE) 
	{
		TRUE = tRUE;
	}
	public void setFALSE(String fALSE) 
	{
		FALSE = fALSE;
	}

	public void setANSWER(String aNSWER)
	{
		ANSWER = aNSWER;
	}
}