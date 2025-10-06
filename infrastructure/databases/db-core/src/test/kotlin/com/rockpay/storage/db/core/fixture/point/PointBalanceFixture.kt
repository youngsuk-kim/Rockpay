package com.rockpay.storage.db.core.fixture.point

import com.rockpay.storage.db.core.entity.point.PointBalance

fun pointBalance(value: Long = 0): PointBalance = PointBalance.of(value)
