package org.devsu.application.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TypeMovementDTO {

    @NotNull
    private Long id;
    private String description;

}
