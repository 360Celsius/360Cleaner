package com.example.dennisshar.a360cleaner;

import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.example.dennisshar.a360cleaner.dbhelper.DatabaseHelper;
import com.example.dennisshar.a360cleaner.interfaces.DataBaseHelperInterface;
import com.example.dennisshar.a360cleaner.interfaces.ModelIngterface;
import com.example.dennisshar.a360cleaner.model.CleanerModel;
import com.example.dennisshar.a360cleaner.reciver.CleanerBroadCastReciver;
import com.example.dennisshar.a360cleaner.service.CleanerService;

public class BaseActivity extends AppCompatActivity implements ModelIngterface,DataBaseHelperInterface{

    private static IntentFilter filter = null;
    private static CleanerBroadCastReciver receiver = null;

    public static CleanerModel cleanerModel = null;
    public static DatabaseHelper helper = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Window window = getWindow();

        // clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        // add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        // finally change the color
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.endColor));
        }

        cleanerModel = CleanerModel.getInstance(getApplicationContext());
        helper = DatabaseHelper.getInstance(getApplicationContext());
    }

    @Override
    protected void onResume() {
        super.onResume();
        filter = new IntentFilter(CleanerService.GET_DATA);
        receiver = new CleanerBroadCastReciver();
        registerReceiver(receiver, filter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
    }

    @Override
    public CleanerModel getCleanerModel() {
        return cleanerModel;
    }

    @Override
    public DatabaseHelper getDataBasehelper() {
        return helper;
    }
}
