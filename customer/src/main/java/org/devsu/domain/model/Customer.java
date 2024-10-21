package org.devsu.domain.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("CUSTOMER")
public class Customer extends Person {

    private String password;
    private String status;

    public Customer(){}

    public Customer(String idCard, String name, String gender, Integer age, String address, String phone, String password, String status) {
        super(idCard, name, gender, age, address, phone);
        this.password = password;
        this.status = status;
    }

    public Customer(Long id,String idCard, String name, String gender, Integer age, String address, String phone, String password, String status) {
        super(id,idCard, name, gender, age, address, phone);
        this.password = password;
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
