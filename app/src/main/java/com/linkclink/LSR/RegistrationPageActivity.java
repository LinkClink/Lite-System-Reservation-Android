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
    EditText password_0;
    EditText password_1;
    EditText login;

    TextView error_log;

    String error_text = "";
    boolean boolean_1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.registration_page);
    }

    public void PreviousLayout(View view)
    {
        Intent intent_reg = new Intent(RegistrationPageActivity.this, MainClass_FirstPage.class);
        startActivityForResult(intent_reg,1);
        overridePendingTransition(R.anim.layout_back,R.anim.layout_back);
    }


    public void RegisterDataCheck(View view)
    {
        error_text = "";

        login = (EditText) findViewById(R.id.editText_login_registration);
        password_0 = (EditText) findViewById(R.id.editText_pass1_registration);
        password_1 = (EditText) findViewById(R.id.editText_pass2_registration);
        error_log = (TextView) findViewById(R.id.textView_error);

        /* Login charters check */
        LoginChartersCheck();

       /* Password charters check */
        PasswordChartersCheck();

        // Check
        error_log.setText(error_text);
    }

    public void LoginChartersCheck()
    {
        boolean_1 = CheckDataCyrillic(login.getText().toString());
        if(login.getText().toString().length() < 6) error_text += "Login is to small\n"; /* Check login length */
        if (!boolean_1) error_text += "Incorrect Charters only:[0-9,a-z,A-Z]\n"; /* Check incorrect Symbols */
    }

    public void PasswordChartersCheck()
    {
        if(!password_0.getText().toString().equals(password_1.getText().toString())) error_text += "Password mismatch\n";
        if(password_0.getText().toString().length() < 4) error_text += "Password is to small\n";
    }


    private static boolean CheckDataCyrillic(String data)
    {
        data = data.replaceAll("[A-Za-z0-9]", "");
        System.out.println(data);
        return data.equals("");
    }
}
