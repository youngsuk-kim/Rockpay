package com.rockpay.core.controller

import com.rockpay.api.test.RestDocsTest
import com.rockpay.api.test.RestDocsUtils.requestPreprocessor
import com.rockpay.api.test.RestDocsUtils.responsePreprocessor
import com.rockpay.core.app.GetProductQueryResult
import com.rockpay.core.app.GetProductService
import io.mockk.every
import io.mockk.mockk
import io.restassured.http.ContentType
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.http.HttpStatus
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document
import org.springframework.restdocs.payload.JsonFieldType
import org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath
import org.springframework.restdocs.payload.PayloadDocumentation.responseFields
import org.springframework.restdocs.request.RequestDocumentation.parameterWithName
import org.springframework.restdocs.request.RequestDocumentation.pathParameters
import org.springframework.restdocs.request.RequestDocumentation.queryParameters

class ProductControllerTest : RestDocsTest() {
    private lateinit var getProductService: GetProductService
    private lateinit var controller: ProductController

    @BeforeEach
    fun setUp() {
        getProductService = mockk()
        controller = ProductController(getProductService)
        mockMvc = mockController(controller)
    }

    @Test
    fun getProduct() {
        every { getProductService.invoke(any<GetProductRequest>()) } returns
            GetProductQueryResult(
                id = 1L,
                name = "Test Product",
                basePrice = "10000",
                salePrice = "8000",
            )

        given()
            .contentType(ContentType.JSON)
            .get("/v1/products/{productId}", 1L)
            .then()
            .status(HttpStatus.OK)
            .apply(
                document(
                    "get-product",
                    requestPreprocessor(),
                    responsePreprocessor(),
                    pathParameters(
                        parameterWithName("productId").description("상품 ID"),
                    ),
                    responseFields(
                        fieldWithPath("id").type(JsonFieldType.NUMBER).description("상품 ID"),
                        fieldWithPath("name").type(JsonFieldType.STRING).description("상품명"),
                        fieldWithPath("basePrice.value").type(JsonFieldType.NUMBER).description("기본 가격"),
                        fieldWithPath("salePrice.value").type(JsonFieldType.NUMBER).description("판매 가격"),
                    ),
                ),
            )
    }

    @Test
    fun getProducts() {
        every { getProductService.invoke(any<GetProductsRequest>()) } returns
            listOf(
                GetProductQueryResult(
                    id = 1L,
                    name = "Test Product 1",
                    basePrice = "10000",
                    salePrice = "8000",
                ),
                GetProductQueryResult(
                    id = 2L,
                    name = "Test Product 2",
                    basePrice = "20000",
                    salePrice = "18000",
                ),
            )

        given()
            .contentType(ContentType.JSON)
            .param("productIds", "1,2")
            .get("/v1/products")
            .then()
            .status(HttpStatus.OK)
            .apply(
                document(
                    "get-products",
                    requestPreprocessor(),
                    responsePreprocessor(),
                    queryParameters(
                        parameterWithName("productIds").description("상품 ID 목록"),
                    ),
                    responseFields(
                        fieldWithPath("[].id").type(JsonFieldType.NUMBER).description("상품 ID"),
                        fieldWithPath("[].name").type(JsonFieldType.STRING).description("상품명"),
                        fieldWithPath("[].basePrice.value").type(JsonFieldType.NUMBER).description("기본 가격"),
                        fieldWithPath("[].salePrice.value").type(JsonFieldType.NUMBER).description("판매 가격"),
                    ),
                ),
            )
    }
}
