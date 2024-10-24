package org.devsu.infrastructure.adapter.async.comunication.payload;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class RequestCustomer implements Serializable {

    private static final long serialVersionUID=1L;
    private String id;
    private String idCard;
    private String fechaInicio;
    private String fechaFin;

    public  RequestCustomer(){}

    public RequestCustomer(String id, String fechaInicio, String fechaFin) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }
}
