package com.wanzi.mvp_test_2.main

import com.wanzi.mvp_test_2.BasePresenter
import com.wanzi.mvp_test_2.model.WeatherBean
import com.wanzi.mvp_test_2.retrofit.ApiClient
import com.wanzi.mvp_test_2.rxjava.ApiCallback

class MainPresenter(view: MainView) : BasePresenter<MainView>() {

    init {
        attachView(view)
    }

    fun loadData(pathId: String) {
        view!!.showProgress()
        addSubscription(
                ApiClient.instances.create().loadData(pathId),
                object : ApiCallback<Any>() {
                    override fun onSuccess(t: Any) {
                        view!!.showData(t as WeatherBean)
                    }

                    override fun onFailure(message: String) {
                        view!!.showFail(message)
                    }

                    override fun onFinish() {
                        view!!.hideProgress()
                    }

                }
        )
    }
}