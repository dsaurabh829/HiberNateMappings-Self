package com.dsaurabh.HibernateMappingSelf.controller;

import com.dsaurabh.HibernateMappingSelf.entity.Order;
import com.dsaurabh.HibernateMappingSelf.request.CreateNewOrderRequest;
import com.dsaurabh.HibernateMappingSelf.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping(value = "/order", produces = MediaType.APPLICATION_JSON_VALUE)
    public Order createNewOrder(@RequestBody CreateNewOrderRequest request){

        return service.createNewOrder(request);

    }

}
