package com.centennial.project.eatouteatsafe.pojos;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutionException;

/**
 * Created by a_b on 21-10-2016.
 */
public class JSONParser {

    HttpURLConnection conn;
    StringBuilder result;
    URL urlObj;
    JSONObject jObj = null;

    public String makeHttpRequest(String url, String method) {

        if (method.equals("POST")) {
            // request method is POST
            // to be enabled only when post is used
           /* try {
                urlObj = new URL(url);

                conn = (HttpURLConnection) urlObj.openConnection();

                conn.setDoOutput(true);

                conn.setRequestMethod("POST");

                conn.setRequestProperty("Accept-Charset", charset);

                conn.setReadTimeout(10000);
                conn.setConnectTimeout(15000);

                conn.connect();

                paramsString = sbParams.toString();

                wr = new DataOutputStream(conn.getOutputStream());
                wr.writeBytes(paramsString);
                wr.flush();
                wr.close();

            }catch (MalformedURLException mfe){
                mfe.printStackTrace();
            }
            catch (IOException e) {
                e.printStackTrace();
            }*/
        }
        else if(method.equals("GET")){
            // request method is GET

            try {
                urlObj = new URL(url);
                conn = (HttpURLConnection) urlObj.openConnection();
                conn.setConnectTimeout(30000);
                conn.setReadTimeout(30000);
                conn.setInstanceFollowRedirects(true);
                conn.connect();
            } catch (IOException ioe) {
                ioe.printStackTrace();
                if(conn != null){ conn.disconnect();}
            } catch (Exception e){
                e.printStackTrace();
                if(conn != null){ conn.disconnect();}
            }
        }

        try {
            //Receive the response from the server
            InputStream in = new BufferedInputStream(conn.getInputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            result = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }catch (Exception e ){
            e.printStackTrace();
        }finally {
            if(conn != null){ conn.disconnect();}
        }


        // try parse the string to a JSON object
        try {
            jObj = new JSONObject(result.toString());
        } catch (JSONException e) {
            Log.e("JSON Parser", "Error parsing data " + e.toString());
        }

        // return JSON Object
        String jsonStr = result.toString();
        return result.toString();
    }
}