package com.rockpay.db.core.fixture.point

import com.rockpay.db.core.entity.point.Point
import com.rockpay.common.vo.PointBalance

fun point(
    buyerId: Long = 0L,
    balance: PointBalance = pointBalance(),
): Point =
    Point(
        buyerId = buyerId,
        balance = balance,
    )
