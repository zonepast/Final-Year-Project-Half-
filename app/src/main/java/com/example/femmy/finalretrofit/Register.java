package com.example.femmy.finalretrofit;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.ActionBar;
import android.view.MenuItem;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Register extends AppCompatActivity {

    EditText et_uname, et_pass, et_email, et_contact_number, et_address;
    Button bt_register;
    ProgressDialog pd;

    String url = "http://192.168.0.103";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().setTitle("Register");
       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        et_uname = (EditText) findViewById(R.id.et_uname);
        et_pass = (EditText) findViewById(R.id.et_pass);
        et_email = (EditText) findViewById(R.id.et_email);
        et_address = (EditText) findViewById(R.id.et_address);
        et_contact_number = (EditText) findViewById(R.id.et_contact_number);

        bt_register = (Button) findViewById(R.id.bt_register);

        pd=new ProgressDialog(Register.this);

        bt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (et_uname.getText().toString().length() == 0) {
                    et_uname.setError("Username not Entered");
                    et_uname.requestFocus();
                }
                if (et_pass.getText().toString().length() == 0) {
                    et_pass.setError("Password not Entered");
                    et_uname.requestFocus();
                }
                if(et_email.getText().toString().length() == 0)
                {
                    et_email.setError("Email not Entered");
                    et_email.requestFocus();
                }
                if(et_address.getText().toString().length() == 0)
                {
                    et_address.setError("Address not Entered");
                    et_address.requestFocus();
                }
                if (et_contact_number.getText().toString().length() == 0)
                {
                    et_contact_number.setError("Contact No not Entered");
                    et_contact_number.requestFocus();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
                }

                register(et_uname.getText().toString(),
                        et_pass.getText().toString(),
                        et_email.getText().toString(),
                        et_address.getText().toString(),
                        et_contact_number.getText().toString());
            }
        });
    }
    public void register(String username,String password,String email,String address,String contact_number)
    {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        REGAPI services = retrofit.create(REGAPI.class);
        Call<String> call = services.register(username,password,email,address,contact_number);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                System.out.println("done" + response.body().toString());

                if (response.body().toString().equals("inserted"))
                {
                    Intent i = new Intent(getApplicationContext(),LoginActivity.class);
                    startActivity(i);
                    finish();
                }
                /*else
                {+
                    Toast.makeText(getApplicationContext(),"Data not registered",Toast.LENGTH_LONG).show();
                }*/
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                System.out.println("error" + t.toString());
                pd.dismiss();

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
