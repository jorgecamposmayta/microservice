package org.devsu.application.mapper;

import org.devsu.application.dto.AccountDTO;
import org.devsu.application.dto.AccountInsideMovementDTO;
import org.devsu.application.dto.TypeAccountDTO;
import org.devsu.domain.model.Account;
import org.devsu.domain.model.TypeAccount;

import java.util.ArrayList;

public class AccountMapper {

    public static AccountDTO toDTO(Account acc) {
        return AccountDTO.builder()
                .id(acc.getId())
                .accountNumber(acc.getAccountNumber())
                .initialBalance(acc.getInitialBalance())
                .status(acc.getStatus())
                .idCustomer(acc.getIdCustomer())
                .typeaccount(TypeAccountMapper.toDTO(acc.getTypeaccount()))
                .listMovement(acc.getListMovement().stream()
                        .map(x->MovementMapper.toDTOInsideAccount(x)).toList())
                .build();
    }
    public static AccountInsideMovementDTO toDTOInsideMovement(Account acc) {
        return AccountInsideMovementDTO.builder()
                .id(acc.getId())
                .accountNumber(acc.getAccountNumber())
                .build();
    }


    public static Account fromDTO(AccountDTO dto) {
        return new Account(
                dto.getId(),
                dto.getAccountNumber(),
                dto.getInitialBalance(),
                dto.getStatus(),
                dto.getIdCustomer(),
                TypeAccountMapper.fromDTO(dto.getTypeaccount()==null?
                        TypeAccountDTO.builder().build():
                        dto.getTypeaccount()),
                dto.getListMovement()==null?new ArrayList<>():
                        dto.getListMovement().stream().map(x->MovementMapper.fromDTOInsideAccount(x)).toList());
    }

    public static Account fromDTOInsideMovement(AccountInsideMovementDTO dto) {
        return new Account(
                dto.getId(),
                dto.getAccountNumber(),
                null,
                "",
                null,
                new TypeAccount(),
                new ArrayList<>());
    }


    public static Account fromDtoUpdate(AccountDTO dto, Long id){
        return new Account(
                id,
                dto.getAccountNumber(),
                dto.getInitialBalance(),
                dto.getStatus(),
                dto.getIdCustomer(),
                TypeAccountMapper.fromDTO(dto.getTypeaccount()==null?
                        TypeAccountDTO.builder().build():
                        dto.getTypeaccount()),
                dto.getListMovement()==null?new ArrayList<>():
                        dto.getListMovement().stream().map(x->MovementMapper.fromDTOInsideAccount(x)).toList());
    }
}
