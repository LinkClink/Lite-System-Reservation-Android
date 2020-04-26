package RegistrationPage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import com.linkclink.LSR.R;

import LoginRegistrationPage.LoginRegistrationActivity;
import androidx.appcompat.app.AppCompatActivity;

public class RegistrationPageActivity extends AppCompatActivity {
    private TextView errorLogEditText;

    static EditText passwordEditText0;
    static EditText passwordEditText1;
    static EditText loginEditText0;

    static String dataPassword0;
    static String dataPassword1;
    static String dataLogin;

    static String dataErrorText = "";

    boolean boolean0 = Boolean.parseBoolean(null);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.layout_registration);
    }

    /* Button onclick change layout */
    public void PreviousLayout(View view) {
        Intent intent_reg = new Intent(RegistrationPageActivity.this, LoginRegistrationActivity.class);
        startActivityForResult(intent_reg, 1);
        overridePendingTransition(R.anim.layout_no_an, R.anim.layout_no_an);
    }

    /* Component Initialisation */
    private void InitialisationLayoutComponents() {
        loginEditText0 = (EditText) findViewById(R.id.editText_login_registration);
        passwordEditText0 = (EditText) findViewById(R.id.editText_pass1_registration);
        passwordEditText1 = (EditText) findViewById(R.id.editText_pass2_registration);
        errorLogEditText = (TextView) findViewById(R.id.textView_error);

        dataLogin = loginEditText0.getText().toString();
        dataPassword0 = passwordEditText0.getText().toString();
        dataPassword1 = passwordEditText1.getText().toString();
    }

    /* Set data error */
    private void ResetErrorLog() {
        errorLogEditText.setText(dataErrorText);
        dataErrorText = "";
    }

    /* Main button OnClick */
    public void RegisterDataCheck(View view) {
        DataChartersUserCheck DataCheck = new DataChartersUserCheck();
        sqlDataUserCheck DataBaseCheck = new sqlDataUserCheck();
        AddNewUser addNewUser = new AddNewUser();
        InitialisationLayoutComponents();
        /* Charters check lg + pass */
        DataCheck.LoginChartersCheck(); /* Login charters check */
        DataCheck.PasswordChartersCheck(); /* Password charters check */
        /* Success charters check */
        if ((DataChartersUserCheck.flagLoginCharterError | DataChartersUserCheck.flagPasswordCharterError) == 0)
            DataBaseCheck.DataBaseSqlDataCheck(getApplicationContext()); /* Login sql-data check */
        // Show errors (beta)
        ResetErrorLog();
        /* Success sql check */
        if (sqlDataUserCheck.flagSqlLoginError == 0) /* Add new user to db */
            addNewUser.RegisterNewUser(getApplicationContext());
    }
}
