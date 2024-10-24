package org.devsu.infrastructure.repository;

import org.devsu.domain.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerJpaRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByIdCard(String idCard);
}
