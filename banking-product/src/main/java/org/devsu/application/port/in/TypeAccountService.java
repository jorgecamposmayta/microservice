package org.devsu.application.port.in;

import org.devsu.application.dto.TypeAccountDTO;
import org.devsu.domain.model.TypeAccount;

import java.util.List;

public interface TypeAccountService {

    List<TypeAccountDTO> findAll();
    TypeAccount finById(Long id);
    TypeAccountDTO save(TypeAccountDTO dto);
    TypeAccountDTO update(Long id, TypeAccountDTO dto);
}
