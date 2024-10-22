package org.devsu.domain.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Movement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private Long idAccountNumber;
    private BigDecimal initialBalance;
    private String status;
    private BigDecimal valueMovement;
    private BigDecimal availableBalance;

    @ManyToOne
    @JoinColumn(name = "id_type_movement")
    private TypeMovement typemovement;

    public Movement(){}

    public Movement(Long id, LocalDate date, Long idAccountNumber, BigDecimal initialBalance, String status, BigDecimal valueMovement, BigDecimal availableBalance, TypeMovement typemovement) {
        this.id = id;
        this.date = date;
        this.idAccountNumber = idAccountNumber;
        this.initialBalance = initialBalance;
        this.status = status;
        this.valueMovement = valueMovement;
        this.availableBalance = availableBalance;
        this.typemovement = typemovement;
    }

    public Movement(LocalDate date, Long idAccountNumber, BigDecimal initialBalance, String status, BigDecimal valueMovement, BigDecimal availableBalance, TypeMovement typemovement) {
        this.date = date;
        this.idAccountNumber = idAccountNumber;
        this.initialBalance = initialBalance;
        this.status = status;
        this.valueMovement = valueMovement;
        this.availableBalance = availableBalance;
        this.typemovement = typemovement;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getIdAccountNumber() {
        return idAccountNumber;
    }

    public void setIdAccountNumber(Long idAccountNumber) {
        this.idAccountNumber = idAccountNumber;
    }

    public BigDecimal getInitialBalance() {
        return initialBalance;
    }

    public void setInitialBalance(BigDecimal initialBalance) {
        this.initialBalance = initialBalance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getValueMovement() {
        return valueMovement;
    }

    public void setValueMovement(BigDecimal valueMovement) {
        this.valueMovement = valueMovement;
    }

    public BigDecimal getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(BigDecimal availableBalance) {
        this.availableBalance = availableBalance;
    }

    public TypeMovement getTypemovement() {
        return typemovement;
    }

    public void setTypemovement(TypeMovement typemovement) {
        this.typemovement = typemovement;
    }
}
