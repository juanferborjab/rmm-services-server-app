package com.ninjarmm.app.entity.service;
import com.ninjarmm.app.entity.device.Device;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(
        name = "serve"
)
public class Serve {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long id_service;
    @Size(max = 100)
    private String name;
    @NotBlank
    private double cost;

    private ServeType type;

    @ManyToOne
    @JoinColumn(name="id_device", nullable=false)
    Device device; // Bidirectional


     public long getId_service() {
        return this.id_service;
    }

    public void setId_service(long id) {
        this.id_service = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return this.cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public ServeType getType() {
        return type;
    }

    public void setType(ServeType type) {
        this.type = type;
    }
}

