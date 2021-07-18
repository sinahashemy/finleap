package com.finleap.oms.repository;
import com.finleap.oms.models.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    Customer findByEmail(String email);
    Customer signIn(String email, String password);
}