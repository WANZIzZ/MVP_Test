package com.wanzi.mvp_test_2.main

import com.wanzi.mvp_test_2.model.WeatherBean

interface MainView {

    fun showData(bean: WeatherBean)

    fun showFail(message: String)

    fun showProgress()

    fun hideProgress()
}