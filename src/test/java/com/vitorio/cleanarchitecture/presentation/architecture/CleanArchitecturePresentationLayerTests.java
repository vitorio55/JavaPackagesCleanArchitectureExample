package com.vitorio.cleanarchitecture.presentation.architecture;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.vitorio.cleanarchitecture.util.ArchitectureTests;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

@AnalyzeClasses(packages = "com.vitorio.cleanarchitecture", importOptions = ImportOption.DoNotIncludeTests.class)
class CleanArchitecturePresentationLayerTests extends ArchitectureTests {

    @ArchTest
    static final ArchRule should_respect_layer_dependencies_regarding_presentation_layer = layeredArchitecture()
        .consideringAllDependencies()
        .layer(domainLayer).definedBy(BASE_PACKAGE + ".domain..")
        .layer(useCaseLayer).definedBy(BASE_PACKAGE + ".usecase..")
        .layer(presentationLayer).definedBy(BASE_PACKAGE + ".presentation..")
        .layer(infrastructureLayer).definedBy(BASE_PACKAGE + ".infrastructure..")

        .whereLayer(presentationLayer).mayOnlyBeAccessedByLayers(infrastructureLayer);

}
