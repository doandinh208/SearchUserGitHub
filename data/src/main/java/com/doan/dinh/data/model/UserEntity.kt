package com.doan.dinh.data.model

import com.google.gson.annotations.SerializedName

data class UserEntity(
    var login: String,
    var id: Long?,
    @SerializedName("node_id")
    var nodeId: String?,
    @SerializedName("avatar_url")
    var avatarUrl: String,
    @SerializedName("gravatar_id")
    var gravatar_id: String?,
    var url: String?,
    @SerializedName("html_url")
    var htmlUrl: String?,
    @SerializedName("followers_url")
    var followersUrl: String?,
    @SerializedName("following_url")
    var followingUrl: String?,
    @SerializedName("gists_url")
    var gistsUrl: String?,
    @SerializedName("starred_url")
    var starredUrl: String?,
    var type: String?,
    @SerializedName("site_admin")
    var isSiteAdmin: Boolean?,
    var name: String?,
    var company: String?,
    var blog: String?,
    var location: String?,
    var email: String?,
    @SerializedName("hireable")
    var isHireable: Boolean?,
    var bio: String?,
    var followers: Int?,
    var following: Int?,
)
