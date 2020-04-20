package RegistrationPage;

public class DataChartersUserCheck extends RegistrationPageActivity
{
    SetErrorBackgroundEditText setErrorEd = new SetErrorBackgroundEditText();

    /* Check (login-data) charters */
    protected void LoginChartersCheck()
    {
        boolean_1 = CheckLoginDataCyrillic(dataLogin);
        if((dataLogin.length() < 6 || dataLogin.length() > 15) && dataLogin.length() != 0) dataErrorText += "Login is to small or long\n"; /* Check login length */
        if (!boolean_1) dataErrorText += "Incorrect login charters only:[0-9,a-z,A-Z]\n"; /* Check incorrect Symbols */
        if(!dataErrorText.equals("")) setErrorEd.SetLoginError(); else setErrorEd.ResetLoginError();
    }
    /* Check (password-data) charters */
    protected void PasswordChartersCheck()
    {
        boolean_1 = CheckPasswordDataCyrillic(dataPassword0);
        if(!dataPassword0.equals(dataPassword1)) dataErrorText += "Password mismatch\n"; /* Second password is incorrect */
        if((dataPassword0.length() < 4 || dataPassword0.length() > 20) && dataPassword0.length() != 0) dataErrorText += "Password is to small or long\n"; /* Check password length */
        if(!boolean_1) dataErrorText += "Incorrect password charters only:[0-9,a-z,A-Z]\n";
        if(!dataErrorText.equals("")) setErrorEd.SetPassword0Error(); else setErrorEd.ResetPassword0Error();
    }
    /* Check (a-z) (0-9) (A-Z) */
    protected boolean CheckLoginDataCyrillic(String data)
    {
        data = data.replaceAll("[A-Za-z0-9]", "");
        return data.equals("");
    }
    /* Check (a-z) (0-9) (A-Z) */
    protected boolean CheckPasswordDataCyrillic(String data)
    {
        data = data.replaceAll("[A-Za-z0-9^\\S]", "");
        return data.equals("");
    }
}
