package org.devsu.infrastructure.adapter.in;

import org.devsu.application.dto.TypeMovementDTO;
import org.devsu.application.port.in.TypeMovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipo/movimientos")
public class TypeMovementController {

    private final TypeMovementService tmService;

    @Autowired
    public TypeMovementController(TypeMovementService tmService) {
        this.tmService = tmService;
    }

    @GetMapping("/")
    public ResponseEntity<List<TypeMovementDTO>> listTypeMovement(){
        List<TypeMovementDTO> listTypeMovement= tmService.findAll();
        return new ResponseEntity<>(listTypeMovement, HttpStatus.OK);
    }

    @PostMapping("/")
    public  ResponseEntity<TypeMovementDTO> createTypeMovement(@RequestBody TypeMovementDTO dto){
        TypeMovementDTO tm= tmService.save(dto);
        return new ResponseEntity<>(tm,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<TypeMovementDTO> updateTypeMovement(@PathVariable Long id, @RequestBody TypeMovementDTO dto){
        TypeMovementDTO tm= tmService.update(id,dto);
        return new ResponseEntity<>(tm,HttpStatus.OK);
    }

}
