package com.milon.mvvmwithretrofit.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.milon.mvvmwithretrofit.repository.QuoateRepository

class ViewModelFactory(private val quoteRepository: QuoateRepository) : ViewModelProvider.Factory{

     override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(quoteRepository) as T
    }
}