package com.rockpay.domain.common

data class Id<T, V>(val value: V) {
    companion object {
        fun <T> of(): Id<T, Long> {
            return Id(0L)
        }
    }
}
