package com.example.fitnessapp;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// The DBHelper class is used to setup and get the database ready to be used for the app.
public class DBHelper extends SQLiteOpenHelper {

    private static String DB_PATH = "/data/data/com.example.fitnessapp/databases/";
    private static String DB_NAME = "Final_ProjDB";
    private SQLiteDatabase fitnessDB;
    private Context DBHelperContext;

    // Constructor for DBHelper
    public DBHelper(Context context) {
        super(context, DB_NAME, null, 1);
        this.DBHelperContext = context;
    }

    // Checks whether the database exists or not
    private boolean checkDataBase() {

        SQLiteDatabase dbCheck = null;

        try {
            String path = DB_PATH + DB_NAME;
            dbCheck = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READONLY);

        } catch (SQLiteException e) {

        }
        if (dbCheck != null) {

            dbCheck.close();
        }
        return dbCheck != null ? true : false;
    }

    // Checks whether the database exists and creates a database if it does exist
    public void createDataBase() throws IOException {

        boolean dbPresent = checkDataBase();

        if (dbPresent) {

        } else {

            this.getReadableDatabase();

            try {

                copyDataBase();

            } catch (IOException e) {

                throw new Error("Error copying database");

            }
        }

    }

    // Opens the database
    public void openDataBase() throws SQLException {

        String path = DB_PATH + DB_NAME;
        fitnessDB = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);

    }

    // Closes the database
    @Override
    public synchronized void close() {

        if (fitnessDB != null)
            fitnessDB.close();

        super.close();

    }

    // Copies the existing database onto an empty database
    private void copyDataBase() throws IOException {

        InputStream iStream = DBHelperContext.getAssets().open(DB_NAME + ".db");

        String output = DB_PATH + DB_NAME;

        OutputStream oStream = new FileOutputStream(output);

        byte[] buffer = new byte[1024];
        int length;
        while ((length = iStream.read(buffer)) > 0) {
            oStream.write(buffer, 0, length);
        }

        oStream.flush();
        oStream.close();
        iStream.close();

    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

