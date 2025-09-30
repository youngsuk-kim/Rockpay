package com.rockpay.storage.db.core.fixture.point

import com.rockpay.common.vo.Id
import com.rockpay.storage.db.core.entity.point.Point
import com.rockpay.storage.db.core.entity.point.PointBalance
import com.rockpay.storage.db.core.entity.user.Buyer

fun point(
    buyerId: Id<Buyer, Long> = Id.of(0),
    balance: PointBalance = pointBalance(),
): Point =
    Point(
        buyerId = buyerId,
        balance = balance,
    )
