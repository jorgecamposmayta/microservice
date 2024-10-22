package org.devsu.infrastructure.adapter.out;

import org.devsu.application.port.out.TypeAccountRepository;
import org.devsu.domain.model.TypeAccount;
import org.devsu.infrastructure.repository.TypeAccountJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TypeAccountAdapter implements TypeAccountRepository {

    private final TypeAccountJpaRepository taJpa;

    @Autowired
    public TypeAccountAdapter(TypeAccountJpaRepository taJpa) {
        this.taJpa = taJpa;
    }

    @Override
    public List<TypeAccount> findAll() {
        return taJpa.findAll();
    }

    @Override
    public Optional<TypeAccount> finById(Long id) {
        return taJpa.findById(id);
    }

    @Override
    public TypeAccount save(TypeAccount cus) {
        return taJpa.save(cus);
    }
}
