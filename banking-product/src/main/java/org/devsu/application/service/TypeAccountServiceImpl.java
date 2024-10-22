package org.devsu.application.service;

import org.devsu.application.dto.TypeAccountDTO;
import org.devsu.application.mapper.TypeAccountMapper;
import org.devsu.application.port.in.TypeAccountService;
import org.devsu.application.port.out.TypeAccountRepository;
import org.devsu.domain.exception.TypeAccountNotFoundException;
import org.devsu.domain.model.TypeAccount;
import org.devsu.domain.service.constant.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeAccountServiceImpl  implements TypeAccountService {

    private  final TypeAccountRepository taRepository;

    @Autowired
    public TypeAccountServiceImpl(TypeAccountRepository taRepo) {
        this.taRepository = taRepo;
    }

    @Override
    public List<TypeAccountDTO> findAll() {
        return taRepository.findAll().stream()
                .map(x->{
                    return TypeAccountMapper.toDTO(x);
                }).toList();
    }

    @Override
    public TypeAccount finById(Long id) {
        return taRepository.finById(id)
                .orElseThrow(()-> new TypeAccountNotFoundException(Constant.TYPE_ACCOUNT_NOT_FOUND.concat(" - id: ")+id));
    }

    @Override
    public TypeAccountDTO save(TypeAccountDTO dto) {
        TypeAccount ta=TypeAccountMapper.fromDTO(dto);
        return TypeAccountMapper.toDTO(taRepository.save(ta));
    }

    @Override
    public TypeAccountDTO update(Long id, TypeAccountDTO dto) {
        finById(id);
        TypeAccount taEntity=TypeAccountMapper.fromDtoUpdate(dto, id);
        return TypeAccountMapper.toDTO(taRepository.save(taEntity));
    }

}
