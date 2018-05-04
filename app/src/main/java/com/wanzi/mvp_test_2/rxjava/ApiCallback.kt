package com.wanzi.mvp_test_2.rxjava

import io.reactivex.observers.DisposableObserver

abstract class ApiCallback<T> : DisposableObserver<T>() {

    abstract fun onSuccess(t: T)

    abstract fun onFailure(message: String)

    abstract fun onFinish()

    override fun onComplete() {
        onFinish()
    }

    override fun onNext(t: T) {
        onSuccess(t)
    }

    override fun onError(e: Throwable) {
        onFailure(e.message!!)
        onFinish()
    }
}