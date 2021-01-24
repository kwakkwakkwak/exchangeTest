package com.example.demo;

import com.example.demo.currencylayer.LiveResponseDemo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void liveResponseDemoTest() throws IOException {
        LiveResponseDemo.sendLiveRequest();
        LiveResponseDemo.httpClient.close();
    }

}
