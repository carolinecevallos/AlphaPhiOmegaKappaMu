package com.example.apo;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class Fragment3 extends Fragment {

	ListView mListView;
	
	public Fragment3() {
		super();
	}
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_3, container, false);
		mListView = (ListView) view.findViewById(R.id.frag3List);
		mListView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				switch(position) {
				//Toast song
				case 0:
					goToToast();
					break;
				//Greek Alphabet
				case 1:
					goToGreek();
					break;
				//Board Members
				case 2:
					goToBoard();
					break;
				//APO History
				case 3:
					goToAPOHistory();
					break;
				//Kappa Mu History
				case 4:
					goToKMHistory();
					break;
				}
			}

		});
		return view;
	}

	private void goToToast() {
		Intent intent = new Intent(getActivity(), ToastSongActivity.class);
		startActivity(intent);
	}
	
	private void goToGreek() {
		Intent intent = new Intent(getActivity(), GreekLettersActivity.class);
		startActivity(intent);
	}
	
	private void goToBoard() {
		Intent intent = new Intent(getActivity(), BoardMembersActivity.class);
		startActivity(intent);
	}
	
	private void goToAPOHistory() {
		Intent intent = new Intent(getActivity(), APOHistoryActivity.class);
		startActivity(intent);
	}
	
	private void goToKMHistory() {
		Intent intent = new Intent(getActivity(), KappaMuActivity.class);
		startActivity(intent);
	}
}
