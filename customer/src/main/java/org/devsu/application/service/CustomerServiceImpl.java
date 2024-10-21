package org.devsu.application.service;

import org.devsu.application.dto.CustomerDTO;
import org.devsu.application.mapper.CustomerMapper;
import org.devsu.application.port.in.CustomerService;
import org.devsu.application.port.out.CustomerRepository;
import org.devsu.domain.exception.CustomerNotFoundException;
import org.devsu.domain.model.Customer;
import org.devsu.domain.service.constant.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository cusRepository;
    @Autowired
    public CustomerServiceImpl(CustomerRepository cusRepository) {
        this.cusRepository = cusRepository;
    }

    @Override
    public List<CustomerDTO> findAll() {
        return cusRepository.findAll().stream()
                .filter(x-> x.getStatus().equals(Constant.CUSTOMER_STATUS_ACTIVE))
                .map(x->{
                    return CustomerMapper.toDTO(x);
                }).toList();
    }

    @Override
    public Customer finById(Long id) {
        return cusRepository.finById(id)
                .orElseThrow(()-> new CustomerNotFoundException(Constant.CUSTOMER_NOT_FOUND.concat(" - id: ")+id));
    }

    @Override
    public CustomerDTO save(CustomerDTO dto) {
        Customer cus=CustomerMapper.fromDTO(dto);
        return CustomerMapper.toDTO(cusRepository.save(cus));
    }

    @Override
    public CustomerDTO update(Long id, CustomerDTO dto) {
        finById(id);
        Customer cusEntity=CustomerMapper.fromDtoUpdate(dto, id);
        return CustomerMapper.toDTO(cusRepository.save(cusEntity));
    }

    @Override
    public CustomerDTO delete(Long id) {
        Customer cus=finById(id);
        cus.setStatus(Constant.CUSTOMER_STATUS_INACTIVE);
        return CustomerMapper.toDTO(cusRepository.save(cus));
    }

}
