package com.wubanglin.base

import android.content.Context
import android.widget.Toast

class ToastUtil {
    fun showToast(context: Context, str: String) {
        Toast.makeText(context, str, Toast.LENGTH_SHORT).show()
    }
}