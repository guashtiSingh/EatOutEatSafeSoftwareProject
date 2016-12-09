package com.centennial.project.eatouteatsafe;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.centennial.project.eatouteatsafe.pojos.APIConnection;
import com.centennial.project.eatouteatsafe.pojos.JSONParser;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SignupActivity extends AppCompatActivity {

    private EditText mUsernameText;
    private EditText mPasswordText;
    private EditText mFirstNameText;
    private EditText mLastNameText;
    private EditText mEmailText;
    protected String WEBSERVICE_URL_SIGUP = "http://ec2-54-218-26-177.us-west-2.compute.amazonaws.com:8080/EOES-webService/user/signup";
    private ProgressDialog progressDialog = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mUsernameText = (EditText) findViewById(R.id.usernameText);
        mPasswordText = (EditText) findViewById(R.id.passwordText);
        mFirstNameText = (EditText) findViewById(R.id.firstNameText);
        mLastNameText = (EditText) findViewById(R.id.lastNameText);
        mEmailText = (EditText) findViewById(R.id.emailText);

        Button mSignInButton = (Button) findViewById(R.id.signUpButton);
        mSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptSigUp();
            }
        });

    }

    private void attemptSigUp(){

        if(checkIfEmpty(mUsernameText) && checkIfEmpty(mPasswordText) &&
                checkIfEmpty(mFirstNameText) && checkIfEmpty(mLastNameText) &&
                checkIfEmpty(mEmailText)){

            UserSigUpTask mSignUpTask = new UserSigUpTask(
                    mUsernameText.getText().toString().trim(),
                    mPasswordText.getText().toString().trim(),
                    mFirstNameText.getText().toString().trim(),
                    mLastNameText.getText().toString().trim(),
                    mEmailText.getText().toString().trim(),
                    this
            );
            mSignUpTask.execute((Void) null);
        }
    }

    /**
     * Represents an asynchronous registration task used to authenticate
     * the user.
     */
    public class UserSigUpTask extends AsyncTask<Void, Void, JSONObject> {

        private final String mUsername;
        private final String mPassword;
        private final String mFirstName;
        private final String mLastName;
        private final String mEmail;
        private SignupActivity act = null;

        UserSigUpTask(String username, String password, String firstName, String lastName,
                      String email, SignupActivity act) {
            mUsername = username;
            mPassword = password;
            mFirstName = firstName;
            mLastName = lastName;
            mEmail = email;
            this.act = act;
            progressDialog = new ProgressDialog(act);
        }

        protected void onPreExecute() {
            if(progressDialog != null) {
                progressDialog.setMessage("Signing Up ...");
                progressDialog.show();
                progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    public void onCancel(DialogInterface arg0) {
                        UserSigUpTask.this.cancel(true);
                    }
                });
            }else{
                Log.d("EatoutApp_Warning","Progress Dialog is null");
            }
        }

        @Override
        protected JSONObject doInBackground(Void... params) {
            try {

                JSONParser parser = new JSONParser();
                String[] signUpDetails = {mUsername,mPassword,mFirstName,mLastName,mEmail};
                Map<String, String[]> credentials = new HashMap<String, String[]>();
                credentials.put("SignUpCred",signUpDetails);
                String jsonString = parser.makeHttpRequest(WEBSERVICE_URL_SIGUP,"POST",credentials);
                return new JSONObject(jsonString);

            } catch (Exception e) {
                e.printStackTrace();
                return null;

            }
        }

        @Override
        protected void onPostExecute(final JSONObject jsonObject) {

            if(jsonObject.has("resultMsg") &&
                    jsonObject.optString("resultMsg").equalsIgnoreCase("success")){

               Toast.makeText(act, "SignUp Completed, Please login to use features",
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SignupActivity.this,LoginActivity.class);
                startActivity(intent);

            }else{
                Toast.makeText(act, "SignUp Failed, please try later", Toast.LENGTH_SHORT).show();
            }

            if(progressDialog != null)
                progressDialog.dismiss();
        }
    }

    /**
     * Generic method to check if the editText passed is empty or not
     * @param editTextTmp
     * @return
     */

    private boolean checkIfEmpty(EditText editTextTmp){
        boolean checkStatus = true;
        String inputValue = editTextTmp.getText().toString();
        if(inputValue.trim().length() == 0){
            checkStatus = false;
            editTextTmp.setError("required");
        }
        return checkStatus;
    }
}
