package com.centennial.project.eatouteatsafe.pojos;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import com.centennial.project.eatouteatsafe.ListRestaurantsActivity;
import com.centennial.project.eatouteatsafe.R;
import com.centennial.project.eatouteatsafe.ReviewListActivity;
import com.centennial.project.eatouteatsafe.ViewRestaurantActivity;


/**
 * Created by a_b on 21-10-2016.
 *
 * This class makes asynchronous call to API and get the JSON data. It avoids disrupting the main thread when making API calls.
 */
public class APIConnection extends AsyncTask<Void, Void, String> {

    private  String jsonString = "";
    private String searchString;
    private String resId;
    private int OPTION = 0;
    private ListRestaurantsActivity listRest = null;
    private ViewRestaurantActivity viewRest = null;
    private ProgressDialog progressDialog = null;
    private ReviewListActivity reviewList = null;

    private String[] credentials = null;
    protected String WEBSERVICE_URL_POPULAR = "http://ec2-54-218-26-177.us-west-2.compute.amazonaws.com:8080/EOES-webService/restaurant/list/P";
    protected String WEBSERVICE_URL_LOCATION = "http://ec2-54-218-26-177.us-west-2.compute.amazonaws.com:8080/EOES-webService/restaurant/list/L";
    protected String WEBSERVICE_URL_ALLERGY = "http://ec2-54-218-26-177.us-west-2.compute.amazonaws.com:8080/EOES-webService/restaurant/list/A";
    protected String WEBSERVICE_URL_SEARCH = "http://ec2-54-218-26-177.us-west-2.compute.amazonaws.com:8080/EOES-webService/restaurant/list/M/";
    protected String WEBSERVICE_URL_RESTAURANT = "http://ec2-54-218-26-177.us-west-2.compute.amazonaws.com:8080//EOES-webService/restaurant/resDetail/";
    //user webservice links
    protected String WEBSERVICE_URL_LOGIN = "http://ec2-54-218-26-177.us-west-2.compute.amazonaws.com:8080/EOES-webService/user/login";
    protected String WEBSERVICE_URL_SIGNUP = "http://ec2-54-218-26-177.us-west-2.compute.amazonaws.com:8080/EOES-webService/user/signup";
    //Review
    protected String WEBSERVICE_REVIEW_LIST = "http://ec2-54-218-26-177.us-west-2.compute.amazonaws.com:8080/EOES-webService/review/list/";


    /**
     *
     * @param act
     * @param option
     * @param queryString
     */

    public APIConnection(ListRestaurantsActivity act, int option, String queryString){
        listRest = act;
        OPTION = option;
        progressDialog = new ProgressDialog(act);
        searchString = queryString;
    }

    public APIConnection(ViewRestaurantActivity act, int option, String resId){
        viewRest = act;
        OPTION = option;
        progressDialog = new ProgressDialog(act);
        this.resId = resId;
    }

    public APIConnection(ReviewListActivity act, int option, String resId){
        reviewList = act;
        OPTION = option;
        progressDialog = new ProgressDialog(act);
        this.resId = resId;
    }


    protected void onPreExecute() {
        if(progressDialog != null) {
            progressDialog.setMessage("Loading Restaurant List...");
            progressDialog.show();
            progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                public void onCancel(DialogInterface arg0) {
                    APIConnection.this.cancel(true);
                }
            });
        }else{
            Log.d("EatoutApp_Warning","Progress Dialog is null");
        }
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
                jsonString = jsonParserObj.makeHttpRequest(WEBSERVICE_URL_POPULAR,"GET",null);
                break;
            case 1:
                jsonString = jsonParserObj.makeHttpRequest(WEBSERVICE_URL_LOCATION,"GET",null);
                break;
            case 2:
                jsonString = jsonParserObj.makeHttpRequest(WEBSERVICE_URL_ALLERGY,"GET",null);
                break;
            case 3:
                jsonString = jsonParserObj.makeHttpRequest(WEBSERVICE_URL_SEARCH+searchString,"GET",null);
                break;
            case 4:
                jsonString = jsonParserObj.makeHttpRequest(WEBSERVICE_URL_RESTAURANT+resId,"GET",null);
                break;
            case 5:
                jsonString = jsonParserObj.makeHttpRequest(WEBSERVICE_REVIEW_LIST+resId,"GET",null);
                break;
            default:
                jsonString = jsonParserObj.makeHttpRequest(WEBSERVICE_URL_POPULAR,"GET",null);
                break;
        }

        return null;
    }

    @Override
    protected void onPostExecute(String strings) {
        super.onPostExecute(strings);
        if(OPTION >=0 && OPTION <=3){
            doListActivities();
        }else if(OPTION == 4){
            viewRest.populateFromJSON(jsonString);
        }else if(OPTION == 5){
            reviewList.parseJSONtoReview(jsonString, OPTION);
        }

        if(progressDialog != null)
            this.progressDialog.dismiss();

    }

    private void doListActivities(){
        boolean isResListEmpty = false;
        isResListEmpty = listRest.parseJSONData(jsonString);
        if(isResListEmpty) {
            TextView titleTxt = (TextView) listRest.findViewById(R.id.listText);
            titleTxt.setText("Oops ! Sorry");

            titleTxt = (TextView) listRest.findViewById(R.id.footerText);
            titleTxt.setText("The searched restaurant is not in our list");
        }else{
            listRest.populateListView();
            listRest.registItemClick();
        }
    }

}
