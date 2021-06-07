
package com.doan.dinh.doanapplication.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.doan.dinh.doanapplication.adapter.ResultAdapter
import com.doan.dinh.doanapplication.base.BaseActivity
import com.doan.dinh.doanapplication.databinding.ActivityMainBinding
import com.doan.dinh.doanapplication.viewmodel.SearchViewModel
import com.doan.dinh.doanapplication.viewmodel.SearchViewModelFactory
import javax.inject.Inject

class MainActivity : BaseActivity<SearchViewModel>() {

    @Inject
    lateinit var factory: SearchViewModelFactory
    private lateinit var binding: ActivityMainBinding
    private var searchAdapter = ResultAdapter()


    override fun createViewModel(): SearchViewModel {
        return ViewModelProvider(this, factory).get(SearchViewModel::class.java)

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        daggerInjector.createSearchComponent().inject(this)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        init()
        observeViewModel()
        setupViewListeners()

    }

    private fun init() {
        binding.recyclerView.adapter = searchAdapter
    }

    private fun setupViewListeners() {
        binding.btnSearch.setOnClickListener {
            if(binding.progressBar.visibility == View.GONE) {
                val key = binding.edtSearch.text.toString()
                if(key.isNotEmpty()) {
                    binding.tvNoresult.visibility = View.GONE
                    viewModel.doSearch(key)
                }
            }

        }

        searchAdapter.setItemClick { item ->
            viewModel.onUserItemClick(item)
        }
    }

    private fun observeViewModel() {
        viewModel.getHideLoadingLiveData().observe {
            binding.progressBar.visibility = View.GONE
        }

        viewModel.getShowLoadingLiveData().observe {
            binding.progressBar.visibility = View.VISIBLE
        }

        viewModel.onSearch().observe { data ->
            searchAdapter.setItems(data.items)
            binding.progressBar.visibility = View.GONE
            if(data.items.isEmpty()) {
                binding.tvNoresult.visibility = View.VISIBLE
            }else{
                binding.tvNoresult.visibility = View.GONE
            }
        }

        viewModel.getNavigateToDetails().observe { item ->
            UserDetailsActivity.start(this, item.login)
        }

        viewModel.getShowErrorLiveData().observe { error ->
            Toast.makeText(this, error, Toast.LENGTH_LONG).show()
        }
    }

}
