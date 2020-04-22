package RegistrationPage;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import SQL.sqlDataBaseConnect;
import logic.ShowToast;

public class AddNewUser extends RegistrationPageActivity
{
    private String generatedUserId = "";

    private Random randomNumber = new Random();

    private Date currentTime = new Date();
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yy"); /* Year day mouth */

    ShowToast showToast = new ShowToast();

    private String[] dataNumberAfterSplit = new String[2];
    private String dataNumberToSplit = null;

    private sqlDataBaseConnect dataBaseHelper;
    private SQLiteDatabase database;

    private int dataNumbersSum = 0;

    private Context context;

    protected void RegisterNewUser(Context context)
    {
        this.context = context;
        /* Connect to Db */
        ConnectToDataBase();
        /* Generate user id function */
        GenerateUserId();
    }
    /* Generate user id */
    protected void GenerateUserId()
    {
        /* Generated first random numbers (2) */
        generatedUserId  += String.valueOf(randomNumber.nextInt(90)+10); /* 10-99 */

        dataNumberToSplit = simpleDateFormat.format(currentTime);
        dataNumberAfterSplit= dataNumberToSplit.split("-",3);

        for(int i = 0; i < dataNumberAfterSplit.length; i++)
        {
            generatedUserId += (dataNumberAfterSplit[i]);
            dataNumbersSum += Integer.parseInt(String.valueOf(dataNumberAfterSplit[i].charAt(0)));
            if(dataNumbersSum <=9) generatedUserId += "0";
        }
        generatedUserId += dataNumbersSum;

        ShowToast.showToast(context,String.valueOf(generatedUserId));
    }

    private void AddNewUserToDataBase()
    {
        Cursor cursorDataLogin;
        //cursorDataLogin = database.rawQuery();
        //cursorDataLogin.moveToFirst();
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
        { database = dataBaseHelper.getWritableDatabase(); }
        catch (SQLException mSQLException)
        { ShowToast.showToast(getApplicationContext(),"Unable to write database: error 02"); }
    }
}
