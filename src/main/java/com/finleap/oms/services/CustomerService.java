package com.finleap.oms.services;

import com.finleap.oms.models.Customer;
import java.util.List;


public interface CustomerService {
    List<Customer> findAll();

    Customer findByEmail(String email);

    void singUp(Customer customer);

    Customer signIn(String email, String password);
}
