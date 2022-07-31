package com.wubanglin.box.network

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

object WBLNet {

    private var CALL_TIMEOUT = 30L
    private var CONNECT_TIMEOUT = 30L
    private var READ_TIMEOUT = 30L
    private var WRITE_TIMEOUT = 30L

    private lateinit var baseURL: String

    fun setBaseURL(baseURL: String): WBLNet {
        this.baseURL = baseURL
        return this
    }

    private var okHttpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()

    fun setCallTimeOut(callOutTime: Long): WBLNet {
        this.CALL_TIMEOUT = callOutTime
        return this
    }

    fun setConnectOutTime(connectOutTime: Long): WBLNet {
        this.CONNECT_TIMEOUT = connectOutTime
        return this
    }

    fun setReadTimeOut(readOutTime: Long): WBLNet {
        this.WRITE_TIMEOUT = readOutTime
        return this
    }

    fun setWriteTimeOut(writeOutTime: Long): WBLNet {
        this.WRITE_TIMEOUT = writeOutTime
        return this
    }

    fun addLogInterceptor(): WBLNet {
        val loggingInterceptor = HttpLoggingInterceptor {
            Log.d("Http", it)
        }
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        HttpLoggingInterceptor.Level.BASIC
        okHttpClientBuilder.addInterceptor(loggingInterceptor)
        return this
    }

    fun initWBLNet(): Api {
        if (baseURL.isEmpty()) {
            throw Exception("BaseUrl is null")
        }
        okHttpClientBuilder.apply {
            callTimeout(CALL_TIMEOUT, TimeUnit.SECONDS)
            connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
        }
        val retrofit = Retrofit.Builder().apply {
            client(okHttpClientBuilder.build())
            baseUrl(baseURL)
            addConverterFactory(GsonConverterFactory.create())
        }
        return retrofit.build().create(Api::class.java)
    }
}