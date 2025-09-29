package com.rockpay.core.fixture.user

import com.rockpay.core.domain.entity.user.Buyer

fun buyer(name: String = "구매자1", email: String = "test@rockpay.com"): Buyer {
    return Buyer(
        name = name,
        email = email
    )
}
