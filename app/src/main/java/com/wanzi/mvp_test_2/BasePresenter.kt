package com.wanzi.mvp_test_2

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

open class BasePresenter<V> {

    var view: V? = null

    private val mCompositeDisposable = CompositeDisposable()

    fun attachView(view: V) {
        this.view = view
    }

    fun detachView() {
        view = null
        onUnSubscribe()
    }

    /**
     * 将DisposableObserver添加到容器中
     *
     * @param observable 被观察者
     * @param observer   观察者
     */
    fun addSubscription(observable: Observable<*>, observer: DisposableObserver<Any>) {
        mCompositeDisposable.add(observer)

        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer)
    }

    /**
     * 在退出的时候，调用CompositeDisposable.clear() 即可快速解除
     */
    private fun onUnSubscribe() {
        mCompositeDisposable.clear()
        mCompositeDisposable.dispose()
    }
}