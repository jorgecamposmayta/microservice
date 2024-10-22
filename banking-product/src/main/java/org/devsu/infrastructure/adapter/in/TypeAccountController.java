package org.devsu.infrastructure.adapter.in;

import org.devsu.application.dto.TypeAccountDTO;
import org.devsu.application.port.in.TypeAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipo/cuentas")
public class TypeAccountController {

    private final TypeAccountService taService;

    @Autowired
    public TypeAccountController(TypeAccountService taService) {
        this.taService = taService;
    }

    @GetMapping("/")
    public ResponseEntity<List<TypeAccountDTO>> listTypeAccount(){
        List<TypeAccountDTO> listTypeAccount=taService.findAll();
        return new ResponseEntity<>(listTypeAccount, HttpStatus.OK);
    }

    @PostMapping("/")
    public  ResponseEntity<TypeAccountDTO> createTypeAccount(@RequestBody TypeAccountDTO dto){
        TypeAccountDTO ta=taService.save(dto);
        return new ResponseEntity<>(ta,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<TypeAccountDTO> updateTypeAccount(@PathVariable Long id, @RequestBody TypeAccountDTO dto){
        TypeAccountDTO ta=taService.update(id,dto);
        return new ResponseEntity<>(ta,HttpStatus.OK);
    }

}
