package org.devsu.domain.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class TypeAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @OneToMany(mappedBy = "typeaccount", cascade = CascadeType.ALL)
    private List<Account> listAccount;

    public TypeAccount(){}

    public TypeAccount(Long id, String description, List<Account> listAccount) {
        this.id = id;
        this.description = description;
        this.listAccount = listAccount;
    }

    public TypeAccount( String description, List<Account> listAccount) {
        this.description = description;
        this.listAccount = listAccount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Account> getListAccount() {
        return listAccount;
    }

    public void setListAccount(List<Account> listAccount) {
        this.listAccount = listAccount;
    }
}
