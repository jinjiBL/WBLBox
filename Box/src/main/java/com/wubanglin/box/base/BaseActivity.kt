package com.wubanglin.box.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<T : ViewBinding> : AppCompatActivity() {
    lateinit var v: T
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        v = getViewBinding()
        setContentView(v.root)
        init()
    }

    abstract fun getViewBinding(): T

    abstract fun init()
}