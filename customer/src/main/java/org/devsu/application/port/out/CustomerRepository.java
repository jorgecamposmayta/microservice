package org.devsu.application.port.out;

import org.devsu.domain.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {
    List<Customer> findAll();
    Optional<Customer> finById(Long id);
    Customer save(Customer cus);
}
