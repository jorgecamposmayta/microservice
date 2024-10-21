package org.devsu.infrastructure.adapter.in;

import org.devsu.application.dto.CustomerDTO;
import org.devsu.application.port.in.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class CustomerController {

    private final CustomerService cusService;

    @Autowired
    public CustomerController(CustomerService cusService) {
        this.cusService = cusService;
    }

    @GetMapping("/")
    public ResponseEntity<List<CustomerDTO>> listCustomer(){
        List<CustomerDTO> listCustomer=cusService.findAll();
        return new ResponseEntity<>(listCustomer, HttpStatus.OK);
    }

    @PostMapping("/")
    public  ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO dto){
        CustomerDTO cus=cusService.save(dto);
        return new ResponseEntity<>(cus,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<CustomerDTO> updateCustomer(@PathVariable Long id, @RequestBody CustomerDTO dto){
        CustomerDTO cus=cusService.update(id,dto);
        return new ResponseEntity<>(cus,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<CustomerDTO> deleteCustomer(@PathVariable Long id){
        CustomerDTO cus=cusService.delete(id);
        return new ResponseEntity<>(cus,HttpStatus.OK);
    }
}
