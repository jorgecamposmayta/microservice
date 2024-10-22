package org.devsu.application.service;

import org.devsu.application.dto.AccountDTO;
import org.devsu.application.mapper.AccountMapper;
import org.devsu.application.port.in.AccountService;
import org.devsu.application.port.in.TypeAccountService;
import org.devsu.application.port.out.AccountRepository;
import org.devsu.domain.exception.AccountNotFoundException;
import org.devsu.domain.model.Account;
import org.devsu.domain.model.TypeAccount;
import org.devsu.domain.service.constant.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private  final AccountRepository accRepository;
    private final TypeAccountService taService;
    @Autowired
    public AccountServiceImpl(AccountRepository taRepository, TypeAccountService taService) {
        this.accRepository = taRepository;
        this.taService = taService;
    }



    @Override
    public List<AccountDTO> findAll() {
        return accRepository.findAll().stream()
                .filter(x-> x.getStatus().equals(Constant.ACCOUNT_STATUS_ACTIVE))
                .map(x->{
                    return AccountMapper.toDTO(x);
                }).toList();
    }

    @Override
    public Account finById(Long id) {
        return accRepository.finById(id)
                .orElseThrow(()-> new AccountNotFoundException(Constant.TYPE_ACCOUNT_NOT_FOUND.concat(" - id: ")+id));
    }

    @Override
    public AccountDTO save(AccountDTO dto) {
        TypeAccount ta=taService.finById(dto.getTypeaccount().getId());
        dto.getTypeaccount().setDescription(ta.getDescription());
        Account acc=AccountMapper.fromDTO(dto);
        return AccountMapper.toDTO(accRepository.save(acc));
    }

    @Override
    public AccountDTO update(Long id, AccountDTO dto) {
        finById(id);
        TypeAccount ta=taService.finById(dto.getTypeaccount().getId());
        dto.getTypeaccount().setDescription(ta.getDescription());
        Account accEntity=AccountMapper.fromDtoUpdate(dto, id);
        return AccountMapper.toDTO(accRepository.save(accEntity));
    }

    @Override
    public AccountDTO delete(Long id) {
        Account acc=finById(id);
        acc.setStatus(Constant.ACCOUNT_STATUS_INACTIVE);
        return AccountMapper.toDTO(accRepository.save(acc));
    }
}
