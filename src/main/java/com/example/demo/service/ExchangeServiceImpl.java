package com.example.demo.service;

import com.example.demo.currencylayer.LiveResponse;
import com.example.demo.domain.Exchange;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ExchangeServiceImpl implements ExchangeService {

    @Override
    public Map getExchangeRate(String quote) {
        return LiveResponse.sendLiveRequestOne(quote);
    }

    @Override
    public String getExchange(Exchange exchange) {
        double exchangeRate = Double.parseDouble(exchange.getExchangeRate().substring(0,exchange.getExchangeRate().length()-8).replaceAll("\\,",""));
        System.out.println(exchangeRate);
        double result = exchangeRate * Integer.parseInt(exchange.getAmount());

        return "수취금액은 " + String.format("%,.2f",result) + " " + exchange.getQuote() +" 입니다.";
    }
}
