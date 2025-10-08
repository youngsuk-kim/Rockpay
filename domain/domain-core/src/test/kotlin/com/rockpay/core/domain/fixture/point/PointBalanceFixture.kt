package com.rockpay.core.db.fixture.point

import com.rockpay.core.domain.entity.point.PointBalance

fun pointBalance(value: Long = 0): PointBalance = PointBalance.of(value)
