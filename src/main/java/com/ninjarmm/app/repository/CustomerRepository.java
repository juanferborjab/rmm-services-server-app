package com.ninjarmm.app.repository;
import com.ninjarmm.app.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("customerRepository")
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
