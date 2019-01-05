package com.example.hp.delhitourism.offlineDatabase;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class openDatabaseHelper extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "tourist.db";
    private static final int DATABASE_VERSION = 1;

    public openDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
}
