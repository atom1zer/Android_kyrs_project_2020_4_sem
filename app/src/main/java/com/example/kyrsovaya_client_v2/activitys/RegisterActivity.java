package com.example.kyrsovaya_client_v2.activitys;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kyrsovaya_client_v2.R;
import com.example.kyrsovaya_client_v2.api.RetrofitClient;
import com.example.kyrsovaya_client_v2.helper.SharedPrefManager;
import com.example.kyrsovaya_client_v2.models.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterActivity extends Activity implements View.OnClickListener {

    private EditText Login;
    private EditText Email;
    private EditText Password;
    private Button SignUp;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set View to register.xml
        setContentView(R.layout.register);
        TextView loginScreen = (TextView) findViewById(R.id.link_to_login);
        SignUp =  (Button)  findViewById( R.id.btnRegister);
        Login =  (EditText)  findViewById( R.id.reg_fullname);
        Password =  (EditText)  findViewById( R.id.reg_password);
        Email =  (EditText)  findViewById( R.id.reg_email);
        SignUp.setOnClickListener(this);
        // Listening to Login Screen link
        loginScreen.setOnClickListener((v) -> {Swap();});

        };
    private void Swap() {
            // Closing registration screen
            // Switching to Login Screen/closing register screen
        Intent i = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(i);
            finish();
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (SharedPrefManager.getInstance(this).isLoggedIn()){
            Intent intent = new Intent(this, ChatListActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }

    @Override
    public void onClick(View view) {
        if ( view ==  SignUp) {
            UserSignUp();
        }
    }



    private void UserSignUp(){
        String email = Email.getText().toString().trim(); //email
        String password = Password.getText().toString().trim(); //password
        String login = Login.getText().toString().trim(); //логин



        if (login.isEmpty()){
            Login.setError("Не правильно введено имя");
            Login.requestFocus();
            return;

        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            Email.setError("Напишите майл правильно");
            Email.requestFocus();
            return;
        }

        if(password.length() <8 ){
            Password.setError("Пароль короткий");
            Password.requestFocus();
            return;
        }
        if (login.isEmpty()){
            Login.setError("Не правильно введен логин");
            Login.requestFocus();
            return;
        }


        if(password.isEmpty()){
            Password.setError("Пароль не верный");
            Password.requestFocus();
            return;
        }




        Call<ResponseBody> call = RetrofitClient
                .getInstance()
                .getApi()
                .createUser(email, login, password);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                try {
                    if(!response.isSuccessful()){
                        Toast.makeText(  RegisterActivity.this, "Регистрация  не произошла!!!", Toast.LENGTH_LONG).show();
                    }
                    String s = response.body().string();
                    Intent i=new Intent(getApplicationContext(),LoginActivity.class);
                    startActivity(i);

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(  RegisterActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }

        });

    }



}

