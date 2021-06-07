
package com.doan.dinh.data.model

data class ResultEntity (
    var totalCount: Long,
    var isIncompleteResults: Boolean,
    var itemEntities: List<ItemEntity>
) {
    data class ItemEntity(
        var login: String,
        var id: Long?,
        var nodeId: String?,
        var avatarUrl: String?,
        var gravatarId: String?,
        var url: String?,
        var htmlUrl: String?,
        var followersUrl: String?,
        var followingUrl: String?,
        var gistsUrl: String?,
        var starredUrl: String?,
        var subscriptionsUrl: String?,
        var organizationsUrl: String?
    )
}
