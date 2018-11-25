package com.example.dennisshar.a360cleaner;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.dennisshar.a360cleaner.service.CleanerService;
import com.example.dennisshar.a360cleaner.service.CleanerServiceCalls;

public class SplashActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                Intent msgIntent = new Intent(getApplicationContext(), CleanerService.class);
                msgIntent.putExtra(CleanerServiceCalls.DATA_TYPE_KEY, CleanerServiceCalls.START_MAIN_ACTIVITY);
                startService(msgIntent);

            }
        }, 3000);   //3 seconds


    }
}
