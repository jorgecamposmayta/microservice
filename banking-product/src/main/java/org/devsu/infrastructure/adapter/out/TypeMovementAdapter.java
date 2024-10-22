package org.devsu.infrastructure.adapter.out;

import org.devsu.application.port.out.TypeMovementRepository;
import org.devsu.domain.model.TypeMovement;
import org.devsu.infrastructure.repository.TypeMovementJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TypeMovementAdapter implements TypeMovementRepository {

    private final TypeMovementJpaRepository tmJpa;

    @Autowired
    public TypeMovementAdapter(TypeMovementJpaRepository taJpa) {
        this.tmJpa = taJpa;
    }

    @Override
    public List<TypeMovement> findAll() {
        return tmJpa.findAll();
    }

    @Override
    public Optional<TypeMovement> finById(Long id) {
        return tmJpa.findById(id);
    }

    @Override
    public TypeMovement save(TypeMovement cus) {
        return tmJpa.save(cus);
    }
}
