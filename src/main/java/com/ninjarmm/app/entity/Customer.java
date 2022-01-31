package com.ninjarmm.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ninjarmm.app.entity.device.Device;
import com.ninjarmm.app.entity.service.Serve;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCustomer;

    @OneToMany(mappedBy = "customer")
    @JsonIgnore
    private Set<Device> devices;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "customer_serve",
            joinColumns = @JoinColumn(name = "idCustomer"),
            inverseJoinColumns = @JoinColumn(name = "idServe")
    )
    @JsonIgnore
    private Set<Serve> serves;

    public Customer(long idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Customer() {
    }

    public long getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(long idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Set<Device> getDevices() {
        return devices;
    }

    public void setDevices(Set<Device> devices) {
        this.devices = devices;
    }

    public Set<Serve> getServes() {
        return serves;
    }

    public void setServes(Set<Serve> serves) {
        this.serves = serves;
    }

    public Double totalCost() {
        Double costDevices = devices.stream().map(Device::getCost).reduce(0.0, (acc, n) -> acc + n);
        Double costServicesByDevices = devices.stream().map(device ->
                serves.stream().filter(s -> device.getType().isAllowedServiceType(s.getType())).map(Serve::getCost).reduce(0.0, (acc, n) -> acc + n)
        ).reduce(0.0, (acc, n) -> acc + n);
        return costDevices + costServicesByDevices;
    }

    public boolean findServe(Serve serve){ return this.serves.contains(serve);}

    public void addServe(Serve serve) {
        this.serves.add(serve);
    }

    public void removeServe(Serve serve) {
        this.serves.remove(serve);
    }

    public List<Serve> getAllServes( Set<Serve> serves) {
       this.serves=serves;
        List<Serve> servesAll = new ArrayList<>();
         this.getServes().forEach(serve -> servesAll.add(serve)); // map(serve -> serves.add(serve));
        return servesAll;
    }

}
