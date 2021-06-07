
package com.doan.dinh.doanapplication.view

import android.content.Context
import androidx.lifecycle.*
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
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
        binding.test.text = username


    }

}
