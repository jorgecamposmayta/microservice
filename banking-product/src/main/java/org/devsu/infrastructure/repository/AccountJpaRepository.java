package org.devsu.infrastructure.repository;

import org.devsu.domain.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountJpaRepository extends JpaRepository<Account, Long> {
}
