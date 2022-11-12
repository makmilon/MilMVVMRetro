package com.milon.mvvmwithretrofit.Api

import com.milon.mvvmwithretrofit.models.QuateList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuateServices {

    @GET("/quotes")
    suspend fun getQuotes(@Query("page") page: Int): Response<QuateList>
}