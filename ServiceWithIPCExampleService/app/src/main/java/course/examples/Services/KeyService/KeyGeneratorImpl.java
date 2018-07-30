package course.examples.Services.KeyService;

import java.net.URLEncoder;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.widget.Toast;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import course.examples.Services.KeyCommon.KeyGenerator;

public class KeyGeneratorImpl extends Service {

	// Set of already assigned IDs
	// Note: These keys are not guaranteed to be unique if the Service is killed 
	// and restarted.

	private final  Set<UUID> mIDs = new HashSet<UUID>();
	private final  String TAG="log_tag";
	//private int year=0;
	public   JSONArray jsonArray=null;
	public String sd="",ed="";
	public HandlerThread responseHandler;
	public   String json;
	public String status="";
	//public boolean flag=false;
	private volatile  String value;


	// Implement the Stub for this Object
	private  KeyGenerator.Stub mBinder = new KeyGenerator.Stub() {

		// Implement the remote method
		public String getKey() {

			UUID id;

			// Acquire lock to ensure exclusive access to mIDs 
			// Then examine and modify mIDs

			synchronized (mIDs) {

				do {

					id = UUID.randomUUID();
					Log.i(TAG,"in service");

				} while (mIDs.contains(id));

				mIDs.add(id);
			}
			return id.toString();
		}



		public String mC(final int year){
			//int[] a={1,2};
			MainActivity.status="BOUNDED WITH ONE OR MORE CLIENTS RUNNING MonthlyCash Method";

			String link="http://api.treasury.io/cc7znvq/47d80ae900e04f2/sql/?q=SELECT+DISTINCT+open_mo%2C+month%0AFROM%0At1%0AWHERE+year%3D'"+year+"'++AND+ACCOUNT%3D%22Total+Operating+Balance%22+GROUP+BY++MONTH";
			Log.i(TAG,"BOUNDED WITH ONE OR MORE CLIENTS RUNNING AN API");
			try{
				a foo = new a(link);
				Thread t=new Thread(foo);
				t.start();t.join();
				 value = foo.getResult();
			}catch (Exception e){}






			Log.i(TAG+"===>",""+value);
			return value;
		}



		public String dC(final int day,final int month,final int year,final int nod){
			MainActivity.status="BOUNDED WITH ONE OR MORE CLIENTS RUNNING DailyCash Method";


			Log.i(TAG,"BOUNDED WITH ONE OR MORE CLIENTS RUNNING AN API");
						//Your code goes here
						Log.i(TAG,"Starting...");


						String mo="",da="",eod_t="";
						Log.i(TAG,""+month);
						sd=""; ed="";
						if(Integer.toString(Math.abs(month)).trim().length()==1){
							Log.i(TAG,"sucess");
							mo="0"+month;

						}
						else{
							mo=""+month;
						}
						if(Integer.toString(Math.abs(day)).trim().length()==1){
							Log.i(TAG,"sucess");
							da="0"+day;

						}
						else{
							da=""+day;
						}
						Log.i(TAG,"MONTH===>"+mo);
						sd=year+"-"+mo+"-"+da;

						Log.i(TAG+"$$$",sd+":::"+nod);

						String link="http://api.treasury.io/cc7znvq/47d80ae900e04f2/sql/?q=select%20open_today%20%2C%20DATE%20FROM%20T1%20WHERE%20ACCOUNT%3D%22Total%20Operating%20Balance%22%20and%20date%3E%3D'"+sd+"'%20LIMIT%20"+nod;

						try{
							a foo = new a(link);
							Thread t=new Thread(foo);
							t.start();t.join();
							value = foo.getResult();
						}catch (Exception e){}






						Log.i(TAG+"===>",""+value);
						return value;

						//Log.i(TAG,jsonobject);





		}
		public String yA(int year){
			MainActivity.status="BOUNDED WITH ONE OR MORE CLIENTS RUNNING yearlyAverage Method";
			Log.i(TAG,"BOUNDED WITH ONE OR MORE CLIENTS RUNNING AN API");
			try  {
				//Your code goes here
				Log.i(TAG,"Starting...");

				String link="http://api.treasury.io/cc7znvq/47d80ae900e04f2/sql/?q=select+AVG(open_today)+from+t1+where+year%3D'"+year+"'+and+account%3D%22Total+Operating+Balance%22";
				try{
					a foo = new a(link);
					Thread t=new Thread(foo);
					t.start();t.join();
					value = foo.getResult();
				}catch (Exception e){}






				Log.i(TAG+"===>",""+value);
				return value;

				//Log.i(TAG,jsonobject);
			} catch (Exception e) {
				e.printStackTrace();
			}

			return null;
		}
	};



	// Return the Stub defined above
	@Override
	public IBinder onBind(Intent intent) {
		/*Intent i=new Intent(getApplicationContext(),MainActivity.class);
		i.putExtra("STATUS","BOUNDED WITH ONE OR MORE CLIENTS");
		startActivity(i);*/
		//runOnUiThread(new Thread())


		/*Intent in = new Intent("filter_string");
		in.putExtra("key", "My Data");
		// put your all data using put extra

		LocalBroadcastManager.getInstance(this).sendBroadcast(intent);*/

		//MainActivity.flag=true;
		MainActivity.UNBOUND_flag=false;
		MainActivity.status="BOUNDED WITH ONE OR MORE CLIENTS BUT IDLE";

		Log.i(TAG,"BOUNDED WITH ONE OR MORE CLIENTS BUT IDLE");




		return mBinder;
	}
	@Override
public void onDestroy() {

		MainActivity.destroyed=false;
		MainActivity.status="SERVICE DESTROYED";
 }
 @Override
	public boolean onUnbind(Intent intent){
		Log.i(TAG,"UNBOUND");
		//MainActivity.UNBOUND_flag=true;
		MainActivity.status="NOT YET BOUND";
		return false;
 }





}
