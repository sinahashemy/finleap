package com.finleap.oms.controllers;

import com.finleap.oms.dtos.OrderDTO;
import com.finleap.oms.services.CustomerService;
import com.finleap.oms.services.OrderService;
import com.finleap.oms.util.ObjectMapperUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/o")
public class OrderRestController {

    @Autowired
    private CustomerService customerService;
    private OrderService orderService;

    @GetMapping(value = "/orders")
    @PreAuthorize("")
    public List<OrderDTO> getAllCustomers() {
        return ObjectMapperUtils.mapAll(orderService.findAll(), OrderDTO.class);
    }

    @PostMapping(value = "/orders/{orderId}/complete")
    @PreAuthorize("")
    public ResponseEntity<?> completeOrder(@PathVariable String orderId) {
        orderService.completeOrder(orderId);
        return new ResponseEntity("order complete successfully", HttpStatus.OK);
    }
}
