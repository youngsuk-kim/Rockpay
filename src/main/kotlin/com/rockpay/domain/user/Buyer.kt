package com.rockpay.domain.user

import com.rockpay.domain.Id

class Buyer(
    id: Id = Id.of(),
    name: String,
    email: String
) {
    var id: Id = id
        private set

    var name: String = name
        private set

    var email: String = email
        private set

    fun changeEmail(newEmail: String): Buyer {
        return of(name = this.name, email = email)
    }

    companion object {
        fun of(name: String, email: String): Buyer {
            return Buyer(name = name, email =  email)
        }
    }
}