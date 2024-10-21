package org.devsu.application.port.in;

import org.devsu.application.dto.CustomerDTO;
import org.devsu.domain.model.Customer;

import java.util.List;

public interface CustomerService {

    List<CustomerDTO> findAll();
    Customer finById(Long id);
    CustomerDTO save(CustomerDTO dto);
    CustomerDTO update(Long id, CustomerDTO dto);
    CustomerDTO delete(Long id);

}
