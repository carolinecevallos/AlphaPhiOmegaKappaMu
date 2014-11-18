package com.example.apo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class APOHistoryLearn extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_apohistory_learn);
		GridView mGridView = (GridView) findViewById(R.id.apoHistoryGrid);
		String[] info = {
				"Founder:", "Frank Reed Horton",
				"Second President:", "H. Roe Bartle, \"The Chief\"",
				"Founded:", "December 16, 1925",
				"", "Lafayette College, Easton, PA",
				"", "Brainerd Hall, Second Floor",
				"Women allowed to join:", "1976",
				"Cardinal Priniciples:", "Leadership, Friendship, Service",
				"National Tree:", "Oak",
				"National Colors:", "Royal Blue and Old Gold",
				"National Jewel:", "Diamond",
				"National Flower:", "Forget-Me-Not",
				"National Bird:", "Golden Eagle",
				"National Office:", "Independence, MO",
				"Motto:", "Be a leader, be a friend, be of service.",
				"Four fields of service:", "College, Community, Fraternity, Nation",
				"International Locations:", "Canada, Australia, Philippines"
		};
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
		        android.R.layout.simple_list_item_1, info);
		mGridView.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.apohistory_learn, menu);
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
