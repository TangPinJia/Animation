package com.example.tpj.myapplication.interfaces;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

/**
 * Created by TPJ on 2019/4/18.
 * Describe:
 */
public interface RetrofitService  {

    @GET("数据接口")
    Call<String> getName(/*参数*/);
}
