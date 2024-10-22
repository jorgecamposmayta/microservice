package org.devsu.application.mapper;

import org.devsu.application.dto.TypeAccountDTO;
import org.devsu.domain.model.TypeAccount;

public class TypeAccountMapper {

    public static TypeAccountDTO toDTO(TypeAccount ta) {
        return TypeAccountDTO.builder()
                .id(ta.getId())
                .description(ta.getDescription())
                .build();
    }

    public static TypeAccount fromDTO(TypeAccountDTO dto) {
        return new TypeAccount(
                dto.getId(),
                dto.getDescription(),
                null);
    }

    public static TypeAccount fromDtoUpdate(TypeAccountDTO dto, Long id){
        return new TypeAccount(
                id,
                dto.getDescription(),
                null);
    }
}
