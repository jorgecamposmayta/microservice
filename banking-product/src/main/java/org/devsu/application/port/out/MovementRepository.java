package org.devsu.application.port.out;

import org.devsu.domain.model.Movement;

import java.util.List;
import java.util.Optional;

public interface MovementRepository {
    List<Movement> findAll();
    Optional<Movement> finById(Long id);
    Movement save(Movement cus);
}
