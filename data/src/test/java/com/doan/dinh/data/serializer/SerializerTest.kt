package com.doan.dinh.data.serializer


import com.doan.dinh.data.model.SearchEntity
import com.doan.dinh.data.model.UserEntity
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertNull
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

const val JSON_SEARCH_TEST =
    " {\"total_count\":4238,\"incomplete_results\":false,\"items\":[{\"login\":\"doan\",\"id\":152672,\"node_id\":\"MDQ6VXNlcjE1MjY3Mg==\",\"avatar_url\":\"https://avatars.githubusercontent.com/u/152672?v=4\",\"gravatar_id\":\"\",\"url\":\"https://api.github.com/users/doan\",\"html_url\":\"https://github.com/doan\",\"followers_url\":\"https://api.github.com/users/doan/followers\",\"following_url\":\"https://api.github.com/users/doan/following{/other_user}\",\"gists_url\":\"https://api.github.com/users/doan/gists{/gist_id}\",\"starred_url\":\"https://api.github.com/users/doan/starred{/owner}{/repo}\",\"subscriptions_url\":\"https://api.github.com/users/doan/subscriptions\",\"organizations_url\":\"https://api.github.com/users/doan/orgs\",\"repos_url\":\"https://api.github.com/users/doan/repos\",\"events_url\":\"https://api.github.com/users/doan/events{/privacy}\",\"received_events_url\":\"https://api.github.com/users/doan/received_events\",\"type\":\"User\",\"site_admin\":false,\"score\":1.0},{\"login\":\"doanduyhai\",\"id\":1532977,\"node_id\":\"MDQ6VXNlcjE1MzI5Nzc=\",\"avatar_url\":\"https://avatars.githubusercontent.com/u/1532977?v=4\",\"gravatar_id\":\"\",\"url\":\"https://api.github.com/users/doanduyhai\",\"html_url\":\"https://github.com/doanduyhai\",\"followers_url\":\"https://api.github.com/users/doanduyhai/followers\",\"following_url\":\"https://api.github.com/users/doanduyhai/following{/other_user}\",\"gists_url\":\"https://api.github.com/users/doanduyhai/gists{/gist_id}\",\"starred_url\":\"https://api.github.com/users/doanduyhai/starred{/owner}{/repo}\",\"subscriptions_url\":\"https://api.github.com/users/doanduyhai/subscriptions\",\"organizations_url\":\"https://api.github.com/users/doanduyhai/orgs\",\"repos_url\":\"https://api.github.com/users/doanduyhai/repos\",\"events_url\":\"https://api.github.com/users/doanduyhai/events{/privacy}\",\"received_events_url\":\"https://api.github.com/users/doanduyhai/received_events\",\"type\":\"User\",\"site_admin\":false,\"score\":1.0}]}"

const val JSON_DETAIL_TEST =
    "{\"login\":\"doanac\",\"id\":227620,\"node_id\":\"MDQ6VXNlcjIyNzYyMA==\",\"avatar_url\":\"https://avatars.githubusercontent.com/u/227620?v=4\",\"gravatar_id\":\"\",\"url\":\"https://api.github.com/users/doanac\",\"html_url\":\"https://github.com/doanac\",\"followers_url\":\"https://api.github.com/users/doanac/followers\",\"following_url\":\"https://api.github.com/users/doanac/following{/other_user}\",\"gists_url\":\"https://api.github.com/users/doanac/gists{/gist_id}\",\"starred_url\":\"https://api.github.com/users/doanac/starred{/owner}{/repo}\",\"subscriptions_url\":\"https://api.github.com/users/doanac/subscriptions\",\"organizations_url\":\"https://api.github.com/users/doanac/orgs\",\"repos_url\":\"https://api.github.com/users/doanac/repos\",\"events_url\":\"https://api.github.com/users/doanac/events{/privacy}\",\"received_events_url\":\"https://api.github.com/users/doanac/received_events\",\"type\":\"User\",\"site_admin\":false,\"name\":\"Andy Doan\",\"company\":\"Foundries.io\",\"blog\":\"https://doanac.github.io/\",\"location\":null,\"email\":null,\"hireable\":null,\"bio\":null,\"twitter_username\":null,\"public_repos\":88,\"public_gists\":1,\"followers\":11,\"following\":1,\"created_at\":\"2010-03-22T03:10:34Z\",\"updated_at\":\"2021-06-04T14:23:46Z\"}";

@RunWith(MockitoJUnitRunner::class)
class SerializerTest {

    lateinit var gson: Gson

    @Before
    fun setUp() {
        gson = Gson()
    }

    @get: Rule
    val expectedException: ExpectedException = ExpectedException.none()

    @Test
    fun testSerializeResultSearchHappyCase() {
        val resultEntity = gson.fromJson(JSON_SEARCH_TEST, SearchEntity::class.java)

        assertThat(resultEntity.totalCount, `is`(4238))
        assertThat(resultEntity.isIncompleteResults, `is`(false))
        assertThat(resultEntity.items.size, `is`(2))
        val itemOne = resultEntity.items[0]
        assertThat(itemOne.avatarUrl, `is`("https://avatars.githubusercontent.com/u/152672?v=4"))
        assertThat(itemOne.login, `is`("doan"))
    }

    @Test
    fun testSerializeUserDetailHappyCase() {
        val userEntity = gson.fromJson(JSON_DETAIL_TEST, UserEntity::class.java)

        assertThat(userEntity.login, `is`("doanac"))
        assertThat(userEntity.id, `is`(227620))
        assertThat(userEntity.nodeId, `is`("MDQ6VXNlcjIyNzYyMA=="))
        assertThat(userEntity.avatarUrl, `is`("https://avatars.githubusercontent.com/u/227620?v=4"))
        assertThat(userEntity.gravatar_id, `is`(""))
        assertThat(userEntity.url, `is`("https://api.github.com/users/doanac"))
        assertThat(userEntity.htmlUrl, `is`("https://github.com/doanac"))
        assertThat(userEntity.followersUrl, `is`("https://api.github.com/users/doanac/followers"))
        assertThat(
            userEntity.followingUrl,
            `is`("https://api.github.com/users/doanac/following{/other_user}")
        )
        assertThat(userEntity.gistsUrl, `is`("https://api.github.com/users/doanac/gists{/gist_id}"))
        assertThat(
            userEntity.starredUrl,
            `is`("https://api.github.com/users/doanac/starred{/owner}{/repo}")
        )
        assertThat(userEntity.type, `is`("User"))
        assertThat(userEntity.isSiteAdmin, `is`(false))
        assertThat(userEntity.name, `is`("Andy Doan"))
        assertThat(userEntity.company, `is`("Foundries.io"))
        assertThat(userEntity.blog, `is`("https://doanac.github.io/"))
        assertNull(userEntity.location)
        assertNull(userEntity.email)
        assertNull(userEntity.isHireable)
        assertNull(userEntity.bio)
        assertThat(userEntity.followers, `is`(11))
        assertThat(userEntity.following, `is`(1))
    }

    @Test
    fun testTransformSearchEntityNotValidResponse() {
        expectedException.expect(JsonSyntaxException::class.java)
        gson.fromJson("Hello!", SearchEntity::class.java)
    }

    @Test
    fun testTransformUserEntityCollectionNotValidResponse() {
        expectedException.expect(JsonSyntaxException::class.java)
        gson.fromJson("How are you?", UserEntity::class.java)
    }


}
