package com.rockpay.storage.db.core.fixture.product

import com.rockpay.storage.db.core.entity.product.Stock

fun stock(value: Int = 0): Stock = Stock(value)
