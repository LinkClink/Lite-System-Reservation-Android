package com.linkclink.LSR;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrationPageActivity extends AppCompatActivity
{
    EditText passwordEditText0;
    EditText passwordEditText1;
    EditText loginEditText0;

    TextView errorLog;

    String errorText = null;
    boolean boolean_1 = Boolean.parseBoolean(null);

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.registration_page);
    }
    public void PreviousLayout(View view)
    {
        Intent intent_reg = new Intent(RegistrationPageActivity.this, MainClassFirstPage.class);
        startActivityForResult(intent_reg,1);
        overridePendingTransition(R.anim.layout_back,R.anim.layout_back);
    }
    public void RegisterDataCheck(View view)
    {
        errorText = "";
        loginEditText0 = (EditText) findViewById(R.id.editText_login_registration);
        passwordEditText0 = (EditText) findViewById(R.id.editText_pass1_registration);
        passwordEditText1 = (EditText) findViewById(R.id.editText_pass2_registration);
        errorLog = (TextView) findViewById(R.id.textView_error);
        /* Login charters check */
        LoginChartersCheck();
       /* Password charters check */
        PasswordChartersCheck();
        // Check
        errorLog.setText(errorText);
    }

    public void LoginChartersCheck()
    {
        boolean_1 = CheckLoginDataCyrillic(loginEditText0.getText().toString());
        if(loginEditText0.getText().toString().length() < 6 || loginEditText0.getText().toString().length() > 15) errorText += "Login is to small or long\n"; /* Check login length */
        if (!boolean_1) errorText += "Incorrect login charters only:[0-9,a-z,A-Z]\n"; /* Check incorrect Symbols */
    }
    public void PasswordChartersCheck()
    {
        boolean_1 = CheckPasswordDataCyrillic(passwordEditText0.getText().toString());
        if(!passwordEditText0.getText().toString().equals(passwordEditText1.getText().toString())) errorText += "Password mismatch\n"; /* Second password is incorrect */
        if(passwordEditText0.getText().toString().length() < 4 || passwordEditText0.getText().toString().length() > 20) errorText += "Password is to small or long\n"; /* Check password length */
        if(!boolean_1) errorText += "Incorrect password charters only:[0-9,a-z,A-Z]\n";
    }
    private static boolean CheckLoginDataCyrillic(String data)
    {
        data = data.replaceAll("[A-Za-z0-9]", "");
        System.out.println(data);
        return data.equals("");
    }
    private static boolean CheckPasswordDataCyrillic(String data)
    {
        data = data.replaceAll("[A-Za-z0-9^\\S]", ""); /* (a-z) (0-9) (A-Z) (symbols) */
        System.out.println(data);
        return data.equals("");
    }
    
    private static void DataBaseSqlDataCheck()
    {

    }





}
