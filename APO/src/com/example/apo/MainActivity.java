package com.example.apo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity implements
		NavigationDrawerFragment.NavigationDrawerCallbacks {

	//private static final int RESOLVE_CONNECTION_REQUEST_CODE = 1;
	private NavigationDrawerFragment mNavigationDrawerFragment;
	private CharSequence mTitle;
	public boolean pledge;
	//public GoogleApiClient mGoogleApiClient;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Google API authorization stuff
		/*mGoogleApiClient = new GoogleApiClient.Builder(this)
												.addApi(Drive.API)
												.addScope(Drive.SCOPE_FILE)
												.addConnectionCallbacks(this)
												.addOnConnectionFailedListener(this)
												.build();
		*/

		//Navigation stuff
		mNavigationDrawerFragment = (NavigationDrawerFragment) getSupportFragmentManager()
				.findFragmentById(R.id.navigation_drawer);
		mTitle = getTitle();
		
		mNavigationDrawerFragment.setUp(R.id.navigation_drawer,
				(DrawerLayout) findViewById(R.id.drawer_layout));
		
	}
	
	/*@Override
	public void onConnectionFailed(ConnectionResult connectionResult) {
		if (connectionResult.hasResolution()) {
			try {
				connectionResult.startResolutionForResult(this, RESOLVE_CONNECTION_REQUEST_CODE);
			} catch (IntentSender.SendIntentException e) {
				Toast.makeText(this, "Failed to connect to Internet", Toast.LENGTH_LONG).show();
				mGoogleApiClient.connect();
			}
		} else {
			GooglePlayServicesUtil.getErrorDialog(connectionResult.getErrorCode(), this, 0).show();
		}
	}
	
	@Override
	protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
		if (requestCode == RESOLVE_CONNECTION_REQUEST_CODE) {
			if (resultCode == RESULT_OK) {
				mGoogleApiClient.connect();
			}
		}
	} */

	@Override
	public void onNavigationDrawerItemSelected(int position) {
		// update the main content by replacing fragments
		FragmentManager fragmentManager = getSupportFragmentManager();
		Fragment fragment;
		switch(position + 1) {
		case 1: 
			fragment = new Fragment1();
			break;
		case 2:
			fragment = new Fragment2();
			break;
		case 3:
			fragment = new Fragment3();
			break;
		case 4:
			fragment = new Fragment4();
			break;
		case 5:
			fragment = new Fragment5();
			break;
		default:
			fragment = null;
		}
		fragmentManager
				.beginTransaction()
				.replace(R.id.container,
						fragment).commit();
	}

	public void onSectionAttached(int number) {
		switch (number) {
		case 1:
			mTitle = getString(R.string.title_section1);
			break;
		case 2:
			mTitle = getString(R.string.title_section2);
			break;
		case 3:
			mTitle = getString(R.string.title_section3);
			break;
		case 4:
			mTitle = getString(R.string.title_section4);
			break;
		case 5:
			mTitle = getString(R.string.title_section5);
		}
	}

	public void restoreActionBar() {
		ActionBar actionBar = getSupportActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar.setTitle(mTitle);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		if (!mNavigationDrawerFragment.isDrawerOpen()) {
			// Only show items in the action bar relevant to this screen
			// if the drawer is not showing. Otherwise, let the drawer
			// decide what to show in the action bar.
			getMenuInflater().inflate(R.menu.main, menu);
			restoreActionBar();
			return true;
		}
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			openSettings();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void openSettings() {
		Intent intent = new Intent(this, Settings.class);
		startActivity(intent);
	}

}
