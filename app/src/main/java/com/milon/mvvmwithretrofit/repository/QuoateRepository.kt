package com.milon.mvvmwithretrofit.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.milon.mvvmwithretrofit.Api.QuateServices
import com.milon.mvvmwithretrofit.models.QuateList

class QuoateRepository(private val quoteServices: QuateServices) {

    private val quoteLivedata=MutableLiveData<QuateList>()

    val quotes: LiveData<QuateList>
    get() = quoteLivedata

    suspend fun getQuoate(page: Int){
        val result=quoteServices.getQuotes(page)
        if (result?.body() != null){
            quoteLivedata.postValue(result.body())
        }
    }
}