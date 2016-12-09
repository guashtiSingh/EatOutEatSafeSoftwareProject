package com.centennial.project.eatouteatsafe;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.RatingBar;
import android.widget.Toast;

import com.centennial.project.eatouteatsafe.pojos.JSONReviewParser;
import com.centennial.project.eatouteatsafe.pojos.Restaurant;
import com.centennial.project.eatouteatsafe.pojos.Review;
import com.centennial.project.eatouteatsafe.pojos.Utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class ReviewListActivity extends AppCompatActivity {

    //For review list
    public ExpandableListView expandableListView;
    private ArrayList<Review> reviews;
    private Review review;

    private Restaurant restaurant;

    //for review insert
    public String reviewTitle = "";
    public String reviewContent = "";
    public float rating = 0.0f;
    public String userName = "";
    public ReviewListActivity reviewAct;
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        reviewAct = this;
        reviews =  new ArrayList<Review>();
        //Retrieve restaurant
        restaurant = (Restaurant) getIntent().getSerializableExtra("Restaurant");


        toolbar.setTitle(restaurant.getName());
        setSupportActionBar(toolbar);

        //Object for shared preference
        //Check if user session is validated.
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        SharedPreferences sessionPreferences = getSharedPreferences(LoginActivity.APP_PREFERENCES, MODE_PRIVATE);

        if(!sessionPreferences.getBoolean("isValidSession",false))
        {
            fab.hide();
        }
        else
        {
            fab.show();
            userName = sessionPreferences.getString("Username","beymig");
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    populateDialog(view);
                }
            });
        }

        //Button for going back to restaurant detail
        FloatingActionButton fabBack = (FloatingActionButton) findViewById(R.id.fabBack);
        fabBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBackReviewDetail(view);
            }
        });

        resetEpListView(reviewAct);
    }


    public void resetEpListView(ReviewListActivity reviewAct)
    {
        //Review List
        expandableListView = (ExpandableListView) findViewById(R.id.reviewListView);
        Utils.connectToAPIAndGetJSON(reviewAct, 5, restaurant.get_id());
    }


    public void parseJSONtoReview(String jsonString, int OPTION){

        try {
            //Get the instance of JSONArray that contains JSONObjects

            JSONObject jsonRootObject  = new JSONObject(jsonString);
            JSONArray jsonArray = jsonRootObject.optJSONArray("reviews");
            reviewThroughJSON(jsonArray);

            Log.d("review is empty: ", ""+reviews.isEmpty());

        } catch (JSONException e) {
            e.printStackTrace();

        } catch (Exception e){
            e.printStackTrace();
        }

        if(!reviews.isEmpty())
            populateReviews(reviews);
    }

    public void reviewThroughJSON(JSONArray jsonArray) throws JSONException {

        String data = "";
        String url = "";
        JSONObject jsonObject = null;
        Review reviewObj = null;

        //Iterate the jsonArray and create restaurant objects using JSON data
        for(int i=0; i < jsonArray.length(); i++) {

            jsonObject = jsonArray.getJSONObject(i);

            if (jsonObject.has("RV_Id")) {
                reviewObj = new Review();
                reviewObj.setReview_Id(jsonObject.optString("RV_Id").toString());
                reviewObj.setRes_Id(restaurant.get_id());
                reviewObj.setAuthor_Id(jsonObject.optString("User_Id"));
                reviewObj.setAuthor_name(jsonObject.optString("userFullName"));
                reviewObj.setTitle(jsonObject.optString("RV_Title"));
                reviewObj.setContent(jsonObject.optString("RV_Content"));
                reviewObj.setRate(Float.parseFloat(jsonObject.has("Rate") ? jsonObject.optString("Rate") : "0"));

                reviews.add(reviewObj);
            }
        }

        Log.d("reviews size", ""+reviews.size());

    }

    public void populateReviews(ArrayList<Review> reviews){
        ReviewListAdapter reviewListAdapter = new ReviewListAdapter(this, reviews);
        expandableListView.setAdapter(reviewListAdapter);
    }

    /** /////////////////////////////////////////////////////////////////////////
     *  //// FUNCTIONS RELATED TO ADDING, UPDATING AND DELETING REVIEWS /////////
     */ /////////////////////////////////////////////////////////////////////////

    //New dialog for insert review form
    private void populateDialog(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
        builder.setTitle("Review Write");
        // I'm using fragment here so I'm using getView() to provide ViewGroup
        // but you can provide here any other instance of ViewGroup from your Fragment / Activity

        View viewInflated = LayoutInflater.from(view.getContext()).inflate(R.layout.review_input_form, null);
        // Set up the input
        final EditText txtTitle = (EditText) viewInflated.findViewById(R.id.txtTitle);
        final EditText txtContent = (EditText) viewInflated.findViewById(R.id.txtContent);
        final RatingBar ratingBar = (RatingBar) viewInflated.findViewById(R.id.ratingBar);
        // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
        builder.setView(viewInflated);

        final Context context = view.getContext();

        // Set up the buttons
        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                reviewTitle = txtTitle.getText().toString();
                reviewContent = txtContent.getText().toString();
                rating = ratingBar.getRating();

                // Check for a valid email address.
                if (TextUtils.isEmpty(reviewTitle)) {
                    txtTitle.setError("Please enter review title");
                }

                else if(TextUtils.isEmpty(reviewContent))
                {
                    txtContent.setError("Please enter review content");
                }
                else if(rating == 0.0f)
                {
                    Toast.makeText(context,"Please select rating for the restaurant", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    HashMap<String, String> params = new HashMap<>();

                    params.put("TaskMode", "Insert");
                    params.put("resId", restaurant.get_id());
                    params.put("reviewTitle", reviewTitle);
                    params.put("reviewContent", reviewContent);
                    params.put("userId", ""+ userName);
                    params.put("mainImgPath", "");
                    params.put("mainImgName", "");
                    params.put("rate", "" + rating);

                    ReviewTask reviewTask = new ReviewTask(params);
                    reviewTask.execute((Void) null);

                    //params.clear();
                }
            }
        });
        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }

    // to go back to restaurant details
    private void goBackReviewDetail(View view)
    {
        Intent intent = new Intent(ReviewListActivity.this, ViewRestaurantActivity.class);
        intent.putExtra("Restaurant", restaurant);
        startActivity(intent);
    }

    /**
     *  API class for review manipulations
     */
    public class ReviewTask extends AsyncTask<Void, Void, JSONObject> {

        protected String WEBSERVICE_REVIEW_INSERT = "http://ec2-54-218-26-177.us-west-2.compute.amazonaws.com:8080/EOES-webService/review/insert";
        protected String WEBSERVICE_REVIEW_UPDATE = "http://ec2-54-218-26-177.us-west-2.compute.amazonaws.com:8080/EOES-webService/review/update";
        protected String WEBSERVICE_REVIEW_DELETE = "http://ec2-54-218-26-177.us-west-2.compute.amazonaws.com:8080/EOES-webService/review/delete";

        public final HashMap<String, String> parameters;


        ReviewTask(HashMap<String, String> params) {
            this.parameters = params;

        }

        @Override
        public JSONObject doInBackground(Void... params) {
            // TODO: attempt authentication against a network service.

            try {

                JSONReviewParser parser = new JSONReviewParser();
                String jsonString = "";
                if(parameters == null)
                    throw new IllegalArgumentException("Parameter is null");
                else
                {
                    String MODE = parameters.get("TaskMode").toUpperCase();
                    parameters.remove("TaskMode");


                    switch (MODE) {
                        
                        case "INSERT":
                            jsonString = parser.makeHttpRequest(WEBSERVICE_REVIEW_INSERT, "POST", parameters);
                            break;
                        case "UPDATE":
                            jsonString = parser.makeHttpRequest(WEBSERVICE_REVIEW_UPDATE, "PUT", parameters);
                            break;
                        case "DELETE":
                            jsonString = parser.makeHttpRequest(WEBSERVICE_REVIEW_DELETE, "DELETE", parameters);
                            break;
                        default:
                            jsonString = parser.makeHttpRequest(WEBSERVICE_REVIEW_INSERT, "POST", parameters);
                            break;
                    }
                }

                return new JSONObject(jsonString);

            } catch (Exception e) {
                e.printStackTrace();
                return null;

            }
        }

        @Override
        protected void onPostExecute(final JSONObject jsonObject) {


            if(jsonObject.has("resultMsg") && jsonObject.optString("resultMsg").equalsIgnoreCase("success")){

                //resetEpListView(reviewAct, "refresh");
                Intent intent = new Intent(ReviewListActivity.this, ReviewListActivity.class);
                intent.putExtra("Restaurant",restaurant);
                startActivity(intent);

            }else{
                Toast.makeText(getApplicationContext(),"Unexpected error!",Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        protected void onCancelled() {

        }

    }

}


