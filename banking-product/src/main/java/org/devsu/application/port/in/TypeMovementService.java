package org.devsu.application.port.in;

import org.devsu.application.dto.TypeMovementDTO;
import org.devsu.domain.model.TypeMovement;

import java.util.List;

public interface TypeMovementService {

    List<TypeMovementDTO> findAll();
    TypeMovement finById(Long id);
    TypeMovementDTO save(TypeMovementDTO dto);
    TypeMovementDTO update(Long id, TypeMovementDTO dto);
}
