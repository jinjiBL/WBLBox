package com.wubanglin.box.base

data class BaseBean<T>(
    val errorCode: Int,
    val errorMsg: String,
    val data: T
)