package com.doan.dinh.doanapplication.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.doan.dinh.doanapplication.base.BaseActivity
import com.doan.dinh.doanapplication.databinding.ActivityUserDetailsBinding
import com.doan.dinh.doanapplication.viewmodel.UserDetailsViewModel
import com.doan.dinh.doanapplication.viewmodel.UserDetailsViewModelFactory
import javax.inject.Inject

class UserDetailsActivity : BaseActivity<UserDetailsViewModel>() {

    companion object {
        const val EXTRA_USERNAME = "username"
        fun start(context: Context, userName: String?) {
            val starter = Intent(context, UserDetailsActivity::class.java)
            starter.putExtra(EXTRA_USERNAME, userName)
            context.startActivity(starter)
        }
    }

    @Inject
    lateinit var factory: UserDetailsViewModelFactory

    private lateinit var binding: ActivityUserDetailsBinding

    override fun createViewModel(): UserDetailsViewModel {
        return ViewModelProvider(this, factory).get(UserDetailsViewModel::class.java)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        daggerInjector.createDetailsComponent().inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityUserDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val username = intent.getStringExtra(EXTRA_USERNAME)

        if (username == null) {
            finish()
        }


        username?.apply {
            viewModel.getDetail(this)
            observeViewModel()
        }


    }

    private fun observeViewModel() {
        viewModel.onGetDetail().observe { user ->
            if (!user.avatarUrl.isNullOrEmpty()) {
                Glide.with(applicationContext).load(user.avatarUrl).into(binding.ivAvatarDetail)
            }

            binding.tvName.text = user.name
            binding.tvEmail.text = user.email
            binding.tvCompany.text = user.company
            binding.tvLocation.text = user.location
            binding.tvBlog.text = user.blog
        }

        viewModel.getHideLoadingLiveData().observe {
            binding.progressBar.visibility = View.GONE
        }

        viewModel.getShowLoadingLiveData().observe {
            binding.progressBar.visibility = View.VISIBLE
        }


        viewModel.getShowErrorLiveData().observe { error ->
            Toast.makeText(this, error, Toast.LENGTH_LONG).show()
        }
    }

}
