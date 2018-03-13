package com.gzmantis.tyassistant.https;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import com.google.gson.Gson;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.MultipartBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import com.gzmantis.tyassistant.utils.InputStreamToString;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class OkHttpClientManager
{
  private static final String SESSION_KEY = "Set-Cookie";
  private static final String TAG = "OkHttpClientManager";
  private static OkHttpClientManager mInstance;
  private static final String mSessionKey = "JSESSIONID";
  private Handler mDelivery;
  private Gson mGson;
  private OkHttpClient mOkHttpClient = new OkHttpClient();
  private Map<String, String> mSessions = new HashMap();
  
  @TargetApi(9)
  private OkHttpClientManager()
  {
    this.mOkHttpClient.setConnectTimeout(10000L, TimeUnit.MILLISECONDS);
    this.mOkHttpClient.setReadTimeout(10000L, TimeUnit.MILLISECONDS);
    this.mOkHttpClient.setWriteTimeout(10000L, TimeUnit.MILLISECONDS);
    this.mOkHttpClient.setCookieHandler(new CookieManager(null, CookiePolicy.ACCEPT_ORIGINAL_SERVER));
    this.mDelivery = new Handler(Looper.getMainLooper());
    this.mGson = new Gson();
  }
  
  private void _displayImage(final ImageView paramImageView, String paramString, final int paramInt)
  {
    Request localRequest = new Builder().url(paramString).build();
    this.mOkHttpClient.newCall(localRequest).enqueue(new Callback()
    {
      public void onFailure(Request paramAnonymousRequest, IOException paramAnonymousIOException)
      {
        OkHttpClientManager.this.setErrorResId(paramImageView, paramInt);
      }
      
      public void onResponse(Response paramAnonymousResponse)
      {
        if (paramAnonymousResponse.code() == 200)
        {
          InputStream localInputStream = null;
          for (;;)
          {
            try
            {
              localInputStream = paramAnonymousResponse.body().byteStream();
              Options localOptions = new Options();
              localOptions.inJustDecodeBounds = false;
              final Bitmap localBitmap = BitmapFactory.decodeStream(localInputStream, null, localOptions);
              OkHttpClientManager.this.mDelivery.post(new Runnable()
              {
                public void run()
                {
//                  OkHttpClientManager.this.view.setImageBitmap(localBitmap);
                }
              });
            }
            catch (Exception localException)
            {
              OkHttpClientManager.this.setErrorResId(paramImageView, paramInt);
              if (localInputStream == null) {
                continue;
              }
              try
              {
                localInputStream.close();
                return;
              }
              catch (IOException localIOException2)
              {
                localIOException2.printStackTrace();
                return;
              }
            }
            finally
            {
              if (localInputStream == null) {
                break;
              }
            }
            try
            {
              localInputStream.close();
              return;
            }
            catch (IOException localIOException3)
            {
              localIOException3.printStackTrace();
              return;
            }
          }
          try
          {
            localInputStream.close();
            label125:
            throw new IOException();
          }
          catch (IOException localIOException1)
          {
            for (;;)
            {
              localIOException1.printStackTrace();
            }
          }
        }
        OkHttpClientManager.this.setErrorResId(paramImageView, paramInt);
      }
    });
  }
  
  private void _downloadAsyn(final String paramString1, final String paramString2, final ResultCallback paramResultCallback)
  {
    Request localRequest = new Builder().url(paramString1).build();
    this.mOkHttpClient.newCall(localRequest).enqueue(new Callback()
    {
      public void onFailure(Request paramAnonymousRequest, IOException paramAnonymousIOException)
      {
        OkHttpClientManager.this.sendFailedStringCallback(paramAnonymousRequest, paramAnonymousIOException, paramResultCallback);
      }
      
      /* Error */
      public void onResponse(Response paramAnonymousResponse)
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore_2
        //   2: sipush 2048
        //   5: newarray byte
        //   7: astore_3
        //   8: aconst_null
        //   9: astore 4
        //   11: aload_1
        //   12: invokevirtual 47	com/squareup/okhttp/Response:body	()Lcom/squareup/okhttp/ResponseBody;
        //   15: invokevirtual 53	com/squareup/okhttp/ResponseBody:byteStream	()Ljava/io/InputStream;
        //   18: astore_2
        //   19: new 55	java/io/File
        //   22: dup
        //   23: aload_0
        //   24: getfield 26	com/tt/caipiao/pkg/https/OkHttpClientManager$1:val$destFileDir	Ljava/lang/String;
        //   27: aload_0
        //   28: getfield 22	com/tt/caipiao/pkg/https/OkHttpClientManager$1:this$0	Lcom/tt/caipiao/pkg/https/OkHttpClientManager;
        //   31: aload_0
        //   32: getfield 28	com/tt/caipiao/pkg/https/OkHttpClientManager$1:val$url	Ljava/lang/String;
        //   35: invokestatic 59	com/tt/caipiao/pkg/https/OkHttpClientManager:access$100	(Lcom/tt/caipiao/pkg/https/OkHttpClientManager;Ljava/lang/String;)Ljava/lang/String;
        //   38: invokespecial 62	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
        //   41: astore 11
        //   43: new 64	java/io/FileOutputStream
        //   46: dup
        //   47: aload 11
        //   49: invokespecial 67	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
        //   52: astore 12
        //   54: aload_2
        //   55: aload_3
        //   56: invokevirtual 73	java/io/InputStream:read	([B)I
        //   59: istore 13
        //   61: iload 13
        //   63: iconst_m1
        //   64: if_icmpeq +57 -> 121
        //   67: aload 12
        //   69: aload_3
        //   70: iconst_0
        //   71: iload 13
        //   73: invokevirtual 77	java/io/FileOutputStream:write	([BII)V
        //   76: goto -22 -> 54
        //   79: astore 5
        //   81: aload 12
        //   83: astore 4
        //   85: aload_0
        //   86: getfield 22	com/tt/caipiao/pkg/https/OkHttpClientManager$1:this$0	Lcom/tt/caipiao/pkg/https/OkHttpClientManager;
        //   89: aload_1
        //   90: invokevirtual 81	com/squareup/okhttp/Response:request	()Lcom/squareup/okhttp/Request;
        //   93: aload 5
        //   95: aload_0
        //   96: getfield 24	com/tt/caipiao/pkg/https/OkHttpClientManager$1:val$callback	Lcom/tt/caipiao/pkg/https/OkHttpClientManager$ResultCallback;
        //   99: invokestatic 37	com/tt/caipiao/pkg/https/OkHttpClientManager:access$000	(Lcom/tt/caipiao/pkg/https/OkHttpClientManager;Lcom/squareup/okhttp/Request;Ljava/lang/Exception;Lcom/tt/caipiao/pkg/https/OkHttpClientManager$ResultCallback;)V
        //   102: aload_2
        //   103: ifnull +7 -> 110
        //   106: aload_2
        //   107: invokevirtual 84	java/io/InputStream:close	()V
        //   110: aload 4
        //   112: ifnull +8 -> 120
        //   115: aload 4
        //   117: invokevirtual 85	java/io/FileOutputStream:close	()V
        //   120: return
        //   121: aload 12
        //   123: invokevirtual 88	java/io/FileOutputStream:flush	()V
        //   126: aload_0
        //   127: getfield 22	com/tt/caipiao/pkg/https/OkHttpClientManager$1:this$0	Lcom/tt/caipiao/pkg/https/OkHttpClientManager;
        //   130: aload 11
        //   132: invokevirtual 92	java/io/File:getAbsolutePath	()Ljava/lang/String;
        //   135: aload_0
        //   136: getfield 24	com/tt/caipiao/pkg/https/OkHttpClientManager$1:val$callback	Lcom/tt/caipiao/pkg/https/OkHttpClientManager$ResultCallback;
        //   139: invokestatic 96	com/tt/caipiao/pkg/https/OkHttpClientManager:access$200	(Lcom/tt/caipiao/pkg/https/OkHttpClientManager;Ljava/lang/String;Lcom/tt/caipiao/pkg/https/OkHttpClientManager$ResultCallback;)V
        //   142: aload_2
        //   143: ifnull +7 -> 150
        //   146: aload_2
        //   147: invokevirtual 84	java/io/InputStream:close	()V
        //   150: aload 12
        //   152: ifnull +8 -> 160
        //   155: aload 12
        //   157: invokevirtual 85	java/io/FileOutputStream:close	()V
        //   160: return
        //   161: astore 14
        //   163: return
        //   164: astore 6
        //   166: aload_2
        //   167: ifnull +7 -> 174
        //   170: aload_2
        //   171: invokevirtual 84	java/io/InputStream:close	()V
        //   174: aload 4
        //   176: ifnull +8 -> 184
        //   179: aload 4
        //   181: invokevirtual 85	java/io/FileOutputStream:close	()V
        //   184: aload 6
        //   186: athrow
        //   187: astore 15
        //   189: goto -39 -> 150
        //   192: astore 10
        //   194: goto -84 -> 110
        //   197: astore 9
        //   199: return
        //   200: astore 8
        //   202: goto -28 -> 174
        //   205: astore 7
        //   207: goto -23 -> 184
        //   210: astore 6
        //   212: aload 12
        //   214: astore 4
        //   216: goto -50 -> 166
        //   219: astore 5
        //   221: aconst_null
        //   222: astore 4
        //   224: goto -139 -> 85
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	227	0	this	1
        //   0	227	1	paramAnonymousResponse	Response
        //   1	170	2	localInputStream	InputStream
        //   7	63	3	arrayOfByte	byte[]
        //   9	214	4	localObject1	Object
        //   79	15	5	localIOException1	IOException
        //   219	1	5	localIOException2	IOException
        //   164	21	6	localObject2	Object
        //   210	1	6	localObject3	Object
        //   205	1	7	localIOException3	IOException
        //   200	1	8	localIOException4	IOException
        //   197	1	9	localIOException5	IOException
        //   192	1	10	localIOException6	IOException
        //   41	90	11	localFile	File
        //   52	161	12	localFileOutputStream	java.io.FileOutputStream
        //   59	13	13	i	int
        //   161	1	14	localIOException7	IOException
        //   187	1	15	localIOException8	IOException
        // Exception table:
        //   from	to	target	type
        //   54	61	79	java/io/IOException
        //   67	76	79	java/io/IOException
        //   121	142	79	java/io/IOException
        //   155	160	161	java/io/IOException
        //   11	54	164	finally
        //   85	102	164	finally
        //   146	150	187	java/io/IOException
        //   106	110	192	java/io/IOException
        //   115	120	197	java/io/IOException
        //   170	174	200	java/io/IOException
        //   179	184	205	java/io/IOException
        //   54	61	210	finally
        //   67	76	210	finally
        //   121	142	210	finally
        //   11	54	219	java/io/IOException
      }
    });
  }
  
  private String _getAsString(String paramString)
    throws IOException
  {
    return _getAsyn(paramString).body().string();
  }
  
  private Response _getAsyn(String paramString)
    throws IOException
  {
    Request localRequest = new Builder().url(paramString).build();
    return this.mOkHttpClient.newCall(localRequest).execute();
  }
  
  private Response _post(String paramString1, File paramFile, String paramString2)
    throws IOException
  {
    Request localRequest = buildMultipartFormRequest(paramString1, new File[] { paramFile }, new String[] { paramString2 }, null);
    return this.mOkHttpClient.newCall(localRequest).execute();
  }
  
  private Response _post(String paramString1, File paramFile, String paramString2, Param... paramVarArgs)
    throws IOException
  {
    Request localRequest = buildMultipartFormRequest(paramString1, new File[] { paramFile }, new String[] { paramString2 }, paramVarArgs);
    return this.mOkHttpClient.newCall(localRequest).execute();
  }
  
  private Response _post(String paramString, Param... paramVarArgs)
    throws IOException
  {
    Request localRequest = buildPostRequest(paramString, paramVarArgs);
    return this.mOkHttpClient.newCall(localRequest).execute();
  }
  
  private Response _post(String paramString, File[] paramArrayOfFile, String[] paramArrayOfString, Param... paramVarArgs)
    throws IOException
  {
    Request localRequest = buildMultipartFormRequest(paramString, paramArrayOfFile, paramArrayOfString, paramVarArgs);
    return this.mOkHttpClient.newCall(localRequest).execute();
  }
  
  private void _postAsyn(String paramString1, ResultCallback paramResultCallback, File paramFile, String paramString2)
    throws IOException
  {
    deliveryResult(paramResultCallback, buildMultipartFormRequest(paramString1, new File[] { paramFile }, new String[] { paramString2 }, null));
  }
  
  private void _postAsyn(String paramString1, ResultCallback paramResultCallback, File paramFile, String paramString2, Param... paramVarArgs)
    throws IOException
  {
    deliveryResult(paramResultCallback, buildMultipartFormRequest(paramString1, new File[] { paramFile }, new String[] { paramString2 }, paramVarArgs));
  }
  
  private void _postAsyn(String paramString, ResultCallback paramResultCallback, Map<String, String> paramMap)
  {
    deliveryResult(paramResultCallback, buildPostRequest(paramString, map2Params(paramMap)));
  }
  
  private void _postAsyn(String paramString, ResultCallback paramResultCallback, File[] paramArrayOfFile, String[] paramArrayOfString, Param... paramVarArgs)
    throws IOException
  {
    deliveryResult(paramResultCallback, buildMultipartFormRequest(paramString, paramArrayOfFile, paramArrayOfString, paramVarArgs));
  }
  
  private Request buildMultipartFormRequest(String paramString, File[] paramArrayOfFile, String[] paramArrayOfString, Param[] paramArrayOfParam)
  {
    Param[] arrayOfParam = validateParam(paramArrayOfParam);
    MultipartBuilder localMultipartBuilder = new MultipartBuilder().type(MultipartBuilder.FORM);
    int i = arrayOfParam.length;
    for (int j = 0; j < i; j++)
    {
      Param localParam = arrayOfParam[j];
      String[] arrayOfString2 = new String[2];
      arrayOfString2[0] = "Content-Disposition";
      arrayOfString2[1] = ("form-data; name=\"" + localParam.key + "\"");
      localMultipartBuilder.addPart(Headers.of(arrayOfString2), RequestBody.create(null, localParam.value));
    }
    if (paramArrayOfFile != null) {
      for (int k = 0; k < paramArrayOfFile.length; k++)
      {
        File localFile = paramArrayOfFile[k];
        String str = localFile.getName();
        RequestBody localRequestBody2 = RequestBody.create(MediaType.parse(guessMimeType(str)), localFile);
        String[] arrayOfString1 = new String[2];
        arrayOfString1[0] = "Content-Disposition";
        arrayOfString1[1] = ("form-data; name=\"" + paramArrayOfString[k] + "\"; filename=\"" + str + "\"");
        localMultipartBuilder.addPart(Headers.of(arrayOfString1), localRequestBody2);
      }
    }
    RequestBody localRequestBody1 = localMultipartBuilder.build();
    return new Builder().url(paramString).post(localRequestBody1).build();
  }
  
  private Request buildPostRequest(String paramString, Param[] paramArrayOfParam)
  {
    int i = 0;
    if (paramArrayOfParam == null) {
      paramArrayOfParam = new Param[0];
    }
    FormEncodingBuilder localFormEncodingBuilder = new FormEncodingBuilder();
    int j = paramArrayOfParam.length;
    while (i < j)
    {
      Param localParam = paramArrayOfParam[i];
      localFormEncodingBuilder.add(localParam.key, localParam.value);
      i++;
    }
    RequestBody localRequestBody = localFormEncodingBuilder.build();
    return new Builder().url(paramString).post(localRequestBody).build();
  }
  
  private void deliveryResult(final ResultCallback paramResultCallback, final Request paramRequest)
  {
    this.mOkHttpClient.newCall(paramRequest).enqueue(new Callback()
    {
      public void onFailure(Request paramAnonymousRequest, IOException paramAnonymousIOException)
      {
        OkHttpClientManager.this.sendFailedStringCallback(paramAnonymousRequest, paramAnonymousIOException, paramResultCallback);
      }
      
      public void onResponse(Response paramAnonymousResponse)
      {
        try
        {
          if (paramAnonymousResponse.code() == 200)
          {
            String str = InputStreamToString.inputStream2String(paramAnonymousResponse.body().byteStream());
            OkHttpClientManager.this.sendSuccessResultCallback(str, paramResultCallback);
            return;
          }
          OkHttpClientManager.this.sendSuccessResultCallback("", paramResultCallback);
          return;
        }
        catch (IOException localIOException)
        {
          localIOException.printStackTrace();
          OkHttpClientManager.this.sendFailedStringCallback(paramRequest, localIOException, paramResultCallback);
        }
      }
    });
  }
  
  public static void displayImage(ImageView paramImageView, String paramString)
  {
    getInstance()._displayImage(paramImageView, paramString, -1);
  }
  
  public static void displayImage(ImageView paramImageView, String paramString, int paramInt)
    throws IOException
  {
    getInstance()._displayImage(paramImageView, paramString, paramInt);
  }
  
  public static void downloadAsyn(String paramString1, String paramString2, ResultCallback paramResultCallback)
  {
    getInstance()._downloadAsyn(paramString1, paramString2, paramResultCallback);
  }
  
  public static String getAsString(String paramString)
    throws IOException
  {
    return getInstance()._getAsString(paramString);
  }
  
  public static Response getAsyn(String paramString)
    throws IOException
  {
    return getInstance()._getAsyn(paramString);
  }
  
  public static void getAsyn(String paramString, ResultCallback paramResultCallback)
  {
    getInstance()._getAsyn(paramString, paramResultCallback);
  }
  
  private String getFileName(String paramString)
  {
    int i = paramString.lastIndexOf("/");
    if (i < 0) {
      return paramString;
    }
    return paramString.substring(i + 1, paramString.length());
  }
  
  public static OkHttpClientManager getInstance()
  {
    if (mInstance == null) {}
    try
    {
      if (mInstance == null) {
        mInstance = new OkHttpClientManager();
      }
      return mInstance;
    }
    finally {}
  }
  
  private String guessMimeType(String paramString)
  {
    String str = URLConnection.getFileNameMap().getContentTypeFor(paramString);
    if (str == null) {
      str = "application/octet-stream";
    }
    return str;
  }
  
  private Param[] map2Params(Map<String, String> paramMap)
  {
    Param[] arrayOfParam;
    if (paramMap == null) {
      arrayOfParam = new Param[0];
    }
    for (;;)
    {
//      return arrayOfParam;
      arrayOfParam = new Param[paramMap.size()];
      Set localSet = paramMap.entrySet();
      int i = 0;
      Iterator localIterator = localSet.iterator();
      while (localIterator.hasNext())
      {
        Entry localEntry = (Entry)localIterator.next();
        int j = i + 1;
        arrayOfParam[i] = new Param((String)localEntry.getKey(), (String)localEntry.getValue());
        i = j;
      }
    }
  }
  
  public static Response post(String paramString1, File paramFile, String paramString2)
    throws IOException
  {
    return getInstance()._post(paramString1, paramFile, paramString2);
  }
  
  public static Response post(String paramString1, File paramFile, String paramString2, Param... paramVarArgs)
    throws IOException
  {
    return getInstance()._post(paramString1, paramFile, paramString2, paramVarArgs);
  }
  
  public static Response post(String paramString, Param... paramVarArgs)
    throws IOException
  {
    return getInstance()._post(paramString, paramVarArgs);
  }
  
  public static Response post(String paramString, File[] paramArrayOfFile, String[] paramArrayOfString, Param... paramVarArgs)
    throws IOException
  {
    return getInstance()._post(paramString, paramArrayOfFile, paramArrayOfString, paramVarArgs);
  }
  
  public static String postAsString(String paramString, Param... paramVarArgs)
    throws IOException
  {
    return getInstance()._postAsString(paramString, paramVarArgs);
  }
  
  public static void postAsyn(String paramString1, ResultCallback paramResultCallback, File paramFile, String paramString2)
    throws IOException
  {
    getInstance()._postAsyn(paramString1, paramResultCallback, paramFile, paramString2);
  }
  
  public static void postAsyn(String paramString1, ResultCallback paramResultCallback, File paramFile, String paramString2, Param... paramVarArgs)
    throws IOException
  {
    getInstance()._postAsyn(paramString1, paramResultCallback, paramFile, paramString2, paramVarArgs);
  }
  
  public static void postAsyn(String paramString, ResultCallback paramResultCallback, Map<String, String> paramMap)
  {
    getInstance()._postAsyn(paramString, paramResultCallback, paramMap);
  }
  
  public static void postAsyn(String paramString, ResultCallback paramResultCallback, Param... paramVarArgs)
  {
    getInstance()._postAsyn(paramString, paramResultCallback, paramVarArgs);
  }
  
  public static void postAsyn(String paramString, ResultCallback paramResultCallback, File[] paramArrayOfFile, String[] paramArrayOfString, Param... paramVarArgs)
    throws IOException
  {
    getInstance()._postAsyn(paramString, paramResultCallback, paramArrayOfFile, paramArrayOfString, paramVarArgs);
  }
  
  private void sendFailedStringCallback(final Request paramRequest, final Exception paramException, final ResultCallback paramResultCallback)
  {
    this.mDelivery.post(new Runnable()
    {
      public void run()
      {
        if (paramResultCallback != null) {
          paramResultCallback.onError(paramRequest, paramException);
        }
      }
    });
  }
  
  private void sendSuccessResultCallback(final String paramString, final ResultCallback paramResultCallback)
  {
    this.mDelivery.post(new Runnable()
    {
      public void run()
      {
        if (paramResultCallback != null) {
          paramResultCallback.onResponse(paramString);
        }
      }
    });
  }
  
  private void setErrorResId(final ImageView paramImageView, final int paramInt)
  {
    this.mDelivery.post(new Runnable()
    {
      public void run()
      {
        paramImageView.setImageResource(paramInt);
      }
    });
  }
  
  private Param[] validateParam(Param[] paramArrayOfParam)
  {
    if (paramArrayOfParam == null) {
      paramArrayOfParam = new Param[0];
    }
    return paramArrayOfParam;
  }
  
  public Call _PostAndGet(Request paramRequest)
  {
    return this.mOkHttpClient.newCall(paramRequest);
  }
  
  public void _getAsyn(String paramString, ResultCallback paramResultCallback)
  {
    deliveryResult(paramResultCallback, new Builder().url(paramString).build());
  }
  
  public String _postAsString(String paramString, Param... paramVarArgs)
    throws IOException
  {
    return _post(paramString, paramVarArgs).body().string();
  }
  
  public void _postAsyn(String paramString, ResultCallback paramResultCallback, Param... paramVarArgs)
  {
    deliveryResult(paramResultCallback, buildPostRequest(paramString, paramVarArgs));
  }
  
  public static class Param
  {
    String key;
    String value;
    
    public Param() {}
    
    public Param(String paramString1, String paramString2)
    {
      this.key = paramString1;
      this.value = paramString2;
    }
  }
  
  public static abstract class ResultCallback
  {
    public abstract void onError(Request paramRequest, Exception paramException);
    
    public abstract void onResponse(String paramString);
  }
}



/* Location:           C:\Users\Joesea Lea\Desktop\ty_app_dex2jar.jar

 * Qualified Name:     com.tt.caipiao.pkg.https.OkHttpClientManager

 * JD-Core Version:    0.7.0.1

 */