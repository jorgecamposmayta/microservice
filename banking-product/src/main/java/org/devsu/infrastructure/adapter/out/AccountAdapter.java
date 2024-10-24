package org.devsu.infrastructure.adapter.out;

import org.devsu.application.port.out.AccountRepository;
import org.devsu.domain.model.Account;
import org.devsu.infrastructure.repository.AccountJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AccountAdapter implements AccountRepository {

    private final AccountJpaRepository aJpa;

    @Autowired
    public AccountAdapter(AccountJpaRepository aJpa) {
        this.aJpa = aJpa;
    }

    @Override
    public List<Account> findAll() {
        return aJpa.findAll();
    }

    @Override
    public Optional<Account> finById(Long id) {
        return aJpa.findById(id);
    }

    @Override
    public Account save(Account acc) {
        return aJpa.save(acc);
    }

}
