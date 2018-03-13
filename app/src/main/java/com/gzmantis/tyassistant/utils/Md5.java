package com.gzmantis.tyassistant.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5
{
  public static String getMD51(String paramString)
  {
    byte[] arrayOfByte1 = paramString.getBytes();
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      byte[] arrayOfByte2 = localMessageDigest.digest(arrayOfByte1);
      StringBuffer localStringBuffer = new StringBuffer();
      for (int i = 0; i < arrayOfByte2.length; i++)
      {
        int j = arrayOfByte2[i];
        if (j < 0) {
          j += 256;
        }
        if (j < 16) {
          localStringBuffer.append("0");
        }
        localStringBuffer.append(Integer.toHexString(j));
      }
      return localStringBuffer.toString().toLowerCase();
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      return null;
    }
  }
  
  public static String getMD52(String paramString)
  {
    for (;;)
    {
      int i;
      try
      {
        MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
        localMessageDigest.update(paramString.getBytes("UTF-8"));
        byte[] arrayOfByte = localMessageDigest.digest();
        StringBuffer localStringBuffer = new StringBuffer();
        i = 0;
        if (i < arrayOfByte.length) {
          if (Integer.toHexString(0xFF & arrayOfByte[i]).length() == 1) {
            localStringBuffer.append("0").append(Integer.toHexString(0xFF & arrayOfByte[i]));
          } else {
            localStringBuffer.append(Integer.toHexString(0xFF & arrayOfByte[i]));
          }
        }
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        return "";
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        return "";
      }
      i++;
    }
  }
}