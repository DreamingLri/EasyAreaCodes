package com.project.eac;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.project.eac.mapper")
public class EasyAreaCodesApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasyAreaCodesApplication.class, args);
    }

}
