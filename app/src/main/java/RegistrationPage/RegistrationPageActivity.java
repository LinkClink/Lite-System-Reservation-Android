package RegistrationPage;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.linkclink.LSR.MainClassFirstPage;
import com.linkclink.LSR.R;

import androidx.appcompat.app.AppCompatActivity;
import logic.ShowToast;

public class RegistrationPageActivity extends AppCompatActivity
{
    static EditText passwordEditText0;
    static EditText passwordEditText1;
    static EditText loginEditText0;

    static String dataPassword0;
    static String dataPassword1;
    static String dataLogin;

    TextView errorLogEditText;

    static String dataErrorText = null;
    boolean boolean_1 = Boolean.parseBoolean(null);

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.registration_page);
    }
    /* Button onclick change layout */
    public void PreviousLayout(View view)
    {
        Intent intent_reg = new Intent(RegistrationPageActivity.this, MainClassFirstPage.class);
        startActivityForResult(intent_reg,1);
        overridePendingTransition(R.anim.layout_no_an,R.anim.layout_no_an);
    }
    /* Main */
    public void RegisterDataCheck(View view)
    {
        DataChartersUserCheck DataCheck = new DataChartersUserCheck();
        dataErrorText = "";

        loginEditText0 = (EditText) findViewById(R.id.editText_login_registration);
        passwordEditText0 = (EditText) findViewById(R.id.editText_pass1_registration);
        passwordEditText1 = (EditText) findViewById(R.id.editText_pass2_registration);
        errorLogEditText = (TextView) findViewById(R.id.textView_error);

        dataLogin = loginEditText0.getText().toString();
        dataPassword0 = passwordEditText0.getText().toString();
        dataPassword1 = passwordEditText1.getText().toString();

        /* Login charters check */
        DataCheck.LoginChartersCheck();
        /* Password charters check */
        DataCheck.PasswordChartersCheck();
        // Check
        errorLogEditText.setText(dataErrorText);
        ShowToast.showToast(getApplicationContext(),dataErrorText);
    }


    private static void DataBaseSqlDataCheck()
    { }
}
