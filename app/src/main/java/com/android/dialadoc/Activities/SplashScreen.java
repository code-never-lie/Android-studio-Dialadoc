package com.android.dialadoc.Activities;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.dialadoc.Models.SharePrefrencesModel;
import com.android.dialadoc.R;
import com.google.firebase.auth.FirebaseAuth;

public class SplashScreen extends AppCompatActivity {
    //declare variables
    private Button patient,doctor;
    private String userType;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //calling function
        initAllUi();
        buttonClickListeners();
    }

    private void buttonClickListeners() {
        //handle patient button
        patient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userType="Patient";
                //calling function
                userTypeClick(userType);
            }
        });
        //handle doctor button
        doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userType="Doctor";
                //calling function
                userTypeClick(userType);
            }
        });
    }
    //functionality of function that calling upper braces
    private void userTypeClick(String userType) {
        SharePrefrencesModel.setDefaults("usertype",userType,SplashScreen.this);
        //changing screens
        Intent intent=new Intent(SplashScreen.this,Login.class);
        intent.putExtra("userType",userType);
        startActivity(intent);
    }
    //functionality of function that calling upper braces
    private void initAllUi() {
        //casting variables
        patient=(Button)findViewById(R.id.splashScreen_patient);
        doctor=(Button)findViewById(R.id.splash_Screen_doctor);
        //initalize variables
        mAuth=FirebaseAuth.getInstance();
        //there is no user login
        if(mAuth.getCurrentUser()!=null)
        {
            //for testing
            Log.d("authkey",mAuth.getUid());
            //changing screens
            Intent intent=new Intent(SplashScreen.this,MainActivity.class);
            startActivity(intent);
            finish();

        }
    }
}
