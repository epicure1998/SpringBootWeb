package com.qiumengke;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.sql.DataSource;
@EnableScheduling//开始定时任务执行功能
@SpringBootApplication
public class DemoApplication {


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        System.out.println("启动成功");
    }

}
