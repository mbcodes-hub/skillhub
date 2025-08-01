package com.skillhub.dto;


import com.skillhub.enums.SkillLevel;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SkillDto {

    private Long id;
    private String name;
    private SkillLevel level;
    private Long userId;
}
