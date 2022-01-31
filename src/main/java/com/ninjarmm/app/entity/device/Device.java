package com.ninjarmm.app.entity.device;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ninjarmm.app.entity.Customer;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "device")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idDevice;

    @Size(max = 200)
    private String systemName;

    @Enumerated(EnumType.STRING)
    private DeviceType type;

   @ManyToOne(targetEntity = Customer.class, fetch = FetchType.EAGER)
   @JoinColumn(name="idCustomer", nullable=false)
   @JsonIgnore
   private Customer customer;

   @Column (name="idCustomer", insertable = false, updatable = false)
   private long idCustomer;

    private Double cost = 4.0;

    public Device(Customer customer, String systemName, DeviceType type) {
        this.customer = customer;
        this.systemName = systemName;
        this.type = type;
    }

    public Device() {

    }

    public long getIdDevice() {
        return this.idDevice;
    }

    public void setIdDevice(long id) {
        this.idDevice = id;
    }

    public String getSystemName() {
        return this.systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public DeviceType getType() {
        return this.type;
    }

    public void setType(DeviceType type) {
        this.type = type;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

}

