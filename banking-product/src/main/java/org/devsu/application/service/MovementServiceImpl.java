package org.devsu.application.service;

import org.devsu.application.dto.AccountDTO;
import org.devsu.application.dto.MovementDTO;
import org.devsu.application.dto.TypeMovementDTO;
import org.devsu.application.mapper.AccountMapper;
import org.devsu.application.mapper.MovementMapper;
import org.devsu.application.port.in.AccountService;
import org.devsu.application.port.in.MovementService;
import org.devsu.application.port.in.TypeMovementService;
import org.devsu.application.port.out.AccountRepository;
import org.devsu.application.port.out.MovementRepository;
import org.devsu.domain.exception.MovementNotFoundException;
import org.devsu.domain.model.Account;
import org.devsu.domain.model.Movement;
import org.devsu.infrastructure.adapter.async.comunication.payload.RequestCustomer;
import org.devsu.domain.model.TypeMovement;
import org.devsu.domain.service.MovementServiceDomain;
import org.devsu.domain.service.constant.Constant;
import org.devsu.infrastructure.adapter.async.comunication.publisher.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovementServiceImpl implements MovementService {

    private final Publisher publisher;
    private  final MovementRepository movRepository;
    private  final AccountService accService;
    private  final AccountRepository accRepository;
    private final TypeMovementService tmService;
    @Autowired
    public MovementServiceImpl(Publisher publisher, MovementRepository movRepository, AccountService accService, AccountRepository accRepository, TypeMovementService tmService) {
        this.publisher = publisher;
        this.movRepository = movRepository;
        this.accService = accService;
        this.accRepository = accRepository;
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
    public MovementDTO addMovementToAccount(MovementDTO dto) {
        TypeMovementDTO tm=MovementServiceDomain.calculateTypeMovement(dto.getValueMovement());
        Account acc=accService.finById(dto.getAccount().getId());
        MovementServiceDomain.validateBalance(tm.getDescription(),acc.getInitialBalance(), dto.getValueMovement());
        BigDecimal initialBalance =acc.getInitialBalance();
        BigDecimal availableBalance=MovementServiceDomain.caculateAvailableBalance(initialBalance,dto.getValueMovement());
        acc.setInitialBalance(availableBalance);
        MovementDTO dtoComplete=MovementMapper.toDTOComplete(dto, availableBalance, tm, acc.getAccountNumber(), initialBalance);
        Movement mov= MovementMapper.fromDTO(dtoComplete);
        if (acc.getListMovement().isEmpty()){
            acc.setListMovement(new ArrayList<>());
        }
        acc.getListMovement().add(mov);
        accRepository.save(acc);
        return MovementMapper.toDTO(movRepository.save(mov));
    }

    @Override
    public List<AccountDTO> reportByUserBetweenRangeDate(String id, String idCard, String starDate, String endDate) {
        RequestCustomer rqCustomer = new RequestCustomer(id, idCard, starDate, endDate);
        System.out.println("idCard o Identificacion recibida en publisher = " + idCard);
        this.publisher.send(rqCustomer);
        List<AccountDTO> listaAccountDTO= new ArrayList<>();
        if(id!=null ) {
            Optional<Account> optAccount = accRepository.finById(Long.valueOf(id));
            listaAccountDTO = AccountMapper.getlistAccountDTO(optAccount, starDate, endDate);
        }
        return listaAccountDTO;
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
