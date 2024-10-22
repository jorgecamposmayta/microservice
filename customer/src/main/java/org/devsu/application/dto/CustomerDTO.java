package org.devsu.application.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerDTO  {
    private Long id;
    private String idCard;
    private String name;
    private String gender;

    //validacion mayor 18
    private Integer age;
    private String address;
    private String phone;
    private String password;
    private String status;

}
