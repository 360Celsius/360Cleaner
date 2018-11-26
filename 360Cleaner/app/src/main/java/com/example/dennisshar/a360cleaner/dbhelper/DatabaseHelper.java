package com.example.dennisshar.a360cleaner.dbhelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.dennisshar.a360cleaner.datamodels.InstalledPackdgesDataModel;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Cleaner.db";
    private static DatabaseHelper sInstance;
    private Context context;


    public static synchronized DatabaseHelper getInstance(Context context) {

        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (sInstance == null) {
            sInstance = new DatabaseHelper(context.getApplicationContext());
        }
        return sInstance;
    }

    /**
     * Constructor should be private to prevent direct instantiation.
     * make call to static method "getInstance()" instead.
     */
    private DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DataBaseHelperContract.InstalledPackdges.SQL_CREATE_INSTALLED_PACKADGES_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            db.execSQL(DataBaseHelperContract.InstalledPackdges.SQL_CREATE_INSTALLED_PACKADGES_TABLE);

        }
    }

    ////////////////////////// External Push Notifications //////////////////////////

    public void bulkExternalPushNotification(InstalledPackdgesDataModel installedPackdgesDataModel){
        try {
            //deletexternalPushNotification();
            ContentValues[] ipInfoObjectArr = new ContentValues[1];
            ;
            for (int i = 0; i < ipInfoObjectArr.length; i++) {
                ContentValues values = new ContentValues();
                values.put(DataBaseHelperContract.InstalledPackdges.DATABASE_TABLE_PACKAGE_COLUMN, installedPackdgesDataModel.getPackadgeName());

                ipInfoObjectArr[i] = values;
            }
            context.getContentResolver().bulkInsert(DataBaseHelperContract.InstalledPackdges.CONTENT_URI, ipInfoObjectArr);
        }catch (NullPointerException e){
            e.printStackTrace();
        }
    }


    private void deletexternalPushNotification(){
        SQLiteDatabase db = getWritableDatabase();
        db.beginTransaction();
        try {
            db.delete(DataBaseHelperContract.InstalledPackdges.TABLE_NAME, null, null);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }
    }


}
