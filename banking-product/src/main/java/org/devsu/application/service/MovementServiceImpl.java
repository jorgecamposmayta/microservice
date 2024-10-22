package org.devsu.application.service;

import org.devsu.application.dto.MovementDTO;
import org.devsu.application.mapper.MovementMapper;
import org.devsu.application.port.in.MovementService;
import org.devsu.application.port.in.TypeMovementService;
import org.devsu.application.port.out.MovementRepository;
import org.devsu.domain.exception.MovementNotFoundException;
import org.devsu.domain.model.Movement;
import org.devsu.domain.model.TypeMovement;
import org.devsu.domain.service.constant.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovementServiceImpl implements MovementService {

    private  final MovementRepository movRepository;
    private final TypeMovementService tmService;
    @Autowired
    public MovementServiceImpl(MovementRepository movRepository, TypeMovementService tmService) {
        this.movRepository = movRepository;
        this.tmService = tmService;
    }

    @Override
    public List<MovementDTO> findAll() {
        return movRepository.findAll().stream()
                .filter(x-> x.getStatus().equals(Constant.MOVEMENT_STATUS_ACTIVE))
                .map(x->{
                    return MovementMapper.toDTO(x);
                }).toList();
    }

    @Override
    public Movement finById(Long id) {
        return movRepository.finById(id)
                .orElseThrow(()-> new MovementNotFoundException(Constant.TYPE_MOVEMENT_NOT_FOUND.concat(" - id: ")+id));
    }

    @Override
    public MovementDTO save(MovementDTO dto) {
        TypeMovement tm=tmService.finById(dto.getTypemovement().getId());
        dto.getTypemovement().setDescription(tm.getDescription());
        Movement mov= MovementMapper.fromDTO(dto);
        return MovementMapper.toDTO(movRepository.save(mov));
    }

    @Override
    public MovementDTO update(Long id, MovementDTO dto) {
        finById(id);
        TypeMovement tm=tmService.finById(dto.getTypemovement().getId());
        dto.getTypemovement().setDescription(tm.getDescription());
        Movement movEntity=MovementMapper.fromDtoUpdate(dto, id);
        return MovementMapper.toDTO(movRepository.save(movEntity));
    }

    @Override
    public MovementDTO delete(Long id) {
        Movement mov=finById(id);
        mov.setStatus(Constant.MOVEMENT_STATUS_INACTIVE);
        return MovementMapper.toDTO(movRepository.save(mov));
    }
}
