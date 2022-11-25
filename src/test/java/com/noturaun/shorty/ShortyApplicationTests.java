package com.noturaun.shorty;

import com.noturaun.shorty.util.ConversionUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShortyApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testEncoder() {
//        String text = "http://localhost:8080/shorty/api/v1/test/ping";
        System.out.println(ConversionUtil.encode(1));
    }


}
