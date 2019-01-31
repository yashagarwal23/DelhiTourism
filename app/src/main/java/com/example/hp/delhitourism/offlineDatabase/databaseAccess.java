package com.example.hp.delhitourism.offlineDatabase;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.hp.delhitourism.TouristPlace;

import java.util.ArrayList;

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

    public int getCount()
    {
        int ans=1;
        c=db.rawQuery("select count(*) from touristPlace",null);
        while(c.moveToNext())
        {
            String s=c.getString(0);
            ans=Integer.parseInt(s);
        }
        return ans;
    }

    public ArrayList<TouristPlace> getTouristPlacesByCategory(String category) {
        Cursor cursor = db.rawQuery("select * from touristPlace where category = '"+category+"'",new String[]{});
        ArrayList<TouristPlace> touristPlaces = new ArrayList<>();
        while (cursor.moveToNext()) {
            TouristPlace touristPlace = new TouristPlace();
            touristPlace.setName(cursor.getString(0));
            touristPlace.setId(cursor.getString(1));
            touristPlace.setImageLocation(cursor.getString(2));
            touristPlace.setStarRating(Double.parseDouble(cursor.getString(3)));
            //touristPlace.setStarRating(4);
            touristPlace.setCategory(cursor.getString(4));
            touristPlace.setLocation(cursor.getString(5));
            touristPlace.setDescription(cursor.getString(6));
            touristPlace.setAbout(cursor.getString(7));
            touristPlace.setLongitude(Double.parseDouble(cursor.getString(8)));
            touristPlace.setLatitude(Double.parseDouble(cursor.getString(9)));

            touristPlaces.add(touristPlace);
        }
        return touristPlaces;
    }

    public TouristPlace getPlace(int i)
    {
        c=db.rawQuery("select * from touristPlace where id = '"+i+"'",new String[]{});
        TouristPlace temp =new TouristPlace();
        while(c.moveToNext())
        {
            temp.setName(c.getString(0));
            temp.setId(c.getString(1));
            temp.setImageLocation(c.getString(2));
            temp.setStarRating(Double.parseDouble(c.getString(3)));
            temp.setCategory(c.getString(4));
            temp.setLocation(c.getString(5));
            temp.setDescription(c.getString(6));
            temp.setAbout(c.getString(7));
            temp.setLongitude(Double.parseDouble(c.getString(8)));
            temp.setLatitude(Double.parseDouble(c.getString(9)));
        }
        return temp;
    }
}
