package org.devsu.application.mapper;

import org.devsu.application.dto.TypeMovementDTO;
import org.devsu.domain.model.TypeMovement;

public class TypeMovementMapper {

    public static TypeMovementDTO toDTO(TypeMovement tm) {
        return TypeMovementDTO.builder()
                .id(tm.getId())
                .description(tm.getDescription())
                .build();
    }

    public static TypeMovement fromDTO(TypeMovementDTO dto) {
        return new TypeMovement(
                dto.getId(),
                dto.getDescription(),
                null);
    }

    public static TypeMovement fromDtoUpdate(TypeMovementDTO dto, Long id){
        return new TypeMovement(
                id,
                dto.getDescription(),
                null);
    }
}
