package RegistrationPage;

public class DataChartersUserCheck extends RegistrationPageActivity
{
    SetErrorBackgroundEditText setErrorEd = new SetErrorBackgroundEditText();

    private int flagLoginError = 0;
    private int flagPasswordError = 0;

    /* Check (login-data) charters */
    protected void LoginChartersCheck()
    {
        flagLoginError = 0;
        if((dataLogin.length() < 6 || dataLogin.length() > 15) && dataLogin.length() != 0) /* Check login length */
        {
            dataErrorText += "* login is to small or long\n";
            flagLoginError = 1;
        }
        if(!(boolean0 = CheckLoginDataCyrillic(dataLogin))) /* Check incorrect Symbols */
        {
            dataErrorText += "* incorrect login charters only:[0-9,a-z,A-Z]\n";
            flagLoginError = 1;
        }
        if(flagLoginError != 1) setErrorEd.ResetLoginError();
        else setErrorEd.SetLoginError();
    }
    /* Check (password-data) charters */
    protected void PasswordChartersCheck()
    {
        flagPasswordError = 0;
        if(!dataPassword0.equals(dataPassword1)) /* Second password is incorrect */
        {
            dataErrorText += "* password mismatch\n";
            setErrorEd.SetPassword1Error();
        } else setErrorEd.ResetPassword1Error();

        if((dataPassword0.length() < 4 || dataPassword0.length() > 20) && dataPassword0.length() != 0) /* Check password length */
        {
            dataErrorText += "* password is to small or long\n";
            flagPasswordError = 1;
        }
        if(!(boolean0 = CheckPasswordDataCyrillic(dataPassword0))) /* Check incorrect Symbols */
        {
            dataErrorText += "* incorrect password charters only:[0-9,a-z,A-Z,symbols]\n";
            flagPasswordError = 1;
        }
        if(flagPasswordError != 1) setErrorEd.ResetPassword0Error();
        else setErrorEd.SetPassword0Error();
    }
    /* Check (a-z) (0-9) (A-Z) */
    protected boolean CheckLoginDataCyrillic(String data)
    {
        data = data.replaceAll("[A-Za-z0-9]", "");
        return data.equals("");
    }
    /* Check (a-z) (0-9) (A-Z) (symbols) */
    protected boolean CheckPasswordDataCyrillic(String data)
    {
        data = data.replaceAll("[A-Za-z0-9]", "");
        return data.equals("");
    }
}
