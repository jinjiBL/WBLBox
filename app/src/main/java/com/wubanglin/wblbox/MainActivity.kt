package com.wubanglin.wblbox

import android.util.Log
import com.wubanglin.box.base.BaseActivity
import com.wubanglin.box.network.WBLNet
import com.wubanglin.wblbox.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun getViewBinding() = ActivityMainBinding.inflate(layoutInflater)

    override fun init() {
        val request = WBLNet.setBaseURL("https://www.wanandroid.com")
            .addLogInterceptor()
            .initWBLNet()
        v.text.setOnClickListener {
            GlobalScope.launch {
                val map = HashMap<String, Any>().apply {
                    this["username"] = "admin"
                    this["password"] = "123456"
                }
            }
        }
    }
}