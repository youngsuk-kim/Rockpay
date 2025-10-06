package com.rockpay.storage.db.core.fixture.user

import com.rockpay.storage.db.core.entity.user.Buyer

fun buyer(
    name: String = "구매자1",
    email: String = "test@rockpay.com",
): Buyer =
    Buyer(
        name = name,
        email = email,
    )
