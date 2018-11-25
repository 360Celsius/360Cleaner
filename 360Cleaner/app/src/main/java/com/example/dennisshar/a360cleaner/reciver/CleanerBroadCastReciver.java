package com.example.dennisshar.a360cleaner.reciver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.dennisshar.a360cleaner.MainActivity;
import com.example.dennisshar.a360cleaner.service.CleanerServiceCalls;

public class CleanerBroadCastReciver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {


        switch (intent.getStringExtra(CleanerServiceCalls.DATA_TYPE_KEY)) {
            case CleanerServiceCalls.START_MAIN_ACTIVITY:
                try {
                    Intent intentone = new Intent(context, MainActivity.class);
                    intentone.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intentone);
                }catch (Exception e){
                    e.printStackTrace();
                }
                break;
        }
    }
}
