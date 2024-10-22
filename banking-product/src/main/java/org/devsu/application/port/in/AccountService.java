package org.devsu.application.port.in;

import org.devsu.application.dto.AccountDTO;
import org.devsu.domain.model.Account;

import java.util.List;

public interface AccountService {

    List<AccountDTO> findAll();
    Account finById(Long id);
    AccountDTO save(AccountDTO dto);
    AccountDTO update(Long id, AccountDTO dto);
    AccountDTO delete(Long id);
}
