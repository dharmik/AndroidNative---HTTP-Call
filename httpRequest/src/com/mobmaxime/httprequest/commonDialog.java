package com.mobmaxime.httprequest;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.widget.Toast;

public class commonDialog {

	public static AlertDialog AlertDialogSingle(final Context context,
			String Title, String Message, String ButtonName) {
		AlertDialog alertDialog = new AlertDialog.Builder(context).create();

		// Setting Dialog Title
		alertDialog.setTitle(Title);

		// Setting Dialog Message
		alertDialog.setMessage(Message);

		// Setting OK Button
		alertDialog.setButton(ButtonName,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						// Write your code here to execute after dialog closed
						Toast.makeText(context, "You clicked on OK",
								Toast.LENGTH_SHORT).show();
						dialog.dismiss();
					}
				});

		// Showing Alert Message
		return alertDialog;
	}

	public static Builder AlertDialogDouble(final Context context,
			String Title, String Message, String FirstButtonName,
			String SecondButtonName) {

		AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);

		// Setting Dialog Title
		alertDialog.setTitle("Confirm Delete...");

		// Setting Dialog Message
		alertDialog.setMessage("Are you sure you want delete this?");

		// Setting Icon to Dialog
		alertDialog.setIcon(R.drawable.ic_launcher);

		// Setting Positive "Yes" Button
		alertDialog.setPositiveButton(FirstButtonName,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						// Write your code here to invoke YES event
						Toast.makeText(context, "You clicked on YES",
								Toast.LENGTH_SHORT).show();
					}
				});

		// Setting Negative "NO" Button
		alertDialog.setNegativeButton(SecondButtonName,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						// Write your code here to invoke NO event
						Toast.makeText(context, "You clicked on NO",
								Toast.LENGTH_SHORT).show();
						dialog.cancel();
					}
				});
		// Showing Alert Message
		return alertDialog;
	}

	public static Builder AlertDialogThree(final Context context, String Title,
			String Message, String FirstButtonName, String SecondButtonName,
			String ThirdButtonName) {

		AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);

		// Setting Dialog Title
		alertDialog.setTitle("Confirm Delete...");

		// Setting Dialog Message
		alertDialog.setMessage("Are you sure you want delete this?");

		// Setting Icon to Dialog
		alertDialog.setIcon(R.drawable.ic_launcher);

		// Setting Positive "Yes" Button
		alertDialog.setPositiveButton(FirstButtonName,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						// Write your code here to invoke YES event
						Toast.makeText(context, "You clicked on YES",
								Toast.LENGTH_SHORT).show();
					}
				});

		// Setting Negative "NO" Button
		alertDialog.setNegativeButton(SecondButtonName,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						// Write your code here to invoke NO event
						Toast.makeText(context, "You clicked on NO",
								Toast.LENGTH_SHORT).show();
						dialog.cancel();
					}
				});

		alertDialog.setNeutralButton(ThirdButtonName,
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub

					}
				});
		// Showing Alert Message
		return alertDialog;
	}

	public static String httpCall(String url, Context context) {

		Log.d("URL", url);

		HttpClient httpClient = new DefaultHttpClient();
		Log.d("URL2", url);
		HttpGet httpGet = new HttpGet(url);
		Log.d("U3L2", url);
		HttpResponse response = null;
		String xmll = null;
		Log.d("URL4", url);

		try {
			response = httpClient.execute(httpGet);
			HttpEntity entity = response.getEntity();
			xmll = EntityUtils.toString(entity);
		} catch (ClientProtocolException e) {
			Log.d("HttpError", e.getMessage() + "");
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			Log.d("HttpError", e.getMessage() + "");
			e.printStackTrace();
		}

		return xmll;

	}

	public static JSONObject xml2json(String data) {

		Log.e("hi", "msg");

		JSONObject jsonData = null;
		try {
			jsonData = XML.toJSONObject(data);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return jsonData;

	}

}
