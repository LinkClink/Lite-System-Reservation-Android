package LoginRegistrationPage;

import com.linkclink.LSR.R;

public class SetErrorBackgroundEditText extends LoginRegistrationActivity {

    /* Set EditText drawable for visible errors */
    protected void SetLoginError() {
        loginEditText.setBackgroundResource(R.drawable.shape_edittext_error);
    }

    protected void SetPasswordError() {
        passwordEditText.setBackgroundResource(R.drawable.shape_edittext_error);
    }

    protected void ResetLoginError() {
        loginEditText.setBackgroundResource(R.drawable.selector_edittext_0);
    }

    protected void ResetPasswordError() {
        passwordEditText.setBackgroundResource(R.drawable.selector_edittext_0);
    }


}
