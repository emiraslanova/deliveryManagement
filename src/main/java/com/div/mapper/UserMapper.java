package com.div.mapper;

import com.div.dto.UserDto;
import com.div.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(componentModel = "spring")

public interface UserMapper  {
// @Mapping(target = "isEnabled", source = "enabled")
 // @Mapping(target = "id",ignore = true)

  UserDto toDto(User user);


//  @Mapping(target = "isEnabled", source = "isEnabled")
  User toUser(UserDto dto);

  List<UserDto> toUserDtoList(List<User>users);



}
