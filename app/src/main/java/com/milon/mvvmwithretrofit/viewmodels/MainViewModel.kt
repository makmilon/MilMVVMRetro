package com.milon.mvvmwithretrofit.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.milon.mvvmwithretrofit.models.QuateList
import com.milon.mvvmwithretrofit.repository.QuoateRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository: QuoateRepository): ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getQuoate(1)
        }

    }

    val quotes: LiveData<QuateList>
    get() = repository.quotes

}