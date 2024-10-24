package org.devsu.application.dto;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
public class MovementDTO {
    private Long id;
    private LocalDate date;
    @NotNull
    private BigDecimal initialBalance;
    @NotNull
    @NotBlank
    @Size(min = 1,max = 1)
    @Pattern(regexp = "^[AI]+$", message = "Se permite letras A o I ")
    private String status;
    @NotNull
    private BigDecimal valueMovement;
    private BigDecimal availableBalance;
    @NotNull
    private TypeMovementDTO typemovement;
    @NotNull
    private AccountInsideMovementDTO account;
}
