package com.skillhub.mapper;


import com.skillhub.domain.Experience;
import com.skillhub.dto.ExperienceDto;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = UserMapperHelper.class)
public interface ExperienceMapper {

    @Mapping(source = "user.id", target = "userId")
    ExperienceDto toDto(Experience experience);

    @Mapping(target = "user", expression = "java(userMapperHelper.mapUserIdToUser(dto.getUserId()))")
    Experience toEntity(ExperienceDto dto, @Context UserMapperHelper userMapperHelper);

    @Mapping(target = "user", expression = "java(userMapperHelper.mapUserIdToUser(dto.getUserId()))")
    void updateEntityFromDto(ExperienceDto dto, @MappingTarget Experience entity, @Context UserMapperHelper userMapperHelper);

}
