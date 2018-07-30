package course.examples.Services.KeyService;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import static android.content.ContentValues.TAG;

/**
 * Created by laksh on 12/2/2017.
 */

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class JSONfunctions{

        private static String url="null";

    public static String myHTTPCLIENT(String link)
    {
        StringBuffer sb = new StringBuffer("");
        String json="";
        JSONObject jObj;
        try
        {
            //String link="http://api.treasury.io/cc7znvq/47d80ae900e04f2/sql/?q=SELECT%20*%20FROM%20t2%20WHERE%20transaction_type%20=%20%27withdrawal%27%20ORDER%20BY%20date%20DESC%20LIMIT%2010";
            // String link="http://api.treasury.io/cc7znvq/47d80ae900e04f2/sql/?q=SELECT+DISTINCT+open_mo%2C+month%0AFROM%0At1%0AWHERE+year%3D'2006'++AND+ACCOUNT%3D%22Federal+Reserve+Account%22+GROUP+BY++MONTH";



            URL url = new URL(link);
            HttpClient client = new DefaultHttpClient();
            HttpGet request = new HttpGet();
            request.setURI(new URI(link));
            HttpResponse response = client.execute(request);
            BufferedReader in = new BufferedReader(new
                    InputStreamReader(response.getEntity().getContent()));


            String line="";

            while ((line = in.readLine()) != null) {
                sb.append(line);
                break;
            }
            json=sb.toString();


            in.close();

        }catch(Exception e){
            e.printStackTrace();
        }




        return sb.toString();
    }





}

