package com.doan.dinh.doanapplication.di

import com.doan.dinh.doanapplication.di.search.SearchSubComponent

interface DaggerInjector {
    fun createSearchComponent(): SearchSubComponent
}