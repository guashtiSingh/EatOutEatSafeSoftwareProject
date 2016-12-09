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
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
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
    OutputStreamWriter wr;

    public String makeHttpRequest(String url, String method, Map<String,String[]> params) {

        if (method.equals("POST")) {
            // request method is POST
            // to be enabled only when post is used
           try {

               if(!params.isEmpty()) {
                   urlObj = new URL(url);
                   conn = (HttpURLConnection) urlObj.openConnection();

                   JSONObject cred = new JSONObject();
                   String[] userAndPass = params.get("loginCred");
                   String[] signUpDetails = params.get("SignUpCred");

                   if(userAndPass != null) {
                       cred.put("userId", userAndPass[0]);
                       cred.put("password", userAndPass[1]);
                   }else if(signUpDetails != null){
                       cred.put("userId", signUpDetails[0]);
                       cred.put("password", signUpDetails[1]);
                       cred.put("firstName", signUpDetails[2]);
                       cred.put("lastName", signUpDetails[3]);
                       cred.put("email", signUpDetails[4]);
                   }

                   conn.setDoOutput(true);
                   conn.setRequestProperty("Content-Type", "application/json");
                   conn.setRequestProperty("Accept", "application/json");
                   conn.setRequestMethod("POST");

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
           }catch (Exception e){
               e.printStackTrace();
           }
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

        // return JSON Object
        return result.toString();
    }

}