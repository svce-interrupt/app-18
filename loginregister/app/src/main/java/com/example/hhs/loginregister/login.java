package com.example.hhs.loginregister;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class login extends AppCompatActivity {

    TextView uid,lgin_pswd;
    Button lgin;
    String uid_mobile,login_pswd;

    int isSignedIn=0;

    private ProgressDialog progressDialog;
    private static final String TAG = login.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        uid=findViewById(R.id.uid);
        lgin_pswd=findViewById(R.id.login_pswd);
        lgin=findViewById(R.id.login_btn);

        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);

        /*try {
            if (!isConnected()) {
                Toast.makeText(register.this, "Please connect to the Internet.", Toast.LENGTH_SHORT).show();
            }
        } catch (InterruptedException f) {

        } catch (IOException e) {

        }*/

        lgin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uid_mobile=uid.getText().toString();
                login_pswd=lgin_pswd.getText().toString();

                signin();
            }
        });
    }

    private void signin() {
        if(isSignedIn==1){          // goto myevents screen

        }
        else{
            /*if (!validate()) {
            onSignupFailed();
            return;
            }*/

            progressDialog.setMessage("Signing in ...");
            showDialog();

            Log.d(TAG,"login vals : "+uid_mobile+login_pswd);

            StringRequest strReq = new StringRequest(Request.Method.POST,
                    //"http://localhost/interrupt/18/register.php",
                    //"http://192.168.13.217/interrupt/app_connect/login.php",
                    // "http://192.168.43.53/interrupt/app_connect/login.php",         // correct
                     "http://192.168.0.3/interrupt/app_connect/login.php",
                    //"http://localhost/interrupt/app_connect/login.php",
                    //"https://keontaesemisi.000webhostapp.com/reg.php",
                    //"http://172.31.99.160/interrupt/db/register.php",
                    //"http://localhost/interrupt/app_db/register.php",
                    new Response.Listener<String>() {

                        @Override
                        public void onResponse(String response) {
                            Log.d(TAG, "Login Response: " + response.toString());
                            hideDialog();

                            try {
                                JSONObject jObj = new JSONObject(response);
                                boolean error = jObj.getBoolean("error");

                                if (!error) {

                                    JSONObject user = jObj.getJSONObject("user");
                                    String mobile = user.getString("mobileNo");
                                    String password = user.getString("password");
                                    String collegeName = user.getString("college");
                                    String name1 = user.getString("name");
                                    String email = user.getString("email");

                                    Log.d(TAG,"login successful");

                                    Toast.makeText(getApplicationContext(), "Login successful!", Toast.LENGTH_LONG).show();

                                } else {


                                    String errorMsg = jObj.getString("error_msg");
                                    Toast.makeText(getApplicationContext(),
                                            errorMsg, Toast.LENGTH_LONG).show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e(TAG, "Registration Error: " + error.getMessage());
                    Toast.makeText(getApplicationContext(),
                            error.getMessage(), Toast.LENGTH_LONG).show();
                    hideDialog();
                }
            }) {

                @Override
                protected Map<String, String> getParams() {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("mobileNo", uid_mobile);
                    params.put("password", login_pswd);
                    return params;
                }

            };

            AppController.getInstance().addToRequestQueue(strReq);
        }

                }

    private void showDialog() {
        if (!progressDialog.isShowing())
            progressDialog.show();
    }

    private void hideDialog() {
        if (progressDialog.isShowing())
            progressDialog.dismiss();
    }

    public boolean validate() {
        boolean valid = true;

        /*String name1 = nameText.getText().toString();
        String email = emailText.getText().toString();
        String mobile = mobNumText.getText().toString();
        String password = passText.getText().toString();
        //String reEnterPassword = rePasText.getText().toString();


        if (name1.isEmpty() || name1.length() < 3) {
            nameText.setError("at least 3 characters");
            valid = false;
        } else {
            nameText.setError(null);
        }

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailText.setError("enter a valid email address");
            valid = false;
        } else {
            emailText.setError(null);
        }

        if (mobile.isEmpty() || mobile.length() != 10) {
            mobNumText.setError("Enter Valid Mobile Number");
            valid = false;
        } else {
            mobNumText.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            passText.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            passText.setError(null);
        }

        /*if (reEnterPassword.isEmpty() || reEnterPassword.length() < 4 || reEnterPassword.length() > 10 || !(reEnterPassword.equals(password))) {
            rePasText.setError("Password Do not match");
            valid = false;
        } else {
            rePasText.setError(null);
        }
*/
        return valid;
    }

    /*public void onSignupFailed() {
        Toast.makeText(getBaseContext(), "Signup failed", Toast.LENGTH_LONG).show();
        createAccount.setEnabled(true);
    }*/

    public boolean isConnected() throws InterruptedException, IOException {
        String command = "ping -c 1 google.com";
        return (Runtime.getRuntime().exec(command).waitFor() == 0);
    }
}
