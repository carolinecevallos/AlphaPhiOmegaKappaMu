package com.example.apo;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class Fragment2 extends Fragment {

	SharedPreferences sharedPrefs;
	boolean pledge;
	boolean changesMade;
	
	TextView completionMessage; //you did it!
	ProgressBar mProgressBar; //how far are you?
	TextView secondaryMeetingTitle; //pledge for brothers
	SeekBar fellowshipSeekBar;
	SeekBar serviceHoursSeekBar;
	SeekBar primaryMeetingsSeekBar;
	TextView fellowshipsValueText;
	TextView serviceHoursValueText;
	TextView primaryMeetingsValueText;

	CheckBox chk1; //fellowships
	CheckBox chk2; //service
	CheckBox chk3; //primary meetings
	CheckBox chka; //secondary meetings
	CheckBox chkb; //enabled for pledges only
	
	public Fragment2() {
		super();
	}
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_2, container, false);
		sharedPrefs = PreferenceManager
				.getDefaultSharedPreferences(getActivity());
		
		changesMade = false;
		
		//Get all the views
		completionMessage = (TextView) view.findViewById(R.id.completed);
		mProgressBar = (ProgressBar) view.findViewById(R.id.progressBar1);
		secondaryMeetingTitle = (TextView) view.findViewById(R.id.secondaryMeetingTitle);
		fellowshipSeekBar = (SeekBar) view.findViewById(R.id.fellowshipSeekBar);
		serviceHoursSeekBar = (SeekBar) view.findViewById(R.id.serviceHoursSeekBar);
		primaryMeetingsSeekBar = (SeekBar) view.findViewById(R.id.primaryMeetingsSeekBar);
		fellowshipsValueText = (TextView) view.findViewById(R.id.fellowshipsValueText);
		serviceHoursValueText = (TextView) view.findViewById(R.id.serviceHoursValueText);
		primaryMeetingsValueText = (TextView) view.findViewById(R.id.primaryMeetingsValueText);

		chk1 = (CheckBox) view.findViewById(R.id.chk1);
		chk2 = (CheckBox) view.findViewById(R.id.chk2);
		chk3 = (CheckBox) view.findViewById(R.id.chk3);
		chka = (CheckBox) view.findViewById(R.id.chka);
		chkb = (CheckBox) view.findViewById(R.id.chkb);


		load();

		//Change primary meeting text if pledge
		if (sharedPrefs.getString("settings_isPledge", "1").equals("1")) {
			pledge = true;
			chk3.setText("Pledge Meetings (7)");
			secondaryMeetingTitle.setText("Brother Meetings (2)");
			chkb.setEnabled(true);
			mProgressBar.setMax(35); //extra meeting they must attend
		} else {
			pledge = false;
		}
		
		//Set up onChangeListener for fellowship SeekBar
		fellowshipSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				fellowshipsValueText.setText(String.valueOf(progress * .5));
				//Update Fellowship CheckBox
				if (progress >= fellowshipSeekBar.getMax()) {
					chk1.setChecked(true);
				} else {
					if (chk1.isChecked()) {
						chk1.setChecked(false);
					}
				}
				updateProgress();
			}
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {}
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {}
		});
		
		//Set up onChangeListener for service SeekBar
		serviceHoursSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				serviceHoursValueText.setText(String.valueOf(progress * .5));
				//Update Fellowship CheckBox
				if (progress >= serviceHoursSeekBar.getMax()) {
					chk2.setChecked(true);
				} else {
					if (chk2.isChecked()) {
						chk2.setChecked(false);
					}
				}
				updateProgress();
			}
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {}
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {}
		});
		
		//Set up onChangeListener for primary meeting SeekBar
		primaryMeetingsSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				primaryMeetingsValueText.setText(String.valueOf(progress));
				//Update Fellowship CheckBox
				if (progress >= primaryMeetingsSeekBar.getMax()) {
					chk3.setChecked(true);
				} else {
					if (chk3.isChecked()) {
						chk3.setChecked(false);
					}
				}
				updateProgress();
			}
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {}
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {}
		});
		
		//Set up listeners for Meeting checkboxes
		chka.setOnClickListener(new CheckBox.OnClickListener() {
			@Override
			public void onClick(View view) {
				updateProgress();
			}
		});
		
		chkb.setOnClickListener(new CheckBox.OnClickListener() {
			@Override
			public void onClick(View view) {
				updateProgress();
			}
		});
		
		return view;
	}
	
	private void updateProgress() {
		int currentValue = 0;
		currentValue += fellowshipSeekBar.getProgress() / 2;
		currentValue += serviceHoursSeekBar.getProgress() / 2;
		currentValue += primaryMeetingsSeekBar.getProgress();
		if (chka.isChecked()) {
			currentValue += 1;
		}
		if (pledge && chkb.isChecked()) {
			currentValue += 1;
		}
		
		mProgressBar.setProgress(currentValue);
		checkProgress();
		changesMade = true;
	}
	
	/**
	 * Check if progress bar is at the max value and set text accordingly
	 * @param progress the progress bar
	 */
	private void checkProgress() {
		if (mProgressBar.getProgress() == mProgressBar.getMax()) {
			completionMessage.setText("You did it!");
		} else {
			completionMessage.setText("");
		}
	}
	
	public void onPause() {
		super.onPause();
		save();
		if (changesMade) {
			Toast.makeText(getActivity(), "Progress Saved", Toast.LENGTH_SHORT).show();
		}
	}
	
	public void onResume() {
		super.onResume();
		load();
	}
	
	/**
	 * Save the current state of the checkboxes and other views
	 */
	private void save() {
		Editor editor = sharedPrefs.edit();
		//Checklist
		editor.putBoolean("Chk1Value", chk1.isChecked());
		editor.putBoolean("Chk2Value", chk2.isChecked());
		editor.putBoolean("Chk3Value", chk3.isChecked());
		editor.putBoolean("ChkaValue", chka.isChecked());
		editor.putBoolean("ChkbValue", chkb.isChecked());
		
		//SeekBars
		editor.putInt("fellowshipSeekBarValue", fellowshipSeekBar.getProgress());
		editor.putString("fellowshipSeekBarText", fellowshipsValueText.getText() + "");
		
		editor.putInt("serviceHoursSeekBarValue", serviceHoursSeekBar.getProgress());
		editor.putString("serviceHoursSeekBarText", serviceHoursValueText.getText() + "");
		
		editor.putInt("primaryMeetingsSeekBarValue", primaryMeetingsSeekBar.getProgress());
		editor.putString("primaryMeetingsSeekBarText", primaryMeetingsValueText.getText() + "");
		
		//Progress Bar
		editor.putInt("ProgressBarValue", mProgressBar.getProgress());
		editor.putString("CompletionMessage", completionMessage.getText() + "");
		
		//Save
		editor.commit();
	}
	
	private void load() {
		//Checkboxes
		chk1.setChecked(sharedPrefs.getBoolean("Chk1Value", false));
		chk2.setChecked(sharedPrefs.getBoolean("Chk2Value", false));
		chk3.setChecked(sharedPrefs.getBoolean("Chk3Value", false));
		chka.setChecked(sharedPrefs.getBoolean("ChkaValue", false));
		chkb.setChecked(sharedPrefs.getBoolean("ChkbValue", false));
				
		//SeekBars
		fellowshipSeekBar.setProgress(sharedPrefs.getInt("fellowshipSeekBarValue", 0));
		serviceHoursSeekBar.setProgress(sharedPrefs.getInt("serviceHoursSeekBarValue", 0));
		primaryMeetingsSeekBar.setProgress(sharedPrefs.getInt("primaryMeetingsSeekBarValue", 0));
		
		//Progress Bar
		mProgressBar.setProgress(sharedPrefs.getInt("ProgressBarValue", 1));
		
		//SeekBar text values
		fellowshipsValueText.setText(sharedPrefs.getString("fellowshipSeekBarText", "0"));
		serviceHoursValueText.setText(sharedPrefs.getString("serviceHoursSeekBarText", "0"));
		primaryMeetingsValueText.setText(sharedPrefs.getString("primaryMeetingsSeekBarText", "0"));

	}

}

