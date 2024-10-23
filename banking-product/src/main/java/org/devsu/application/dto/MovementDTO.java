package org.devsu.application.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
public class MovementDTO {
    private Long id;
    private LocalDate date;
    private Long idAccountNumber;
    private BigDecimal initialBalance;
    private String status;
    private BigDecimal valueMovement;
    private BigDecimal availableBalance;
    private TypeMovementDTO typemovement;
    private AccountDTO account;
}
