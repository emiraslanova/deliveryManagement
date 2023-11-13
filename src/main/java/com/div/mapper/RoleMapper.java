package com.div.mapper;

import com.div.dto.RoleDto;
import com.div.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    Role toRole(RoleDto roleDto);

    RoleDto toDto(Role role);
}
