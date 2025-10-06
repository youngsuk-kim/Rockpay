package com.rockpay.db.core.entity.product

import com.rockpay.common.enums.product.PromotionStatus
import com.rockpay.common.vo.Price
import com.rockpay.db.core.Auditing
import jakarta.persistence.Column
import jakarta.persistence.Embedded
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "promotion")
class Promotion(
    id: Long = 0L,
    name: String,
    promotionalPrice: Price,
    startedAt: LocalDateTime,
    endedAt: LocalDateTime,
    status: PromotionStatus = PromotionStatus.PENDING,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id = id
        private set

    @Column
    var name: String = name
        private set

    @Column
    var promotionalPrice: Price = promotionalPrice
        private set

    @Column
    var status: PromotionStatus = status
        private set

    @Column
    var startedAt: LocalDateTime = startedAt
        private set

    @Column
    var endedAt: LocalDateTime = endedAt
        private set

    @Embedded
    var auditing: Auditing = Auditing()
        private set

    fun markAsInProgress() {
        this.status = PromotionStatus.IN_PROGRESS
    }

    fun markAsCompleted() {
        this.status = PromotionStatus.FINISHED
    }
}
