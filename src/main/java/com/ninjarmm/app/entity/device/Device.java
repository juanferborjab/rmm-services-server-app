package com.ninjarmm.app.entity.device;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ninjarmm.app.entity.Customer;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(
        name = "device"
)
public class Device {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long id_device;
    @Size(max = 200)
    private String systemName;

    @Enumerated(EnumType.STRING)
    private DeviceType type;

    private Double cost = 4.0;

    @JsonIgnore
    @OneToMany(mappedBy="device")
    private Set<Serve> servis = new HashSet<>();



    public Device(String systemName, DeviceType type) {
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

