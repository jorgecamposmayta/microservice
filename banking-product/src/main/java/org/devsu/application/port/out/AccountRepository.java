package org.devsu.application.port.out;

import org.devsu.domain.model.Account;

import java.util.List;
import java.util.Optional;

public interface AccountRepository {

    List<Account> findAll();
    Optional<Account> finById(Long id);
    Account save(Account cus);
}
