package com.example.hhs.loginregister;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class register extends AppCompatActivity {

    private static final String TAG = register.class.getSimpleName();
    private EditText nameText;
    private EditText emailText;
    private EditText mobNumText;
    private EditText passText;
    private EditText rePasText;
    private TextView loginLink;
    private EditText collegeNameText;
    private Button createAccount;
    private int flag = 0;
    private String name1;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nameText = (EditText) findViewById(R.id.name);
        emailText = (EditText) findViewById(R.id.email);
        mobNumText = (EditText) findViewById(R.id.mobile);
        passText = (EditText) findViewById(R.id.pswd);
        //rePasText = (EditText) findViewById(R.id.input_reEnterPassword);
        collegeNameText = (EditText) findViewById(R.id.college);
        //loginLink = (TextView) findViewById(R.id.link_login);
        createAccount = (Button) findViewById(R.id.reg);
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);

        /*try {
            if (!isConnected()) {
                Toast.makeText(register.this, "Please connect to the Internet.", Toast.LENGTH_SHORT).show();
            }
        } catch (InterruptedException f) {

        } catch (IOException e) {

        }*/

        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });

        /*loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.animator.push_left_in, R.animator.push_left_out);
            }
        });*/
    }

    public boolean isConnected() throws InterruptedException, IOException {
        String command = "ping -c 1 google.com";
        return (Runtime.getRuntime().exec(command).waitFor() == 0);
    }


    public void signup() {
        /*if (!validate()) {
            onSignupFailed();
            return;
        }*/


        name1 = nameText.getText().toString().trim();
        final String email1 = emailText.getText().toString().trim();
        final String mobile1 = mobNumText.getText().toString().trim();
        String password1 = passText.getText().toString().trim();
        String collegeName = collegeNameText.getText().toString().trim();

        registerUser(name1, email1, password1, mobile1, collegeName);

    }


    public void onSignupFailed() {
        Toast.makeText(getBaseContext(), "Signup failed", Toast.LENGTH_LONG).show();
        createAccount.setEnabled(true);
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(register.this, MainActivity.class);
        startActivity(i);
    }

    private void registerUser(final String name1, final String email1,
                              final String password1, final String mobile1, final String collegeName) {

        Log.d(TAG, "onclick Response: " + name1+email1+password1+mobile1+collegeName);

        progressDialog.setMessage("Creating Account ...");
        showDialog();

        StringRequest strReq = new StringRequest(Request.Method.POST,
                //"http://localhost/interrupt/18/register.php",
                //"http://192.168.13.217/interrupt/app_connect/register.php",
                //"http://192.168.43.53/interrupt/app_connect/register.php",         // correct
                 "http://192.168.0.3/interrupt/app_connect/register.php",
                //"http://localhost/interrupt/app_connect/register.php",
                //"https://keontaesemisi.000webhostapp.com/reg.php",
                //"http://172.31.99.160/interrupt/db/register.php",
                //"http://localhost/interrupt/app_db/register.php",
                new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.d(TAG, "Register Response: " + response.toString());
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

                        Toast.makeText(getApplicationContext(), "Registration successful!", Toast.LENGTH_LONG).show();

                    /*    Intent i = new Intent(SignUpActivity.this, MainActivity.class);
                        i.putExtra("username", name1);
                        i.putExtra("usermail", email);
                        i.putExtra("usernum", mobile);
                        startActivity(i);
                            finish();*/
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
                params.put("mobileNo", mobile1);
                params.put("password", password1);
                params.put("college", collegeName);
                params.put("name", name1);
                params.put("email", email1);

                return params;
            }

        };

        AppController.getInstance().addToRequestQueue(strReq);
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
}