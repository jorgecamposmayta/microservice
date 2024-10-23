package org.devsu.application.dto;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.springframework.boot.context.properties.bind.DefaultValue;

@Data
@Builder
public class CustomerDTO  {
    private Long id;
    @NotNull
    @NotBlank
    @Size(min = 7,max = 12)
    private String idCard;
    @NotNull
    @NotBlank
    @Size(min = 2, max = 150)
    private String name;

    private String gender;

    @NotNull
    @Min(value = 18, message = "Cliente debe ser mayor de 18 años")
    private Integer age;
    @NotNull
    @NotBlank
    private String address;
    @NotNull
    @NotBlank
    @Size(min = 7,max = 12)
    @Pattern(regexp = "[^0-9]*", message = "Se permite solo numeros y de 7 a 12 digitos")
    private String phone;
    @NotNull
    @NotBlank
    private String password;
    @NotNull
    @NotBlank
    @Size(min = 1,max = 1)
    private String status;

}
