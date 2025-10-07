package com.rockpay.api.test

import org.springframework.restdocs.operation.preprocess.OperationRequestPreprocessor
import org.springframework.restdocs.operation.preprocess.OperationResponsePreprocessor
import org.springframework.restdocs.operation.preprocess.Preprocessors

object RestDocsUtils {
    fun requestPreprocessor(): OperationRequestPreprocessor =
        Preprocessors.preprocessRequest(
            Preprocessors
                .modifyUris()
                .scheme("http")
                .host("dev.dodn.io")
                .removePort(),
            Preprocessors.prettyPrint(),
        )

    fun responsePreprocessor(): OperationResponsePreprocessor = Preprocessors.preprocessResponse(Preprocessors.prettyPrint())
}
