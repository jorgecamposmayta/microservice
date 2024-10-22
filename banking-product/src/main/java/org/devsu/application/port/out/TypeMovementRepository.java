package org.devsu.application.port.out;

import org.devsu.domain.model.TypeMovement;

import java.util.List;
import java.util.Optional;

public interface TypeMovementRepository {
    List<TypeMovement> findAll();
    Optional<TypeMovement> finById(Long id);
    TypeMovement save(TypeMovement cus);

}
