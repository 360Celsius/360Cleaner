package com.example.dennisshar.a360cleaner;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
//                Intent msgIntent = new Intent(getApplicationContext(), MainActivity.class);
//                msgIntent.putExtra(PushiRecappGlobalServiceCalls.DATA_TYPE_KEY, PushiRecappGlobalServiceCalls.LOAD_MAIN_ACTIVITY);
//                startService(msgIntent);


                Intent myIntent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(myIntent);


            }
        }, 3000);   //3 seconds


    }
}
