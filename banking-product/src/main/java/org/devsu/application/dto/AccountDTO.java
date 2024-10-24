package org.devsu.application.dto;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class AccountDTO {

    private Long id;
    @NotNull
    @NotBlank
    @Size(min = 8,max = 12)
    private String accountNumber;
    @NotNull
    @Min(0)
    private BigDecimal initialBalance;
    @NotNull
    @NotBlank
    @Size(min = 1,max = 1)
    @Pattern(regexp = "^[AI]+$", message = "Se permite letras A o I ")
    private String status;
    @NotNull
    private Long idCustomer;

    @NotNull
    private TypeAccountDTO typeaccount;//validacion no nulo
    private List<MovementInsideAccountDTO> listMovement;
}
