package com.centennial.project.eatouteatsafe;

import android.content.Intent;
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

import com.centennial.project.eatouteatsafe.pojos.ImageLoader;
import com.centennial.project.eatouteatsafe.pojos.Restaurant;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ListRestaurantsActivity extends AppCompatActivity {

    private ArrayList<Restaurant> restaurantList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_restaurant);
        updateTitle(getIntent());

        String jsonString = "{\n" +
                "\t\"restaurants\":[\n" +
                "\t\t{\n" +
                "\t\t  \"_id\": \"12345\",\n" +
                "\t\t  \"name\": \"SneakyDees Restaurant and Concert Venue\",\n" +
                "\t\t  \"image_url\": \"http://ec2-54-218-26-177.us-west-2.compute.amazonaws.com/images%5Calmond.jpg\",\n" +
                "\t\t  \"description\": \"Located in downtown Toronto’s vibrant Harbord Street village, just South of Bloor (two blocks west of Spadina), Almond Butterfly is a 100% gluten-free bake shop and espresso bar. You can find us at 100A Harbord Street. Click here for directions.HOMEMADE, FRESH BAKED GOODS & TREATS From fresh-baked muffins, biscuits, and bagels... to our mouth-watering cupcakes, brownies, & cookies- we’ve got you covered.Toasted breakfast egg sandwiches, bagels (we make the bagels fresh right here every morning), and grilled lunch sandwiches that will definitely hit the spot. In the Annex? Come by the shop to enjoy a scrumptious, grilled turkey & pesto sandwich... or perhaps a melt-in-your-mouth ham & cheddar melt, hot off the grill? All gluten-free, of course. :) DINE-IN, TAKEOUT, OR DELIVERY!\",\n" +
                "\t\t  \"rating\": \"3\",\n" +
                "\t\t  \"reviews\": \"33\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t  \"_id\": \"12346\",\n" +
                "\t\t  \"name\": \"Poutini’s House Of Poutine \",\n" +
                "\t\t  \"image_url\": \"http://ec2-54-218-26-177.us-west-2.compute.amazonaws.com/images%5Cloving_hut.jpg\",\n" +
                "\t\t  \"description\": \"The Loving Hut serves healthy, delicious foods with a variety of tastes, such as Vietnamese and Chinese dishes that are organic, vegan, non-GMO, peanut/nut free and contain no MSG. Their menu is also filled with many gluten-free options. Dishes are made to order and the staff is happy to make customizations to suit your tastes or dietary restrictions\",\n" +
                "\t\t  \"rating\": \"2\",\n" +
                "\t\t  \"reviews\": \"10\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t  \"_id\": \"12347\",\n" +
                "\t\t  \"name\": \"restaurant3\",\n" +
                "\t\t  \"image_url\": \"http://ec2-54-218-26-177.us-west-2.compute.amazonaws.com/images%5Ckeg.jpg\",\n" +
                "\t\t  \"description\": \"test description 3\",\n" +
                "\t\t  \"rating\": \"4\",\n" +
                "\t\t  \"reviews\": \"20\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t  \"_id\": \"12348\",\n" +
                "\t\t  \"name\": \"restaurant4\",\n" +
                "\t\t  \"image_url\": \"http://ec2-54-218-26-177.us-west-2.compute.amazonaws.com/images%5Cpizzaiolo.jpg\",\n" +
                "\t\t  \"description\": \"test description 4\",\n" +
                "\t\t  \"rating\": \"1\",\n" +
                "\t\t  \"reviews\": \"5\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t  \"_id\": \"12349\",\n" +
                "\t\t  \"name\": \"restaurant5\",\n" +
                "\t\t  \"image_url\": \"http://ec2-54-218-26-177.us-west-2.compute.amazonaws.com/images%5Cpoutinis.jpg\",\n" +
                "\t\t  \"description\": \"test description 5\",\n" +
                "\t\t  \"rating\": \"2\",\n" +
                "\t\t  \"reviews\": \"3\"\n" +
                "\t\t}\n" +
                "\t]\n" +
                "}";
        parseJSONData(jsonString);
        populateListView();

    }

    private void updateTitle(Intent intent){
        TextView titleTxt = (TextView) findViewById(R.id.listText);
        String[] titleArray = getResources().getStringArray(R.array.titles_res_listPage);

        switch (intent.getIntExtra("BUTTON_CODE",0)){
            case 1:
                titleTxt.setText(titleArray[0]);
                break;
            case 2:
                titleTxt.setText(titleArray[1]);
                break;
            case 3:
                titleTxt.setText(titleArray[2]);
                break;
            default:
                titleTxt.setText(titleArray[3]);
                break;
        }
    }

    /*
    private void connectToAPIAndGetJSON(){

    }*/

    private void parseJSONData(String jsonString){

        try {
            JSONObject jsonRootObject  = new JSONObject(jsonString);
            String data = "";

            //Get the instance of JSONArray that contains JSONObjects
            JSONArray jsonArray = jsonRootObject.optJSONArray("restaurants");
            JSONObject jsonObject = null;
            Restaurant restObj = null;
            restaurantList =  new ArrayList<Restaurant>();


            //Iterate the jsonArray and print the info of JSONObjects
            for(int i=0; i < jsonArray.length(); i++) {

                jsonObject = jsonArray.getJSONObject(i);
                restObj = new Restaurant();

                restObj.set_id(jsonObject.optString("_id").toString());
                restObj.setName(jsonObject.optString("name").toString());
                restObj.setImageURL(jsonObject.optString("image_url"));
                restObj.setDescritpion(jsonObject.optString("description"));
                restObj.setRating(Integer.parseInt(jsonObject.optString("rating")));
                restObj.setReviews(Integer.parseInt(jsonObject.optString("reviews")));

                restaurantList.add(restObj);
            }

        } catch (JSONException e) {
            Toast.makeText(ListRestaurantsActivity.this, "Something went wrong on loading list, going to main menu", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } catch (Exception e){
            Toast.makeText(ListRestaurantsActivity.this, "Something went wrong on loading list, going to main menu", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }

    private void populateListView(){
        ArrayAdapter<Restaurant> resAdapter = new RestaurantListAdapter();
        ListView restaurantList = (ListView)findViewById(R.id.resListView);
        restaurantList.setAdapter(resAdapter);
    }

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
            ratingBar.setRating((float)currentRestaurant.getRating());
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
