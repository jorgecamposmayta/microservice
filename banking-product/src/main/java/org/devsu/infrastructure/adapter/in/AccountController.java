package org.devsu.infrastructure.adapter.in;

import jakarta.validation.Valid;
import org.devsu.application.dto.AccountDTO;
import org.devsu.application.port.in.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cuentas")
public class AccountController {

    private final AccountService accService;

    @Autowired
    public AccountController(AccountService accService) {
        this.accService = accService;
    }

    @GetMapping("/")
    public ResponseEntity<List<AccountDTO>> listAccount(){
        List<AccountDTO> listAccount=accService.findAll();
        return new ResponseEntity<>(listAccount, HttpStatus.OK);
    }

    @PostMapping("/")
    public  ResponseEntity<AccountDTO> createAccount(@Valid @RequestBody AccountDTO dto){
        AccountDTO acc=accService.save(dto);
        return new ResponseEntity<>(acc,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<AccountDTO> updateAccount(@Valid @PathVariable Long id, @RequestBody AccountDTO dto){
        AccountDTO acc=accService.update(id,dto);
        return new ResponseEntity<>(acc,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<AccountDTO> deleteAccount(@PathVariable Long id){
        AccountDTO acc=accService.delete(id);
        return new ResponseEntity<>(acc,HttpStatus.OK);
    }
}
