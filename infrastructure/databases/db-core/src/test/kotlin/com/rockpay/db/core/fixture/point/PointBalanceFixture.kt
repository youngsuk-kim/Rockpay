package com.rockpay.db.core.fixture.point

import com.rockpay.common.vo.PointBalance

fun pointBalance(value: Long = 0): PointBalance = PointBalance.of(value)
