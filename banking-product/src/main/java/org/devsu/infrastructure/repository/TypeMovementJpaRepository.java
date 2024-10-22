package org.devsu.infrastructure.repository;

import org.devsu.domain.model.TypeMovement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeMovementJpaRepository extends JpaRepository<TypeMovement, Long> {
}
