package com.doan.dinh.doanapplication.di

import com.doan.dinh.doanapplication.di.search.SearchSubComponent
import com.doan.dinh.doanapplication.di.userdetail.DetailsSubComponent

interface DaggerInjector {
    fun createSearchComponent(): SearchSubComponent
    fun createDetailsComponent(): DetailsSubComponent
}