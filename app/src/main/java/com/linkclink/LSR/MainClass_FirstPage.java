package com.linkclink.LSR;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainClass_FirstPage extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        setTheme(R.style.AppTheme);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstpage_login_registration);
    }

    public void RegistrationLayout(View view)
    {
        Intent intent_reg = new Intent(MainClass_FirstPage.this, RegistrationPageActivity.class);
        startActivityForResult(intent_reg,1);
        overridePendingTransition(R.anim.layout_next,R.anim.layout_next);
    }
}
