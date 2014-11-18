package com.example.apo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreenActivity extends Activity {

	private static final int SPLASH_SCREEN_TIME_OUT = 3000;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash_screen);
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
				startActivity(intent);
				finish();
			}
		}, SPLASH_SCREEN_TIME_OUT);
	}
	
}
