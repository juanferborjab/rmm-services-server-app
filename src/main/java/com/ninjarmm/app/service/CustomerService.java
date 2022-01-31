package com.ninjarmm.app.service;

import com.ninjarmm.app.entity.Customer;
import com.ninjarmm.app.entity.service.Serve;
import com.ninjarmm.app.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    ServeService serveService;

    @Autowired
    CustomerRepository customerRepository;

    public Customer addService(Long idCostumer, Long idService) throws Exception {
        Customer customer = findById(idCostumer);
        Serve serve = serveService.findById(idService);
        findServeCostumer(customer,serve);
        customer.addServe(serve);
       return customerRepository.save(customer);
    }

    public Customer removeService(Long idCostumer, Long idService) {
        Customer customer = findById(idCostumer);
        Serve serve = serveService.findById(idService);
        customer.removeServe(serve);
        return customerRepository.save(customer);
    }
    public List<Serve> getServices(Long idCostumer) {
        validateCustomerExist(idCostumer);
        Customer customer = findById(idCostumer);
        return customer.getAllServes(customer.getServes());
    }

    public Double totalCostOfServices(Long idCostumer) {
        Customer customer = findById(idCostumer);
        return customer.totalCost();
    }

    public Customer findById(Long idCostumer) {
        return customerRepository.findById(idCostumer).orElseThrow(() -> new RuntimeException("Customer not found."));
    }

    public void validateCustomerExist(Long idCustomer) {
        customerRepository.findById(idCustomer).orElseThrow(() -> new RuntimeException("Customer not found."));
    }

    public void findServeCostumer (Customer customer, Serve serve) throws Exception {
        if(customer.findServe(serve))
            throw new Exception("Already Customer have the service");
    }



}
