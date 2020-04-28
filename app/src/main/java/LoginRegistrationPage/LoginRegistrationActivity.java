package LoginRegistrationPage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import com.linkclink.LSR.R;

import RegistrationPage.RegistrationPageActivity;
import androidx.appcompat.app.AppCompatActivity;
import logic.ShowToast;

public class LoginRegistrationActivity extends AppCompatActivity {
    protected static EditText loginEditText;
    protected static EditText passwordEditText;

    protected static TextView errorLogTextView;

    protected static String dataLogin;
    protected static String dataPassword;
    protected static String dbLoginData;
    protected static String dbPasswordData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_firstpage_lr);
    }

    public void RegistrationLayout(View view) {
        Intent intent_reg = new Intent(LoginRegistrationActivity.this, RegistrationPageActivity.class);
        startActivityForResult(intent_reg, 1);
        overridePendingTransition(R.anim.layout_no_an, R.anim.layout_no_an);
    }

    private void InitialisationComponents() {
        loginEditText = (EditText) findViewById(R.id.editText_login_firstpage);
        passwordEditText = (EditText) findViewById(R.id.editText_pass_firstpage);
        dataLogin = loginEditText.getText().toString();
        dataPassword = passwordEditText.getText().toString();
        errorLogTextView = (TextView) findViewById(R.id.textView_error);
    }

    public void LogIn(View view) {
        CheckUserDataForLogIn checkUser = new CheckUserDataForLogIn();
        /* Comp init */
        InitialisationComponents();
        /* Check data */
        checkUser.MainCheck(getApplicationContext());
        if(CheckUserDataForLogIn.flagSqlDataError != 1)
            ShowToast.showToast(getApplicationContext(),"Success login");


    }
}
