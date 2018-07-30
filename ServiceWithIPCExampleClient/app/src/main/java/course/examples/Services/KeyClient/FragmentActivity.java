package course.examples.Services.KeyClient;

/**
 * Created by laksh on 12/4/2017.
 */
import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;
public class FragmentActivity extends Activity  implements
        placesFragment.ListSelectionListener {

    public static String[] mPlacesArray;  //Array for storing the place names.
    public static String[] mPlacesURLArray;//Array for storing the urls for all the places.




    private final displayFragment mDisplayFragment = new displayFragment();
    private FragmentManager mFragmentManager;
    private FrameLayout mPlacesFrameLayout, mDisplayFrameLayout; //Getting the framelayouts.
    placesFragment mPF;
    displayFragment mDF;
    private static final String TAG_PLACES_FRAGMENT ="PF"; //TAG for place fragment while its being created.
    private static final String TAG_DISPLAY_FRAGMENT ="DF"; //TAG for display fragment while its being created.


    private static final int MATCH_PARENT = LinearLayout.LayoutParams.MATCH_PARENT;
    private static final String TAG = "KeyServiceUser";







    @Override
    protected void onCreate(final Bundle savedInstanceState) {

        Log.i(TAG, getClass().getSimpleName() + ":entered onCreate()");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
       // getSupportActionBar().setTitle("PROJECT3 A1"); //Statement to set the action bar with the title.

        // Get the string arrays with the places and placesURL
       // mPlacesArray = (String[])KeyServiceUser.list_of_calls.toArray();
        mPlacesArray= new String[KeyServiceUser.list_of_calls.size()];
        mPlacesArray = KeyServiceUser.list_of_calls.toArray(mPlacesArray);

        mPlacesURLArray = getResources().getStringArray(R.array.PlacesURL);
        Log.i(TAG,""+mPlacesArray.length);


        // Get references to the placesFragment and to the displayFragment
        mPlacesFrameLayout = (FrameLayout) findViewById(R.id.places_fragment);
        mDisplayFrameLayout = (FrameLayout) findViewById(R.id.url_fragment);

        // Get a reference to the FragmentManager
        mFragmentManager = getFragmentManager();

        // Start a new FragmentTransaction
        FragmentTransaction fragmentTransaction = mFragmentManager
                .beginTransaction();


        //Get the retained fragments:
        mPF = (placesFragment) mFragmentManager.findFragmentByTag(TAG_PLACES_FRAGMENT);
        mDF = (displayFragment) mFragmentManager.findFragmentByTag(TAG_DISPLAY_FRAGMENT);
        //If first time create the placesFragment:
        if (mPF == null) {
            Log.d(TAG, "-----------------Places Fragment not retained SO CREATING THE FIRST INSTANCE!!!!!");
            fragmentTransaction.replace(R.id.places_fragment,
                    new placesFragment(), TAG_PLACES_FRAGMENT);

            // Commit the FragmentTransaction
            fragmentTransaction.commit();



        }
        //In else part firstly, we need to add the retained placesfragment to the framelayout.
        //Next, we need to check if the displayFragment is present or not.
        //If present, add the retained displayFragment to the framelayout else create a new one and add it to the framelayout.
        else {

            Log.d(TAG, "-----------------Places Fragment  retained");
            fragmentTransaction.replace(R.id.places_fragment,
                    mPF, TAG_PLACES_FRAGMENT);
            if (mDF != null) {
                Log.d(TAG, "-----------------Display Fragment retained MOSTLY IN LANDSCAPE MODE WITH 2 FRAGMENTS :D");
                fragmentTransaction.replace(R.id.url_fragment,
                        mDF, TAG_DISPLAY_FRAGMENT);
            } else {
                Log.d(TAG, "-----------------Display Fragment not retained MOSTLY IN LANDSCAPE MODE WITH 1 FRAGMENT BUT CREATED OTHER ONE");
                mDF = new displayFragment();

                fragmentTransaction.replace(R.id.url_fragment,
                        mDF, TAG_DISPLAY_FRAGMENT);

            }


            // Commit the FragmentTransaction
            fragmentTransaction.commit();




        }
        // Add a OnBackStackChangedListener to reset the layout when the back stack changes
        mFragmentManager
                .addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
                    public void onBackStackChanged() {

                        setLayout();
                    }
                });

    }

    private void setLayout( ) {

        // Determine whether the displayFragment has been added
        if(getResources().getConfiguration().orientation== Configuration.ORIENTATION_PORTRAIT) {

            if (!mDisplayFragment.isAdded()) {
                Log.d(TAG,"--------------------PORTRAIT+URL NOT ADDED");

                // Make the placesFragment occupy the entire layout
                mPlacesFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(MATCH_PARENT,
                        MATCH_PARENT, 1f));

                // Make the displlayFragment take 2/3's of the layout's width
                mDisplayFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(MATCH_PARENT,
                        MATCH_PARENT, 2f));
            }
            else  {
                Log.d(TAG,"---------------PORTRAIT+URL  ADDED");
                // Make the displayFragment occupy the entire layout

                mPlacesFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(MATCH_PARENT,
                        MATCH_PARENT, 1f));

                // Make the displlayFragment take 2/3's of the layout's width
                mDisplayFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(MATCH_PARENT,
                        MATCH_PARENT, 2f));
            }


        }
        else
        {

            if (!mDisplayFragment.isAdded()) {
                Log.d(TAG,"-------------------LANDSCAPE+URL NOT ADDED");
                // Make the placesFragment occupy the entire layout
                mPlacesFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(MATCH_PARENT,
                        MATCH_PARENT, 1f));

                // Make the displlayFragment take 2/3's of the layout's width
                mDisplayFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(MATCH_PARENT,
                        MATCH_PARENT, 2f));
            } else {
                Log.d(TAG,"-------------------LANDSCAPE+URL  ADDED");

                // Make the placesFragment take 1/3 of the layout's width
                mPlacesFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(MATCH_PARENT,
                        MATCH_PARENT, 1f));

                // Make the displlayFragment take 2/3's of the layout's width
                mDisplayFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(MATCH_PARENT,
                        MATCH_PARENT, 2f));
            }


        }

    }

    // Called when the user selects an item in the placesFragment
    @Override
    public void onListSelection(int index) {

        // If the displayFragment has not been added, add it now
        if (!mDisplayFragment.isAdded()) {

            // Start a new FragmentTransaction
            FragmentTransaction fragmentTransaction = mFragmentManager
                    .beginTransaction();

            // Add the displayFragment to the layout
            fragmentTransaction.replace(R.id.url_fragment,
                    mDisplayFragment,TAG_DISPLAY_FRAGMENT);

            // Add this FragmentTransaction to the backstack
            fragmentTransaction.addToBackStack(null);

            // Commit the FragmentTransaction
            fragmentTransaction.commit();

            // Force Android to execute the committed FragmentTransaction
            mFragmentManager.executePendingTransactions();
        }

        if (mDisplayFragment.getShownIndex() != index) {
                Log.i(TAG+"INDEX===>",""+index);
            // Tell the displayFragment to show the url string at position index
            mDisplayFragment.showURLAtIndex(index);

        }
    }

    @Override
    protected void onDestroy() {
        Log.i(TAG, getClass().getSimpleName() + ":entered onDestroy()");
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        Log.i(TAG, getClass().getSimpleName() + ":entered onPause()");
        super.onPause();


    }

    @Override
    protected void onRestart() {
        Log.i(TAG, getClass().getSimpleName() + ":entered onRestart()");
        super.onRestart();
    }

    @Override
    protected void onResume() {
        Log.i(TAG, getClass().getSimpleName() + ":entered onResume()");
        super.onResume();
    }

    @Override
    protected void onStart() {
        Log.i(TAG, getClass().getSimpleName() + ":entered onStart()");
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.i(TAG, getClass().getSimpleName() + ":entered onStop()");
        super.onStop();
    }




}
