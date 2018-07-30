package course.examples.Services.KeyClient;

import android.app.Activity ;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import course.examples.Services.KeyCommon.KeyGenerator;

public class KeyServiceUser extends Activity {

	protected static final String TAG = "KeyServiceUser";
	private KeyGenerator mKeyGeneratorService;
	private boolean mIsBound = false;
	public static int year_int=2007;
	public  String temp,newSD,newED,str="",json=null;
	public EditText year;
	final static String DATE_FORMAT = "yyyy/mm/dd";
	final static DateFormat df = new SimpleDateFormat(DATE_FORMAT);
	public EditText startDate,nod;
	public  Date sd=null,ed=null;
	public static int days;
	public static JSONArray jsonArray=null;
	public static List<Integer> api1_list=new ArrayList<Integer>();
	public static List<Integer> api2_list=new ArrayList<Integer>();
	public static List<Integer>api3_list=new ArrayList<Integer>();
	public static List<String> list_of_calls=new ArrayList<String>();
	public static List<List<Integer>>result=new ArrayList<List<Integer>>();
	public static int index=0;

	/**
	 * ATTENTION: This was auto-generated to implement the App Indexing API.
	 * See https://g.co/AppIndexing/AndroidStudio for more information.
	 */
	private GoogleApiClient client;

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);

		setContentView(R.layout.main);
		//final TextView labelOutput=(TextView) findViewById(R.id.labeloutput);

		//final TextView output = (TextView) findViewById(R.id.output);
		 year=(EditText)findViewById(R.id.year);

		 startDate=(EditText)findViewById(R.id.startDate);
		 nod=(EditText)findViewById(R.id.nod);

		//String temp1=;


		  //year_int=Integer.parseInt(year.getText().toString());


		final Button api1 = (Button) findViewById(R.id.api1);
		api1.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				list_of_calls.add("MonthlyCash");

				try {

					Log.i(TAG,year.getText().toString());
					year_int=Integer.parseInt(year.getText().toString());
					if(!(year_int>=2006&&year_int<=2016)){
						year.setText("");
						Toast.makeText(getApplicationContext(),"year is between 2006 and 2016 inclusive",Toast.LENGTH_LONG).show();
					}
					else
					{// Call KeyGenerator and get a new ID
						if (mIsBound)
						{
							json=""+mKeyGeneratorService.mC(year_int);
							Log.i(TAG+"SUCCESS=>",json);

							Log.i(TAG,json);

							//JSONObject jsonObj = (JSONObject) parser.parse(stringToParse);
							try{
								Log.i(TAG,"inside the try 2"+json);
								jsonArray=new JSONArray(json);
								Log.i(TAG,"HI===>"+jsonArray.toString());
							}catch (Exception e){e.printStackTrace();}

							parseJSONArray(jsonArray);
							//Log.i(TAG+"MC===>",result.toString());
							Log.i(TAG,api1_list.toString());


							//finish();
							//labelOutput.setText(mKeyGeneratorService.getKey());
							//output.setText(temp);
						}

						else {
							Log.i(TAG, "the service was not bound!");
							myBind();
							try{
								Log.i(TAG,"inside else try"+mIsBound);
								if (mIsBound)
								{
									json=""+mKeyGeneratorService.mC(year_int);
									Log.i(TAG+"SUCCESS=>",json);

									Log.i(TAG,json);

									//JSONObject jsonObj = (JSONObject) parser.parse(stringToParse);
									try{
										Log.i(TAG,"inside the try 2"+json);
										jsonArray=new JSONArray(json);
										Log.i(TAG,"HI===>"+jsonArray.toString());
										//result.add(api1_list);
									}catch (Exception e){e.printStackTrace();}

									parseJSONArray(jsonArray);
									Log.i(TAG,api1_list.toString());
									}
							}catch (RemoteException e){

							}
						}
					}


				} catch (RemoteException e) {

					Log.e(TAG, e.toString());

				}
			}
		});


		final Button api2 = (Button) findViewById(R.id.api2);
		api2.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				list_of_calls.add("DailyCash");

				try
				{

					Log.i(TAG,"inside button 2");
					Log.i(TAG+"==>",startDate.getText().toString());
					try{
						if(isDateValid(startDate.getText().toString())){
							Log.i(TAG,"TRUE");
							sd=new Date(startDate.getText().toString());
							str=startDate.getText().toString();
						}else{
							Log.i(TAG,"FALSE");
							startDate.setText("");
							Toast.makeText(getApplicationContext(),"DATE==>yyyy/mm/dd,year between 2006 to 2016",Toast.LENGTH_SHORT).show();
						}




					}catch(Exception e){e.printStackTrace();}

					days=Integer.parseInt(nod.getText().toString());
					if(!(days>=5 &&days<=25)){
						nod.setText("");
						Toast.makeText(getApplicationContext(),"END DATE MUST BE 5 TO 25 WORKING DAYS FROM THE START DATE",Toast.LENGTH_SHORT).show();
					}




					//int days = Days.daysBetween(sd, ed).getDays();

					//year_int=Integer.parseInt(year.getText().toString());
					// Call KeyGenerator and get a new ID
					else
					{
						if (mIsBound)
						{
							Log.i(TAG,"inside button 2" +"isbound");


							Log.i(TAG,"DAYS===>" +days);
							//int d=(int)days;
							if(str!=null){
								String[] par=str.split("/");
								json=mKeyGeneratorService.dC(Integer.parseInt(par[2]),Integer.parseInt(par[1]),Integer.parseInt(par[0]),days);
								Log.i(TAG,json);

								//JSONObject jsonObj = (JSONObject) parser.parse(stringToParse);
								try{
									Log.i(TAG,"inside the try 2"+json);
									jsonArray=new JSONArray(json);
									Log.i(TAG,"HI===>"+jsonArray.toString());
								}catch (Exception e){e.printStackTrace();}

								parseJSONArray_api2(jsonArray);
								//Log.i(TAG+"DC===>",result.toString());
								//result.add(api2_list);
								Log.i(TAG,api1_list.toString());

							}

							//labelOutput.setText(mKeyGeneratorService.getKey());
							//output.setText(temp);
						}

						else {
							Log.i(TAG, "the service was not bound!");
							myBind();
							if (mIsBound)
							{
								Log.i(TAG,"inside button 2" +"isbound");


								Log.i(TAG,"DAYS===>" +days);
								//int d=(int)days;
								if(str!=null){
									String[] par=str.split("/");
									json=mKeyGeneratorService.dC(Integer.parseInt(par[2]),Integer.parseInt(par[1]),Integer.parseInt(par[0]),days);
									Log.i(TAG,json);

									//JSONObject jsonObj = (JSONObject) parser.parse(stringToParse);
									try{
										Log.i(TAG,"inside the try 2"+json);
										jsonArray=new JSONArray(json);
										Log.i(TAG,"HI===>"+jsonArray.toString());
									}catch (Exception e){e.printStackTrace();}

									parseJSONArray_api2(jsonArray);
									Log.i(TAG,api1_list.toString());
									//result.add(api2_list);


								}

								//labelOutput.setText(mKeyGeneratorService.getKey());
								//output.setText(temp);
							}
						}
					}


				} catch (RemoteException e) {

					Log.e(TAG, e.toString());

				}
			}
		});

		final Button api3 = (Button) findViewById(R.id.api3);
		api3.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				list_of_calls.add("YearlyCash");
				try {

					Log.i(TAG,year.getText().toString());
					year_int=Integer.parseInt(year.getText().toString());
					if(!(year_int>2005&&year_int<2017)){
						year.setText("");
						Toast.makeText(getApplicationContext(),"year is between 2006 and 2016 inclusive",Toast.LENGTH_LONG).show();
					}
					// Call KeyGenerator and get a new ID
					else
					{// Call KeyGenerator and get a new ID
						if (mIsBound)
						{
							json=""+mKeyGeneratorService.yA(year_int);
							Log.i(TAG+"SUCCESS=>",json);

							Log.i(TAG,json);

							//JSONObject jsonObj = (JSONObject) parser.parse(stringToParse);
							try{
								Log.i(TAG,"inside the try 2"+json);
								jsonArray=new JSONArray(json);
								Log.i(TAG,"HI===>"+jsonArray.toString());
							}catch (Exception e){e.printStackTrace();}

							parseJSONArray_api3(jsonArray);
							//Log.i(TAG+"YA===>",result.toString());
							Log.i(TAG,api3_list.toString());
							//result.add(api3_list);

							//finish();
							//labelOutput.setText(mKeyGeneratorService.getKey());
							//output.setText(temp);
						}

						else {
							Log.i(TAG, "the service was not bound!");
							myBind();
							if (mIsBound)
							{
								json=""+mKeyGeneratorService.yA(year_int);
								Log.i(TAG+"SUCCESS=>",json);

								Log.i(TAG,json);

								//JSONObject jsonObj = (JSONObject) parser.parse(stringToParse);
								try{
									Log.i(TAG,"inside the try 2"+json);
									jsonArray=new JSONArray(json);
									Log.i(TAG,"HI===>"+jsonArray.toString());
								}catch (Exception e){e.printStackTrace();}

								parseJSONArray_api3(jsonArray);

								Log.i(TAG,api3_list.toString());
								//result.add(api3_list);

								//finish();
								//labelOutput.setText(mKeyGeneratorService.getKey());
								//output.setText(temp);
							}
						}
					}

				} catch (RemoteException e) {

					Log.e(TAG, e.toString());

				}
			}
		});

		final Button unbind = (Button) findViewById(R.id.unbind);
		unbind.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {

				myUnbind();
			}
		});

		final Button LOC = (Button) findViewById(R.id.loc);
		LOC.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Log.i(TAG+"GOD$$$$",result.toString());

				Intent i=new Intent(getApplicationContext(),FragmentActivity.class);
				startActivity(i);
			}
		});


		// ATTENTION: This was auto-generated to implement the App Indexing API.
		// See https://g.co/AppIndexing/AndroidStudio for more information.
		client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
	}

	// Bind to KeyGenerator Service
	@Override
	protected void onResume() {
		super.onResume();

		if (!mIsBound) {

			boolean b = false;
			Intent i = new Intent(KeyGenerator.class.getName());

			// UB:  Stoooopid Android API-20 no longer supports implicit intents
			// to bind to a service #@%^!@..&**!@
			// Must make intent explicit or lower target API level to 19.
			ResolveInfo info = getPackageManager().resolveService(i, Context.BIND_AUTO_CREATE);
			i.setComponent(new ComponentName(info.serviceInfo.packageName, info.serviceInfo.name));

			b = bindService(i, this.mConnection, Context.BIND_AUTO_CREATE);
			if (b) {
				Log.i(TAG, " bindService() succeeded!");
			} else {
				Log.i(TAG, " bindService() failed!");
			}

		}
	}

	// Unbind from KeyGenerator Service
	@Override
	protected void onPause() {

	/*	if (mIsBound) {

			unbindService(this.mConnection);
			mIsBound=false;

		}*/
		startDate.setText("");
		nod.setText("");
		year.setText("");

		super.onPause();
	}

	private final ServiceConnection mConnection = new ServiceConnection() {

		public void onServiceConnected(ComponentName className, IBinder iservice) {

			mKeyGeneratorService = KeyGenerator.Stub.asInterface(iservice);

			mIsBound = true;

		}

		public void onServiceDisconnected(ComponentName className) {

			mKeyGeneratorService = null;

			mIsBound = false;

		}
	};





	@Override
	public void onStart() {
		super.onStart();

		// ATTENTION: This was auto-generated to implement the App Indexing API.
		// See https://g.co/AppIndexing/AndroidStudio for more information.
		client.connect();
		Action viewAction = Action.newAction(
				Action.TYPE_VIEW, // TODO: choose an action type.
				"KeyServiceUser Page", // TODO: Define a title for the content shown.
				// TODO: If you have web page content that matches this app activity's content,
				// make sure this auto-generated web page URL is correct.
				// Otherwise, set the URL to null.
				Uri.parse("http://host/path"),
				// TODO: Make sure this auto-generated app deep link URI is correct.
				Uri.parse("android-app://course.examples.Services.KeyClient/http/host/path")
		);
		AppIndex.AppIndexApi.start(client, viewAction);
	}

	@Override
	public void onStop() {
		super.onStop();

		// ATTENTION: This was auto-generated to implement the App Indexing API.
		// See https://g.co/AppIndexing/AndroidStudio for more information.
		Action viewAction = Action.newAction(
				Action.TYPE_VIEW, // TODO: choose an action type.
				"KeyServiceUser Page", // TODO: Define a title for the content shown.
				// TODO: If you have web page content that matches this app activity's content,
				// make sure this auto-generated web page URL is correct.
				// Otherwise, set the URL to null.
				Uri.parse("http://host/path"),
				// TODO: Make sure this auto-generated app deep link URI is correct.
				Uri.parse("android-app://course.examples.Services.KeyClient/http/host/path")
		);
		AppIndex.AppIndexApi.end(client, viewAction);
		client.disconnect();
	}




	public static boolean isDateValid(String date)
	{
		try {
			String[] parts=date.split("/");
			if(Integer.parseInt(parts[0])>2005&&Integer.parseInt(parts[0])<2017&&Integer.parseInt(parts[1])<=12&&Integer.parseInt(parts[2])<=31){
				df.setLenient(false);
				df.parse(date);
				return true;

			}


		} catch (ParseException e) {
			return false;
		}
		return false;
	}
	public static long getDifferenceDays(Date d1, Date d2) {
		long diff = d2.getTime() - d1.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}


	public void parseJSONArray(JSONArray jsonarray){
		api1_list=new ArrayList<Integer>();
		for (int i = 0; i < jsonarray.length(); i++) {
			try{
				JSONObject jsonobject = jsonarray.getJSONObject(i);
				int amt = jsonobject.getInt("open_mo");
				api1_list.add(amt);

			}catch (Exception e){}



		}
		result.add(api1_list);
	}
	public void parseJSONArray_api2(JSONArray jsonarray){
		api2_list=new ArrayList<Integer>();
		for (int i = 0; i < jsonarray.length(); i++) {
			try{
				JSONObject jsonobject = jsonarray.getJSONObject(i);
				int amt = jsonobject.getInt("open_today");
				api2_list.add(amt);

			}catch (Exception e){}


		}
		result.add(api2_list);
	}
	public void parseJSONArray_api3(JSONArray jsonarray){
		api3_list=new ArrayList<Integer>();
		for (int i = 0; i < jsonarray.length(); i++) {
			try{
				JSONObject jsonobject = jsonarray.getJSONObject(i);
				int amt = jsonobject.getInt("AVG(open_today)");
				api3_list.add(amt);

			}catch (Exception e){}

		}
		result.add(api3_list);
	}
	public void myUnbind(){
		if (mIsBound) {

			unbindService(this.mConnection);
			mIsBound=false;

		}

	}
	public void myBind(){
		if (!mIsBound) {

			boolean b = false;
			Intent i = new Intent(KeyGenerator.class.getName());

			// UB:  Stoooopid Android API-20 no longer supports implicit intents
			// to bind to a service #@%^!@..&**!@
			// Must make intent explicit or lower target API level to 19.
			ResolveInfo info = getPackageManager().resolveService(i, Context.BIND_AUTO_CREATE);
			i.setComponent(new ComponentName(info.serviceInfo.packageName, info.serviceInfo.name));

			b = bindService(i, this.mConnection, Context.BIND_AUTO_CREATE);
			if (b) {
				Log.i(TAG, "bindService() succeeded!");
				Log.i(TAG+"MBOUND==>",""+mIsBound);
				mIsBound=true;
			} else {
				Log.i(TAG, "bindService() failed!");

			}

		}

	}
}
