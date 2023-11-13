package com.div.service;

import com.div.dto.DriverDto;
import com.div.entity.Driver;
import com.div.mapper.DriverMapper;
import com.div.repository.DriverRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DriverService {

    private  final DriverRepository driverRepository;
    private  final DriverMapper driverMapper;

    public DriverService(DriverRepository driverRepository, DriverMapper driverMapper) {
        this.driverRepository = driverRepository;
        this.driverMapper = driverMapper;
    }

    public DriverDto creatDriver(DriverDto driverDto) {
        Driver driver =  driverMapper.toDriver(driverDto);
        Driver savedDriver=driverRepository.save(driver);
        return driverMapper.toDriverDto(savedDriver);
    }

    public List<DriverDto> getAllDriver() {
        List<Driver>all =driverRepository.findAll();
        List<DriverDto>driverDtoList = all.stream()
                .map(driverMapper::toDriverDto)
                .collect(Collectors.toList());
        return driverDtoList;
    }

    public DriverDto getDriverById(Long id) {
        Driver driver = driverRepository.findById(id).orElse(null);
        return driverMapper.toDriverDto(driver);
    }

    public void updateDriver(Long id, DriverDto driverDto) {
        Optional<Driver>optionalDriver = driverRepository.findById(id);
        if (optionalDriver.isPresent()){
            Driver oldDriver = optionalDriver.get();
            oldDriver.setBusy(driverDto.isBusy());
            driverRepository.save(oldDriver);
        }

    }

    public void deleteDriver(Long id) {
        driverRepository.deleteById(id);

    }
}
