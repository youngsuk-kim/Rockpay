package com.rockpay.core.fixture.point

import com.rockpay.common.vo.Id
import com.rockpay.core.domain.entity.point.Point
import com.rockpay.core.domain.entity.point.PointBalance
import com.rockpay.core.domain.entity.user.Buyer

fun point(buyerId: Id<Buyer, Long> = Id.of(0), balance: PointBalance = pointBalance()): Point {
    return Point(
        buyerId = buyerId,
        balance = balance
    )
}
