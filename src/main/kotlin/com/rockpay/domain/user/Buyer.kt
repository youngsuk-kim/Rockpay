package com.rockpay.domain.user

import com.rockpay.domain.Id

class Buyer(
    id: Id<Buyer> = Id.of(),
    name: String,
    email: String
) {
    var id = id
        private set

    var name: String = name
        private set

    var email: String = email
        private set

    fun changeEmail(newEmail: String): Buyer {
        return of(name = this.name, email = newEmail)
    }

    companion object {
        fun of(name: String, email: String): Buyer {
            return Buyer(name = name, email =  email)
        }
    }
}