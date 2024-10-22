package org.devsu.infrastructure.repository;

import org.devsu.domain.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountJpaRepository extends JpaRepository<Account, Long> {
}
