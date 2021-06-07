package com.doan.dinh.domain.model

data class SearchModel(
    var totalCount: Long,
    var isIncompleteResults: Boolean,
    var items: List<ItemModel>
) {
    data class ItemModel(
        var avatarUrl: String?,
        var login: String
    )
}
