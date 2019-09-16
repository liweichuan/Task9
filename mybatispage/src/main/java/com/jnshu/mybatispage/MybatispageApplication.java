package com.jnshu.mybatispage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jnshu.mybatispage.mapper")
public class MybatispageApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatispageApplication.class, args);
    }

}
