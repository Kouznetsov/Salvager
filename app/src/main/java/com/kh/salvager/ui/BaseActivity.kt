package com.kh.salvager.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResource())
    }

    abstract fun getLayoutResource() : Int

    fun showGenericError(throwable: Throwable) {
        Toast.makeText(this, "An error occured: " + throwable.message, Toast.LENGTH_SHORT).show()
        throwable.printStackTrace()
    }
}