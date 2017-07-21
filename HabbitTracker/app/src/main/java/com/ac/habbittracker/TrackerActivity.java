package com.ac.habbittracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ac.habbittracker.data.TrackerContract;
import com.ac.habbittracker.data.TrackerDbHelper;

public class TrackerActivity extends AppCompatActivity {

    private TrackerDbHelper trackerDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void insertIntoRuns(){
        SQLiteDatabase db = trackerDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TrackerContract.RunEntry.COLUMN_DISTANCE, "10");
        values.put(TrackerContract.RunEntry.COLUMN_UNIT, TrackerContract.RunEntry.UNIT_KM);
        values.put(TrackerContract.RunEntry.COLUMN_PACE, "7.4");
        long newRowId = db.insert(TrackerContract.RunEntry.TABLE_NAME, null, values);
    }

    private void insertIntoFitness(){
        SQLiteDatabase db = trackerDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TrackerContract.FitnessEntry.LENGTH, "30");
        values.put(TrackerContract.FitnessEntry.TRAININIG_TYPE, TrackerContract.FitnessEntry.TRAINING_CLIMBING);
        long newRowId = db.insert(TrackerContract.FitnessEntry.TABLE_NAME, null, values);
    }

    private void displayDatabaseInfo() {
        SQLiteDatabase db = trackerDbHelper.getReadableDatabase();
        String[] projection_runs = {
                TrackerContract.RunEntry._ID,
                TrackerContract.RunEntry.COLUMN_DISTANCE,
                TrackerContract.RunEntry.COLUMN_UNIT,
                TrackerContract.RunEntry.COLUMN_PACE};

        String[] projection_fitness = {
                TrackerContract.FitnessEntry._ID,
                TrackerContract.FitnessEntry.LENGTH,
                TrackerContract.FitnessEntry.TRAININIG_TYPE};

        Cursor cursor_runs = db.query(
                TrackerContract.RunEntry.TABLE_NAME,
                projection_runs,
                null,
                null,
                null,
                null,
                null);

        Cursor cursor_fitness = db.query(
                TrackerContract.FitnessEntry.TABLE_NAME,
                projection_fitness,
                null,
                null,
                null,
                null,
                null);

        try {
            int idColumnIndex = cursor_runs.getColumnIndex(TrackerContract.RunEntry._ID);
            int distanceColumnIndex = cursor_runs.getColumnIndex(TrackerContract.RunEntry.COLUMN_DISTANCE);
            int unitColumnIndex = cursor_runs.getColumnIndex(TrackerContract.RunEntry.COLUMN_UNIT);
            int paceColumnIndex = cursor_runs.getColumnIndex(TrackerContract.RunEntry.COLUMN_PACE);

            StringBuffer runsToDisplay = new StringBuffer();

            while (cursor_runs.moveToNext()) {

                int currentID = cursor_runs.getInt(idColumnIndex);
                String currentDistance = cursor_runs.getString(distanceColumnIndex);
                int currentUnit = cursor_runs.getInt(unitColumnIndex);
                String currentPace = cursor_runs.getString(paceColumnIndex);

                String runToDisplay = "\n" + currentID + " " + currentDistance + " " + currentUnit + " " + currentPace;

                runsToDisplay.append(runToDisplay);
            }
        } finally {
            cursor_runs.close();
        }

        try {
            int idColumnIndex2 = cursor_fitness.getColumnIndex(TrackerContract.FitnessEntry._ID);
            int typeColumnIndex = cursor_fitness.getColumnIndex(TrackerContract.FitnessEntry.TRAININIG_TYPE);
            int lengthColumnIndex = cursor_fitness.getColumnIndex(TrackerContract.FitnessEntry.LENGTH);

            StringBuffer fitToDisplay = new StringBuffer();


            while (cursor_runs.moveToNext()) {

                int currentID = cursor_runs.getInt(idColumnIndex2);
                int currentType = cursor_runs.getInt(typeColumnIndex);
                String currentLength = cursor_runs.getString(lengthColumnIndex);

                String fitnessToDisplay = "\n" + currentID + " " + currentType + " " + currentLength;

                fitToDisplay.append(fitnessToDisplay);
            }
        } finally {
            cursor_fitness.close();
        }
    }
}
