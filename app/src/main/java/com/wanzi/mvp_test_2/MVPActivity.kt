package com.wanzi.mvp_test_2

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

abstract class MVPActivity<P : BasePresenter<*>> : AppCompatActivity() {

    protected lateinit var presenter: P

    protected abstract fun createPresenter(): P

    override fun onCreate(savedInstanceState: Bundle?) {
        presenter = createPresenter()
        super.onCreate(savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }
}