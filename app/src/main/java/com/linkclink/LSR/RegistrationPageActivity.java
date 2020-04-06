package com.linkclink.LSR;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrationPageActivity extends AppCompatActivity
{

    Button back_button;
    Button sing_up;

    EditText password_0;
    EditText password_1;
    EditText login;

    TextView error_log;

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
        sing_up = (Button) findViewById(R.id.button_singUp_registration);

        if(view == back_button)
        {
            Intent intent_reg = new Intent(RegistrationPageActivity.this, MainClass_FirstPage.class);
            startActivityForResult(intent_reg,1);
            overridePendingTransition(R.anim.layout_back,R.anim.layout_back);
        }

        if(view == sing_up)
        {
            RegisterDataCheck();
        }


    }


    public void RegisterDataCheck()
    {
        login = (EditText) findViewById(R.id.editText_login_registration);
        password_0 = (EditText) findViewById(R.id.editText_pass1_registration);
        password_1 = (EditText) findViewById(R.id.editText_pass2_registration);
        error_log = (TextView) findViewById(R.id.textView_error);


        Pattern p = Pattern.compile("[^\\w]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(login.getText().toString());
        boolean b = m.find();

        if (b)
            error_log.setText("Incorrect Charters only:[0-9,a-z,A-Z]");



    }







}
