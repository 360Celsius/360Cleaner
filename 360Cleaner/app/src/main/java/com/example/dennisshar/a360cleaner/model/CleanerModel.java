package com.example.dennisshar.a360cleaner.model;

import android.content.Context;
import android.content.pm.PackageInfo;

import com.example.dennisshar.a360cleaner.datamodels.DeviceMemoryStatusModel;

import java.io.BufferedReader;
import java.io.FileReader;
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

    public DeviceMemoryStatusModel getDeviceMemoryStatus(){
        DeviceMemoryStatusModel deviceMemoryStatusModel = new DeviceMemoryStatusModel();
        BufferedReader reader = null;
        StringBuilder logBuilder = null;
        //memory global info
        try {
            reader = new BufferedReader(new FileReader("/proc/meminfo"));
            logBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                logBuilder.append(line);
                String key = line.split(":")[0];
                String value = line.split(":")[1].trim();

                switch (key){
                    case "MemTotal":
                        deviceMemoryStatusModel.setmMemTotal(value);
                        break;
                    case "MemFree":
                        deviceMemoryStatusModel.setmMemFree(value);
                        break;
                    case "Buffers":
                        deviceMemoryStatusModel.setmBuffers(value);
                        break;
                    case "Cached":
                        deviceMemoryStatusModel.setmCached(value);
                        break;
                    case "SwapCached":
                        deviceMemoryStatusModel.setmSwapCached(value);
                        break;
                    case "Active":
                        deviceMemoryStatusModel.setmActive(value);
                        break;
                    case "Inactive":
                        deviceMemoryStatusModel.setmInactive(value);
                        break;
                    case "Active(anon)":
                        deviceMemoryStatusModel.setmActiveAnon(value);
                        break;
                    case "Inactive(anon)":
                        deviceMemoryStatusModel.setmInactiveAnon(value);
                        break;
                    case "Active(file)":
                        deviceMemoryStatusModel.setmActiveFile(value);
                        break;
                    case "Inactive(file)":
                        deviceMemoryStatusModel.setmInactiveFile(value);
                        break;
                    case "Unevictable":
                        deviceMemoryStatusModel.setmUnevictable(value);
                        break;
                    case "Mlocked":
                        deviceMemoryStatusModel.setmMlocked(value);
                        break;
                    case "SwapTotal":
                        deviceMemoryStatusModel.setmSwapTotal(value);
                        break;
                    case "SwapFree":
                        deviceMemoryStatusModel.setmSwapFree(value);
                        break;
                    case "Dirty":
                        deviceMemoryStatusModel.setmDirty(value);
                        break;
                    case "Writeback":
                        deviceMemoryStatusModel.setmWriteback(value);
                        break;
                    case "AnonPages":
                        deviceMemoryStatusModel.setmAnonPages(value);
                        break;
                    case "Mapped":
                        deviceMemoryStatusModel.setmMapped(value);
                        break;
                    case "Slab":
                        deviceMemoryStatusModel.setmSlab(value);
                        break;
                    case "SReclaimable":
                        deviceMemoryStatusModel.setmSReclaimable(value);
                        break;
                    case "SUnreclaim":
                        deviceMemoryStatusModel.setmSUnreclaim(value);
                        break;
                    case "PageTables":
                        deviceMemoryStatusModel.setmPageTables(value);
                        break;
                    case "NFS_Unstable":
                        deviceMemoryStatusModel.setmNFS_Unstable(value);
                        break;
                    case "Bounce":
                        deviceMemoryStatusModel.setmBounce(value);
                        break;
                    case "WritebackTmp":
                        deviceMemoryStatusModel.setmWritebackTmp(value);
                        break;
                    case "CommitLimit":
                        deviceMemoryStatusModel.setmCommitLimit(value);
                        break;
                    case "Committed_AS":
                        deviceMemoryStatusModel.setmCommitted_AS(value);
                        break;
                    case "VmallocTotal":
                        deviceMemoryStatusModel.setmVmallocTotal(value);
                        break;
                    case "VmallocUsed":
                        deviceMemoryStatusModel.setmVmallocUsed(value);
                        break;
                    case "VmallocChunk":
                        deviceMemoryStatusModel.setmVmallocChunk(value);
                        break;
                }
            }
            deviceMemoryStatusModel.setmDateOfMeasurment(String.valueOf(getCurrentTimeStamp()));

        }catch (Exception e){
            e.printStackTrace();
        }


        return deviceMemoryStatusModel;
    }

    private long getCurrentTimeStamp(){
        long time= System.currentTimeMillis();
        return time;
    }
}
