package com.centennial.project.eatouteatsafe;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import com.centennial.project.eatouteatsafe.pojos.ImageLoader;
import com.centennial.project.eatouteatsafe.pojos.Menu;
import com.centennial.project.eatouteatsafe.pojos.Restaurant;
import com.centennial.project.eatouteatsafe.pojos.Utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

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
        Utils.connectToAPIAndGetJSON(this, 4, restaurant.get_id());
        checkAndUpdateAccountUI();
    }

    @Override
    protected void onResume(){
        super.onResume();
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


    public void onMenuBtnClick(View view){

        Utils.connectToAPIAndGetJSON(this,6,restaurant.get_id());
    }


    public void onReviewBtnClick(View view)
    {
        Intent intent = new Intent(this, ReviewListActivity.class);
        intent.putExtra("Restaurant",restaurant);
        startActivity(intent);
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

    public void onSignUpBtnClick(View view){
        Intent intent = new Intent(ViewRestaurantActivity.this, SignupActivity.class);
        startActivity(intent);
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
            userName.setText(sessionPreferences.getString("FirstName","Invalid User").toUpperCase());
            signUp.setVisibility(View.INVISIBLE);

        }else {
            loginBtn.setText("Login");
            userName.setText("Guest");
            signUp.setVisibility(View.VISIBLE);
        }
    }

    public void createAndShowMenu(String menuJson, ViewRestaurantActivity act){

        boolean isSafeToLaunchDialog = false;
        ArrayList<Menu> menuList = null;

        try {
            menuList = parseMenuJson(menuJson);
            isSafeToLaunchDialog = true;
        }catch (JSONException jse){
            jse.printStackTrace();
            Toast.makeText(act,"Menu error",Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (isSafeToLaunchDialog && menuList != null) {
                // creating alert dialog box and creating parent layout
                AlertDialog.Builder builder = new AlertDialog.Builder(act);
                LinearLayout menuParentLayout = new LinearLayout(act);
                menuParentLayout.setOrientation(LinearLayout.VERTICAL);
                LinearLayout.LayoutParams parantParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                menuParentLayout.setLayoutParams(parantParams);

                // creating child layout one
                LinearLayout headingLayout = new LinearLayout(act);
                LinearLayout.LayoutParams headParms = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);
                headingLayout.setLayoutParams(headParms);
                headingLayout.setGravity(Gravity.CLIP_VERTICAL);
                headingLayout.setPadding(10, 10, 10, 10);

                Typeface headTypeFace = Typeface.createFromAsset(act.getAssets(), "fonts/Chunkfive.otf");
                TextView titleText = new TextView(act);
                titleText.setText((restaurant != null ? restaurant.getName() : "") + " Menu");
                titleText.setPadding(8, 8, 8, 8);
                titleText.setGravity(Gravity.CENTER);
                titleText.setTextSize(20);
                titleText.setBackgroundColor(Color.RED);
                titleText.setTextColor(Color.WHITE);
                titleText.setTypeface(headTypeFace);
                headingLayout.addView(titleText);


                // creating child layout two as scroll view
                ScrollView sv = new ScrollView(act);
                sv.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT));

                // creating sub child for scroll view to show the menu details
                LinearLayout layout = new LinearLayout(act);
                LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);
                layout.setOrientation(LinearLayout.VERTICAL);
                layout.setLayoutParams(parms);

                layout.setGravity(Gravity.CLIP_VERTICAL);
                layout.setPadding(10, 10, 10, 10);

                // Load fonts before showing text views

                Typeface titleTypeFace = Typeface.createFromAsset(act.getAssets(), "fonts/JosefinSans-Bold.ttf");
                Typeface subtitleTypeFace =
                        Typeface.createFromAsset(act.getAssets(), "fonts/JosefinSans-SemiBoldItalic.ttf");
                Typeface detailTypeFace = Typeface.createFromAsset(act.getAssets(), "fonts/Quicksand-Bold.otf");

                // Create image loader for images and get ready to load images
                ImageLoader itemImageLoader = new ImageLoader(act.getApplicationContext());


                for(Menu item:menuList) {
                    TextView nameText = new TextView(act);
                    nameText.setText(item.getName());
                    nameText.setPadding(8, 8, 8, 8);
                    nameText.setGravity(Gravity.LEFT);
                    nameText.setTextSize(20);
                    nameText.setTypeface(titleTypeFace);
                    layout.addView(nameText);

                    ImageView menuImage = new ImageView(act);
                    menuImage.setLayoutParams(new ViewGroup.LayoutParams(250, 250));
                    layout.addView(menuImage);
                    itemImageLoader.DisplayImage(item.getImageURL(), menuImage);

                    TextView descText = new TextView(act);
                    descText.setText(item.getDescription());
                    descText.setPadding(8, 8, 8, 8);
                    descText.setGravity(Gravity.LEFT);
                    descText.setTextSize(12);
                    descText.setTypeface(subtitleTypeFace);
                    layout.addView(descText);

                    TextView costText = new TextView(act);
                    costText.setText("CAD "+ item.getPrice()+"$");
                    costText.setPadding(8, 8, 8, 8);
                    costText.setGravity(Gravity.RIGHT);
                    costText.setTextSize(12);
                    costText.setTypeface(detailTypeFace);
                    layout.addView(costText);


                    View hzLine = new View(act);
                    hzLine.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 1));
                    hzLine.setBackgroundColor(Color.GRAY);
                    hzLine.setPadding(4, 4, 4, 4);
                    layout.addView(hzLine);
                }
                sv.addView(layout); // adding the sub-child linear layout to scroll view

                // adding all child layouts to parent linear layout
                menuParentLayout.addView(headingLayout);
                menuParentLayout.addView(sv);

                // adding parent layout to alert dialog
                builder.setView(menuParentLayout);
                builder.setNegativeButton("GO BACK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.show();
            }
        }
    }

    private ArrayList<Menu> parseMenuJson(String jsonString) throws JSONException{

        if(jsonString != null && jsonString.length() > 0){
            JSONObject jsonRootObject  = new JSONObject(jsonString);
            JSONArray jsonArray = jsonRootObject.optJSONArray("menus");
            ArrayList<Menu> menuList =  new ArrayList<Menu>();
            JSONObject jsonObject = null;
            String url = "";

            for(int i=0; i < jsonArray.length(); i++) {
                Menu resMenuItem = new Menu();
                jsonObject = jsonArray.getJSONObject(i);
                resMenuItem.setName(jsonObject.has("Menu_Name") ?
                        jsonObject.optString("Menu_Name").toString() : "Untitled");
                resMenuItem.setPrice(jsonObject.has("Menu_Price") ?
                        jsonObject.optString("Menu_Price").toString(): "0");
                resMenuItem.setDescription(jsonObject.has("Menu_Description") ?
                        jsonObject.optString("Menu_Description").toString() : "No Description");
                url = jsonObject.optString("MainImg_Path").toString() +
                        jsonObject.optString("MainImg_Name").toString();
                resMenuItem.setImageURL(url);
                menuList.add(resMenuItem);
            }

            return menuList;
        }

        return null;

    }
}
