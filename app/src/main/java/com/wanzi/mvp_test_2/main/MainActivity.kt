package com.wanzi.mvp_test_2.main

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.wanzi.mvp_test_2.MVPActivity
import com.wanzi.mvp_test_2.R
import com.wanzi.mvp_test_2.model.WeatherBean
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : MVPActivity<MainPresenter>(), MainView {

    override fun showData(bean: WeatherBean) {
        Toast.makeText(this, "$bean", Toast.LENGTH_SHORT).show()
    }

    override fun showFail(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressBar.visibility = View.GONE
    }


    override fun createPresenter(): MainPresenter {
        return MainPresenter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn.setOnClickListener {
            presenter.loadData("101190201")
        }
    }
}
