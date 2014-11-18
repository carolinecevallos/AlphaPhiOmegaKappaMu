package com.example.apo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class BoardMembersLearn extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_board_members_learn);
		GridView mGridView = (GridView) findViewById(R.id.boardMembersGrid);
		String[] info = {
				"President:", "Rebecca Wilson",
				"", "jhu.apo.president@gmail.com",
				"Service Chairs:", "Stephen Jenkins",
				"", "Philippe Rameau",
				"", "Kayla Dickerman",
				"", "jhu.apo.service@gmail.com",
				"Membership:", "Harry Ngai",
				"", "jhu.apo.membership@gmail.com",
				"Fellowship:", "Wei-Shi Lin",
				"", "David Hudak",
				"", "jhu.apo.fellowship@gmail.com",
				"Pledgemasters:", "Kivilcim Gunay",
				"", "Stephanie Huie",
				"", "jhu.apo.pledgemasters@gmail.com",
				"Treasurer:", "Carissa Zukowski",
				"", "jhu.apo.treasurer@gmail.com",
				"Secretary:", "Caitlin McDonald",
				"", "jhu.apo.secretary@gmail.com",
				"Historian:", "Amber Zhang",
				"", "jhu.apo.historian@gmail.com",
				"Sergeant at Arms:", "Maggie Weese",
				"", "jhu.apo.sgtatarms@gmail.com"
		};
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
		        android.R.layout.simple_list_item_1, info);
		mGridView.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.board_members_learn, menu);
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
