package org.example.spring.cloud.loadbalancer.orderservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/order")
public class OrderController {
    @Value("${spring.application.name}")
    private String appName;

    @Value("${server.port}")
    private String portNumber;

    @RequestMapping("/endpoint1")
    public String endpoint1() {
        return "[" + appName + " - " + portNumber + "] -> This is the endpoint 1";
    }

    @RequestMapping("/endpoint2")
    public String endpoint2() {
        return  "[" + appName + " - " + portNumber + "] -> This is the endpoint 2";
    }
}

