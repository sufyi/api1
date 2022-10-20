package com.example.api1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TextInputEditText username,password;
    Button btnlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=findViewById(R.id.text1);
        password=findViewById(R.id.textpassword);
        btnlogin=findViewById(R.id.btnlgn);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(username.getText().toString()) ||
                        (TextUtils.isEmpty(password.getText().toString()))){
                    Toast.makeText(MainActivity.this, "username/password Required", Toast.LENGTH_LONG).show();

                } else{
                    //proceed to login}
                    login();
            }}
        });
    }
    public void login(){
        loginrequest loginrequest=new loginrequest();
        loginrequest.setUsername(username.getText().toString());
        loginrequest.setUsername(password.getText().toString());
        Call<loginresponse> loginresponseCall=apiclient.getUserService().userlogin(loginrequest);
        loginresponseCall.enqueue(new Callback<loginresponse>() {
            @Override
            public void onResponse(Call<loginresponse> call, Response<loginresponse> response) {
                if(response.isSuccessful()){
                    Toast.makeText(MainActivity.this, "login successful", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this, "login failed", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<loginresponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });
                    }
}