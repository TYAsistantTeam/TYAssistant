package com.gzmantis.tyassistant.https;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by LONG on 2018/3/8.
 */

public abstract interface Datas
{
    @GET("test/JsonTestWithArg")
    public abstract Call<String> Test();
}
