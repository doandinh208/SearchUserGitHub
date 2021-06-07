
package com.doan.dinh.domain.model

import java.util.Date

data class UserModel (
        var avatarUrl: String?,
    var nodeId: String?,

    var url: String?,
    var htmlUrl: String?,
    var isSiteAdmin: Boolean?,
    var name: String?,
    var company: String?,
    var blog: String?,
    var location: String?,
    var email: String?
)
