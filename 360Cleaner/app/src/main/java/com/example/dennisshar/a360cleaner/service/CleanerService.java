package com.example.dennisshar.a360cleaner.service;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

import com.example.dennisshar.a360cleaner.BaseActivity;
import com.example.dennisshar.a360cleaner.dbhelper.DatabaseHelper;
import com.example.dennisshar.a360cleaner.model.CleanerModel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CleanerService extends IntentService {

    public static final String GET_DATA = "GET_DATA";
    private static CleanerModel cleanerModel = null;
    private static DatabaseHelper helper = null;

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public CleanerService(String name) {
        super(name);
    }

    public CleanerService() {
        super("CleanerService");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        cleanerModel = BaseActivity.cleanerModel;
        helper = BaseActivity.helper;
    }




    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        if( intent.getStringExtra(CleanerServiceCalls.DATA_TYPE_KEY).equalsIgnoreCase(CleanerServiceCalls.START_MAIN_ACTIVITY) ){

            cleanerModel.getInstalledApps();

            cleanerModel.getDeviceMemoryStatus();

            cleanerModel.getDeviceCPUstatus();


            Intent broadcastIntent = new Intent();
            broadcastIntent.setAction(GET_DATA);
            broadcastIntent.putExtra(CleanerServiceCalls.DATA_TYPE_KEY, CleanerServiceCalls.START_MAIN_ACTIVITY);
            sendBroadcast(broadcastIntent);
        }
    }

}
