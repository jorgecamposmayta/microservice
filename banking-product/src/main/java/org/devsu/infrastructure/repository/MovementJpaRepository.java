package org.devsu.infrastructure.repository;

import org.devsu.domain.model.Movement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovementJpaRepository extends JpaRepository<Movement, Long> {
}
