package com.example.hp.delhitourism.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.wifi.p2p.WifiP2pManager;

import com.example.hp.delhitourism.data.placeContract.placeEntry;

public class placeDBHelper extends SQLiteOpenHelper {
    public static final String LOG_TAG = placeDBHelper.class.getSimpleName();

    /** Name of the database file */
    private static final String DATABASE_NAME = "TouristPlace.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.
     */
    private static final int DATABASE_VERSION = 1;

    /**
     * Constructs a new instance of {@link placeDBHelper}.
     *
     * @param context of the app
     */
    public placeDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * This is called when the database is created for the first time.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_PETS_TABLE =  "CREATE TABLE " + placeEntry.TABLE_NAME + " ("
                + placeEntry._ID + " INTEGER , "
                + placeEntry.COLUMN_PLACE_NAME + " TEXT, "
                + placeEntry.COLUMN_PLACE_CATEGORY + " TEXT , "
                + placeEntry.COLUMN_PLACE_LOCATION + " TEXT , "
                + placeEntry.COLUMN_PLACE_ABOUT + " TEXT, "
                + placeEntry.COLUMN_PLACE_DESCRIPTION + " TEXT, "
                + placeEntry.COLUMN_PLACE_STAR_RATING + " INTEGER, "
                + placeEntry.COLUMN_PLACE_IMAGE_LOCATION + " TEXT, "
                + placeEntry.COLUMN_PLACE_IMAGE_URL + " TEXT); ";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_PETS_TABLE);
    }

    /**
     * This is called when the database needs to be upgraded.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // The database is still at version 1, so there's nothing to do be done here.
    }
}
