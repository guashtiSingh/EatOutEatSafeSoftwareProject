package com.centennial.project.eatouteatsafe;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.centennial.project.eatouteatsafe.pojos.APIConnection;
import com.centennial.project.eatouteatsafe.pojos.ImageLoader;
import com.centennial.project.eatouteatsafe.pojos.JSONParser;
import com.centennial.project.eatouteatsafe.pojos.Restaurant;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;

public class ListRestaurantsActivity extends AppCompatActivity {

    private ArrayList<Restaurant> restaurantList = null;
    private int option = 0;
    private String searchString = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_restaurant);
        updateTitle(getIntent());
        connectToAPIAndGetJSON();
    }

    /**
     * Update the title of list activity
     * @param intent
     */

    private void updateTitle(Intent intent){
        TextView titleTxt = (TextView) findViewById(R.id.listText);
        String[] titleArray = getResources().getStringArray(R.array.titles_res_listPage);


        switch (intent.getIntExtra("BUTTON_CODE",0)){
            case 1:
                option = 0;
                titleTxt.setText(titleArray[0]);
                break;
            case 2:
                option = 1;
                titleTxt.setText(titleArray[1]);
                break;
            case 3:
                option = 2;
                titleTxt.setText(titleArray[2]);
                break;
            case 4:
                option = 3;
                searchString = intent.getStringExtra("SEARCH_STRING");
                titleTxt.setText(titleArray[3]+" : "+searchString);
                break;
            default:
                option = 0;
                titleTxt.setText(titleArray[4]);
                break;
        }
    }

    /**
     * Connect to API and get JSON data
     */

    private void connectToAPIAndGetJSON(){
        // start parsing the JSON data

        APIConnection apiConnection = new APIConnection(this, option, searchString);
        apiConnection.execute();
    }

    /**
     * Parse JSON data using the JSON string got from the API
     * @param jsonString
     */

    public boolean parseJSONData(String jsonString){

        try {
            //Get the instance of JSONArray that contains JSONObjects
            JSONObject jsonRootObject  = new JSONObject(jsonString);
            JSONArray jsonArray = jsonRootObject.optJSONArray("restaurants");
            restaurantList =  new ArrayList<Restaurant>();
            iterateThroughJSON(jsonArray);

        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(ListRestaurantsActivity.this, "Something went wrong on loading list, " +
                    "going to main menu", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } catch (Exception e){
            e.printStackTrace();
            Toast.makeText(ListRestaurantsActivity.this, "Something went wrong on loading list, " +
                    "going to main menu", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        return restaurantList.isEmpty() ? true : false;
    }

    /**
     *
     * @param jsonArray
     * @throws JSONException
     */

    private void iterateThroughJSON(JSONArray jsonArray) throws JSONException {

        String data = "";
        String url = "";
        JSONObject jsonObject = null;
        Restaurant restObj = null;

        //Iterate the jsonArray and create restaurant objects using JSON data
        for(int i=0; i < jsonArray.length(); i++) {

            jsonObject = jsonArray.getJSONObject(i);
            restObj = new Restaurant();
            if(jsonObject.has("Res_Id")) {
                restObj.set_id(jsonObject.optString("Res_Id").toString());
                restObj.setName(jsonObject.has("Res_Name") ? jsonObject.optString("Res_Name").toString() : ""); // store name if only json data has a field named "Res_Name"
                url = jsonObject.optString("MainImg_Path").toString() +
                        jsonObject.optString("MainImg_Name").toString();
                restObj.setImageURL(url);
                restObj.setDescritpion(jsonObject.has("Res_Description") ?
                        jsonObject.optString("Res_Description") : "None");
                restObj.setRating(Float.parseFloat(jsonObject.has("Rate") ?
                        jsonObject.optString("Rate") : "0"));
                restObj.setReviews(Integer.parseInt(jsonObject.has("Total_review") ?
                        jsonObject.optString("Total_review"): "0"));
            }
            restaurantList.add(restObj);
        }
    }

    /**
     * Populate List View using the list adapter
     */

    public void populateListView(){
        ArrayAdapter<Restaurant> resAdapter = new RestaurantListAdapter();
        ListView restaurantList = (ListView)findViewById(R.id.resListView);
        restaurantList.setAdapter(resAdapter);
    }

    /**
     *  List adapter class that implements each item in the list
     */

    private class RestaurantListAdapter extends ArrayAdapter<Restaurant> {

        public ImageLoader itemImageLoader = null;

        public RestaurantListAdapter(){
            super(ListRestaurantsActivity.this,R.layout.list_item_view, restaurantList);
            itemImageLoader = new ImageLoader(ListRestaurantsActivity.this.getApplicationContext());
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){

            View itemView = convertView;
            String trimmedDescp = null;
            if(itemView == null){
                itemView = getLayoutInflater().inflate(R.layout.list_item_view,parent,false);
            }

            // get restaurant at a particular position
            Restaurant currentRestaurant = restaurantList.get(position);

            // Add details to each row of item

            TextView nameTxtView = (TextView)itemView.findViewById(R.id.resNameTxtView);
            TextView descTxtView = (TextView) itemView.findViewById(R.id.descTxtView);
            TextView reviewTxtView = (TextView) itemView.findViewById(R.id.revTxtView);
            ImageView resImgView = (ImageView) itemView.findViewById(R.id.itemImage);
            RatingBar ratingBar = (RatingBar) itemView.findViewById(R.id.ratingBar);

            nameTxtView.setText(currentRestaurant.getName());
            itemImageLoader.DisplayImage(currentRestaurant.getImageURL(),resImgView);
            ratingBar.setRating(currentRestaurant.getRating());
            ratingBar.setEnabled(false);
            reviewTxtView.setText(currentRestaurant.getReviews() + " Reviews");

            // trim description when length greater than 50
            trimmedDescp = currentRestaurant.getDescritpion();
            if(trimmedDescp.length() >= 50) {
                descTxtView.setText(currentRestaurant.getDescritpion().substring(0, 50) + "......");
            }else{
                descTxtView.setText(currentRestaurant.getDescritpion());
            }

            return itemView;

        }

    }


}
