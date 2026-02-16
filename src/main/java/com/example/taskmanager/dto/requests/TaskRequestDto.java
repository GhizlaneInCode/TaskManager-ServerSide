package com.example.taskmanager.dto.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TaskRequestDto {

    @NotBlank(message = "Title is required")
    private String title;

    private String description;
    private Boolean Completed;
}
