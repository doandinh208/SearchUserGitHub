package com.doan.dinh.domain.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class SearchModelTest {
    private lateinit var searchModel: SearchModel

    @Before
    fun setUp() {
        val testItemModel = SearchModel.ItemModel("url", "login")
        val testListItemModel = arrayListOf(testItemModel)
        searchModel = SearchModel(10, false, testListItemModel)
    }

    @Test
    fun testSearchModelConstructorHappyCase() {

        assertThat(searchModel.totalCount).isEqualTo(10)
        assertThat(searchModel.isIncompleteResults).isEqualTo(false)
        assertThat(searchModel.items.size).isEqualTo(1)
        val item = searchModel.items[0]
        assertThat(item.avatarUrl).isEqualTo("url")
        assertThat(item.login).isEqualTo("login")
    }
}
