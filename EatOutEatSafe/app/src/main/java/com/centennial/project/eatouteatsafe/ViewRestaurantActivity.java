package com.centennial.project.eatouteatsafe;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import com.centennial.project.eatouteatsafe.pojos.APIConnection;
import com.centennial.project.eatouteatsafe.pojos.Restaurant;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ViewRestaurantActivity extends AppCompatActivity {

    private int layoutWidth;
    private int layoutHeight;
    private Restaurant restaurant;
    private ImageSwitcher imageSwitcher;
    private Integer[] images = {R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img3};
    private int i = 0;
    private Button previousBtn;
    private Button nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_restaurant);
        restaurant = (Restaurant) getIntent().getSerializableExtra("Restaurant");
        loadImages();
        connectToAPIAndGetJSON();
        checkAndUpdateAccountUI();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus == true) {
            RelativeLayout myLinearLayout = (RelativeLayout) findViewById(R.id.viewResRelativeLayout);
            layoutWidth = myLinearLayout.getWidth();
            layoutHeight = myLinearLayout.getHeight();
        }
        adjustViewDesign();
    }

    private void adjustViewDesign(){
        Button titleBtn = (Button) findViewById(R.id.titleBtn);
        android.widget.RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams((int)
                (layoutWidth/1.5),RelativeLayout.LayoutParams.WRAP_CONTENT); // 60 is height you can set it as u need
        titleBtn.setLayoutParams(lp);

        Button titleSupplyBtn = (Button) findViewById(R.id.titleSupplyBtn);
        android.widget.RelativeLayout.LayoutParams dp = new RelativeLayout.LayoutParams((int)
                (layoutWidth/2.7),RelativeLayout.LayoutParams.WRAP_CONTENT);
        dp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT); // 60 is height you can set it as u need
        titleSupplyBtn.setLayoutParams(dp);
    }

    private void connectToAPIAndGetJSON(){
        // start parsing the JSON data
        APIConnection apiConnection = new APIConnection(this, 4, restaurant.get_id());
        apiConnection.execute();
    }

    public void populateFromJSON(String jsonString){
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            JSONArray imagesJsonArray = jsonObject.getJSONArray("resImages");
            JSONArray jsonArray = jsonObject.getJSONArray("resDetails");
            String[] images = new String[imagesJsonArray.length()];

            jsonObject = jsonArray.getJSONObject(0);
            restaurant.setProvince(jsonObject.optString("Province"));
            restaurant.setRestaurantCategory(jsonObject.optString("ResCategory"));
            restaurant.setManagerName(jsonObject.optString("ManagerName"));

            if(images.length > 0) {
                for (int i = 0; i < jsonArray.length(); i++) {
                    jsonObject = jsonArray.getJSONObject(i);
                    images[i] = jsonObject.optString("Img_Path") + jsonObject.optString("Img_Name");
                }
                restaurant.setImages(images);
            }
            updateView();

        }catch (JSONException jex){
            jex.printStackTrace();
        }
    }

    private void updateView(){
        Button commonButtonObj = (Button) findViewById(R.id.titleBtn);
        commonButtonObj.setText(restaurant.getAllergy());
        commonButtonObj = (Button) findViewById(R.id.titleSupplyBtn);
        commonButtonObj.setText(restaurant.getLocation());
        commonButtonObj = (Button) findViewById(R.id.locationBtn);
        commonButtonObj.setText("Location : "+restaurant.getLocation()+", "+restaurant.getProvince());

        TextView commonTextView = (TextView) findViewById(R.id.resTitleTxtView);
        commonTextView.setText(restaurant.getName());
        commonTextView = (TextView) findViewById(R.id.descTxtView);
        commonTextView.setText(restaurant.getDescritpion());


    }

    private void loadImages(){
        previousBtn = (Button) findViewById(R.id.previousBtn);
        nextBtn = (Button) findViewById(R.id.nextBtn);

        imageSwitcher = (ImageSwitcher) findViewById(R.id.resImageSwitcher);
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory(){
            @Override
            public View makeView(){
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                imageView.setLayoutParams(
                        new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                                ViewGroup.LayoutParams.MATCH_PARENT));
                return imageView;
            }
        });

        Animation in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.trans_in);
        Animation out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.trans_out);
        imageSwitcher.setInAnimation(in);
        imageSwitcher.setOutAnimation(out);
        imageSwitcher.setImageResource(images[0]);

        previousBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(i>0){
                    i--;
                    imageSwitcher.setImageResource(images[i]);
                }
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(i<(images.length-1)){
                    i++;
                    imageSwitcher.setImageResource(images[i]);
                }
            }
        });
    }

    public void onLoginBtnClick(View view){
        SharedPreferences sessionPreferences = getSharedPreferences(LoginActivity.APP_PREFERENCES, MODE_PRIVATE);
        if(sessionPreferences.getBoolean("isValidSession",false)) {
            SharedPreferences.Editor editor = sessionPreferences.edit();
            editor.clear();
            editor.commit();
            checkAndUpdateAccountUI();
            Toast.makeText(this, "Logged out successfully", Toast.LENGTH_SHORT).show();
        }else{
            Intent intent = new Intent(ViewRestaurantActivity.this, LoginActivity.class);
            startActivity(intent);
        }
    }

    /**
     * Updates the footer based on session
     */
    private void checkAndUpdateAccountUI(){
        SharedPreferences sessionPreferences = getSharedPreferences(LoginActivity.APP_PREFERENCES, MODE_PRIVATE);
        Button loginBtn = (Button) findViewById(R.id.onLoginBtnViewRes);
        Button signUp = (Button) findViewById(R.id.SignUpViewRes);
        Button userName = (Button) findViewById(R.id.userBtnViewRes);

        if(sessionPreferences.getBoolean("isValidSession",false)){
            loginBtn.setText("Logout");
            userName.setText(sessionPreferences.getString("FirstName","Invalid User"));
            signUp.setVisibility(View.INVISIBLE);

        }else {
            loginBtn.setText("Login");
            userName.setText("Guest");
            signUp.setVisibility(View.VISIBLE);
        }
    }
}
