package com.rockpay.core.arch

import com.tngtech.archunit.core.importer.ImportOption
import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses

@AnalyzeClasses(packages = ["com.rockpay"], importOptions = [ImportOption.DoNotIncludeTests::class])
class ArchitectureTest {
    @ArchTest
    fun domainIsolation() =
        noClasses()
            .that()
            .resideInAPackage("..domain..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage(
                "..application..",
                "..infrastructure..",
                "..ui..",
            )
}
