package org.devsu.application.mapper;

import org.devsu.application.dto.MovementDTO;
import org.devsu.domain.model.Movement;

public class MovementMapper {

    public static MovementDTO toDTO(Movement mov) {
        return MovementDTO.builder()
                .id(mov.getId())
                .date(mov.getDate())
                .idAccountNumber(mov.getIdAccountNumber())
                .initialBalance(mov.getInitialBalance())
                .status(mov.getStatus())
                .valueMovement(mov.getValueMovement())
                .availableBalance(mov.getAvailableBalance())
                .build();
    }

    public static Movement fromDTO(MovementDTO dto) {
        return new Movement(
                dto.getId(),
                dto.getDate(),
                dto.getIdAccountNumber(),
                dto.getInitialBalance(),
                dto.getStatus(),
                dto.getValueMovement(),
                dto.getAvailableBalance(),
                TypeMovementMapper.fromDTO(dto.getTypemovement()));
    }

    public static Movement fromDtoUpdate(MovementDTO dto, Long id){
        return new Movement(
                id,
                dto.getDate(),
                dto.getIdAccountNumber(),
                dto.getInitialBalance(),
                dto.getStatus(),
                dto.getValueMovement(),
                dto.getAvailableBalance(),
                TypeMovementMapper.fromDTO(dto.getTypemovement()));
    }
}
