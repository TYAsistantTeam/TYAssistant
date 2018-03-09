package com.gzmantis.tyassistant.https;

import com.gzmantis.tyassistant.apis.Config;

import java.util.HashMap;

/**
 * Created by LONG on 2018/3/8.
 */

public class HttpParam {
    private boolean isPost;
    private String method;
    private HashMap<String, String> params;
    private String url;

    public HttpParam(String paramString, boolean paramBoolean) {
        this.url = paramString;
        this.isPost = paramBoolean;
    }

    public HttpParam(boolean paramBoolean) {
        this.url = Config.HOST;
        this.isPost = paramBoolean;
    }

    public String getMethod() {
        if (this.method == null) ;
        for (String str = ""; ; str = this.method)
            return str;
    }

    public HashMap<String, String> getParams() {
        return this.params;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isPost() {
        return this.isPost;
    }

    public void setMethod(String paramString) {
        this.method = paramString;
    }

    public void setParams(HashMap<String, String> paramHashMap) {
        this.params = paramHashMap;
    }

    public void setPost(boolean paramBoolean) {
        this.isPost = paramBoolean;
    }

    public void setUrl(String paramString) {
        this.url = paramString;
    }
}