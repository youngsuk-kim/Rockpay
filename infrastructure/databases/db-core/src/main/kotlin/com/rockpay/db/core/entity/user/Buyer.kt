package com.rockpay.db.core.entity.user

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "buyer")
class Buyer(
    id: Long = 0L,
    name: String,
    email: String,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = id
        private set
    var name: String = name
        private set
    var email: String = email
        private set

    fun updateEmail(newEmail: String) {
        this.email = newEmail
    }
}
