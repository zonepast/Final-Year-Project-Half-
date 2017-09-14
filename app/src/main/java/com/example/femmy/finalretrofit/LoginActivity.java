package com.example.femmy.finalretrofit;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    EditText et_uname, et_pass;
    TextView tv_reg;
    Button bt_login;
    ProgressDialog pd;

    String url = "http://192.168.0.103";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setTitle("Login");

        et_uname = (EditText) findViewById(R.id.et_uname);
        et_pass = (EditText) findViewById(R.id.et_pass);

        tv_reg = (TextView) findViewById(R.id.tv_register);

        bt_login = (Button) findViewById(R.id.bt_login);

        pd = new ProgressDialog(LoginActivity.this);

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (et_uname.getText().toString().trim().length() == 0) {
                    et_uname.setError("Username not Entered");
                    et_uname.requestFocus();
                }
                if (et_pass.getText().toString().trim().length() == 0) {
                    et_pass.setError("Password not Entered");
                    et_pass.requestFocus();
                } else if (!et_uname.getText().toString().equals("") && !et_pass.getText().toString().equals("")) {
                    login(et_uname.getText().toString(), et_pass.getText().toString());
                } else {
                    Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
                }
            }
        });

        tv_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Register.class);
                startActivity(i);
                finish();
            }
        });
    }

    public void login(String username, String password) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        REGAPI services = retrofit.create(REGAPI.class);
        Call<String> call = services.login(username, password);
        System.out.println(username + "" + password);

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                System.out.println("done " + response.body().toString());

                if (response.body().toString().equals("logged_in")) {
                    Log.e(">>>>", "Ifffff");

                    Intent intent = new Intent(getApplicationContext(), Dashboard.class);
                    startActivity(intent);
                    finish();
                } else {
                    Log.e(">>>>", "Ifffffffdfff");
                    Toast.makeText(getApplicationContext(), "Invalid Data", Toast.LENGTH_LONG).show();
                }
                pd.dismiss();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                System.out.println("error" + t.toString());
                pd.dismiss();

            }
        });
    }
}
