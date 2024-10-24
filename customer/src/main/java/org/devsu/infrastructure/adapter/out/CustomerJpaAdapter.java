package org.devsu.infrastructure.adapter.out;

import org.devsu.application.port.out.CustomerRepository;
import org.devsu.domain.model.Customer;
import org.devsu.infrastructure.repository.CustomerJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CustomerJpaAdapter implements CustomerRepository {

    private final CustomerJpaRepository cusJpa;

    @Autowired
    public CustomerJpaAdapter(CustomerJpaRepository cusJpa) {
        this.cusJpa = cusJpa;
    }

    @Override
    public List<Customer> findAll() {
        return cusJpa.findAll();
    }

    @Override
    public Optional<Customer> finById(Long id) {
        return cusJpa.findById(id);
    }

    @Override
    public Optional<Customer> findByIdCard(String IdCard) {
        return cusJpa.findByIdCard(IdCard);
    }

    @Override
    public Customer save(Customer cus) {
        return cusJpa.save(cus);
    }
}
