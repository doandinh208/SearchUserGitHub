package com.doan.dinh.data.mapper

import com.doan.dinh.data.model.SearchEntity
import com.doan.dinh.data.model.UserEntity
import com.doan.dinh.data.serializer.JSON_DETAIL_TEST
import com.doan.dinh.data.serializer.JSON_SEARCH_TEST
import com.google.gson.Gson
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(org.mockito.junit.MockitoJUnitRunner::class)
class AppEntityJsonMapperTest {

    lateinit var searchEntity: SearchEntity
    lateinit var userEntity: UserEntity

    @Before
    fun setUp() {
        val gson = Gson()
        searchEntity = gson.fromJson(JSON_SEARCH_TEST, SearchEntity::class.java)
        userEntity = gson.fromJson(JSON_DETAIL_TEST, UserEntity::class.java)
    }


    @Test
    fun testTransformSearchResultEntityHappyCase() {
        val resultModel = SearchResultMapper.toDomain(searchEntity)
        Assert.assertThat(resultModel.totalCount, `is`(4238))
        Assert.assertThat(resultModel.isIncompleteResults, `is`(false))
        Assert.assertThat(resultModel.items.size, `is`(2))
        val itemOne = resultModel.items[0]
        Assert.assertThat(
            itemOne.avatarUrl,
            `is`("https://avatars.githubusercontent.com/u/152672?v=4")
        )
        Assert.assertThat(itemOne.login, `is`("doan"))

    }

    @Test
    fun testTransformReposEntityCollectionHappyCase() {
        val resultModel = UserMapper.toDomain(userEntity)
        Assert.assertThat(resultModel.nodeId, `is`("MDQ6VXNlcjIyNzYyMA=="))
        Assert.assertThat(
            resultModel.avatarUrl,
            `is`("https://avatars.githubusercontent.com/u/227620?v=4")
        )
        Assert.assertThat(resultModel.url, `is`("https://api.github.com/users/doanac"))
        Assert.assertThat(resultModel.htmlUrl, `is`("https://github.com/doanac"))
        Assert.assertThat(resultModel.isSiteAdmin, `is`(false))
        Assert.assertThat(resultModel.name, `is`("Andy Doan"))
        Assert.assertThat(resultModel.company, `is`("Foundries.io"))
        Assert.assertThat(resultModel.blog, `is`("https://doanac.github.io/"))
        Assert.assertNull(resultModel.location)
        Assert.assertNull(resultModel.email)

    }

}
