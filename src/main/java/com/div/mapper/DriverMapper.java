package com.div.mapper;

import com.div.dto.DriverDto;
import com.div.entity.Driver;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DriverMapper {

    @Mapping(target = "isBusy", source = "busy")
    Driver toDriver (DriverDto driverDto);

    DriverDto toDriverDto(Driver driver);
}
