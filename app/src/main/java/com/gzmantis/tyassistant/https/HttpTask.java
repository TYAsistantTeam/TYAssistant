package com.gzmantis.tyassistant.https;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import com.gzmantis.tyassistant.utils.LogUtil;
import com.gzmantis.tyassistant.utils.NetUtil;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@SuppressLint({"UseValueOf"})
public class HttpTask
  extends AsyncTask<HttpParam, Integer, HttpResult> {
  private static final String TAG = HttpTask.class.getSimpleName();
  private Call call;
  private Context context;
  private HttpListener listener;
  private OkHttpClientManager okHttpClientManager;

  public HttpTask(Context paramContext, HttpListener paramHttpListener) {
    this.context = paramContext;
    this.listener = paramHttpListener;
    this.okHttpClientManager = OkHttpClientManager.getInstance();
  }

  private Request GetUrl(HttpParam paramHttpParam) {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramHttpParam.getUrl() + paramHttpParam.getMethod());
    HashMap localHashMap = paramHttpParam.getParams();
    if (localHashMap != null) {
      Set localSet = localHashMap.keySet();
      int i = 1;
      Iterator localIterator = localSet.iterator();
      if (localIterator.hasNext()) {
        String str1 = (String) localIterator.next();
        if (i != 0) {
        }
        for (String str2 = "?"; ; str2 = "&") {
          localStringBuffer.append(str2).append(URLEncoder.encode(str1)).append("=").append(URLEncoder.encode((String) localHashMap.get(str1)));
          i = 0;
          break;
        }
      }
    }
    LogUtil.e("get-url:", localStringBuffer.toString());
    return new Request.Builder().url(localStringBuffer.toString()).build();
  }

  private Request PostUrl(HttpParam paramHttpParam) {
    String str1 = paramHttpParam.getUrl() + paramHttpParam.getMethod();
    FormEncodingBuilder localFormEncodingBuilder = new FormEncodingBuilder();
    LogUtil.e("post-url:", str1);
    if (paramHttpParam.getParams() != null) {
      HashMap localHashMap = paramHttpParam.getParams();
      Iterator localIterator = localHashMap.keySet().iterator();
      while (localIterator.hasNext()) {
        String str2 = (String) localIterator.next();
        localFormEncodingBuilder.add(str2, (String) localHashMap.get(str2));
      }
      RequestBody localRequestBody = localFormEncodingBuilder.build();
      return new Request.Builder().url(str1).post(localRequestBody).build();
    }
    return new Request.Builder().url(str1).build();
  }

  protected HttpResult doInBackground(HttpParam... paramVarArgs) {
    HttpResult localHttpResult = new HttpResult(this);
    try {
      if (paramVarArgs[0] != null) {
        HttpParam localHttpParam = paramVarArgs[0];
        Response localResponse = null;
        if (localHttpParam.isPost()) {
          this.call = this.okHttpClientManager._PostAndGet(PostUrl(localHttpParam));
          localResponse = this.call.execute();
          if ((localResponse == null) || (200 != localResponse.code())) {
//            break;
          }
          localHttpResult.setData(localResponse.body().string());
        }
        for (; ; ) {
          if (localResponse == null) {
            return localHttpResult;
          }
          Log.i(TAG, "http statusCode : " + localResponse.code());
          return localHttpResult;
//          this.call = this.okHttpClientManager._PostAndGet(GetUrl(localHttpParam));
//          localResponse = this.call.execute();
//          break;
//          label148:
//          localHttpResult.setError();
        }
      }
      return localHttpResult;
    } catch (IOException localIOException) {
      Log.e(TAG, localIOException.getMessage(), localIOException);
      localHttpResult.setStatus(-1);
      localHttpResult.setErrorMsg("网络异常，请确认是否连接网络!");
      return localHttpResult;
    } catch (IllegalArgumentException localIllegalArgumentException) {
      Log.e(TAG, localIllegalArgumentException.getMessage(), localIllegalArgumentException);
    }
    return localHttpResult;
  }


  protected void onCancelled()
  {
    super.onCancelled();
    if (this.call != null) {
      this.call.cancel();
    }
  }
  
  protected void onPostExecute(HttpResult paramHttpResult)
  {
    super.onPostExecute(paramHttpResult);
    if (this.listener != null) {}
    switch (paramHttpResult.getStatus())
    {
    default: 
      return;
    case -1: 
      this.listener.onLoadFailed(this, paramHttpResult);
      return;
    case 1: 
      this.listener.noData(this, paramHttpResult);
      return;
    }
//    this.listener.onLoadFinish(this, paramHttpResult);
  }
  
  protected void onPreExecute()
  {
    if (this.listener != null)
    {
      this.listener.startLoad();
      if (!NetUtil.isConnected(this.context))
      {
        if (this.listener != null) {
          this.listener.noNet(this);
        }
        cancel(true);
      }
      super.onPreExecute();
      return;
    }
    throw new NullPointerException("HttpListener is null");
  }
}



/* Location:           C:\Users\Joesea Lea\Desktop\ty_app_dex2jar.jar

 * Qualified Name:     com.tt.caipiao.pkg.https.HttpTask

 * JD-Core Version:    0.7.0.1

 */