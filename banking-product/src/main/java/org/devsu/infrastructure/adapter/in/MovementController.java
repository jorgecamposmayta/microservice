package org.devsu.infrastructure.adapter.in;

import jakarta.validation.Valid;
import org.devsu.application.dto.MovementDTO;
import org.devsu.application.port.in.MovementService;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/movimientos")
public class MovementController {

    private final MovementService movService;

    @Autowired
    public MovementController(MovementService movService) {
        this.movService = movService;
    }

    @GetMapping("/")
    public ResponseEntity<List<MovementDTO>> listMovement(){
        List<MovementDTO> listMovement= movService.findAll();
        return new ResponseEntity<>(listMovement, HttpStatus.OK);
    }

    @PostMapping("/")
    public  ResponseEntity<MovementDTO> createMovement(@Valid  @RequestBody MovementDTO dto){
        MovementDTO mov= movService.addMovementToAccount(dto);
        return new ResponseEntity<>(mov,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<MovementDTO> updateMovement(@Valid @PathVariable Long id, @RequestBody MovementDTO dto){
        MovementDTO mov= movService.update(id,dto);
        return new ResponseEntity<>(mov,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<MovementDTO> deleteMovement(@PathVariable Long id){
        MovementDTO mov= movService.delete(id);
        return new ResponseEntity<>(mov,HttpStatus.OK);
    }

    @GetMapping("/reportes")
    public ResponseEntity<List<MovementDTO>> getReportByUserBetweenRangeDate(@RequestParam("id") String idCustomer, @RequestParam("fechaInicio")String starDate, @RequestParam("fechaFin") String endDate){
        List<MovementDTO> listMovement= movService.reportByUserBetweenRangeDate(idCustomer, starDate,endDate);
        return new ResponseEntity<>(listMovement, HttpStatus.OK);
    }
}
