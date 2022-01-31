package com.ninjarmm.app.controller;

import com.ninjarmm.app.entity.Customer;
import com.ninjarmm.app.entity.service.Serve;
import com.ninjarmm.app.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/server")
public class ServeController {

    @Autowired
    CustomerService customerService;

    @PostMapping(value = "/{idCustomer}/{idService}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Customer> addServiceToCustomerAccount(
            @PathVariable(value = "idCustomer") long idCustomer,
            @PathVariable(value = "idService") long idService
    ) throws Exception {
        return new ResponseEntity<>(customerService.addService(idCustomer, idService), HttpStatus.CREATED);
    }
    @DeleteMapping(value = "/{idCustomer}/{idService}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<Customer>  deleteServiceToCustomerAccount(
            @PathVariable(value = "idCustomer") long idCustomer,
            @PathVariable(value = "idService") long idService
    ) {
        return new ResponseEntity<>(customerService.removeService(idCustomer, idService), HttpStatus.OK);
    }

    @GetMapping (value = "/{idCustomer}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Serve>> getAllServiceToCustomerAccount(
            @PathVariable(value = "idCustomer") long idCustomer) {
        return new ResponseEntity<>(customerService.getServices(idCustomer), HttpStatus.OK);
    }

    @GetMapping (value = "/totalCost/{idCustomer}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Double> getTotalCostMontly(
            @PathVariable(value = "idCustomer") long idCustomer) {
        return new ResponseEntity<>(customerService.totalCostOfServices(idCustomer), HttpStatus.OK);
    }
}
