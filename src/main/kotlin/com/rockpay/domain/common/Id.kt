package com.rockpay.domain.common

@JvmInline
value class Id<T>(val value: Long) {
    companion object {
        fun <T> of(id: Long = 0L) = Id<T>(id)
    }
}