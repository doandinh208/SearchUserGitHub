package com.doan.dinh.data.model

import com.google.gson.annotations.SerializedName

data class SearchEntity(
    @SerializedName("total_count")
    var totalCount: Long,
    @SerializedName("incomplete_results")
    var isIncompleteResults: Boolean,
    var items: List<ItemEntity>
) {
    data class ItemEntity(
        var login: String?,
        @SerializedName("avatar_url")
        var avatarUrl: String?,
    )
}
