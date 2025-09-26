package com.rockpay.fixture.point

import com.rockpay.domain.point.PointBalance

fun pointBalance(value: Long = 0): PointBalance {
    return PointBalance.of(value)
}
