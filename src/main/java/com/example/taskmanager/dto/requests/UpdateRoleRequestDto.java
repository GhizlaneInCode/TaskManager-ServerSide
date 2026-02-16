package com.example.taskmanager.dto.requests;

import com.example.taskmanager.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UpdateRoleRequestDto {

    private Role role;
}
