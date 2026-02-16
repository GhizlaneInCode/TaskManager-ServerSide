package com.example.taskmanager.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TaskResponseDto {

    private Long id;
    private String title;
    private String description;
    private boolean completed;

}
