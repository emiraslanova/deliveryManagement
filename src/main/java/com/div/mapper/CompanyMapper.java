package com.div.mapper;

import com.div.dto.CompanyDto;
import com.div.entity.Company;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompanyMapper {

    Company toCompany(CompanyDto companyDto);
    CompanyDto toCompanyDto(Company company);
}
