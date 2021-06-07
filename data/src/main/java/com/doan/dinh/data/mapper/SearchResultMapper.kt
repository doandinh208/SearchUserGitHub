package com.doan.dinh.data.mapper

import com.doan.dinh.data.model.ResultEntity
import com.doan.dinh.domain.model.SearchModel

object SearchResultMapper {
    fun toDomain(dataRemote: ResultEntity): SearchModel {
        return SearchModel(
                totalCount = dataRemote.totalCount,
                isIncompleteResults = dataRemote.isIncompleteResults,
                items = dataRemote.itemEntities.map { e -> SearchModel.ItemModel(
                        login  = e.login,
                    id = e.id,

                    url = e.url,
                        avatarUrl = e.avatarUrl) }
        )
    }

}