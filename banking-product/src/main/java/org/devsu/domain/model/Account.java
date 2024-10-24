package org.devsu.domain.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String accountNumber;
    private BigDecimal initialBalance;
    private String status;
    private Long idCustomer;

    @ManyToOne
    @JoinColumn(name = "id_type_account")
    private TypeAccount typeaccount;

    @OneToMany(mappedBy = "account", cascade = CascadeType.REFRESH)
    private List<Movement> listMovement;

    public Account(){}

    public Account(Long id, String accountNumber, BigDecimal initialBalance, String status, Long idCustomer, TypeAccount typeaccount, List<Movement> listMovement) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.initialBalance = initialBalance;
        this.status = status;
        this.idCustomer = idCustomer;
        this.typeaccount = typeaccount;
        this.listMovement = listMovement;
    }

    public Account(String accountNumber, BigDecimal initialBalance, String status, Long idCustomer, TypeAccount typeaccount, List<Movement> listMovement) {
        this.accountNumber = accountNumber;
        this.initialBalance = initialBalance;
        this.status = status;
        this.idCustomer = idCustomer;
        this.typeaccount = typeaccount;
        this.listMovement = listMovement;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
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

    public Long getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Long idCustomer) {
        this.idCustomer = idCustomer;
    }

    public TypeAccount getTypeaccount() {
        return typeaccount;
    }

    public void setTypeaccount(TypeAccount typeaccount) {
        this.typeaccount = typeaccount;
    }

    public List<Movement> getListMovement() {
        return listMovement;
    }

    public void setListMovement(List<Movement> listMovement) {
        this.listMovement = listMovement;
    }
}
