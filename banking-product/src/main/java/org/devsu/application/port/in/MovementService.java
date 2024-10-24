package org.devsu.application.port.in;

import org.devsu.application.dto.MovementDTO;
import org.devsu.domain.model.Movement;

import java.time.LocalDate;
import java.util.List;

public interface MovementService {

    List<MovementDTO> findAll();
    Movement finById(Long id);
    MovementDTO update(Long id, MovementDTO dto);
    MovementDTO delete(Long id);
    MovementDTO addMovementToAccount(MovementDTO dto);


    List<MovementDTO> reportByUserBetweenRangeDate(String idCustomer, String starDate, String endDate);
}
