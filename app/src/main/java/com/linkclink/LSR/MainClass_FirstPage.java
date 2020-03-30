package com.linkclink.LSR;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class MainClass_FirstPage extends AppCompatActivity
{
    Button registration_button;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstpage_login_registration);
    }

    public void onClick(View view)
    {
        registration_button  = (Button) findViewById(R.id.button_singUp_firstpage);
        if(view == registration_button) Registration();
    }

    public void Registration()
    {
        Intent intent_reg = new Intent(MainClass_FirstPage.this, RegistrationPageActivity.class);
        startActivityForResult(intent_reg,1);
        //overridePendingTransition(R.anim.animation_activity_standart_1,R.anim.animation_activity_standart_1);
    }

}
