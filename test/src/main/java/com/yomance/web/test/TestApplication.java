package com.yomance.web.test;

import com.yomance.web.config.enables.EnableAll;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Yomance
 * @version 1.0
 * @date 2023-02-16 21:40:39
 */
@EnableAll
@SpringBootApplication
public class TestApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class);
    }
}
