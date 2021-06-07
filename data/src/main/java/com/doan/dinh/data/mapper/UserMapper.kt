package com.doan.dinh.data.mapper

import com.doan.dinh.data.model.UserEntity
import com.doan.dinh.domain.model.UserModel

object UserMapper {

    fun toDomain(dataRemote: UserEntity): UserModel {
        return UserModel(
               avatarUrl = dataRemote.avatarUrl,
        nodeId= dataRemote.nodeId,
        url= dataRemote.url,
        htmlUrl= dataRemote.htmlUrl,
        reposUrl= dataRemote.reposUrl,
        isSiteAdmin= dataRemote.isSiteAdmin,
        name= dataRemote.name,
        company= dataRemote.company,
        blog= dataRemote.blog,
        location= dataRemote.location,
        email= dataRemote.email
        )
    }

}