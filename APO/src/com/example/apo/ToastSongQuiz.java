package com.example.apo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class ToastSongQuiz extends Activity {
	
	String[] correctAnswers;
	float score;
	float numQuestions;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_toast_song_quiz);
		
		String[] correctAnswers = {
				"Alpha Phi Omega",
				"Brothers",
				"Self",
				"Each Other",
				"Loyalty",
				"Working",
				"Striving",
				"More",
				"Men",
				"Fraternity",
				"Brothers",
				"Hands",
				"Circle",
				"Mindful",
				"Serving",
				"Humanity",
				"Raise",
				"Voices",
				"Song",
				"Alpha Phi Omega",
				"Always"
		};

		numQuestions = correctAnswers.length;
		
		this.correctAnswers = correctAnswers;
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.toast_song_quiz, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void checkAnswers(View view) {
		EditText[] userAnswers = {
				(EditText)findViewById(R.id.lyric1),	
				(EditText)findViewById(R.id.lyric2),	
				(EditText)findViewById(R.id.lyric3),	
				(EditText)findViewById(R.id.lyric4),	
				(EditText)findViewById(R.id.lyric5),	
				(EditText)findViewById(R.id.lyric6),	
				(EditText)findViewById(R.id.lyric7),	
				(EditText)findViewById(R.id.lyric8),	
				(EditText)findViewById(R.id.lyric9),	
				(EditText)findViewById(R.id.lyric10),	
				(EditText)findViewById(R.id.lyric11),	
				(EditText)findViewById(R.id.lyric12),	
				(EditText)findViewById(R.id.lyric13),	
				(EditText)findViewById(R.id.lyric14),	
				(EditText)findViewById(R.id.lyric15),	
				(EditText)findViewById(R.id.lyric16),	
				(EditText)findViewById(R.id.lyric17),	
				(EditText)findViewById(R.id.lyric18),	
				(EditText)findViewById(R.id.lyric19),	
				(EditText)findViewById(R.id.lyric20),	
				(EditText)findViewById(R.id.lyric21),	
			};
		
		for (int i = 0; i < numQuestions; i++) {
			if (userAnswers[i].getText() == null) {
				userAnswers[i].setText("---");
			}
			if (correctAnswers[i].equalsIgnoreCase(userAnswers[i].getText().toString())) {
				score++;
			} else {
				userAnswers[i].setTextColor(Color.RED);
			}
		}
		Button resultsButton = (Button) findViewById(R.id.resultsButton);
		Button checkButton = (Button) findViewById(R.id.checkToastLyrics);
		resultsButton.setEnabled(true);
		checkButton.setEnabled(false);
	}
	
	public void goToResults(View view) {
		Intent intent = new Intent(this, QuizResultActivity.class);
		Bundle b = new Bundle();
		b.putFloat("score", score);
		b.putFloat("numQuestions", numQuestions);
		intent.putExtras(b);
		startActivity(intent);
	}
	
}
