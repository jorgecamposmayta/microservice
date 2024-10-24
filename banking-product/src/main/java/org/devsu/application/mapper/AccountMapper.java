package org.devsu.application.mapper;

import org.devsu.application.dto.AccountDTO;
import org.devsu.application.dto.AccountInsideMovementDTO;
import org.devsu.application.dto.TypeAccountDTO;
import org.devsu.domain.model.Account;
import org.devsu.domain.model.Movement;
import org.devsu.domain.model.TypeAccount;
import org.devsu.domain.service.constant.Constant;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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

    public static List<AccountDTO> getlistAccountDTO(Optional<Account> optionalAccountA, String starDate, String endDate){
        LocalDate starDateLD = LocalDate.parse(starDate);
        LocalDate endDateLD = LocalDate.parse(endDate);
        List<Movement> listMovement=optionalAccountA.get().getListMovement().stream()
                        .filter(m-> ((m.getDate().isAfter(starDateLD) || m.getDate().isEqual(starDateLD))   && (m.getDate().isBefore(endDateLD) || m.getDate().isEqual(endDateLD)))).toList();
        Account acc =optionalAccountA.get();
        acc.setListMovement(listMovement);
        AccountDTO accDTO=AccountMapper.toDTO(acc);
        List<AccountDTO> listAcc= Arrays.asList(accDTO);
        return listAcc;
    }
}
