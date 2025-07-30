package com.skillhub.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailsDto {
    private Long id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String role;
}
