package com.example.demo.controller;

import com.example.demo.domain.Exchange;
import com.example.demo.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class ExchangeApiController {

    @Autowired
    ExchangeService exchangeService;

    @RequestMapping("/getExchangeRate/{quote}")
    public Map getExchangeRate(@PathVariable String quote){
        return exchangeService.getExchangeRate(quote);
    }

    @PostMapping("/clacExchange")
    public String clacExchange(@RequestBody Exchange exchange){
        return exchangeService.getExchange(exchange);

    }
}
