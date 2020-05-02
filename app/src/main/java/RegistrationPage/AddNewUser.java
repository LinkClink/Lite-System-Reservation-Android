package RegistrationPage;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import SQL.sqlDataBaseConnect;
import logic.ShowToast;

public class AddNewUser extends RegistrationPageActivity {

    private Random randomNumber = new Random();
    private Date currentTime = new Date();

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yy"); /* Year day mouth */
    private SimpleDateFormat simpleDateFormat0 = new SimpleDateFormat("MM-dd-yyyy"); /* Year day mouth */

    private String generatedUserId = "";
    private String[] dataNumberAfterSplit = new String[2];
    private String dataNumberToSplit = null;
    private String table_name = "UserData";
    private String dataCurrentTime = null;

    private sqlDataBaseConnect dataBaseHelper;
    private SQLiteDatabase database;

    private int dataNumbersSum = 0;

    private Context context;

    /* Initialisation functions (m) */
    protected void RegisterNewUser(Context context) {
        this.context = context;
        /* Connect to Db */
        ConnectToDataBase();
        /* Generate user id function */
        GenerateUserId();
        /* Add new user to db */
        AddNewUserToDataBase();
    }

    /* Generate user id */
    private void GenerateUserId() {
        /* Generated first random numbers (2) */
        generatedUserId += String.valueOf(randomNumber.nextInt(90) + 10); /* 10-99 */
        dataNumberToSplit = simpleDateFormat.format(currentTime);
        dataNumberAfterSplit = dataNumberToSplit.split("-", 3);
        for (int i = 0; i < dataNumberAfterSplit.length; i++) {
            generatedUserId += (dataNumberAfterSplit[i]);
            dataNumbersSum += Integer.parseInt(String.valueOf(dataNumberAfterSplit[i].charAt(0)));
            if (dataNumbersSum <= 9) generatedUserId += "0";
        }
        generatedUserId += dataNumbersSum;
    }

    private void DataTimeGenerated() {
        dataCurrentTime = simpleDateFormat0.format(currentTime);
    }

    private void AddNewUserToDataBase() {
        DataTimeGenerated();
        database.execSQL(" INSERT INTO " + table_name + "( user_id, login, password, data_register ) " +
                "VALUES (" + generatedUserId + ", '" + dataLogin + "','" + dataPassword0 + "','" + dataCurrentTime + "');");
        ShowToast.showToast(context, "Success registration"); /* beta */
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
            database = dataBaseHelper.getWritableDatabase();
        } catch (SQLException mSQLException) {
            ShowToast.showToast(getApplicationContext(), "Unable to write database: error 02");
        }
    }
}
