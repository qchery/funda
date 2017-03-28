package com.qchery.funda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Chery
 * @date 2017/3/24 - 下午11:12
 */
@SpringBootApplication
@ComponentScan(basePackages = {
        "com.qchery",
        "com.bairuitech.anychat"
})
public class FundaAppliction {

    public static void main(String[] args) {
        SpringApplication.run(FundaAppliction.class, args);
    }

}
