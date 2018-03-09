package com.gzmantis.tyassistant.https;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by LONG on 2018/3/8.
 */

public class Apis {
    private static Apis Instance;
    private Datas apiDatas = (Datas) new Retrofit.Builder().baseUrl("http://cs.by8.la/").addConverterFactory(GsonConverterFactory.create()).build().create(Datas.class);

    public static Apis getInstance() {
        if (Instance == null) {
            Instance = new Apis();
        }
        return Instance;
    }

    public Datas getApiDatas() {
        return this.apiDatas;
    }
}