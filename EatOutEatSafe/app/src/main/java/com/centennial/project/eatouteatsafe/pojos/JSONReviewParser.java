package com.centennial.project.eatouteatsafe.pojos;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by a_b on 21-10-2016.
 */
public class JSONReviewParser {

    HttpURLConnection conn;
    StringBuilder result;
    URL urlObj;
    JSONObject jObj = null;
    OutputStreamWriter wr;

    public String makeHttpRequest(String url, String method, HashMap<String, String> params) {

        try{
            if(!params.isEmpty()) {
                urlObj = new URL(url);
                conn = (HttpURLConnection) urlObj.openConnection();

                JSONObject cred = new JSONObject();

                for(Map.Entry<String, String> entry : params.entrySet())
                {
                    cred.put(entry.getKey(), entry.getValue());
                    Log.d(entry.getKey() + " ", entry.getValue());
                }

                Log.d("cred ", cred.toString());

                conn.setDoOutput(true);
                conn.setRequestMethod(method);

                conn.setRequestProperty("Content-Type", "application/json");
                conn.setRequestProperty("Accept", "application/json");


                conn.setReadTimeout(10000);
                conn.setConnectTimeout(15000);
                conn.connect();

                wr = new OutputStreamWriter(conn.getOutputStream());
                wr.write(cred.toString());
                wr.flush();
                wr.close();
            }

        }catch (MalformedURLException mfe){
            mfe.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }catch (JSONException jse){
            jse.printStackTrace();
        }


        try {
            int HttpResult = conn.getResponseCode();
            if (HttpResult == HttpURLConnection.HTTP_OK) {
                //Receive the response from the server
                InputStream in = new BufferedInputStream(conn.getInputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                result = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }

                in.close();
                reader.close();
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

        Log.d("Result in parser ", result.toString());
        // return JSON Object
        return result.toString();
    }

}