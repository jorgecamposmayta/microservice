package org.devsu.application.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TypeMovementDTO {

    private Long id;
    private String description;

}
