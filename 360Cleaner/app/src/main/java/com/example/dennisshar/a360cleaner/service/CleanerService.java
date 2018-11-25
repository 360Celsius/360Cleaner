package com.example.dennisshar.a360cleaner.service;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

public class CleanerService extends IntentService {

    public static final String GET_DATA = "GET_DATA";

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
    protected void onHandleIntent(@Nullable Intent intent) {
        if( intent.getStringExtra(CleanerServiceCalls.DATA_TYPE_KEY).equalsIgnoreCase(CleanerServiceCalls.START_MAIN_ACTIVITY) ){
            Intent broadcastIntent = new Intent();
            broadcastIntent.setAction(GET_DATA);
            broadcastIntent.putExtra(CleanerServiceCalls.DATA_TYPE_KEY, CleanerServiceCalls.START_MAIN_ACTIVITY);
            sendBroadcast(broadcastIntent);
        }
    }

}
