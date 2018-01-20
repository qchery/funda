package com.qchery.funda;

import com.qchery.funda.props.SystemProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author Chery
 * @date 2017/3/24 - 下午11:12
 */
@SpringBootApplication
@EnableConfigurationProperties({
        SystemProperties.class
})
public class FundaApplication {

    public static void main(String[] args) {
        SpringApplication.run(FundaApplication.class, args);
    }

}
