package com.skillhub.dto;

import lombok.*;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectDto {
    private Long id;
    private String title;
    private String description;
    private String repositoryUrl;
    private String liveDemoUrl;
    private String imageUrl;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private Long userId;
}
