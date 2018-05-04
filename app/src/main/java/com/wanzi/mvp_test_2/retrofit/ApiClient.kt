package com.wanzi.mvp_test_2.retrofit

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient private constructor() {

    companion object {

        val instances: ApiClient by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            ApiClient()
        }
    }

    fun create(): Api {
        return Retrofit
                .Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(Api::class.java)
    }

}