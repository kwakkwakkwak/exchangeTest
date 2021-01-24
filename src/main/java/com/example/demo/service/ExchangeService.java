package com.example.demo.service;

import com.example.demo.domain.Exchange;
import org.springframework.stereotype.Service;

import java.util.Map;


public interface ExchangeService {

    public Map getExchangeRate(String quote);

    public String getExchange(Exchange exchange);
}
