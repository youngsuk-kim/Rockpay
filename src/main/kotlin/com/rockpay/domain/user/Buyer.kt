package com.rockpay.domain.user

import com.rockpay.domain.common.Id

class Buyer(
    id: Id<Buyer, Long> = Id.of(),
    name: String,
    email: String
) {
    var id = id
        private set

    var name: String = name
        private set

    var email: String = email
        private set

    fun updateEmail(newEmail: String) {
        this.email = newEmail
    }

    companion object {
        fun of(name: String, email: String): Buyer {
            return Buyer(name = name, email = email)
        }
    }
}