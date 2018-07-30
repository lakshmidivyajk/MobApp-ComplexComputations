package course.examples.Services.KeyService;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by laksh on 12/3/2017.
 */

public class MainActivity extends Activity{
    private  TextView tv=null;
    public static  String TAG="log_tag";
    public static boolean UNBOUND_flag;
    public static String status="";
    public static boolean destroyed;
//    SharedPreferences prefs = getSharedPreferences("my.preferences", Context.MODE_PRIVATE);
    BroadcastReceiver receiver;
    @Override
    public void onCreate(Bundle sis){

        super.onCreate(sis);
        setContentView(R.layout.activity_main);

        tv=(TextView)findViewById(R.id.status);
        /*LocalBroadcastManager lbm = LocalBroadcastManager.getInstance(this);
        lbm.registerReceiver(receiver, new IntentFilter("filter_string"));
          receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if (intent != null) {
                    String str = intent.getStringExtra("key");
                    // get all your data from intent and do what you want
                    //Log.i(TAG+"###");
                    tv.setText(str);
                }
            }
        };*/


            tv.setText(status);


       /* if(KeyGeneratorImpl.flag){

        }*/

       /* prefs = getSharedPreferences("my.preferences", Context.MODE_PRIVATE);
        tv.setText(prefs.getString("status",""));*/


    }

    @Override
    protected void onResume(){
        super.onResume();
       tv.setText(status);


    }



}
