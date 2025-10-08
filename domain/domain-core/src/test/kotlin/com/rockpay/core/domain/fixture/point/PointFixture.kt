package com.rockpay.core.domain.fixture.point

import com.rockpay.core.db.fixture.point.pointBalance
import com.rockpay.core.domain.entity.point.Point
import com.rockpay.core.domain.entity.point.PointBalance

fun point(
    buyerId: Long = 0L,
    balance: PointBalance = pointBalance(),
): Point =
    Point(
        buyerId = buyerId,
        balance = balance,
    )
