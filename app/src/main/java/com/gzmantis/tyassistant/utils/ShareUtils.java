
package com.gzmantis.tyassistant.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by LONG on 2018/3/5.
 */

public class ShareUtils {

    private static final String FILE_NAME = "share_caipiao";

    public static void clear(Context paramContext) {
        paramContext.getSharedPreferences("share_caipiao", 0).edit().clear().commit();
    }

    public static Object getParam(Context paramContext, String paramString, Object paramObject) {
        String str = paramObject.getClass().getSimpleName();
        SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("share_caipiao", Context.MODE_PRIVATE);
        Object localObject = null;
        if ("String".equals(str)) {
            localObject = localSharedPreferences.getString(paramString, (String) paramObject);
        } else if ("Integer".equals(str)) {
            localObject = Integer.valueOf(localSharedPreferences.getInt(paramString, ((Integer) paramObject).intValue()));
        } else if ("Boolean".equals(str)) {
            localObject = Boolean.valueOf(localSharedPreferences.getBoolean(paramString, ((Boolean) paramObject).booleanValue()));
        } else if ("Float".equals(str)) {
            localObject = Float.valueOf(localSharedPreferences.getFloat(paramString, ((Float) paramObject).floatValue()));
        } else if ("Long".equals(str)) {
            localObject = Long.valueOf(localSharedPreferences.getLong(paramString, ((Long) paramObject).longValue()));
        }

        return localObject;
    }

    public static String setParam(Context paramContext, String paramString, Object paramObject) {
        String str = paramObject.getClass().getSimpleName();
        SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("share_caipiao", Context.MODE_PRIVATE).edit();
        if ("String".equals(str)) {
            localEditor.putString(paramString, (String) paramObject);
        } else if ("Integer".equals(str)) {
            localEditor.putInt(paramString, ((Integer) paramObject).intValue());
        } else if ("Boolean".equals(str)) {
            localEditor.putBoolean(paramString, ((Boolean) paramObject).booleanValue());
        } else if ("Float".equals(str)) {
            localEditor.putFloat(paramString, ((Float) paramObject).floatValue());
        } else if ("Long".equals(str)) {
            localEditor.putLong(paramString, ((Long) paramObject).longValue());
        }

        localEditor.commit();
        return str;
    }

    public static boolean setParams(Context paramContext, String paramString, Object paramObject) {
        String str = paramObject.getClass().getSimpleName();
        SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("share_caipiao", Context.MODE_PRIVATE).edit();
        if ("String".equals(str)) {
            localEditor.putString(paramString, (String) paramObject);
        } else if ("Integer".equals(str)) {
            localEditor.putInt(paramString, ((Integer) paramObject).intValue());
        } else if ("Boolean".equals(str)) {
            localEditor.putBoolean(paramString, ((Boolean) paramObject).booleanValue());
        } else if ("Float".equals(str)) {
            localEditor.putFloat(paramString, ((Float) paramObject).floatValue());
        } else if ("Long".equals(str)) {
            localEditor.putLong(paramString, ((Long) paramObject).longValue());
        }

        return localEditor.commit();
    }
}
