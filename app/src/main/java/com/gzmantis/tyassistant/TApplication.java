package com.gzmantis.tyassistant;

import android.app.Application;

import com.gzmantis.tyassistant.https.ApiDatas;

/**
 * Created by LONG on 2018/3/5.
 */

public class TApplication extends Application {

    private static TApplication sInstance;
    private ApiDatas apiDatas;

    public static TApplication getInstance() {
        return sInstance;
    }

    public ApiDatas getEngine() {
        return this.apiDatas;
    }

    public void onCreate() {
        super.onCreate();
        sInstance = this;
//        this.apiDatas = ((ApiDatas) new Retrofit.Builder().baseUrl("http://7xk9dj.com1.z0.glb.clouddn.com/").addConverterFactory(GsonConverterFactory.create()).build().create(ApiDatas.class));
//        CrashReport.initCrashReport(getApplicationContext(), "900036961", true);
//        CrashReport.closeCrashReport();
    }

}
