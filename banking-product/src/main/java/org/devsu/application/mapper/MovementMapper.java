package org.devsu.application.mapper;

import org.devsu.application.dto.MovementInsideAccountDTO;
import org.devsu.application.dto.MovementDTO;
import org.devsu.application.dto.TypeMovementDTO;
import org.devsu.domain.model.Account;
import org.devsu.domain.model.Movement;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MovementMapper {

    public static MovementDTO toDTO(Movement mov) {
        return MovementDTO.builder()
                .id(mov.getId())
                .date(mov.getDate())
                .initialBalance(mov.getInitialBalance())
                .status(mov.getStatus())
                .valueMovement(mov.getValueMovement())
                .availableBalance(mov.getAvailableBalance())
                .typemovement(TypeMovementMapper.toDTO(mov.getTypemovement()))
                .account(AccountMapper.toDTOInsideMovement(mov.getAccount()))
                .build();
    }

    public static MovementInsideAccountDTO toDTOInsideAccount(Movement mov) {
        return MovementInsideAccountDTO.builder()
                .id(mov.getId())
                .date(mov.getDate())
                .initialBalance(mov.getInitialBalance())
                .status(mov.getStatus())
                .valueMovement(mov.getValueMovement())
                .availableBalance(mov.getAvailableBalance())
                .typemovement(TypeMovementMapper.toDTO(mov.getTypemovement()))
                .build();
    }

    public static Movement fromDTO(MovementDTO dto) {
        return new Movement(
                dto.getId(),
                LocalDate.now(),
                dto.getInitialBalance(),
                dto.getStatus(),
                dto.getValueMovement(),
                dto.getAvailableBalance(),
                TypeMovementMapper.fromDTO(dto.getTypemovement()),
                dto.getAccount()==null?new Account():// si movement no tiene cuenta asociada devolver error
                        AccountMapper.fromDTOInsideMovement(dto.getAccount()));
    }

    public static Movement fromDTOInsideAccount(MovementInsideAccountDTO dto) {
        return new Movement(
                dto.getId(),
                dto.getDate(),
                dto.getInitialBalance(),
                dto.getStatus(),
                dto.getValueMovement(),
                dto.getAvailableBalance(),
                TypeMovementMapper.fromDTO(dto.getTypemovement()),
                new Account());
    }


    public static Movement fromDtoUpdate(MovementDTO dto, Long id){
        return new Movement(
                id,
                dto.getDate(),
                dto.getInitialBalance(),
                dto.getStatus(),
                dto.getValueMovement(),
                dto.getAvailableBalance(),
                TypeMovementMapper.fromDTO(dto.getTypemovement()),
                dto.getAccount()==null?new Account():
                        AccountMapper.fromDTOInsideMovement(dto.getAccount()));
    }


    public static MovementDTO toDTOComplete(MovementDTO dto, BigDecimal availableBalance, TypeMovementDTO tm, String accountNumber, BigDecimal initialBalance ) {
        dto.setAvailableBalance(availableBalance);
        dto.getTypemovement().setDescription(tm.getDescription());
        dto.getTypemovement().setId(tm.getId());
        dto.getAccount().setAccountNumber(accountNumber);
        dto.setInitialBalance(initialBalance);
        return dto;
    }
}
