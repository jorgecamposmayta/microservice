package org.devsu.application.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TypeAccountDTO {
    private Long id;
    private String description;
}
