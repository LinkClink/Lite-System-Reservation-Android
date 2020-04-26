package LoginRegistrationPage;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.io.IOException;

import SQL.sqlDataBaseConnect;
import logic.ShowToast;

public class CheckUserDataForLogIn extends LoginRegistrationActivity {
    private Context context;

    private sqlDataBaseConnect dataBaseHelper;
    private SQLiteDatabase database;

    private String tableName = "UserData";
    
    private Cursor cursorDataLogin;
    private Cursor cursorRowCount;

    private int columnLength;
    private int columnId;

    private int flagSqlDataError = 1;
    private int flagSqlPasswordError = 0;

    protected void MainCheck(Context context) {
        this.context = context;
        ConnectToDataBase();

        if (dataLogin.length() != 0 && dataPassword.length() != 0) // beta ver 1
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
            System.out.println("Login"+ dbLoginData);
            if (dataLogin.equals(dbLoginData)) /* Check login */ {
                dbPasswordData = cursorDataLogin.getString(3);
                if (dataPassword.equals(dbPasswordData)) /* Check password */ {
                    flagSqlDataError = 0;
                    ShowToast.showToast(context, "Success login");
                    break;
                } else ShowToast.showToast(context, "Password is incorrect");
            }
            else
            {
                flagSqlDataError = 1;
                ShowToast.showToast(context,"Login is incorrect");
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
}
