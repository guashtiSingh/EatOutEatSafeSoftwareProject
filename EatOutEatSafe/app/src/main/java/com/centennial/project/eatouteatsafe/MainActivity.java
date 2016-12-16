package com.centennial.project.eatouteatsafe;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.Window;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.centennial.project.eatouteatsafe.pojos.APIConnection;

public class MainActivity extends AppCompatActivity {

    private String BUTTON_CODE = "BUTTON_CODE";
    private static String SEARCH = "SEARCH_STRING";
    private boolean isValidSession = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        Typeface headTypeFace = Typeface.createFromAsset(this.getAssets(), "fonts/Chunkfive.otf");
        ((Button) findViewById(R.id.searhBtn)).setTypeface(headTypeFace);

        checkAndUpdateAccountUI();
    }

    @Override
    protected void onResume(){
        super.onResume();
        checkAndUpdateAccountUI();
    }

    // calling the list activity trans_in button click
    public void callListRestaurentActivity(View mainView){
        Intent listIntent = new Intent (this, ListRestaurantsActivity.class);

        boolean okToLaunchList = true;

        switch (mainView.getId()) {
            case R.id.popularBtn:
                listIntent.putExtra(BUTTON_CODE, 1);
                break;
            case R.id.allegryBtn:
                listIntent.putExtra(BUTTON_CODE, 2);
                break;
            case R.id.locationBtn:
                listIntent.putExtra(BUTTON_CODE, 3);
                break;
            case R.id.searhBtn:

               EditText searchEditTxt = (EditText) findViewById(R.id.searchEdit);

                if(checkIfNotEmpty(searchEditTxt)){
                    String searchText = searchEditTxt.getText().toString();
                    listIntent.putExtra(BUTTON_CODE, 4);
                    listIntent.putExtra(SEARCH,searchText.trim());

                }else{
                    okToLaunchList = false;
                }
                break;
            default:
                break;
        }

        if(okToLaunchList) {
            startActivity(listIntent);
        }
    }


    /**
     * Reusable function to check if an editable text field trans_in android is null or empty. Returns true
     * if edit text field is not empty otherwise false
     * @param editTextTmp
     * @return
     */
    private boolean checkIfNotEmpty(EditText editTextTmp){
        boolean checkStatus = true;
        String inputValue = editTextTmp.getText().toString();
        if(inputValue.trim().length() == 0){
            checkStatus = false;
            editTextTmp.setError(Html.fromHtml("<font color='red'>Required</font>"));
        }
        return checkStatus;
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
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        }
    }

    public void onSignUpBtnClick(View view){
        Intent intent = new Intent(MainActivity.this, SignupActivity.class);
        startActivity(intent);
    }

    /**
     * Updates the footer based on session
     */
    private void checkAndUpdateAccountUI(){
        SharedPreferences sessionPreferences = getSharedPreferences(LoginActivity.APP_PREFERENCES, MODE_PRIVATE);
        Button loginBtn = (Button) findViewById(R.id.loginBtn);
        Button signUp = (Button) findViewById(R.id.signUpBtn);
        Button userName = (Button) findViewById(R.id.userBtn);

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

}
