package com.rockpay.fixture.user

import com.rockpay.domain.user.Buyer

fun buyer(name: String = "구매자1", email: String = "test@rockpay.com"): Buyer {
    return Buyer.of(
        name = name,
        email = email
    )
}
