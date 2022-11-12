package com.milon.mvvmwithretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.milon.mvvmwithretrofit.Api.QuateServices
import com.milon.mvvmwithretrofit.Api.RetrofitHelper
import com.milon.mvvmwithretrofit.databinding.ActivityMainBinding
import com.milon.mvvmwithretrofit.repository.QuoateRepository
import com.milon.mvvmwithretrofit.viewmodels.MainViewModel
import com.milon.mvvmwithretrofit.viewmodels.ViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val quoteServices=RetrofitHelper.getInstance().create(QuateServices::class.java)

        val repository= QuoateRepository(quoteServices)

        mainViewModel= ViewModelProvider(this, ViewModelFactory(repository)).get(MainViewModel::class.java)

        mainViewModel.quotes.observe(this, Observer {
            Log.d("milon", it.results.toString())
        })
    }
}