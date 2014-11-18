package com.example.apo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class KappaMuLearn extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_kappa_mu_learn);
		GridView mGridView = (GridView) findViewById(R.id.kappaMuGrid);
		String[] info = {
				"Region:", "III",
				"Section:", "86",
				"Chapter name:", "Kappa Mu",
				"Pledge class Greek name:", "Alpha Iota",
				"Originally chartered:", "1952",
				"Re-chartered:", "1998",
				"Other schools in our section:", "UMBC, \nMcDaniel College, \nFrostburg State University, \nTowson University",
				"Conventions:", "Nationals on even years",
				"", "Regionals on odd years",
				"", "Sectionals every spring",
				"Last convention:", "TBD",
				"Acronyms:", "",
				"NIB", "Newly Initiated Brother",
				"CAPS", "Chapter Assessment Planning Session",
				"DSK", "Distinguished Service Key",
				"LEADS", "Launch, Explore, Achieve, Discover, Serve",
				"Important People:", "",
				"National President:", "Mark Strattion",
				"Region III Director:", "Megan Sheedfar",
				"Section Chair:", "Dave Bykowski"
		};
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
		        android.R.layout.simple_list_item_1, info);
		mGridView.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.kappa_mu_learn, menu);
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
}
