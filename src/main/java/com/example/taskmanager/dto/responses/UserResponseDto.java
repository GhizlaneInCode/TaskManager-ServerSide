package com.example.taskmanager.dto.responses;

import com.example.taskmanager.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserResponseDto {

    private Long id;
    private String username;
    private Role role;
}
