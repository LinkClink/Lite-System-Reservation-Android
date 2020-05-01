package LoginRegistrationPage;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SaveLoginDataInDevice extends LoginRegistrationActivity {

    private Context context;

    private SharedPreferences userData;

    protected void SaveUserLoginData(Context context) {
        this.context = context;
        userData = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = userData.edit();
        editor.putString("login", dataLogin);
        editor.putString("password", dataPassword);
        editor.apply();
        editor.commit();
    }

    protected void LoadUserLoginData(Context context) {
        this.context = context;
        userData = PreferenceManager.getDefaultSharedPreferences(context);
        loginEditText.setText(userData.getString("login", ""));
        passwordEditText.setText(userData.getString("password", ""));
    }

}
