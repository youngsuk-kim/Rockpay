package com.rockpay.core.domain.entity.user

import com.rockpay.common.vo.Id

class Buyer(
    val id: Id<Buyer, Long> = Id.of(0L),
    val name: String,
    var email: String
) {
    fun updateEmail(newEmail: String) {
        this.email = newEmail
    }
}
