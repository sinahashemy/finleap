package com.finleap.oms.controllers;

import com.finleap.oms.dtos.CustomerDTO;
import com.finleap.oms.dtos.OrderDTO;
import com.finleap.oms.models.Customer;
import com.finleap.oms.models.Order;
import com.finleap.oms.payload.response.JwtResponse;
import com.finleap.oms.security.jwt.JwtUtils;
import com.finleap.oms.security.services.UserDetailsImpl;
import com.finleap.oms.services.CustomerService;
import com.finleap.oms.services.OrderService;
import com.finleap.oms.util.ObjectMapperUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

@RestController
@RequestMapping("/c")
public class CustomerRestController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private OrderService orderService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtils jwtUtils;


    @PostMapping(value = "/signup")
    public ResponseEntity<?> signupCustomer(@RequestBody CustomerDTO customerDTO) {
        customerService.singUp(ObjectMapperUtils.map(customerDTO, Customer.class));
        return new ResponseEntity("Customer signup successfully", HttpStatus.OK);
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody CustomerDTO customerDTO) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(customerDTO.getEmail(), customerDTO.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getEmail()));
    }


    @PostMapping(value = "/orders")
    @PreAuthorize("")
    public ResponseEntity<?> addCustomerOrder(@RequestBody OrderDTO orderDTO) {
        orderService.addOrder(ObjectMapperUtils.map(orderDTO, Order.class));
        return new ResponseEntity("Customer order added successfully", HttpStatus.OK);
    }

    @GetMapping(value = "/orders")
    @PreAuthorize("")
    public List<OrderDTO> findAllCustomerOrders() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        return ObjectMapperUtils.mapAll(orderService.findByCustomerId(userDetails.getEmail()), OrderDTO.class);
    }

    @DeleteMapping(value = "/orders/{orderId}")
    public ResponseEntity<?> cancelCustomerOrder(@PathVariable String orderId) {
        orderService.cancelOrder(orderId);
        return new ResponseEntity("Customer order cancel successfully", HttpStatus.OK);
    }
}
