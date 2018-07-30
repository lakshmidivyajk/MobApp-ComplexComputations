package course.examples.Services.KeyClient;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static course.examples.Services.KeyClient.FragmentActivity.mPlacesArray;
import static course.examples.Services.KeyClient.FragmentActivity.mPlacesURLArray;
import static course.examples.Services.KeyClient.KeyServiceUser.api1_list;

/**
 * Created by laksh on 10/30/2017.
 */

public class displayFragment extends Fragment {

    private static final String TAG = "KeyServiceUser";
    private int mCurrIdx = -1;
    private int mDisplayArrLen;
    List<Integer>a=new ArrayList<Integer>();
    List<List<Integer>>b=new ArrayList<List<Integer>>();
    private TextView wv=null,yeardisp=null;
    int getShownIndex() {
        return mCurrIdx;
    }

    // Show the placesURL string at position newIndex
    void showURLAtIndex(int newIndex) {
        Log.i(TAG+"new index",""+newIndex);
        Log.i(TAG+"length",""+mDisplayArrLen);
        wv.setText("");
        if (newIndex < 0 || newIndex >= mDisplayArrLen)
            return;
        mCurrIdx = newIndex;
//        String url= mPlacesURLArray[mCurrIdx]; //getting the url at position mCurrIdx
        Log.d(TAG, "curUrl=======>"+mCurrIdx);
        a.add(1);
        a.add(2);
        b.add(a);
        List<Integer>c=b.get(0);
        for(int elem : c){
            String temp=""+elem;
           // wv.append("\n"+temp);
            Log.i(TAG+"@",temp);
        }

       List<Integer> i=KeyServiceUser.result.get(mCurrIdx);
        Log.i(TAG+"#",""+mCurrIdx);

        for(int elem : i){
            String temp=""+elem;
            wv.append("\n"+temp);
        }

        /*switch(mCurrIdx){
            case 0:{
                if(!KeyServiceUser.api1_list.isEmpty()){
                    for(int elem : api1_list){
                        String temp=""+elem;
                        wv.append("\n"+temp);
                    }
                }else{
                    wv.setText("PRESS THE MONTHLYCASH BUTTON IN THE PREVIOUS SCREEN TO RETRIEVE THE RESULT");
                }

                   }break;
            case 1:{
                if(!KeyServiceUser.api2_list.isEmpty()){
                    for(int elem : KeyServiceUser.api2_list){
                        String temp=""+elem;
                        wv.append("\n"+temp);

                    }
                }else{
                    wv.setText("PRESS THE DAILYCASH BUTTON IN THE PREVIOUS SCREEN TO RETRIEVE THE RESULT");
                }

            }break;
            case 2:{
                if(!KeyServiceUser.api3_list.isEmpty()){
                    for(int elem : KeyServiceUser.api3_list){
                        String temp=""+elem;
                        wv.append("\n"+temp);
                    }
                }else{
                    wv.setText("PRESS THE YEARLYAVERAGE BUTTON IN THE PREVIOUS SCREEN TO RETRIEVE THE RESULT");
                }

            }break;
        }*/


      //  wv.setText(mPlacesURLArray[mCurrIdx]);
       // wv.getSettings().setJavaScriptEnabled(true);
        //Setting up webClient for handling the url instead of the host application.
       // wv.setWebViewClient(new webClient());
        //Loading the url in the web view.
      //  wv.loadUrl(url);


    }

    @Override
    public void onAttach(Activity activity) {
        Log.i(TAG, getClass().getSimpleName() + ":entered onAttach()");
        super.onAttach(activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, getClass().getSimpleName() + ":entered onCreate()");
        super.onCreate(savedInstanceState);
        setRetainInstance(true);//Retaining the state of displayFragment.
    }

    // Called to create the content view for this Fragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i(TAG, getClass().getSimpleName() + ":entered onCreateView()");

        // Inflate the layout defined in display_fragment.xml
        // The last parameter is false because the returned view does not need to be attached to the container ViewGroup
        return inflater.inflate(R.layout.display_fragment,
                container, false);
    }

    // Set up some information about the wv WebView
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        Log.i(TAG, getClass().getSimpleName() + ":entered onActivityCreated()");
        super.onActivityCreated(savedInstanceState);

      //get the WebView in wv based on its id placesURL.
        wv = (TextView) getView().findViewById(R.id.placesURL);

        mDisplayArrLen = mPlacesArray.length;
    }

    @Override
    public void onStart() {
        Log.i(TAG, getClass().getSimpleName() + ":entered onStart()");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.i(TAG, getClass().getSimpleName() + ":entered onResume()");
        super.onResume();
    }


    @Override
    public void onPause() {
        Log.i(TAG, getClass().getSimpleName() + ":entered onPause()");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.i(TAG, getClass().getSimpleName() + ":entered onStop()");
        super.onStop();
    }

    @Override
    public void onDetach() {
        Log.i(TAG, getClass().getSimpleName() + ":entered onDetach()");
        super.onDetach();
    }


    @Override
    public void onDestroy() {
        Log.i(TAG, getClass().getSimpleName() + ":entered onDestroy()");
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        Log.i(TAG, getClass().getSimpleName() + ":entered onDestroyView()");
        super.onDestroyView();
    }
}
