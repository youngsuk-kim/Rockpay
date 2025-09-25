package com.rockpay.domain

@JvmInline
value class Id(val value: Long) {
    companion object {
        fun of(id: Long = 0L) = Id(id)
    }
}