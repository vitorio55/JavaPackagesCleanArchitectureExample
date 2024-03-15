package com.vitorio.cleanarchitecture.infrastructure.framework.controller;

import com.vitorio.cleanarchitecture.presentation.CompanyControllerLogic;
import com.vitorio.cleanarchitecture.presentation.dto.CalculateCompanyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {

    private final CompanyControllerLogic controllerLogic;

    @Autowired
    public CompanyController(CompanyControllerLogic controllerLogic) {
        this.controllerLogic = controllerLogic;
    }

    @PostMapping("/")
    public String calculateCompany(@RequestBody CalculateCompanyDto dto) {
        return this.controllerLogic.calculateCompany(dto);
    }
}
