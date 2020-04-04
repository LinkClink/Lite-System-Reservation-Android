package com.linkclink.LSR;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrationPageActivity extends AppCompatActivity
{

    Button back_button;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.registration_page);
    }

    public void onClick(View view)
    {
        back_button = (Button) findViewById(R.id.button_back_registration);
        if(view == back_button)
        {
            Intent intent_reg = new Intent(RegistrationPageActivity.this, MainClass_FirstPage.class);
            startActivityForResult(intent_reg,1);
            overridePendingTransition(R.anim.layout_back,R.anim.layout_back);
        }
    }


}
