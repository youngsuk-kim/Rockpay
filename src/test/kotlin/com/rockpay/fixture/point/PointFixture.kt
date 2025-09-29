package com.rockpay.fixture.point

import com.rockpay.domain.common.Id
import com.rockpay.domain.point.Point
import com.rockpay.domain.point.PointBalance
import com.rockpay.domain.user.Buyer

fun point(buyerId: Id<Buyer> = Id.of(), balance: PointBalance = pointBalance()): Point {
    return Point(
        buyerId = buyerId,
        balance = balance
    )
}
