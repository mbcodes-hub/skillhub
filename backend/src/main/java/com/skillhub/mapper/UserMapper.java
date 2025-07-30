package com.skillhub.mapper;

import com.skillhub.domain.User;
import com.skillhub.dto.UserCreateDto;
import com.skillhub.dto.UserDetailsDto;
import com.skillhub.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User user);
    UserDetailsDto toDetailsDto(User user);
    User toEntity(UserCreateDto dto);
}
