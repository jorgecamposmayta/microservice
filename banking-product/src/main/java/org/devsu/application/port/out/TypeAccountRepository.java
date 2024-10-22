package org.devsu.application.port.out;

import org.devsu.domain.model.TypeAccount;

import java.util.List;
import java.util.Optional;

public interface TypeAccountRepository {

    List<TypeAccount> findAll();
    Optional<TypeAccount> finById(Long id);
    TypeAccount save(TypeAccount cus);

}
