package com.mobmaxime.httprequest;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

public class MainActivity extends Activity {

	String url = null;
	private ListView listView;

	final Context context = this;
	List<createRow> rowItems;
	LazyAdapter adapter;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.d("URL", "Hmm");
		rowItems = new ArrayList<createRow>();

		listView = (ListView) findViewById(R.id.list_item);

		url = "https://in.news.yahoo.com/rss/";

		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				String data = commonDialog.httpCall(url,
						getApplicationContext());

				JSONObject jsonData = commonDialog.xml2json(data);
				JSONObject rss;
				JSONObject channel;
				JSONArray items = null;
				try {
					rss = jsonData.getJSONObject("rss");
					channel = rss.getJSONObject("channel");
					items = channel.getJSONArray("item");
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				Log.d("Lengh", items.length() + "");

				for (int i = 0; i < items.length(); i++) {
					try {
						JSONObject content = items.getJSONObject(i);

						String title = content.getString("title");
						Log.d("Title", title);
						rowItems.add(new createRow(title));
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				runOnUiThread(new Runnable() {
					@Override
					public void run() {

						// stuff that updates ui
						adapter = new LazyAdapter(getApplicationContext(),
								rowItems);

						listView.setAdapter(adapter);
					}
				});

			}
		});
		thread.start();

		// commonDialog.httpCall(url);
	}

}
