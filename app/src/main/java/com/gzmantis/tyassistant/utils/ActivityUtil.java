package com.gzmantis.tyassistant.utils;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

import java.util.List;

/**
 * Created by LONG on 2018/3/6.
 */

public class ActivityUtil {
    private Context context;

    public ActivityUtil(Context paramContext) {
        this.context = paramContext;
    }

    public boolean checkApplication(String paramString) {
        boolean flag = false;
        if (!StringUtil.isEmpty(paramString)) {
            try {
                ApplicationInfo info = this.context.getPackageManager()
                        .getApplicationInfo(paramString, PackageManager.GET_UNINSTALLED_PACKAGES);
                flag = (info != null);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                flag = false;
            }
        }

        return flag;
    }

    public boolean checkApplication2(String paramString) {
        boolean flag = false;
        Intent localIntent = new Intent();
        localIntent.setClassName(this.context, paramString);
        if (null != this.context.getPackageManager().resolveActivity(localIntent, 0)) {
            if (null != localIntent.resolveActivity(this.context.getPackageManager())
                    && this.context.getPackageManager().queryIntentActivities(localIntent, 0).size() > 0){
                flag = true;
            }
        }

        return flag;
    }

    public boolean isExsitMianActivity(Class cls) {
        Intent intent = new Intent(this.context, cls);
        ComponentName cmpName = intent.resolveActivity(this.context.getPackageManager());
        boolean flag = false;
        if (cmpName != null) {
            ActivityManager am = (ActivityManager) context
                    .getSystemService(Context.ACTIVITY_SERVICE);
            List<ActivityManager.RunningTaskInfo> taskInfoList = am.getRunningTasks(10);
            for (ActivityManager.RunningTaskInfo taskInfo : taskInfoList) {
                if (taskInfo.baseActivity.equals(cmpName)) {
                    flag = true;
                    break;
                }
            }
        }

        return flag;
    }

}
