package com.wubanglin.box.network

import com.wubanglin.box.base.BaseBean
import retrofit2.http.*

interface Api {

    @GET
    suspend fun get(@Url url: String)

    @GET
    suspend fun get(@Url url: String, @QueryMap params: HashMap<String, Any>)

    @POST
    suspend fun post(@Url url: String)

    @POST
    @FormUrlEncoded
    suspend fun <T> post(@Url url: String, @FieldMap params: HashMap<String, Any>): BaseBean<T>

    @POST
    @FormUrlEncoded
    suspend fun uploadFile(@Url url: String, @FieldMap params: HashMap<String, Any>)
}