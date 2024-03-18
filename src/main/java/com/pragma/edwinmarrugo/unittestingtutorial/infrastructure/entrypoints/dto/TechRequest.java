package com.pragma.edwinmarrugo.unittestingtutorial.infrastructure.entrypoints.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class TechRequest {
    @NotBlank(message = "id cannot be blank")
    @NotNull(message = "id cannot be null")
    private String id;
    @NotNull(message = "name cannot be null")
    @NotBlank(message = "name cannot be blank")
    @Size(max = 50, message = "name must be less than or equal to 50 characters")
    private String name;
    @NotNull(message = "name cannot be null")
    @NotBlank(message = "name cannot be blank")
    @Size(max = 50, message = "name must be less than or equal to 50 characters")
    private String description;
}
