package com.wubanglin.box.network

class ApiException(var result:String,override var message:String):RuntimeException()