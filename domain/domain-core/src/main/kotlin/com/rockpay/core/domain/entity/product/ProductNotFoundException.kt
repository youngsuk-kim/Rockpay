package com.rockpay.core.domain.entity.product

import com.rockpay.core.domain.exception.CoreException

class ProductNotFoundException : CoreException("상품을 찾을 수 없습니다.")
