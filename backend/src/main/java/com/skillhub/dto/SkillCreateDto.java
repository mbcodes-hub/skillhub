package com.skillhub.dto;

import com.skillhub.enums.SkillLevel;
import lombok.Data;

@Data
public class SkillCreateDto {

    private String name;
    private SkillLevel level;
    private Long userId;
}
