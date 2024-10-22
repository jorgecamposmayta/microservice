package org.devsu.infrastructure.adapter.out;

import org.devsu.application.port.out.MovementRepository;
import org.devsu.domain.model.Movement;
import org.devsu.infrastructure.repository.MovementJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MovementAdapter implements MovementRepository {

    private final MovementJpaRepository mJpa;

    @Autowired
    public MovementAdapter(MovementJpaRepository aJpa) {
        this.mJpa = aJpa;
    }

    @Override
    public List<Movement> findAll() {
        return mJpa.findAll();
    }

    @Override
    public Optional<Movement> finById(Long id) {
        return mJpa.findById(id);
    }

    @Override
    public Movement save(Movement mov) {
        return mJpa.save(mov);
    }
}
