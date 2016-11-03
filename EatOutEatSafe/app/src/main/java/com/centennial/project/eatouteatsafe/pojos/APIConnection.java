package com.centennial.project.eatouteatsafe.pojos;

import android.app.Activity;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import com.centennial.project.eatouteatsafe.ListRestaurantsActivity;
import com.centennial.project.eatouteatsafe.R;


/**
 * Created by a_b on 21-10-2016.
 *
 * This class makes asynchronous call to API and get the JSON data. It avoids disrupting the main thread when making API calls.
 */
public class APIConnection extends AsyncTask<Void, Void, String> {

    private  String jsonString = "";
    private String searchString;
    private int OPTION = 0;
    private ListRestaurantsActivity listRest = null;
    private ProgressDialog progressDialog = null;
    protected String WEBSERVICE_URL_POPULAR = "http://ec2-54-218-26-177.us-west-2.compute.amazonaws.com:8080/EOES-webService/restaurant/list/P";
    protected String WEBSERVICE_URL_LOCATION = "http://ec2-54-218-26-177.us-west-2.compute.amazonaws.com:8080/EOES-webService/restaurant/list/L";
    protected String WEBSERVICE_URL_ALLERGY = "http://ec2-54-218-26-177.us-west-2.compute.amazonaws.com:8080/EOES-webService/restaurant/list/A";
    protected String WEBSERVICE_URL_SEARCH = "http://ec2-54-218-26-177.us-west-2.compute.amazonaws.com:8080/EOES-webService/restaurant/list/M/";

    /**
     * Custom constructors
     * @param act
     * @param option
     */

    public APIConnection(ListRestaurantsActivity act, int option, String queryString){
        listRest = act;
        OPTION = option;
        progressDialog = new ProgressDialog(act);
        searchString = queryString;
    }


    protected void onPreExecute() {
         progressDialog.setMessage("Loading Restaurant List...");
         progressDialog.show();
         progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            public void onCancel(DialogInterface arg0) {
                APIConnection.this.cancel(true);
            }
        });
    }

    /**
     * Create the JSONParser object and make call to the Webservice
     * @param params
     * @return
     */

    @Override
    protected String doInBackground(Void... params) {

        JSONParser jsonParserObj = new JSONParser();

        switch (OPTION){
            case 0:
                jsonString = jsonParserObj.makeHttpRequest(WEBSERVICE_URL_POPULAR,"GET");
                break;
            case 1:
                jsonString = jsonParserObj.makeHttpRequest(WEBSERVICE_URL_LOCATION,"GET");
                break;
            case 2:
                jsonString = jsonParserObj.makeHttpRequest(WEBSERVICE_URL_ALLERGY,"GET");
                break;
            case 3:
                jsonString = jsonParserObj.makeHttpRequest(WEBSERVICE_URL_SEARCH+searchString,"GET");
                break;
            default:
                jsonString = jsonParserObj.makeHttpRequest(WEBSERVICE_URL_POPULAR,"GET");
                break;
        }

        return null;
    }

    @Override
    protected void onPostExecute(String strings) {
        super.onPostExecute(strings);
        boolean isResListEmpty = false;
        isResListEmpty = listRest.parseJSONData(jsonString);
        if(isResListEmpty) {
            TextView titleTxt = (TextView) listRest.findViewById(R.id.listText);
            titleTxt.setText("Oops ! Sorry");

            titleTxt = (TextView) listRest.findViewById(R.id.footerText);
            titleTxt.setText("The searched restaurant is not in our list");
        }else{
            listRest.populateListView();
        }
        this.progressDialog.dismiss();
    }

}
