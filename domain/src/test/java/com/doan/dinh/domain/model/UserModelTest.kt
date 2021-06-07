package com.doan.dinh.domain.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class UserModelTest {


    private lateinit var userModel: UserModel

    @Before
    fun setUp() {
        userModel = UserModel(
                "testUrl",
                "nodeId",
                "url",
                "htmlUrl",
                true,
                "testName",
                "company",
                "blog",
                "location",
                "testEmail"
        )
    }

    @Test
    fun testAuthorConstructorHappyCase() {

        assertThat(userModel.avatarUrl).isEqualTo("testUrl")
        assertThat(userModel.name).isEqualTo("testName")
        assertThat(userModel.url).isEqualTo("url")
        assertThat(userModel.email).isEqualTo("testEmail")
        assertThat(userModel.htmlUrl).isEqualTo("htmlUrl")
        assertThat(userModel.isSiteAdmin).isEqualTo(true)
        assertThat(userModel.blog).isEqualTo("blog")
        assertThat(userModel.company).isEqualTo("company")
        assertThat(userModel.location).isEqualTo("location")
        assertThat(userModel.nodeId).isEqualTo("nodeId")
    }
}
