package LoginRegistrationPage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import com.linkclink.LSR.R;

import MainMenuDrawerPage.MainMenuActivity;
import RegistrationPage.RegistrationPageActivity;
import androidx.appcompat.app.AppCompatActivity;
import logic.ShowToast;

public class LoginRegistrationActivity extends AppCompatActivity {
    protected static EditText loginEditText;
    protected static EditText passwordEditText;

    protected static Switch autoSwitch;

    protected static TextView errorLogTextView;

    protected static String dataLogin;
    protected static String dataPassword;
    protected static String dbLoginData;
    protected static String dbPasswordData;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_firstpage_lr);
        InitialisationComponents(); /* Comp init */
    }

    @Override
    protected void onStart() {
        SaveLoginDataInDevice saveData = new SaveLoginDataInDevice();
        saveData.LoadUserLoginData(getApplicationContext());
        super.onStart();
    }

    public void RegistrationLayout(View view) {
        Intent intent_reg = new Intent(LoginRegistrationActivity.this, RegistrationPageActivity.class);
        startActivityForResult(intent_reg, 1);
        overridePendingTransition(R.anim.animation_between_layout_no_mow, R.anim.animation_between_layout_no_mow);
    }

    private void InitialisationComponents() {
        loginEditText = (EditText) findViewById(R.id.editText_login_firstpage);
        passwordEditText = (EditText) findViewById(R.id.editText_pass_firstpage);
        autoSwitch = (Switch) findViewById(R.id.switch_save_data);
        errorLogTextView = (TextView) findViewById(R.id.textView_error);
    }

    private void GetEditTextData() {
        dataLogin = loginEditText.getText().toString();
        dataPassword = passwordEditText.getText().toString();
    }

    private void MainMenuLayout() {
        Intent intent_main = new Intent(LoginRegistrationActivity.this, MainMenuActivity.class);
        startActivityForResult(intent_main, 1);
        overridePendingTransition(R.anim.animation_between_layout_no_mow, R.anim.animation_between_layout_no_mow);
    }


    public void LogIn(View view) {
        CheckUserDataForLogIn checkUser = new CheckUserDataForLogIn();
        SaveLoginDataInDevice saveData = new SaveLoginDataInDevice();

        /* Get data with EditText */
        GetEditTextData();

        /* Check data */
        checkUser.MainCheck(getApplicationContext());
        /* If login data is correct */
        if (CheckUserDataForLogIn.flagSqlDataError != 1) {
            if (autoSwitch.isChecked()) saveData.SaveUserLoginData(getApplicationContext());
            ShowToast.showToast(getApplicationContext(), "Success login"); /* beta */
            MainMenuLayout();
        }
    }
}
