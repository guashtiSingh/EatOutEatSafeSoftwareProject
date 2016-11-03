package com.centennial.project.eatouteatsafe;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Window;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.centennial.project.eatouteatsafe.pojos.APIConnection;

public class MainActivity extends AppCompatActivity {

    private static String BUTTON_CODE = "BUTTON_CODE";
    private static String SEARCH = "SEARCH_STRING";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
    }
    // calling the list activity in button click
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
     * Reusable function to check if an editable text field in android is null or empty. Returns true
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
}
