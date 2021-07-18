package com.finleap.oms.services;

import com.finleap.oms.models.Customer;
import com.finleap.oms.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

    @Override
    public void singUp(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer signIn(String email, String password) {
        return customerRepository.signIn(email, password);
    }
}
