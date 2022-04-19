package com.edu.hello;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;


@SpringBootApplication

public class HelloApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(HelloApplication.class, args);
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
//        List<Map<String, Object>> result =
//                jdbcTemplate.queryForList("SELECT * FROM USER");
//        System.out.println("测试mysql是否成功");
//        System.out.println(result);


    }

}
