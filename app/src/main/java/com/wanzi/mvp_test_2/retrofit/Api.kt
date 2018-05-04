package com.wanzi.mvp_test_2.retrofit

import com.wanzi.mvp_test_2.model.WeatherBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    companion object {
        val BASE_URL = "http://www.weather.com.cn/"
    }

    // 加载数据
    @GET("adat/sk/{pathId}.html")
    fun loadData(@Path("pathId") pathId: String): Observable<WeatherBean>
}