package com.gzmantis.tyassistant.https;

import com.gzmantis.tyassistant.models.BannerModel;
import com.gzmantis.tyassistant.models.RefreshModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by LONG on 2018/3/5.
 */

public abstract interface ApiDatas {
    @GET("banner/api/5item.json")
    public abstract Call<BannerModel> getBannerModel();

    @GET("refreshlayout/api/defaultdata6.json")
    public abstract Call<List<RefreshModel>> loadInitDatas();

    @GET("refreshlayout/api/moredata{pageNumber}.json")
    public abstract Call<List<RefreshModel>> loadMoreData(@Path("pageNumber") int paramInt);

    @GET("refreshlayout/api/newdata{pageNumber}.json")
    public abstract Call<List<RefreshModel>> loadNewData(@Path("pageNumber") int paramInt);
}
