package com.gzmantis.tyassistant.utils;

import android.util.Log;

public class LogUtil
{
  public static String Tag = "caipia-debug";
  public static boolean debug = true;
  
  public static void e(String paramString)
  {
    if (debug) {
      Log.e(Tag, paramString + "");
    }
  }
  
  public static void e(String paramString1, String paramString2)
  {
    if (debug) {
      Log.e(paramString1, paramString2 + "");
    }
  }
  
  public static void v(String paramString)
  {
    if (debug) {
      Log.v(Tag, paramString + "");
    }
  }
  
  public static void v(String paramString1, String paramString2)
  {
    if (debug) {
      Log.v(paramString1, paramString2 + "");
    }
  }
}



/* Location:           C:\Users\Joesea Lea\Desktop\ty_app_dex2jar.jar

 * Qualified Name:     com.tt.caipiao.pkg.utils.LogUtil

 * JD-Core Version:    0.7.0.1

 */