package com.gzmantis.tyassistant.https;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;

import retrofit2.Call;

/**
 * Created by LONG on 2018/3/8.
 */

@SuppressLint({"UseValueOf"})
public class HttpTask extends AsyncTask<HttpParam, Integer, HttpResult>
{
    private static final String TAG = HttpTask.class.getSimpleName();
    private Call call;
    private Context context;
    private HttpListener listener;
    private OkHttpClientManager okHttpClientManager;

    public HttpTask(Context paramContext, HttpListener paramHttpListener)
    {
        this.context = paramContext;
        this.listener = paramHttpListener;
        this.okHttpClientManager = OkHttpClientManager.getInstance();
    }

    private Request GetUrl(HttpParam paramHttpParam)
    {
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append(paramHttpParam.getUrl() + paramHttpParam.getMethod());
        HashMap localHashMap = paramHttpParam.getParams();
        if (localHashMap != null)
        {
            Set localSet = localHashMap.keySet();
            int i = 1;
            Iterator localIterator = localSet.iterator();
            if (localIterator.hasNext())
            {
                label67: String str1 = (String)localIterator.next();
                if (i != 0);
                for (String str2 = "?"; ; str2 = "&")
                {
                    localStringBuffer.append(str2).append(URLEncoder.encode(str1)).append("=").append(URLEncoder.encode((String)localHashMap.get(str1)));
                    i = 0;
                    break label67:
                }
            }
        }
        LogUtil.e("get-url:", localStringBuffer.toString());
        return new Request.Builder().url(localStringBuffer.toString()).build();
    }

    private Request PostUrl(HttpParam paramHttpParam)
    {
        String str1 = paramHttpParam.getUrl() + paramHttpParam.getMethod();
        FormEncodingBuilder localFormEncodingBuilder = new FormEncodingBuilder();
        LogUtil.e("post-url:", str1);
        RequestBody localRequestBody;
        if (paramHttpParam.getParams() != null)
        {
            HashMap localHashMap = paramHttpParam.getParams();
            Iterator localIterator = localHashMap.keySet().iterator();
            while (localIterator.hasNext())
            {
                String str2 = (String)localIterator.next();
                localFormEncodingBuilder.add(str2, (String)localHashMap.get(str2));
            }
            localRequestBody = localFormEncodingBuilder.build();
        }
        for (Request localRequest = new Request.Builder().url(str1).post(localRequestBody).build(); ; localRequest = new Request.Builder().url(str1).build())
            return localRequest;
    }

    protected HttpResult doInBackground(HttpParam[] paramArrayOfHttpParam)
    {
        HttpResult localHttpResult = new HttpResult(this);
        try
        {
            if (paramArrayOfHttpParam[0] == null)
                break label199;
            HttpParam localHttpParam = paramArrayOfHttpParam[0];
            if (localHttpParam.isPost())
                this.call = this.okHttpClientManager._PostAndGet(PostUrl(localHttpParam));
            for (Response localResponse = this.call.execute(); (localResponse != null) && (200 == localResponse.code()); localResponse = this.call.execute())
            {
                localHttpResult.setData(localResponse.body().string());
                if (localResponse == null)
                    break label199;
                Log.i(TAG, "http statusCode : " + localResponse.code());
                break label199:
                this.call = this.okHttpClientManager._PostAndGet(GetUrl(localHttpParam));
            }
            localHttpResult.setError();
        }
        catch (IOException localIOException)
        {
            Log.e(TAG, localIOException.getMessage(), localIOException);
            localHttpResult.setStatus(-1);
            localHttpResult.setErrorMsg("网络异常，请确认是否连接网络!");
            break label199:
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
            Log.e(TAG, localIllegalArgumentException.getMessage(), localIllegalArgumentException);
        }
        label199: return localHttpResult;
    }

    protected void onCancelled()
    {
        super.onCancelled();
        if (this.call == null)
            return;
        this.call.cancel();
    }

    protected void onPostExecute(HttpResult paramHttpResult)
    {
        super.onPostExecute(paramHttpResult);
        if (this.listener != null)
            switch (paramHttpResult.getStatus())
            {
                default:
                case -1:
                case 1:
                case 0:
            }
        while (true)
        {
            return;
            this.listener.onLoadFailed(this, paramHttpResult);
            continue;
            this.listener.noData(this, paramHttpResult);
            continue;
            this.listener.onLoadFinish(this, paramHttpResult);
        }
    }

    protected void onPreExecute()
    {
        if (this.listener != null)
        {
            this.listener.startLoad();
            if (!NetUtil.isConnected(this.context))
            {
                if (this.listener != null)
                    this.listener.noNet(this);
                cancel(true);
            }
            super.onPreExecute();
            return;
        }
        throw new NullPointerException("HttpListener is null");
    }
}
