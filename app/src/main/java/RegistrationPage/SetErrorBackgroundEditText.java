package RegistrationPage;

import com.linkclink.LSR.R;

public class SetErrorBackgroundEditText extends RegistrationPageActivity
{
    /* Set EditText drawable for visible errors */
    protected void SetLoginError()
    { loginEditText0.setBackgroundResource(R.drawable.shape_edittext_error); }
    protected void SetPassword0Error()
    { passwordEditText0.setBackgroundResource(R.drawable.shape_edittext_error); }
    protected void SetPassword1Error()
    { passwordEditText1.setBackgroundResource(R.drawable.shape_edittext_error); }

    protected void ResetLoginError()
    { loginEditText0.setBackgroundResource(R.drawable.selector_edittext_0); }
    protected void ResetPassword0Error()
    { passwordEditText0.setBackgroundResource(R.drawable.selector_edittext_0); }
    protected void ResetPassword1Error()
    { passwordEditText1.setBackgroundResource(R.drawable.selector_edittext_0); }
}
