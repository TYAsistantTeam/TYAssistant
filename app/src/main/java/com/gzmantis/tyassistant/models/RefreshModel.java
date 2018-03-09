package com.gzmantis.tyassistant.models;

/**
 * Created by LONG on 2018/3/8.
 */

public class RefreshModel {

    public String detail;
    public String title;

    public RefreshModel()
    {
    }

    public RefreshModel(String paramString1, String paramString2)
    {
        this.title = paramString1;
        this.detail = paramString2;
    }

}
