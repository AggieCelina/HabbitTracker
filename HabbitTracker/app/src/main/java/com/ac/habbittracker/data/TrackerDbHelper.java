package com.ac.habbittracker.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by marka1 on 7/21/17.
 */

public class TrackerDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "habbits.db";
    private static final int DATABASE_VERSION = 1;

    public TrackerDbHelper(Context contex){super(contex, DATABASE_NAME, null, DATABASE_VERSION);}
    @Override
    public void onCreate(SQLiteDatabase db) {

        String SQL_CREATE_RUNS_TABLE = "CREATE TABLE " + TrackerContract.RunEntry.TABLE_NAME + " ("
                + TrackerContract.RunEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TrackerContract.RunEntry.COLUMN_DISTANCE + " TEXT NOT NULL DEFAULT 0, "
                + TrackerContract.RunEntry.COLUMN_UNIT + " TEXT NOT NULL, "
                + TrackerContract.RunEntry.COLUMN_PACE + " TEXT NOT NULL DEFAULT 0);";

        db.execSQL(SQL_CREATE_RUNS_TABLE);


        String SQL_CREATE_FITNESS_TABLE = "CREATE TABLE " + TrackerContract.FitnessEntry.TABLE_NAME + " ("
                + TrackerContract.FitnessEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TrackerContract.FitnessEntry.LENGTH + " TEXT NOT NULL DEFAULT 0, "
                + TrackerContract.FitnessEntry.TRAININIG_TYPE + " TEXT);";
        db.execSQL(SQL_CREATE_FITNESS_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
