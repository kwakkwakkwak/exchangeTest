package com.example.demo;


import com.example.demo.currencylayer.LiveResponseDemo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Controller
public class  IndexController {


    @RequestMapping
    public String index() {

        return "index";
    }
}
