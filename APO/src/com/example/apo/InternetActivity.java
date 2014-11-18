/**
 * Async Task to download html from website, then find xml in it
 */

package com.example.apo;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.xmlpull.v1.XmlPullParserException;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.widget.Toast;

public class InternetActivity extends AsyncTask<String, Void, String> {

	   private Context context;
	   InputStream stream = null;

	   public InternetActivity(Context context) {
	      this.context = context;
	   }

	   //check Internet connection.
	   private void checkInternetConnection(){
	       ConnectivityManager check = (ConnectivityManager) this.context.
	       getSystemService(Context.CONNECTIVITY_SERVICE);
	       if (check != null) {
	          NetworkInfo[] info = check.getAllNetworkInfo();
	          if (info != null) 
	             for (int i = 0; i <info.length; i++) {
	                 if (info[i].getState() == NetworkInfo.State.CONNECTED) {
	                	 Toast.makeText(context, "Internet is connected",
	            		 Toast.LENGTH_SHORT).show();
	            	 }
	             }
	       } else {
	          Toast.makeText(context, "not connected to internet",
	          Toast.LENGTH_SHORT).show();
	       }
	   }
	   
	   protected void onPreExecute(){
	       super.onPreExecute();
	       checkInternetConnection();
	   }
	   @Override
	   protected String doInBackground(String... arg0) {
		   try{
			   return loadXmlFromNetwork(arg0[0]);
		   } catch (IOException e) {
			   return context.getResources().getString(R.string.connection_error);
		   } catch (XmlPullParserException e) {
			   return context.getResources().getString(R.string.xml_error);
		   }
	   }
	   
	   // Sets the input stream to the xml file
	   private String loadXmlFromNetwork(String urlString) throws XmlPullParserException, IOException {
		   
		   try {
			   stream = downloadUrl(urlString);
		   } finally {
			   if (stream != null) {
				   stream.close();
			   }
		   }

		    return "downloaded";

	   }
	   
	   //Actually download the html file
	   private InputStream downloadUrl(String urlString) throws IOException {
		    URL url = new URL(urlString);
		    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		    conn.setReadTimeout(10000);
		    conn.setConnectTimeout(15000);
		    conn.setRequestMethod("GET");
		    conn.setDoInput(true);
		    // Starts the query
		    conn.connect();
		    return conn.getInputStream();
	   }
	   
	   
	   @Override
	   protected void onPostExecute(String result){
		   super.onPostExecute(result);
	   }
	   
	   public InputStream getInputStream() {
		   return stream;
	   }
}
