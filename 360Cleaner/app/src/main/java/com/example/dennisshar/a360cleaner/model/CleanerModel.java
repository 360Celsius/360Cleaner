package com.example.dennisshar.a360cleaner.model;

import android.content.Context;
import android.content.pm.PackageInfo;

import java.util.List;

public class CleanerModel {

    private Context context;
    private static CleanerModel sInstance;

    public static synchronized CleanerModel getInstance(Context context) {

        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (sInstance == null) {
            sInstance = new CleanerModel(context.getApplicationContext());
        }
        return sInstance;
    }

    /**
     * Constructor should be private to prevent direct instantiation.
     * make call to static method "getInstance()" instead.
     */
    private CleanerModel(Context context) {
        this.context = context;
    }

    public List<PackageInfo> getInstalledApps() {
        //List<AppList> res = new ArrayList<AppList>();
        List<PackageInfo> packs = context.getPackageManager().getInstalledPackages(0);
        for (int i = 0; i < packs.size(); i++) {
            PackageInfo p = packs.get(i);
            //if ((isSystemPackage(p) == false))
            {
                String appName = p.applicationInfo.loadLabel(context.getPackageManager()).toString();
                // Drawable icon = p.applicationInfo.loadIcon(context.getPackageManager());
                // res.add(new AppList(appName, icon));
            }
        }
        return packs;
    }
}
