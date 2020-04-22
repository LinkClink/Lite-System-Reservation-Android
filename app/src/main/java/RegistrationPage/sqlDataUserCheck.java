package RegistrationPage;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.io.IOException;
import SQL.sqlDataBaseConnect;
import logic.ShowToast;

public class sqlDataUserCheck extends RegistrationPageActivity
{
    private int columnLength = 1;
    private int columnId;

    private String dbLoginData;

    private sqlDataBaseConnect dataBaseHelper;
    private SQLiteDatabase database;

    private Context context;

    private String tableName = "UserData";
    private Cursor cursorDataLogin;
    private Cursor cursorRowCount;

    /* Check login used */
    protected void DataBaseSqlDataCheck(Context context)
    {
        this.context = context;
        ConnectToDataBase();

        /* Get rows count */
        cursorRowCount = database.rawQuery(" SELECT * FROM " + tableName, null);
        columnLength = cursorRowCount.getColumnCount();

        /* Lg ck (login column - 2) */
        for( columnId = 0; columnId < columnLength; columnId++ )
        {
            cursorDataLogin = database.rawQuery(" SELECT * FROM " + tableName +" WHERE id= " + columnId , null);
            cursorDataLogin.moveToFirst();
            dbLoginData = cursorDataLogin.getString(2);
            if(dataLogin.equals(dbLoginData))
            {
                ShowToast.showToast(context,"Login already used");
                break;
            }
        }
        cursorDataLogin.close();
        cursorRowCount.close();
    }

    /* Local db connect */
    private void ConnectToDataBase()
    {
        // For DataBase connect
        dataBaseHelper = new sqlDataBaseConnect(context);
        try
        { dataBaseHelper.updateDataBase(); }
        catch (IOException mIOException)
        { ShowToast.showToast(getApplicationContext(),"Unable to update database: error 01"); }
        try
        { database = dataBaseHelper.getReadableDatabase(); }
        catch (SQLException mSQLException)
        { ShowToast.showToast(getApplicationContext(),"Unable to write database: error 02"); }
    }
}
