package com.skillhub.mapper;

import com.skillhub.domain.Project;
import com.skillhub.dto.ProjectDto;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = UserMapperHelper.class)
public interface ProjectMapper {

    @Mapping(source = "user.id", target = "userId")
    ProjectDto toDto(Project entity);

    @Mapping(target = "user", expression = "java(userMapperHelper.mapUserIdToUser(dto.getUserId()))")
    Project toEntity(ProjectDto dto, @Context UserMapperHelper userMapperHelper);
}