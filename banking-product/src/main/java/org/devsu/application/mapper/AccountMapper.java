package org.devsu.application.mapper;

import org.devsu.application.dto.AccountDTO;
import org.devsu.domain.model.Account;

public class AccountMapper {

    public static AccountDTO toDTO(Account acc) {
        return AccountDTO.builder()
                .id(acc.getId())
                .initialBalance(acc.getInitialBalance())
                .status(acc.getStatus())
                .idCustomer(acc.getIdCustomer())
                .typeaccount(TypeAccountMapper.toDTO(acc.getTypeaccount()))
                .build();
    }

    public static Account fromDTO(AccountDTO dto) {
        return new Account(
                dto.getId(),
                dto.getInitialBalance(),
                dto.getStatus(),
                dto.getIdCustomer(),
                TypeAccountMapper.fromDTO(dto.getTypeaccount()));
    }

    public static Account fromDtoUpdate(AccountDTO dto, Long id){
        return new Account(
                id,
                dto.getInitialBalance(),
                dto.getStatus(),
                dto.getIdCustomer(),
                TypeAccountMapper.fromDTO(dto.getTypeaccount()));
    }
}
