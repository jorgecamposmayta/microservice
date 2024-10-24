package org.devsu.infrastructure.adapter.async.comunication.payload;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class ResponseCustomer implements Serializable {

    private static final long serialVersionUID=1L;
    private String id;
    private String idCard;
    private String nombre;

    public ResponseCustomer(){}

    public ResponseCustomer(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public ResponseCustomer(String id, String idCard, String nombre) {
        this.id = id;
        this.idCard = idCard;
        this.nombre = nombre;
    }
}
