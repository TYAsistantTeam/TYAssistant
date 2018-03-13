package com.gzmantis.tyassistant.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.lang.reflect.Method;

public class NetUtil
{
  private static final String TAG = NetUtil.class.getSimpleName();
  
  public static ConnectivityManager getConnManager(Context paramContext)
  {
    return (ConnectivityManager)paramContext.getSystemService(Context.CONNECTIVITY_SERVICE);
//    return (ConnectivityManager)paramContext.getSystemService("connectivity");
  }
  
  public static NetType getConnectedType(Context paramContext)
  {
    NetworkInfo localNetworkInfo = getConnManager(paramContext).getActiveNetworkInfo();
    if (localNetworkInfo != null)
    {
      switch (localNetworkInfo.getType())
      {
        case 1:
          return NetType.Wifi;
        default:
          return NetType.Other;
      }
//      return NetType.Mobile;
    }
    return NetType.None;
  }
  
  public static boolean isAvailable(Context paramContext)
  {
    return (isWifiAvailable(paramContext)) || ((isMobileAvailable(paramContext)) && (isMobileEnabled(paramContext)));
  }
  
  public static boolean isConnected(Context paramContext)
  {
    NetworkInfo localNetworkInfo = getConnManager(paramContext).getActiveNetworkInfo();
    return (localNetworkInfo != null) && (localNetworkInfo.isConnected());
  }
  
  public static boolean isConnectedOrConnecting(Context paramContext)
  {
    NetworkInfo[] arrayOfNetworkInfo = getConnManager(paramContext).getAllNetworkInfo();
    boolean bool = false;
    int i;
    if (arrayOfNetworkInfo != null) {
      i = arrayOfNetworkInfo.length;
    } else {
      i = 0;
    }
    for (int j = 0;; j++)
    {
      bool = false;
      if (j < i)
      {
        if (arrayOfNetworkInfo[j].isConnectedOrConnecting()) {
          bool = true;
        }
      }
      else {
        return bool;
      }
    }
  }
  
  public static boolean isMobileAvailable(Context paramContext)
  {
    NetworkInfo[] arrayOfNetworkInfo = getConnManager(paramContext).getAllNetworkInfo();
    boolean bool = false;
    int i;
    if (arrayOfNetworkInfo != null) {
      i = arrayOfNetworkInfo.length;
    } else {
      i = 0;
    }
    for (int j = 0;; j++)
    {
      bool = false;
      if (j < i)
      {
        NetworkInfo localNetworkInfo = arrayOfNetworkInfo[j];
        if (localNetworkInfo.getType() == 0) {
          bool = localNetworkInfo.isAvailable();
        }
      }
      else
      {
        return bool;
      }
    }
  }
  
  public static boolean isMobileConnected(Context paramContext)
  {
    NetworkInfo localNetworkInfo = getConnManager(paramContext).getActiveNetworkInfo();
    return (localNetworkInfo != null) && (localNetworkInfo.getType() == 0) && (localNetworkInfo.isConnected());
  }
  
  public static boolean isMobileEnabled(Context paramContext)
  {
    try
    {
      Method localMethod = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);
      localMethod.setAccessible(true);
      boolean bool = ((Boolean)localMethod.invoke(getConnManager(paramContext), new Object[0])).booleanValue();
      return bool;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return true;
  }
  
  public static boolean isWifiAvailable(Context paramContext)
  {
    NetworkInfo[] arrayOfNetworkInfo = getConnManager(paramContext).getAllNetworkInfo();
    boolean bool = false;
    int i;
    if (arrayOfNetworkInfo != null) {
      i = arrayOfNetworkInfo.length;
    } else {
      i = 0;
    }
    for (int j = 0;; j++)
    {
      bool = false;
      if (j < i)
      {
        NetworkInfo localNetworkInfo = arrayOfNetworkInfo[j];
        if (localNetworkInfo.getType() == 1) {
          bool = localNetworkInfo.isAvailable();
        }
      }
      else
      {
        return bool;
      }
    }
  }
  
  public static boolean isWifiConnected(Context paramContext)
  {
    NetworkInfo localNetworkInfo = getConnManager(paramContext).getActiveNetworkInfo();
    return (localNetworkInfo != null) && (localNetworkInfo.getType() == 1) && (localNetworkInfo.isConnected());
  }
  
  public static boolean printNetworkInfo(Context paramContext)
  {
    ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService(Context.CONNECTIVITY_SERVICE);
    if (localConnectivityManager != null)
    {
      NetworkInfo localNetworkInfo = localConnectivityManager.getActiveNetworkInfo();
      LogUtil.e(TAG, "-------------网络状态-------------");
      LogUtil.e(TAG, "getActiveNetworkInfo: " + localNetworkInfo);
      NetworkInfo[] arrayOfNetworkInfo = localConnectivityManager.getAllNetworkInfo();
      if (arrayOfNetworkInfo == null) {
      }
      for (int i = 0; i < arrayOfNetworkInfo.length; i++)
      {
        LogUtil.e(TAG, "NetworkInfo[" + i + "]isAvailable : " + arrayOfNetworkInfo[i].isAvailable());
        LogUtil.e(TAG, "NetworkInfo[" + i + "]isConnected : " + arrayOfNetworkInfo[i].isConnected());
        LogUtil.e(TAG, "NetworkInfo[" + i + "]isConnectedOrConnecting : " + arrayOfNetworkInfo[i].isConnectedOrConnecting());
        LogUtil.e(TAG, "NetworkInfo[" + i + "]: " + arrayOfNetworkInfo[i]);
      }
      LogUtil.e(TAG, "\n");
    }
    for (;;)
    {
      return false;
//      label248:
//      LogUtil.e(TAG, "getAllNetworkInfo is null");
    }
  }
  
  public static enum NetType
  {
    None(0),
    Mobile(1),
    Wifi(2),
    Other(3),
    ;

    public int value;
    private NetType(int paramInt)
    {
      this.value = paramInt;
    }
  }
}
