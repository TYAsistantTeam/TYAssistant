package com.gzmantis.tyassistant.https;

/**
 * Created by LONG on 2018/3/8.
 */

public class HttpResult {
    public static final int STATUS_FAILED = -1;
    public static final int STATUS_NO_DATA = 1;
    public static final int STATUS_SUCCESS = 0;
    private String data;
    private String errorMsg;
    private HttpTask ower;
    private int status;

    public HttpResult(HttpTask paramHttpTask) {
        this.ower = paramHttpTask;
        this.status = -1;
    }

    public String getData() {
        return this.data;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public HttpTask getOwer() {
        return this.ower;
    }

    public int getStatus() {
        return this.status;
    }

    public void setData(String paramString) {
        this.data = paramString;
        this.status = 0;
    }

    public void setError() {
        this.status = -1;
    }

    public void setErrorMsg(String paramString) {
        this.errorMsg = paramString;
    }

    public void setNoData() {
        this.status = 1;
    }

    public void setStatus(int paramInt) {
        this.status = paramInt;
    }
}
