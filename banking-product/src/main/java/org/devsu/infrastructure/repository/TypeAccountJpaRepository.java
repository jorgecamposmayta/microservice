package org.devsu.infrastructure.repository;

import org.devsu.domain.model.TypeAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeAccountJpaRepository extends JpaRepository<TypeAccount, Long> {
}
