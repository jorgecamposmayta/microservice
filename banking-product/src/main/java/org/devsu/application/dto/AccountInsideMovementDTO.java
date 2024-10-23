package org.devsu.application.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountInsideMovementDTO {
    private Long id;
    private String accountNumber;
}
