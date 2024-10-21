package org.devsu.application.mapper;

import org.devsu.application.dto.CustomerDTO;
import org.devsu.domain.model.Customer;

public class CustomerMapper {

    public static CustomerDTO toDTO(Customer cus){
        return CustomerDTO.builder()
                .id(cus.getId())
                .idCard(cus.getIdCard())
                .name(cus.getName())
                .gender(cus.getGender())
                .age(cus.getAge())
                .address(cus.getAddress())
                .phone(cus.getPhone())
                .password(cus.getPassword())
                .status(cus.getStatus())
                .build();
    }

    public static Customer fromDTO(CustomerDTO dto){
        return new Customer(
                dto.getIdCard(),
                dto.getName(),
                dto.getGender(),
                dto.getAge(),
                dto.getAddress(),
                dto.getPhone(),
                dto.getPassword(),
                dto.getStatus());
    }

    public static Customer fromDtoUpdate(CustomerDTO dto, Long id){
        return new Customer(
                id,
                dto.getIdCard(),
                dto.getName(),
                dto.getGender(),
                dto.getAge(),
                dto.getAddress(),
                dto.getPhone(),
                dto.getPassword(),
                dto.getStatus());
    }
}
