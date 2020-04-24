package com.linkclink.LSR;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import RegistrationPage.RegistrationPageActivity;
import androidx.appcompat.app.AppCompatActivity;

public class MainClassFirstPage extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        setTheme(R.style.AppTheme);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_firstpage_lr);
    }
    public void RegistrationLayout(View view)
    {
        Intent intent_reg = new Intent(MainClassFirstPage.this, RegistrationPageActivity.class);
        startActivityForResult(intent_reg,1);
        overridePendingTransition(R.anim.layout_no_an,R.anim.layout_no_an);
    }

    public void LogIn(View view)
    {




    }

}
