package com.rockpay.common.vo

data class Id<T, V>(
    val value: V,
) {
    companion object {
        fun <T, V> of(value: V) = Id<T, V>(value)

        fun <V> ofExternal(value: V): ExternalId<V> = Id(value)
    }
}

typealias ExternalId<V> = Id<Any, V>
