package org.devsu.domain.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class TypeMovement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @OneToMany(mappedBy = "typemovement", cascade = CascadeType.ALL)
    private List<Movement> listMovement;

    public TypeMovement(){}

    public TypeMovement(Long id, String description, List<Movement> listMovement) {
        this.id = id;
        this.description = description;
        this.listMovement = listMovement;
    }

    public TypeMovement(String description, List<Movement> listMovement) {
        this.description = description;
        this.listMovement = listMovement;
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

    public List<Movement> getListMovement() {
        return listMovement;
    }

    public void setListMovement(List<Movement> listMovement) {
        this.listMovement = listMovement;
    }
}
