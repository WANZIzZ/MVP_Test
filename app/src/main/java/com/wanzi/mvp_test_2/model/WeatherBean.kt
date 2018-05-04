package com.wanzi.mvp_test_2.model

data class WeatherBean(
        val weatherinfo: WeatherDetail
) {
    // 这里只拿三个数据
    data class WeatherDetail(
            val city: String,
            val cityid: String,
            val temp: String
    )
}