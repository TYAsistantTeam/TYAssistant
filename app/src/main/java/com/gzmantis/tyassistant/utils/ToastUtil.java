package com.gzmantis.tyassistant.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by LONG on 2018/3/5.
 */

public class ToastUtil {
    public static void showToast(Context paramContext, int paramInt) {
        if (paramContext == null) {
            return;
        }

        Toast.makeText(paramContext, paramInt, Toast.LENGTH_SHORT).show();
    }

    public static void showToast(Context paramContext, String paramString) {
        if (paramContext == null) {
            return;
        }

        Toast.makeText(paramContext, paramString, Toast.LENGTH_SHORT).show();
    }

    public static void toast(Context paramContext, int paramInt) {
        Toast.makeText(paramContext, paramInt, Toast.LENGTH_SHORT).show();
    }

    public static void toast(Context paramContext, String paramString) {
        Toast.makeText(paramContext, paramString, Toast.LENGTH_SHORT).show();
    }
}
