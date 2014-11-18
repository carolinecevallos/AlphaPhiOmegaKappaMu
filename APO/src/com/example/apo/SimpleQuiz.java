package com.example.apo;

import java.util.ArrayList;
import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SimpleQuiz extends Activity {
	
	ArrayList<Question> quesList;
	float score = 0;
	int qid = 1;
	Question currentQ;
	TextView txtQuestion;
	Button butNext;
	Random randy;
	
	float NUM_QUESTIONS;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_simple_quiz);
		//Initialize values
		randy = new Random();
		quesList = new ArrayList<Question>();
		txtQuestion = (TextView) findViewById(R.id.questionText);
		final TextView questionNumText = (TextView) findViewById(R.id.questionNumber);
		butNext=(Button)findViewById(R.id.buttonNext);
		//Set up quiz
		createQuestions();
		currentQ = chooseQuestion();
		
		//Set numQuestions
		SharedPreferences sharedPrefs = PreferenceManager
				.getDefaultSharedPreferences(this);
		//Find out if pledge
		String quizSizeString = sharedPrefs.getString("settings_quizSize", "1");
		if (quizSizeString.equalsIgnoreCase("1")) {
			NUM_QUESTIONS = 5;
		} else if (quizSizeString.equalsIgnoreCase("2")) {
			NUM_QUESTIONS = 10;
		} else if (quizSizeString.equalsIgnoreCase("3")) {
			NUM_QUESTIONS = 15;
		} else if (quizSizeString.equalsIgnoreCase("4")) {
			NUM_QUESTIONS = quesList.size();
		} else {
			throw new IllegalArgumentException();
		}
		
		//start
		setQuestionView();
		
		butNext.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				EditText mEditText = (EditText) findViewById(R.id.userInput);
				String answer = mEditText.getText() + "";
				if(currentQ.getAnswer().equalsIgnoreCase(answer)) {
					Toast.makeText(SimpleQuiz.this, "Correct!", Toast.LENGTH_LONG).show();
					score++;
				} else {
					Toast.makeText(SimpleQuiz.this, currentQ.getAnswer(), Toast.LENGTH_LONG).show();
				}
				if (qid < NUM_QUESTIONS) {
					currentQ = chooseQuestion();
					qid++;
					setQuestionView();
				} else {
					Intent intent = new Intent(SimpleQuiz.this, QuizResultActivity.class);
					Bundle b = new Bundle();
					b.putFloat("score", score);
					b.putFloat("numQuestions", NUM_QUESTIONS);
					intent.putExtras(b);
					startActivity(intent);
					finish();
				}
				mEditText.setText("");
				questionNumText.setText("Question: " + (qid));
				hideKeyboard();
			}
		});
	}
	
	private void hideKeyboard() {
		InputMethodManager inputMethodManager = (InputMethodManager)  getSystemService(Activity.INPUT_METHOD_SERVICE);
	    inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
	}
	
	private void setQuestionView() {
		txtQuestion.setText(currentQ.getQuestion());
	}
	
	private Question chooseQuestion() {
		Question q;
		int numQuest = randy.nextInt(quesList.size());
		q = quesList.get(numQuest);
		quesList.remove(numQuest); //avoid repeats
		return q;
	}
	
	public void createQuestions() {
		//To override
	}
	
}
