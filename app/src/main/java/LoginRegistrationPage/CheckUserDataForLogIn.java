package LoginRegistrationPage;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.io.IOException;

import SQL.sqlDataBaseConnect;
import logic.ShowToast;

public class CheckUserDataForLogIn extends LoginRegistrationActivity {

    private SetErrorBackgroundEditText setError = new SetErrorBackgroundEditText();
    private Context context;

    private sqlDataBaseConnect dataBaseHelper;
    private SQLiteDatabase database;

    private String tableName = "UserData";
    private String dataError = "";

    private Cursor cursorDataLogin;
    private Cursor cursorRowCount;

    private int columnLength;
    private int columnId;

    protected static int flagSqlDataError = 1;

    private int flagCheckEmpty0 = 1;
    private int flagCheckEmpty1 = 1;

    protected void MainCheck(Context context) {
        this.context = context;
        ConnectToDataBase();
        CheckEmptyEditText();
        SetErrorLog();

        if (flagCheckEmpty0 != 1 && flagCheckEmpty1 != 1) // beta ver 1
            CheckData();
    }

    private void CheckData() {
        /* Get rows count */
        cursorRowCount = database.rawQuery(" SELECT * FROM " + tableName, null);
        columnLength = cursorRowCount.getCount();

        /* Lg ck (login column - 2) */
        for (columnId = 1; columnId < columnLength; columnId++) {
            cursorDataLogin = database.rawQuery(" SELECT * FROM " + tableName + " WHERE id = " + columnId, null);
            cursorDataLogin.moveToFirst();
            dbLoginData = cursorDataLogin.getString(2);

            if (dataLogin.equals(dbLoginData)) /* Check login */ {
                dbPasswordData = cursorDataLogin.getString(3);
                if (dataPassword.equals(dbPasswordData)) /* Check password */ {
                    flagSqlDataError = 0;
                    break;
                } else {
                    ShowToast.showToast(context, "Password is incorrect");
                    break;
                }
            } else {
                flagSqlDataError = 1;
                ShowToast.showToast(context, "Login is incorrect");
                break;
            }
        }
        cursorDataLogin.close();
        cursorRowCount.close();
    }

    /* Local db connect */
    private void ConnectToDataBase() {
        /* For DataBase connect */
        dataBaseHelper = new sqlDataBaseConnect(context);
        try {
            dataBaseHelper.updateDataBase();
        } catch (IOException mIOException) {
            ShowToast.showToast(getApplicationContext(), "Unable to update database: error 01");
        }
        try {
            database = dataBaseHelper.getReadableDatabase();
        } catch (SQLException mSQLException) {
            ShowToast.showToast(getApplicationContext(), "Unable to write database: error 02");
        }
    }

    private void CheckEmptyEditText() {
        /* Login */
        if (dataLogin.length() == 0) {
            setError.SetLoginError();
            flagCheckEmpty0 = 1;
            dataError += "* Login must not be Empty\n";
        } else {
            setError.ResetLoginError();
            flagCheckEmpty0 = 0;
        }
        /* Password */
        if (dataPassword.length() == 0) {
            setError.SetPasswordError();
            flagCheckEmpty1 = 1;
            dataError += "* Password must not be Empty\n";
        } else {
            setError.ResetPasswordError();
            flagCheckEmpty1 = 0;
        }
    }

    private void SetErrorLog() {
        errorLogTextView.setText(dataError);
        dataError = "";
    }
}
