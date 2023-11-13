package com.div.service;

import com.div.dto.CompanyDto;
import com.div.entity.Company;
import com.div.mapper.CompanyMapper;
import com.div.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CompanyService {

    private  final CompanyRepository companyRepository;
    private  final CompanyMapper companyMapper;

    public CompanyService(CompanyRepository companyRepository, CompanyMapper companyMapper) {
        this.companyRepository = companyRepository;
        this.companyMapper = companyMapper;
    }


    public CompanyDto creatCompany(CompanyDto companyDto) {
        Company company = companyMapper.toCompany(companyDto);
        Company savedCompany=companyRepository.save(company);
        return companyMapper.toCompanyDto(savedCompany);
    }

    public List<CompanyDto> getAllCompany() {
        List<Company> all = companyRepository.findAll();
        List<CompanyDto>companyDtoList =all.stream()
                .map(companyMapper::toCompanyDto)
                .collect(Collectors.toList());
        return companyDtoList;
    }

    public CompanyDto getCompanyById(Long id) {
        Company company = companyRepository.findById(id).orElse(null);
        return companyMapper.toCompanyDto(company);
    }

    public void updateCompany(Long id, CompanyDto companyDto) {

        Optional<Company>companyOptional=companyRepository.findById(id);
        if (companyOptional.isPresent()){
            Company oldCompany = companyOptional.get();
            oldCompany.setName(companyDto.getName());
            oldCompany.setDesc(companyDto.getDesc());
            oldCompany.setTotalBudget(companyDto.getTotalBudget());
            companyRepository.save(oldCompany);
        }
    }

    public void deleteCompany(Long id) {

        companyRepository.deleteById(id);

    }
}
