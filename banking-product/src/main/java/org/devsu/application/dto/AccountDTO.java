package org.devsu.application.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class AccountDTO {
    private Long id;
    private String accountNumber;
    private BigDecimal initialBalance;
    private String status;
    private Long idCustomer;
    private TypeAccountDTO typeaccount;//validacion no nulo
}
