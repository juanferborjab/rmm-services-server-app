package com.ninjarmm.app.entity.service;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ninjarmm.app.entity.Customer;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(
        name = "serve"
)
public class Serve {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long idServe;
    @Size(max = 100)
    private String name;
    @NotBlank
    private double cost;


    @Enumerated(EnumType.STRING)
    private ServeType type;

    @ManyToMany(fetch = FetchType.EAGER,
            mappedBy = "serves")
    @JsonIgnore
   private Set<Customer> customers;

    public Serve() {
    }

    public Serve(long idServe, String name, double cost, ServeType type) {
        this.idServe = idServe;
        this.name = name;
        this.cost = cost;
        this.type = type;
    }

    public long getIdServe() {
        return this.idServe;
    }

    public void setIdServe(long id) {
        this.idServe = id;
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

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }
}

