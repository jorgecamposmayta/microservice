package org.devsu.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountInsideMovementDTO {
    @NotNull
    private Long id;
    @NotNull
    @NotBlank
    @Size(min = 8,max = 12)
    private String accountNumber;
}
