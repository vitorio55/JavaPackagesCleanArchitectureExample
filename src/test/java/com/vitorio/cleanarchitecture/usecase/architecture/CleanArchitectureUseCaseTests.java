package com.vitorio.cleanarchitecture.usecase.architecture;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import com.vitorio.cleanarchitecture.util.ArchitectureTests;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

class CleanArchitectureUseCaseTests extends ArchitectureTests {

    @Test
    void architecture_should_respect_layer_dependencies() {
        JavaClasses jc = new ClassFileImporter().importPackages(BASE_PACKAGE);

        ArchRule r1 = classes()
            .that()
            .resideInAPackage("..usecase..")
            .should().onlyDependOnClassesThat()
            .resideInAnyPackage(getExpectedDependencyPackagesList());

        r1.check(jc);
    }

    private String[] getExpectedDependencyPackagesList() {
        List<String> finalList = new ArrayList<>();

        List<String> applicationPackages = List.of("..usecase..", "..domain..", "..util..");

        List<String> javaBasePackages = List.of("java.lang", "java.io");
        List<String> junitPackages = List.of("org.junit", "org.junit.jupiter.api");
        List<String> archUnitPackages = List.of(
            "com.tngtech.archunit.lang", "com.tngtech.archunit.core.importer", "com.tngtech.archunit.lang.syntax",
            "com.tngtech.archunit.lang.syntax.elements"
        );

        finalList.addAll(applicationPackages);
        finalList.addAll(javaBasePackages);
        finalList.addAll(junitPackages);
        finalList.addAll(archUnitPackages);
        return finalList.toArray(new String[]{});
    }
}
