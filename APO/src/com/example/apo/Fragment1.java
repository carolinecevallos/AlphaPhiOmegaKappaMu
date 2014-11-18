package com.example.apo;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ViewFlipper;

public class Fragment1 extends Fragment {
	
	String xmlFileName = "news.xml";
	//final String url = "www.alphaphiomegajhuupdates.me";
	//private DropboxAPI<AndroidAuthSession> mDBApi;
	//final static private String APP_KEY = "wdx2e9xp5723qzb";
	//final static private String APP_SECRET = "aqajn5vak6xvdmg";
	//final static private AccessType ACCESS_TYPE = AccessType.APP_FOLDER;
	
	//final int REQUEST_LINK_TO_DBX = 1;
	ListView events;
	InputStream is = null;
	
	ArrayList<Entry> entries;
	
	ArrayAdapter<Entry> adapter;
	final long totalScrollTime = Long.MAX_VALUE;
	final int scrollPeriod = 5000;
	int DELAY = 5000;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_1, container, false);
		
		//Set up slideshow
		ViewFlipper mViewFlipper = (ViewFlipper) view.findViewById(R.id.photo_slideshow);
		mViewFlipper.setInAnimation(getActivity(), android.R.anim.slide_in_left);
		//mViewFlipper.setOutAnimation(getActivity(), android.R.anim.slide_out_right);
		
		//Set up announcements
		events = (ListView) view.findViewById(R.id.eventsListView);
		entries = new ArrayList<Entry>();
		
		//Do Dropbox API stuff
		//AppKeyPair appKeys = new AppKeyPair(APP_KEY, APP_SECRET);
		//AndroidAuthSession session = new AndroidAuthSession(appKeys, ACCESS_TYPE);
		//mDBApi = new DropboxAPI<AndroidAuthSession>(session);
		//mDBApi.getSession().startOAuth2Authentication(((MainActivity)getActivity()));
		
		//InternetActivity ia = new InternetActivity(getActivity());
		//ia.execute(url);
		//is = ia.getInputStream();
		//BufferedReader br = new BufferedReader(new InputStreamReader(is));
		//StringBuilder sb = new StringBuilder();
		//String data;
		/*try {
			while ((data = br.readLine()) != null) {
				sb.append(data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		//Add news events to ListView
		parse();
		//Set adapter for future customization
		adapter = new ArrayAdapter<Entry>(getActivity(),
				android.R.layout.simple_list_item_1, entries);
		events.setAdapter(adapter);
		
		//scroll list
		events.postDelayed(new Runnable() {
			@Override
            public void run() {
                new CountDownTimer(totalScrollTime, scrollPeriod) {
    				int i = 0;
                    public void onTick(long millisUntilFinished) {
                    	//If at end of list, restart
                    	if (i == events.getCount()) {
                    		events.smoothScrollToPosition(0);
                    		i = 0;
                    		DELAY = 5000;
                    	} else {
	                        events.smoothScrollToPosition(i + 1);
	                        i++;
                    	}
                    }

                public void onFinish() {
                    events.smoothScrollToPosition(0);
                    i = 0;
                    this.start();
                }
                
            }.start();
		}
		}, DELAY);
		//adapter.notifyDataSetChanged();
		
		return view;
	}

	private void parse() {
		XmlPullParser parser = Xml.newPullParser();
		try {
			is = getActivity().getApplicationContext().getAssets().open(xmlFileName);
			if (is != null) {
				parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
				parser.setInput(is, null);
				parseXML(parser);
			} else {
				//Toast.makeText(getActivity(), "Failed to download announcements", Toast.LENGTH_LONG).show();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XmlPullParserException e) {
			e.printStackTrace();
		}
	}
	
	private void parseXML(XmlPullParser parser) throws XmlPullParserException, IOException {
		int eventType = parser.getEventType();
		Entry entry = null;
		while (eventType != XmlPullParser.END_DOCUMENT){
			String name = null;
			switch(eventType) {
			case XmlPullParser.START_DOCUMENT:
				entries = new ArrayList<Entry>();
				break;
			case XmlPullParser.START_TAG:
				name = parser.getName();
				if (name.equals("update")) {
					entry = new Entry();
				} else if (entry != null) {
					if (name.equals("description")) {
						entry.description = parser.nextText();
					}
				}
				break;
			case XmlPullParser.END_TAG:
				name = parser.getName();
				if (name.equalsIgnoreCase("update") && entry != null) {
					entries.add(entry);
				}
			}
			
			eventType = parser.next();
		}
		
		//printEntries(entries);
	}
	
	/*public void onResume() {
		super.onResume();
		if (mDBApi.getSession().authenticationSuccessful()) {
			try {
				mDBApi.getSession().finishAuthentication();
				String accessToken = mDBApi.getSession().getOAuth2AccessToken();
			} catch (IllegalStateException) {
				Log.i("DbAuthLog", "Error authenticating", e);
			}
		}
	}*/
	
	/*@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == REQUEST_LINK_TO_DBX) {
			if (resultCode == getActivity().RESULT_OK){
				//dropbox
			} else {
				//result failed
			}
		} else {
			super.onActivityResult(requestCode, resultCode, data);
		}
	}*/


/***************************************************************/
	public static class Entry{
		public String description;
		
		public String toString() {
			return description;
		}
	}
}
