
package com.doan.dinh.doanapplication.view

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.doan.dinh.doanapplication.base.BaseActivity
import com.doan.dinh.doanapplication.databinding.ActivityMainBinding
import com.doan.dinh.doanapplication.viewmodel.SearchViewModel
import com.doan.dinh.doanapplication.viewmodel.SearchViewModelFactory
import javax.inject.Inject

class MainActivity : BaseActivity<SearchViewModel>() {

    @Inject
    lateinit var factory: SearchViewModelFactory


    private lateinit var binding: ActivityMainBinding


    override fun createViewModel(): SearchViewModel {
        return ViewModelProvider(this, factory).get(SearchViewModel::class.java)

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        daggerInjector.createSearchComponent().inject(this)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }

}
