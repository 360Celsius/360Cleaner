package com.example.dennisshar.a360cleaner.dbhelper;

import android.net.Uri;
import android.provider.BaseColumns;

import java.util.Locale;

public class DataBaseHelperContract {

    public static final String packageName = "com.example.dennisshar.a360cleaner";
    public static final String AUTHORITY = packageName + ".provider";
    public static final String CONTENT_BASE = "content://"+AUTHORITY+"/%s";


    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private DataBaseHelperContract() {
    }

    ////////////////////////// Packdges Data Notifications //////////////////////////

    public static class InstalledPackdges implements BaseColumns {

        public static final String URI_SUFFIX = "packadges_data";
        public static final Uri CONTENT_URI = Uri.parse(String.format(Locale.US,CONTENT_BASE, URI_SUFFIX));

        public static final String TABLE_NAME = "packadges_data";

        public static final String DATABASE_TABLE_PACKAGE_COLUMN = "package_name";




        public static final String SQL_CREATE_INSTALLED_PACKADGES_TABLE =
                "CREATE TABLE " + InstalledPackdges.TABLE_NAME + " (" +
                        InstalledPackdges._ID + " INTEGER PRIMARY KEY," +
                        InstalledPackdges.DATABASE_TABLE_PACKAGE_COLUMN + " TEXT)";


        public static final String SQL_DELETE_INSTALLED_PACKADGES_TABLE =
                "DROP TABLE IF EXISTS " + InstalledPackdges.TABLE_NAME;

        public static final String SQL_SELECT_INSTALLED_PACKADGES_TABLE =
                "SELECT  * FROM " + InstalledPackdges.TABLE_NAME + " WHERE "+ InstalledPackdges._ID  + " ORDER BY " + InstalledPackdges._ID + " DESC" ;


    }


}
