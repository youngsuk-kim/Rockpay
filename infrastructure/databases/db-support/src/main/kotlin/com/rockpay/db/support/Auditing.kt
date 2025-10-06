package com.rockpay.db.core

import jakarta.persistence.Embeddable
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Embeddable
class Auditing (
    createdAt: LocalDateTime = LocalDateTime.MIN,
    updatedAt: LocalDateTime = LocalDateTime.MIN
) {
    @CreationTimestamp
    var createdAt: LocalDateTime = createdAt
        private set

    @UpdateTimestamp
    var updatedAt: LocalDateTime = updatedAt
        private set
}