package com.example.hp.delhitourism.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

public final class placeContract {
    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    private placeContract() {}
    public static final String CONTENT_AUTHORITY = "com.example.hp.delhitourism";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    /**
     * Possible path (appended to base content URI for possible URI's)
     * For instance, content://com.example.android.pets/pets/ is a valid path for
     * looking at pet data. content://com.example.android.pets/staff/ will fail,
     * as the ContentProvider hasn't been given any information on what to do with "staff".
     */
    public static final String PATH_PLACE = "TouristPlace";

    /**
     * Inner class that defines constant values for the pets database table.
     * Each entry in the table represents a single pet.
     */
    public static final class placeEntry implements BaseColumns {

        /**
         * The content URI to access the pet data in the provider
         */
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_PLACE);

        /**
         * The MIME type of the {@link #CONTENT_URI} for a list of pets.
         */
        public static final String CONTENT_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PLACE;

        /**
         * The MIME type of the {@link #CONTENT_URI} for a single pet.
         */
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PLACE;


        public final static String TABLE_NAME = "TouristPlace";
        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_PLACE_NAME = "name";
        //public final static String COLUMN_PLACE_ID = "id";
        public final static String COLUMN_PLACE_CATEGORY = "category";
        public final static String COLUMN_PLACE_LOCATION = "location";
        public final static String COLUMN_PLACE_ABOUT = "about";
        public final static String COLUMN_PLACE_DESCRIPTION = "description";
        public final static String COLUMN_PLACE_STAR_RATING = "starRating";
        public final static String COLUMN_PLACE_IMAGE_LOCATION = "imageLocation";
        public final static String COLUMN_PLACE_IMAGE_URL = "imageUrl";


    }
}