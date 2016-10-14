package com.centennial.project.eatouteatsafe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.View;
public class MainActivity extends AppCompatActivity {

    private static String BUTTON_CODE = "BUTTON_CODE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
    }
    // calling the list activity in button click
    public void callListRestaurentActivity(View mainView){
        Intent listIntent = new Intent (this, ListRestaurantsActivity.class);

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
        }

        startActivity(listIntent);
    }
}
