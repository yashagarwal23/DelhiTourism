package com.example.hp.delhitourism.offlineDatabase;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class databaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static databaseAccess instance;
    Cursor c=null;

    private databaseAccess(Context context)
    {
        this.openHelper=new openDatabaseHelper(context);
    }

    // to return the single instance
    public  static databaseAccess getInstance (Context context)
    {
        if(instance==null)
        {
            instance=new databaseAccess(context);
        }
        return  instance;
    }

    public void open()
    {
        this.db=openHelper.getWritableDatabase();
    }

    public void close(){
        if(db!=null)
        {
            this.db.close();
        }
    }

    /*public int getCount()
    {
        c=db.rawQuery("select count(*) from touristPlace",new String[][]);

    }*/
}
