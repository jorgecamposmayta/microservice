package org.devsu.application.service;

import org.devsu.application.dto.TypeMovementDTO;
import org.devsu.application.mapper.TypeMovementMapper;
import org.devsu.application.port.in.TypeMovementService;
import org.devsu.application.port.out.TypeMovementRepository;
import org.devsu.domain.exception.TypeMovementNotFoundException;
import org.devsu.domain.model.TypeMovement;
import org.devsu.domain.service.constant.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeMovementServiceImpl implements TypeMovementService {

    private  final TypeMovementRepository tmRepository;

    @Autowired
    public TypeMovementServiceImpl(TypeMovementRepository tmRepo) {
        this.tmRepository = tmRepo;
    }

    @Override
    public List<TypeMovementDTO> findAll() {
        return tmRepository.findAll().stream()
                .map(x->{
                    return TypeMovementMapper.toDTO(x);
                }).toList();
    }

    @Override
    public TypeMovement finById(Long id) {
        return tmRepository.finById(id)
                .orElseThrow(()-> new TypeMovementNotFoundException(Constant.TYPE_MOVEMENT_NOT_FOUND.concat(" - id: ")+id));
    }

    @Override
    public TypeMovementDTO save(TypeMovementDTO dto) {
        TypeMovement tm=TypeMovementMapper.fromDTO(dto);
        return TypeMovementMapper.toDTO(tmRepository.save(tm));
    }

    @Override
    public TypeMovementDTO update(Long id, TypeMovementDTO dto) {
        finById(id);
        TypeMovement tmEntity=TypeMovementMapper.fromDtoUpdate(dto, id);
        return TypeMovementMapper.toDTO(tmRepository.save(tmEntity));
    }

}
