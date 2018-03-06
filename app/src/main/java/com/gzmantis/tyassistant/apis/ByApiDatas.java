package com.gzmantis.tyassistant.apis;

import android.content.Context;

/**
 * Created by LONG on 2018/3/5.
 */

public class ByApiDatas {

    private Context context;

    public ByApiDatas(Context paramContext) {
        this.context = paramContext;
        Config.HOST = new UserInfo(paramContext).getWebstate();
    }
}
