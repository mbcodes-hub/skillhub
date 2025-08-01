package com.skillhub.mapper;


import com.skillhub.domain.Skill;
import com.skillhub.dto.SkillDto;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = UserMapperHelper.class)
public interface SkillMapper {

    @Mapping(source = "user.id", target = "userId")
    SkillDto toDto(Skill skill);

    @Mapping(target = "user", expression = "java(userMapperHelper.mapUserIdToUser(dto.getUserId()))")
    Skill toEntity(SkillDto dto, @Context UserMapperHelper userMapperHelper);

    @Mapping(target = "user", expression = "java(userMapperHelper.mapUserIdToUser(dto.getUserId()))")
    void updateEntityFromDto(SkillDto dto, @MappingTarget Skill entity, @Context UserMapperHelper userMapperHelper);
}
