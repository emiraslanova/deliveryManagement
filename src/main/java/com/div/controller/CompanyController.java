package com.div.controller;

import com.div.dto.CompanyDto;
import com.div.service.CompanyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    private  final CompanyService companyService;
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping
    public CompanyDto creatCompany(@RequestBody CompanyDto companyDto){
        return companyService.creatCompany(companyDto);
    }

    @GetMapping
    public List<CompanyDto> getAllCompany(){
        return companyService.getAllCompany();
    }

    @GetMapping("/{id}")
    public  CompanyDto getCompanyById(@PathVariable Long id){
        return companyService.getCompanyById(id);
    }

    @PutMapping("/{id}")

    public void updateCompany(@PathVariable Long id,@RequestBody CompanyDto companyDto){
        companyService.updateCompany(id,companyDto);
    }

    @DeleteMapping("/{id}")

    public  void deleteCompany(@PathVariable Long id){

        companyService.deleteCompany(id);
    }
}
