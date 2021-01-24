package com.example.demo;

import com.example.demo.currencylayer.LiveResponse;
import com.example.demo.service.ExchangeService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @AfterAll
    static void connClose()  {
        try {
            LiveResponse.httpClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void liveResponseTest()  {
        LiveResponse.sendLiveRequestOne("KRW");
    }

    @Test
    void liveResponsesTest() throws InterruptedException {
        String[] aa = {"KRW", "JPY","PHP"};
        for (String money : aa) {
            Thread.sleep(10000);
            LiveResponse.sendLiveRequestOne(money);
        }

    }

    @Test
    void liveResponses2Test() throws InterruptedException {
        String[] aa = {"KRW", "JPY","PHP"};
        for (String money : aa) {
            Thread.sleep(5000);
            LiveResponse.sendLiveRequestOne(money);

        }
    }

}
