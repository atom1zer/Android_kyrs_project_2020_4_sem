package com.example.kyrsovaya_client_v2.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.example.kyrsovaya_client_v2.R;
import com.example.kyrsovaya_client_v2.adapters.QuizAdapter;

import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button buttonSignIn,  buttonSignUp;
    private TextView Hello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        buttonSignIn =  (Button)  findViewById( R.id.b_autoriz);
        buttonSignUp =  (Button)  findViewById( R.id.btnRegister);


        buttonSignIn.setOnClickListener(this);
        buttonSignUp.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {

        if ( view ==  buttonSignIn) {

            startActivity(new Intent(this,  LoginActivity.class) );

        }  else if ( view ==  buttonSignUp) {

            startActivity(new Intent(this,  RegisterActivity.class) );

        }
    }

}
