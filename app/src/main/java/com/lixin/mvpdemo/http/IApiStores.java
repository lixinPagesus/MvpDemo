package com.lixin.mvpdemo.http;


import com.lixin.mvpdemo.bean.CookCategoryBean;
import com.lixin.mvpdemo.bean.CookListBean;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by lixin on 16/8/16.
 */
public interface IApiStores {
    //baseUrl
    String API_SERVER_URL = "http://apicloud.mob.com/";

    @GET("v1/cook/category/query")
    Observable<CookCategoryBean> loadCookCategory(@Query("key") String key);

    @GET("v1/cook/menu/search")
    Observable<CookListBean> loadCookList(@QueryMap Map<String,String> params);



}
