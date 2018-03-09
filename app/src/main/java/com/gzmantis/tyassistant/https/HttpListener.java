package com.gzmantis.tyassistant.https;

/**
 * Created by LONG on 2018/3/8.
 */

public abstract interface HttpListener
{
    public abstract void noData(HttpTask paramHttpTask, HttpResult paramHttpResult);

    public abstract void noNet(HttpTask paramHttpTask);

    public abstract void onLoadFailed(HttpTask paramHttpTask, HttpResult paramHttpResult);

    public abstract void onLoadFinish(HttpTask paramHttpTask, HttpResult paramHttpResult);

    public abstract void startLoad();
}
